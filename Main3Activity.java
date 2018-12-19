package com.example.shri.weight_and_watch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

ImageButton food,yoga,frnd,contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    food=findViewById(R.id.food);
        contact=findViewById(R.id.contact);
        yoga=findViewById(R.id.yoga);
        frnd=findViewById(R.id.frnd);


        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"FOOD",Toast.LENGTH_SHORT).show();
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"YOGA",Toast.LENGTH_SHORT).show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"CONTACT",Toast.LENGTH_SHORT).show();
            }
        });

        frnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"FRND",Toast.LENGTH_SHORT).show();
            }
        });

    }
    }
