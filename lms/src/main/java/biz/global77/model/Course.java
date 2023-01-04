package biz.global77.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private String level;

    @Column(name = "with_bond")
    private boolean withBond;

    public Course() {}

    public Course(int id, String name, String description, String level, boolean withBond) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.level = level;
        this.withBond = withBond;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isWithBond() {
        return this.withBond;
    }

    public void setWithBond(boolean withBond) {
        this.withBond = withBond;
    }
}

