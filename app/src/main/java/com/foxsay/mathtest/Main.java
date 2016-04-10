package com.foxsay.mathtest;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.foxsay.mathtest.fragments.GeometryMenuListFragment;
import com.foxsay.mathtest.fragments.MainMenuListFragment;
import com.foxsay.mathtest.fragments.TaskFragment;
import com.foxsay.mathtest.model.Task;

public class Main extends AppCompatActivity implements MainMenuListFragment.OnListItemClick, TaskFragment.TaskPicker {

    ImageButton testBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new MainMenuListFragment()).commit();

//        testBut = (ImageButton) findViewById(R.id.testBut);
//        testBut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(Main.this, TestList.class);
//                startActivity(intent2);
//            }
//        });
    }

    @Override
    public void click(ListFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void select(Task task) {
        TaskFragment taskFragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putParcelable(TaskFragment.ARG_TASK, task);
        taskFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, taskFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
