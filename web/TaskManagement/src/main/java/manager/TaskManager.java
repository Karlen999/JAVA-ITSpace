package manager;

import db.DBConnectionProvider;
import model.Status;
import model.Task;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager = new UserManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public boolean add(Task task) {
        String sql = "INSERT INTO task (name,description,deadline,status,user_id) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            if (task.getDeadline() != null) {
                statement.setString(3, sdf.format(task.getDeadline()));
            } else {
                statement.setString(3, null);
            }
            statement.setString(4, task.getStatus().name());
            statement.setInt(5, task.getUser().getId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                task.setId(resultSet.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM task");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tasks.add(getTaskFromResultSet(resultSet));
            }
            return tasks;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Task> getAllTaskByUser(int userId){
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM task WHERE user_id = " + userId;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                tasks.add(getTaskFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public List<Task> getAllTaskByUserAndStatus(int userId, Status status){
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM task WHERE user_id = ? AND status = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setString(2, status.name());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                tasks.add(getTaskFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public void updateStatus(int taskId, String status){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE task SET status = ? WHERE id = ?");
            statement.setString(1, status);
            statement.setInt(2, taskId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM task WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Task getTaskFromResultSet(ResultSet resultSet) {
        try {
            try {
                Task task = Task.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .deadline(resultSet.getString(4) == null ? null : sdf.parse(resultSet.getString(4)))
                        .status(Status.valueOf(resultSet.getString(5)))
                        .user(userManager.getById(resultSet.getInt(6)))
                        .build();
                return task;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
