package at.techtitans.hackathon.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login", schema = "feedback_DB")
public class Login {
    @Id
    @Column(name = "idLogin", nullable = false)
    private Integer id;

    @Column(name = "Username", nullable = false, length = 45)
    private String username;

    @Column(name = "Email", nullable = false, length = 45)
    private String email;

    @Column(name = "Password", nullable = false, length = 45)
    private String password;

    @Column(name = "Employee_idLogin", nullable = false)
    private Integer employeeIdlogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployeeIdlogin() {
        return employeeIdlogin;
    }

    public void setEmployeeIdlogin(Integer employeeIdlogin) {
        this.employeeIdlogin = employeeIdlogin;
    }

}