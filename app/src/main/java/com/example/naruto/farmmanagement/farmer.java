package com.example.naruto.farmmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class farmer extends AppCompatActivity {
    public Button farmer_login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

        farmer_login_btn= (Button) findViewById(R.id.farmer_reg_btn);
        farmer_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_farmer_reg();
            }
        });
    }

    public void open_farmer_reg()
    {
        Intent freg = new Intent(this, farmer_register.class);
        startActivity(freg);
    }
}
