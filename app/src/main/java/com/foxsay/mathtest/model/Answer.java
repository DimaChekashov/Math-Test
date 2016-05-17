package com.foxsay.mathtest.model;

/**
 * @author rchekashov
 * @since 17.05.2016
 */
public class Answer {
    private Integer taskId;
    private String answer;
    private Integer correct;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }
}
