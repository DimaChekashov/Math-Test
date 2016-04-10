package com.foxsay.mathtest.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

/**
 * @author roman
 * @since 10.04.2016
 */
public class Task implements Parcelable {

    private String img;
    private String task;
    private String answer;
    private List<String> answers;

    /**
     * 1 - true, is One answer
     * 0 - false, several answers
     */
    private Integer isOneAnswer = 1;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Integer getIsOneAnswer() {
        return isOneAnswer;
    }

    public void setIsOneAnswer(Integer isOneAnswer) {
        this.isOneAnswer = isOneAnswer;
    }

    public boolean isOneAnswer(){
        return 0 != isOneAnswer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v("", "writeToParcel..." + flags);
        dest.writeString(img);
        dest.writeString(task);
        dest.writeString(answer);
        dest.writeList(answers);
        dest.writeInt(isOneAnswer);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Task createFromParcel(Parcel in) {
            final Task task = new Task();
            task.setImg(in.readString());
            task.setTask(in.readString());
            task.setAnswer(in.readString());

            List<String> answerList = null;
            in.readList(answerList, List.class.getClassLoader());
            task.setAnswers(answerList);
            task.setIsOneAnswer(1);
            return task;
        }

        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

}
