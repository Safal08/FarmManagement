package com.example.naruto.farmmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class farmer_register extends AppCompatActivity {
        DatabaseHelper db;
        EditText e1, e2, e3, e4;
        Button b1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_customer_register);
            db = new DatabaseHelper(this);
            e1 = (EditText)findViewById(R.id.f_name);
            e2 = (EditText)findViewById(R.id.f_password);
            e3 = (EditText)findViewById(R.id.f_contact);
            e4 = (EditText)findViewById(R.id.f_address);
            b1 =(Button)findViewById(R.id.farmer_reg_btn);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s1 = e1.getText().toString();
                    String s2 = e2.getText().toString();
                    String s3 = e3.getText().toString();
                    String s4 = e4.getText().toString();
                    if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                        Toast.makeText(getApplicationContext(),"Fields are empty", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean checkemail = db.checkemail(s1);
                        if(checkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else Toast.makeText(getApplicationContext(),"Username Already Exists", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
