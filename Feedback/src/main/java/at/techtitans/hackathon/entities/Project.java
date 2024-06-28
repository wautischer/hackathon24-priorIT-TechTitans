package at.techtitans.hackathon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Projects", schema = "feedback_DB")
public class Project {
    @Id
    @Column(name = "idProjects", nullable = false)
    private Integer id;

    @Column(name = "Projectname", nullable = false, length = 45)
    private String projectname;

    @Column(name = "Description", nullable = false, length = 10000)
    private String description;

    @Column(name = "Employee_idLogin", nullable = false)
    private Integer employeeIdlogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEmployeeIdlogin() {
        return employeeIdlogin;
    }

    public void setEmployeeIdlogin(Integer employeeIdlogin) {
        this.employeeIdlogin = employeeIdlogin;
    }

}