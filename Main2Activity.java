package com.example.shri.weight_and_watch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
   Button b2;
    EditText age1,height1,weight1,med1;
 RadioGroup rg;
 RadioButton r1,r2;
    TextView med,weight,height,gender,age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        age1=findViewById(R.id.age1);
        height1=findViewById(R.id.height1);
        weight1=findViewById(R.id.weight1);
        med1=findViewById(R.id.med1);
        b2=findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(getBaseContext(),Main3Activity.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(),"FOOD",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
