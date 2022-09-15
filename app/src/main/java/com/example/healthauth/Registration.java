package com.example.healthauth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Registration extends AppCompatActivity {
    public boolean colorflag=false;
//    Button openColorDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView numm= findViewById(R.id.editTextNumber);

        setContentView(R.layout.activity_registration);
//        openColorDialog = findViewById(R.id.button2);
//        openColorDialog.setOnClickListner;
    }
    @SuppressLint("ResourceAsColor")
    public void saveNext(View view)
    {
        //TextView numm_title= findViewById(R.id.textView3);
        TextView numm= findViewById(R.id.editTextNumber);
        //String n= (String) numm.getText();;
        if (TextUtils.isEmpty( numm.getText().toString())) {
            Toast.makeText(this, "Select Number ", Toast.LENGTH_SHORT).show();
            //numm.setFocusable(true);
            //numm.setHighlightColor(R.color.red);
            //numm_title.setTextColor(R.color.red);
            //numm_title.setHighlightColor(R.color.red);
        }
        else if (colorflag==false)
        {
            Toast.makeText(this, "Select Color", Toast.LENGTH_SHORT).show();

        }
        else {
            Intent intent = new Intent(Registration.this, registration2.class);
            startActivity(intent);
        }
    }

    public void colorsD(View view){

//        Toast.makeText(this,"Choose color clicked ",Toast.LENGTH_SHORT).show();
        Button btn1 = findViewById(R.id.button2);
        ColorPicker colorPicker = new ColorPicker(Registration.this);
        colorPicker.setDefaultColorButton(-14654801);
        colorPicker.show();

        //colorPicker.setTitle("new tile");
            colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
            @Override
            public void onChooseColor(int position,int color) {
                // put code
                System.out.println(color);
                    if (color==0)
                        Toast.makeText(view.getContext(),"No color selected",Toast.LENGTH_SHORT).show();
                    else {
                        System.out.println(color);
                        btn1.setBackgroundColor(color);
                        btn1.setText("Color Selected");
                        colorflag = true;
                    }

            }


            @Override
            public void onCancel(){
                // put code
                Toast.makeText(view.getContext(),"No color selected",Toast.LENGTH_SHORT).show();
            }
        });

//        final Dialog colorDialog = new Dialog(Registration.this);
//        colorDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        colorDialog.setCancelable(true);
//        colorDialog.setContentView(R.layout.colordilogue);
////view initialization
//        final EditText ttext = colorDialog.findViewById(R.id.textView5);
//        final ImageView iv1= colorDialog.findViewById(R.id.imageView);
//        Button btn1 = colorDialog.findViewById(R.id.button3);

//Listner
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                colorDialog.dismiss();
//            }
//        });
          // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
//        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//
//// 2. Chain together various setter methods to set the dialog characteristics
//        builder.setMessage("hi")
//                .setTitle("title");
//
//// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
//        AlertDialog dialog = builder.create();
    }

    public void invertRadio(View view)
    {
        RadioButton sA =  (RadioButton) findViewById(R.id.singleAdd);
        RadioButton sS =  (RadioButton) findViewById(R.id.singleSub);
        RadioButton dA = (RadioButton) findViewById(R.id.doubleAdd);
        RadioButton dS = (RadioButton) findViewById(R.id.doubleSub);

        switch (view.getId())
        {
            case R.id.singleAdd:
                dS.setChecked(true);
                break;
            case R.id.singleSub:
                dA.setChecked(true);
                break;
            case R.id.doubleAdd:
                sS.setChecked(true);
                break;
            case R.id.doubleSub:
                sA.setChecked(true);
                break;
//            case R.id.button2:
//                Toast.makeText(this, "hi", Toast.LENGTH_LONG).show();

            //ColorPickerDialog cc = new ColorPickerDialog(this, (key, color1) -> {},"ass",color,color);

            default:
                break;

        }
    }

}