package com.foxsay.mathtest.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

/**
 * table in DB: tasks
 *
 * @author roman
 * @since 10.04.2016
 */
public class Task implements Parcelable {

    private Integer id;
    private String section; // Math, Physics
    private String subSection; // Geometry, Algebra
    private String group; // Cylinder, Sphere
    private String question;
    private String questionImg;
    private QuestionViewType questionViewType;

    /**
     * 1 - true, is One answer
     * 0 - false, several answers
     */
    private Integer oneAnswer = 1;

    private List<String> taskAnswers;
    private List<String> possibleTaskAnswers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubSection() {
        return subSection;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionImg() {
        return questionImg;
    }

    public void setQuestionImg(String questionImg) {
        this.questionImg = questionImg;
    }

    public QuestionViewType getQuestionViewType() {
        return questionViewType;
    }

    public void setQuestionViewType(QuestionViewType questionViewType) {
        this.questionViewType = questionViewType;
    }

    public Integer getOneAnswer() {
        return oneAnswer;
    }

    public void setOneAnswer(Integer oneAnswer) {
        this.oneAnswer = oneAnswer;
    }

    public List<String> getTaskAnswers() {
        return taskAnswers;
    }

    public void setTaskAnswers(List<String> taskAnswers) {
        this.taskAnswers = taskAnswers;
    }

    public List<String> getPossibleTaskAnswers() {
        return possibleTaskAnswers;
    }

    public void setPossibleTaskAnswers(List<String> possibleTaskAnswers) {
        this.possibleTaskAnswers = possibleTaskAnswers;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v("", "writeToParcel..." + flags);
        dest.writeString(questionImg);
        dest.writeString(question);
        dest.writeList(taskAnswers);
        dest.writeInt(oneAnswer);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Task createFromParcel(Parcel in) {
            final Task task = new Task();
            task.setQuestionImg(in.readString());

            List<String> answerList = null;
            in.readList(answerList, List.class.getClassLoader());
            task.setTaskAnswers(answerList);
            task.setOneAnswer(1);
            return task;
        }

        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

}
