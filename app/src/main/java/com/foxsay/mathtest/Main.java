package com.foxsay.mathtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main extends AppCompatActivity {

    ImageButton testBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


//        testBut = (ImageButton) findViewById(R.id.testBut);
//        testBut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(Main.this, TestList.class);
//                startActivity(intent2);
//            }
//        });
    }


}
