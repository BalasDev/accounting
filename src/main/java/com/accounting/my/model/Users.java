package com.accounting.my.model;



import javax.persistence.*;

/**
 * Created by Balas on 3/24/2016.
 */
@Entity
@Table(name = "USERS")
public class Users extends BaseEntity {



    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLEID")
    private Roles role;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "PERSONALINFORMATIONID")
    private PersonalInformation personalInformation;


    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }
}
