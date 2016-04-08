package com.foxsay.mathtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Task0_DontAnswer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task0__dont_answer);

        Button showanswer = (Button) findViewById(R.id.Show_answer);
        showanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Task0_DontAnswer.this, Task0Answer.class);
                startActivity(intent3);
            }
        });
    }
}
