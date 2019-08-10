package com.example.naruto.farmmanagement;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class farmer_register extends AppCompatActivity {
    Button register;
    EditText username,password,contact,address;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_register);

        register= (Button) findViewById(R.id.farmer_reg_btn);
        username= (EditText) findViewById(R.id.f_name);
        password=(EditText) findViewById(R.id.f_password);
        contact=(EditText) findViewById(R.id.f_contact);
        address=(EditText) findViewById(R.id.f_address);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().trim().isEmpty() || !address.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(farmer_register.this,"Fill all the data",Toast.LENGTH_LONG).show();
                    boolean isInserted = db.insertData(username.getText().toString(), address.getText().toString(), password.getText().toString(), contact.getText().toString());
                    if(isInserted)
                    {
                        showMessage("Sucess" ,"Data inserted sucessfully");
                    }else {
                        showMessage("Error", "failed to insert data");
                    }}else
                {
                    Toast.makeText(farmer_register.this,"Sucess",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void showMessage(String Title, String message ){
        AlertDialog.Builder builder = new AlertDialog.Builder(farmer_register.this);
        builder.setCancelable(true);
        builder.setTitle("Showing Message");
        builder.setMessage("Test");
        builder.show();

    }
}
