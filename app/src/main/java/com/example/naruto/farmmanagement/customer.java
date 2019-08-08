package com.example.naruto.farmmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customer extends AppCompatActivity {
    public Button customer_r_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        customer_r_btn = (Button) findViewById(R.id.customer_reg_btn);
        customer_r_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_cus_reg();
            }
        });
    }

    public void open_cus_reg()
    {
        Intent creg = new Intent(this, customer_register.class);
        startActivity(creg);
    }
}
