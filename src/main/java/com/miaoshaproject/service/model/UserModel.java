package com.miaoshaproject.service.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserModel {
    private Integer id;
    @NotBlank(message = "User Name cannot be blank")
    private String name;
    @NotNull(message = "Gender cannot be blank")
    private Boolean gender;
    @NotNull(message = "Age cannot be blank")
    @Min(value=0, message = "Age has to be greater than 0")
    @Max(value=150, message = "Age too large")
    private Integer age;
    @NotBlank(message = "Phone number cannot be blank")
    private String telephone;
    private String registerMode;
    private String thirdPartyId;
    @NotBlank(message = "Password cannot be blank")
    private String encrptPassword;

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }
}
