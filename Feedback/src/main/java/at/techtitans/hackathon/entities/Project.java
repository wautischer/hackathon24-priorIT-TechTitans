package at.techtitans.hackathon.entities;

import jakarta.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Employee_idLogin", nullable = false)
    private Employee employeeIdlogin;

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

    public Employee getEmployeeIdlogin() {
        return employeeIdlogin;
    }

    public void setEmployeeIdlogin(Employee employeeIdlogin) {
        this.employeeIdlogin = employeeIdlogin;
    }

}