package at.techtitans.hackathon.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CompanyFeedpack", schema = "feedback_DB")
public class CompanyFeedpack {
    @Id
    @Column(name = "idProjectFeedPack", nullable = false)
    private Integer id;

    @Column(name = "`Work Enviroment`", nullable = false)
    private Integer workEnviroment;

    @Column(name = "Innovation", nullable = false)
    private Integer innovation;

    @Column(name = "Finance", nullable = false)
    private Integer finance;

    @Column(name = "Satisfaction", nullable = false)
    private Integer satisfaction;

    @Column(name = "Leadership", nullable = false)
    private Integer leadership;

    @Column(name = "CompanyFeedpackcol", nullable = false)
    private Integer companyFeedpackcol;

    @Column(name = "Creativity", nullable = false)
    private Integer creativity;

    @Column(name = "FurtherEducation", nullable = false)
    private Integer furtherEducation;

    @Column(name = "Coworkers", nullable = false)
    private Integer coworkers;

    @Column(name = "Inputfield", nullable = false, length = 10000)
    private String inputfield;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Employee_idLogin", nullable = false)
    private Employee employeeIdlogin;

    @Column(name = "id_from")
    private Integer idFrom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkEnviroment() {
        return workEnviroment;
    }

    public void setWorkEnviroment(Integer workEnviroment) {
        this.workEnviroment = workEnviroment;
    }

    public Integer getInnovation() {
        return innovation;
    }

    public void setInnovation(Integer innovation) {
        this.innovation = innovation;
    }

    public Integer getFinance() {
        return finance;
    }

    public void setFinance(Integer finance) {
        this.finance = finance;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public Integer getCompanyFeedpackcol() {
        return companyFeedpackcol;
    }

    public void setCompanyFeedpackcol(Integer companyFeedpackcol) {
        this.companyFeedpackcol = companyFeedpackcol;
    }

    public Integer getCreativity() {
        return creativity;
    }

    public void setCreativity(Integer creativity) {
        this.creativity = creativity;
    }

    public Integer getFurtherEducation() {
        return furtherEducation;
    }

    public void setFurtherEducation(Integer furtherEducation) {
        this.furtherEducation = furtherEducation;
    }

    public Integer getCoworkers() {
        return coworkers;
    }

    public void setCoworkers(Integer coworkers) {
        this.coworkers = coworkers;
    }

    public String getInputfield() {
        return inputfield;
    }

    public void setInputfield(String inputfield) {
        this.inputfield = inputfield;
    }

    public Employee getEmployeeIdlogin() {
        return employeeIdlogin;
    }

    public void setEmployeeIdlogin(Employee employeeIdlogin) {
        this.employeeIdlogin = employeeIdlogin;
    }

    public Integer getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(Integer idFrom) {
        this.idFrom = idFrom;
    }

}