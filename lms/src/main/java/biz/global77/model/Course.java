package biz.global77.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be 100 characters or fewer")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must be 1000 characters or fewer")
    private String description;

    @NotBlank(message = "Level is required")
    @Size(max = 50, message = "Level must be 50 characters or fewer")
    private String level;

    @NotNull
    private boolean withBond;

    @NotNull
    private boolean archived;

}

