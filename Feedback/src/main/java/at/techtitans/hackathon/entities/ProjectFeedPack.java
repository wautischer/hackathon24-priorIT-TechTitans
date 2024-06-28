package at.techtitans.hackathon.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ProjectFeedPack", schema = "feedback_DB")
public class ProjectFeedPack {
    @Id
    @Column(name = "idProjectFeedPack", nullable = false)
    private Integer id;

    @Column(name = "Teamwork", nullable = false)
    private Integer teamwork;

    @Column(name = "Organisation", nullable = false)
    private Integer organisation;

    @Column(name = "Deadlines", nullable = false)
    private Integer deadlines;

    @Column(name = "inputField", length = 10000)
    private String inputField;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Projects_idProjects", nullable = false)
    private Project projectsIdprojects;

    @Column(name = "id_from")
    private Integer idFrom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(Integer teamwork) {
        this.teamwork = teamwork;
    }

    public Integer getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Integer organisation) {
        this.organisation = organisation;
    }

    public Integer getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(Integer deadlines) {
        this.deadlines = deadlines;
    }

    public String getInputField() {
        return inputField;
    }

    public void setInputField(String inputField) {
        this.inputField = inputField;
    }

    public Project getProjectsIdprojects() {
        return projectsIdprojects;
    }

    public void setProjectsIdprojects(Project projectsIdprojects) {
        this.projectsIdprojects = projectsIdprojects;
    }

    public Integer getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(Integer idFrom) {
        this.idFrom = idFrom;
    }

}