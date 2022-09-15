package com.example.healthauth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class loginQRCoder extends AppCompatActivity {
    //CodeScanner CS = new CodeScanner(this);
    Button scanbtn;
    TextView scanned_textview;
    private int flag = 0;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_qrcoder);
        scanbtn = findViewById(R.id.scanButton);
        scanned_textview = findViewById(R.id.scannedText);
    scanbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            flag = 1;
            IntentIntegrator intentIntegrator = new IntentIntegrator(loginQRCoder.this);
            intentIntegrator.setPrompt("For flash, use volume up key");
            intentIntegrator.setBeepEnabled(false);
            intentIntegrator.setOrientationLocked(true);
            intentIntegrator.setCaptureActivity(Capture.class);
            intentIntegrator.initiateScan();
        }
    });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String pass="abc";
        if(intentResult.getContents() != null) {
            if (pass.matches(intentResult.getContents())){
                Toast.makeText(this, "succseful", Toast.LENGTH_SHORT);
                Intent intent = new Intent(loginQRCoder.this, loginNumbers.class);
                startActivity(intent);
            }
                else
                scanned_textview.setText(intentResult.getContents()+" is not the required code.");

        } else {
            Toast.makeText(this, "OOPS....You didn't scan anything", Toast.LENGTH_SHORT).show();
        }
    }

    public void skipQR(View v)
    {
        Intent intent = new Intent(loginQRCoder.this, loginNumbers.class);
        startActivity(intent);
    }
}