package com.accounting.my.model;

import javax.persistence.*;

/**
 * Created by Balas on 3/28/2016.
 */
@Entity
@Table(name = "ROLES")
public class Roles extends BaseEntity {


    @Column(name = "NAME")
    private String name;


   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
