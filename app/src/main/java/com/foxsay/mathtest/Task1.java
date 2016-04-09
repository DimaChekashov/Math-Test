package com.foxsay.mathtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Task1 extends AppCompatActivity {
    CheckBox BOX1, BOX2, BOX3, BOX4;
    Button buttonAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task1);
        addListenrOnButtonClick();
    }

    public void addListenrOnButtonClick() {
        BOX1 = (CheckBox) findViewById(R.id.BOX1);
        BOX2 = (CheckBox) findViewById(R.id.BOX2);
        BOX3 = (CheckBox) findViewById(R.id.BOX3);
        BOX4 = (CheckBox) findViewById(R.id.BOX4);

        buttonAnswer = (Button) findViewById(R.id.answer);

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                if(BOX1.isChecked()){
                    result.append("\nПравильно!");
                    Intent intent2  = new Intent(Task1.this, Task0Answer.class);
                    startActivity(intent2);
                }if(BOX2.isChecked()){
                    Intent intent5  = new Intent(Task1.this, Task0_DontAnswer.class);
                    startActivity(intent5);
                    result.append("\nНе правильно!");
                }if(BOX3.isChecked()){
                    Intent intent6  = new Intent(Task1.this, Task0_DontAnswer.class);
                    startActivity(intent6);
                    result.append("\nНе правильно!");
                }if(BOX4.isChecked()){
                    Intent intent7  = new Intent(Task1.this, Task0_DontAnswer.class);
                    startActivity(intent7);
                    result.append("\nНе правильно!");
                }
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
