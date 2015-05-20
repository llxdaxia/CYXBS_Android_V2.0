package com.mredrock.cyxbs.model.entities;

/**
 * Info of user
 * <p>
 * Created by David on 15/5/15.
 */
public class UserEntity {
    private String stuNum;
    private String idNum;
    private String name;
    private String gender;
    private String classNum;
    private String major;
    private String college;
    private String grade;

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public static class UserEntityWrapper extends Wrapper{
        private UserEntity data;

        public UserEntity getData() {
            return data;
        }

        public void setData(UserEntity data) {
            this.data = data;
        }
    }
}
