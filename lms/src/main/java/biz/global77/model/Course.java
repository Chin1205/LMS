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

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 1000)
    private String description;

    @NotBlank
    @Size(max = 20)
    private String level;

    @NotNull
    private boolean withBond;

    @NotNull
    private boolean archived;

}

