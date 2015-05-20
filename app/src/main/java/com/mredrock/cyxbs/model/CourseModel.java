package com.mredrock.cyxbs.model;

import java.io.Serializable;

/**
 * Created by David on 15/5/20.
 */
public class CourseModel implements Serializable {
    private String hash_day;
    private String hash_lesson;
    private String begin_lesson;
    private String day;
    private String lesson;
    private String course;
    private String teacher;
    private String classroom;
    private String rawWeek;
    private String weekModel;
    private String weekBegin;
    private String weekEnd;
    private String[] week;
    private String status;
    private String period;

    public String getBegin_lesson() {
        return begin_lesson;
    }

    public void setBegin_lesson(String begin_lesson) {
        this.begin_lesson = begin_lesson;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHash_day() {
        return hash_day;
    }

    public void setHash_day(String hash_day) {
        this.hash_day = hash_day;
    }

    public String getHash_lesson() {
        return hash_lesson;
    }

    public void setHash_lesson(String hash_lesson) {
        this.hash_lesson = hash_lesson;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRawWeek() {
        return rawWeek;
    }

    public void setRawWeek(String rawWeek) {
        this.rawWeek = rawWeek;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String[] getWeek() {
        return week;
    }

    public void setWeek(String[] week) {
        this.week = week;
    }

    public String getWeekBegin() {
        return weekBegin;
    }

    public void setWeekBegin(String weekBegin) {
        this.weekBegin = weekBegin;
    }

    public String getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(String weekEnd) {
        this.weekEnd = weekEnd;
    }

    public String getWeekModel() {
        return weekModel;
    }

    public void setWeekModel(String weekModel) {
        this.weekModel = weekModel;
    }
}
