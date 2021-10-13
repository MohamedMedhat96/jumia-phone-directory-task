package com.example.phone.directory.model.lookups;

import com.example.phone.directory.model.AbstractModel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "country_codes")
public class CountryCodes extends AbstractModel {
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    public String getCountryName() {
        return name;
    }

    public void setCountryName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
