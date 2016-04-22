package com.foxsay.mathtest.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.foxsay.mathtest.R;
import com.foxsay.mathtest.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roman
 */
public class GeometryMenuListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.geometry_menu_array));
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TaskFragment.TaskPicker taskPicker = (TaskFragment.TaskPicker) getActivity();

        Task task = new Task();
        List<String> answers = new ArrayList<>();
        answers.add("6 дм");

        List<String> possibleAnswers = new ArrayList<>();
        possibleAnswers.add("3 дм");
        possibleAnswers.add("6 дм");
        possibleAnswers.add("10 дм");
        possibleAnswers.add("4 дм");

        task.setQuestionImg("task1");
        task.setQuestion("task question?");
        task.setTaskAnswers(answers);
        task.setPossibleTaskAnswers(possibleAnswers);

        taskPicker.select(task);
    }

}
