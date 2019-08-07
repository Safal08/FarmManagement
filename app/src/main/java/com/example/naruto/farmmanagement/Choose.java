package com.example.naruto.farmmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Choose extends AppCompatActivity {

    public Button farmer_btn , cus_btn;
    ViewFlipper vflipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        int images[]={R.drawable.s1, R.drawable.s2, R.drawable.s3};

        vflipper=findViewById(R.id.flipper);

        for(int image: images)
        {
            flipperImages(image);
        }

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



    public void flipperImages(int image)
    {
        ImageView imgView = new ImageView(this);
        imgView.setBackgroundResource(image);
        vflipper.addView(imgView);
        vflipper.setFlipInterval(4000);
        vflipper.setAutoStart(true);
        vflipper.setInAnimation(this, android.R.anim.slide_in_left);
        vflipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}