package com.accounting.my.model;

import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Balas on 4/8/2016.
 */
@Entity
@Table(name = "PERSONALINFORMATIONS")
public class PersonalInformation extends BaseEntity {

    /*@Id
    @SequenceGenerator(name="personalinformations_id_seq",
            sequenceName="personalinformations_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="personalinformations_id_seq")
    @Column(name = "ID", updatable=false)
    private Integer id;*/

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "SECONDNAME")
    private String secondName;

    @Column(name = "LASTNAME")
    private String lastName;


    //@DateTimeFormat(pattern="dd MM yyyy")
    @Column(name = "BIRTHDAY")
    private Date birthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
