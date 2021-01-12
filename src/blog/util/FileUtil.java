package blog.util;

import blog.model.Post;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileUtil {

    private static final String BLOG_LIST_PATH = "G:\\JAVA ITSpace\\src\\blog\\file\\blogList.txt";

    public static void serializePostList(List<Post> posts){
        createFileIfNotExists(BLOG_LIST_PATH);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(BLOG_LIST_PATH))){
            outputStream.writeObject(posts);
        } catch (IOException e) {
            System.out.println(BLOG_LIST_PATH + " Does not exists or empty");
        }
    }

    public static List<Post> deserializePostList(){
        createFileIfNotExists(BLOG_LIST_PATH);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(BLOG_LIST_PATH))){
            return (List<Post>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(BLOG_LIST_PATH + " Does not exists or empty");
            return new LinkedList<>();
        }
    }

    private static void createFileIfNotExists(String path){
        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(path + "File not be created");
            }
        }
    }

}
