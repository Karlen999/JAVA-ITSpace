package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    private int id;
    private String name;
    private String description;
    private Date deadline;
    private Status status;
    private User user;
}
