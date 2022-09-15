package com.example.healthauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openReg(View view)
    {
        Intent intent = new Intent(MainActivity.this, Registration.class);
        startActivity(intent);

    }

    public void abc2(View view)
    {
        Intent intent = new Intent(MainActivity.this, loginQRCoder.class);
        startActivity(intent);
        //Toast.makeText(this,"button 2 clicked ",Toast.LENGTH_SHORT).show();
    }
}