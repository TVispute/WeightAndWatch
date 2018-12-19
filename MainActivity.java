package com.example.shri.weight_and_watch;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
     EditText number1,email1,password1,username1;
     String uname,e,p,n;
     Button b1;
     TextView number,email,password,username;
     SQLiteAdapter sqLiteAdapter;

    private ArrayList<LoginModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1=findViewById(R.id.number1);
        email1=findViewById(R.id.email1);
        username1=findViewById(R.id.username1);
        password1=findViewById(R.id.password1);
        b1=findViewById(R.id.b1);
        sqLiteAdapter= new SQLiteAdapter(this);
        list = new ArrayList<>();


        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                uname = Objects.requireNonNull(username1.getText()).toString();
                e=Objects.requireNonNull(email1.getText()).toString();
                p=Objects.requireNonNull(password1.getText()).toString();
                n=Objects.requireNonNull(number1.getText()).toString();

                boolean ins =  sqLiteAdapter.insert(sqLiteAdapter,uname,e,p,n);
                if (ins) {
                    Log.i("Status: ","Inserted!");
                } else {
                    Log.i("Status: ","Failure!");
                }

               list=  sqLiteAdapter.getAllRecords(sqLiteAdapter);
                Log.i("Dataaaaa",list.toString());




                Intent i=new Intent(getBaseContext(),Main2Activity.class);
                startActivity(i);
                //Toast.makeText(getApplicationContext(),"FOOD",Toast.LENGTH_SHORT).show();


            }
        });
    }


}
