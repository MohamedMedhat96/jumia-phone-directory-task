package com.example.phone.directory.model.lookups;

import com.example.phone.directory.model.AbstractModel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CountryRegex extends AbstractModel {

    @Column(name = "name")
    private String name;
    @Column(name = "regex")
    private String regex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
