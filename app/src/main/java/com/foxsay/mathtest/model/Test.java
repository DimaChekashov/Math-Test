package com.foxsay.mathtest.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * table in DB: tests
 *
 * @author roman
 * @since 15.04.2016
 */
public class Test {
    private Integer id;
    private Date date;
    private Integer time;
    private Float grade;

    private List<Task> tasks;
    private Map<Integer, List<String>> answers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Map<Integer, List<String>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, List<String>> answers) {
        this.answers = answers;
    }
}
