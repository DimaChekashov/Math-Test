package com.foxsay.mathtest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.foxsay.mathtest.R;
import com.foxsay.mathtest.model.Task;

/**
 * @author roman
 * @since 10.04.2016
 */
public class TaskFragment extends Fragment {

    public static final String ARG_TASK = "task";
    Button buttonAnswer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_fragment, container, false);
        Task task = null;
        if(null == savedInstanceState){
            task = getArguments().getParcelable(ARG_TASK);
        } else {
            task = savedInstanceState.getParcelable(ARG_TASK);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.ivTask);
        imageView.setImageResource(getActivity().getResources().getIdentifier(task.getImg(), "drawable", getActivity().getPackageName()));

        buttonAnswer = (Button) view.findViewById(R.id.answer);
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    public interface TaskPicker{
        void select(Task task);
    }
}
