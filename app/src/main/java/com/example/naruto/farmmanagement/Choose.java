package com.example.naruto.farmmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose extends AppCompatActivity {

    public Button farmer_btn , cus_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        farmer_btn =(Button) findViewById(R.id.fbt);
        farmer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfarmer();
            }
        });

        cus_btn =(Button) findViewById(R.id.cbt);
        cus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencustomer();
            }
        });

    }
    public void openfarmer(){
        Intent far = new Intent(this, farmer.class);
        startActivity(far);
    }

    public void opencustomer()
    {
        Intent cus = new Intent(this, customer.class);
        startActivity(cus);
    }
}
