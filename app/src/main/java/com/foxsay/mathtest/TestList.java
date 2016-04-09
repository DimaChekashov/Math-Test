package com.foxsay.mathtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TestList extends AppCompatActivity {

    ImageButton celindrBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list);

        celindrBut = (ImageButton) findViewById(R.id.celindrBut);
        celindrBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(TestList.this, Task1.class);
                startActivity(intent2);
            }
        });
    }

}
