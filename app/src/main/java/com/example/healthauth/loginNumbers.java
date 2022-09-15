package com.example.healthauth;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class loginNumbers extends AppCompatActivity {
    GridView textGridView;
    public String[] numb= new String[12];
    public int[] colors={
      R.color.color1,R.color.color2,R.color.color3,R.color.color4,R.color.color5,R.color.color6,R.color.color7,R.color.color8,R.color.color9,R.color.color10
    };
//            = new String[]{
//            "apple",
//            "box",
//            "angel",
//            "goat",
//            "money"
//    };
//    TextViewAdapter textViewAdapter;
//    GridView textGridView = findViewById(R.id.numGrid);
    Random rd = new Random(); // creating Random object
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_numbers);
        ///RANDOMize ARRAY OF COLORS
        shuffleColors();

        textGridView = findViewById(R.id.textGrid);
          //int[] arr = new int[5];
        for (int i = 0; i < 12; i++) {
            numb[i]=String.valueOf(rd.nextInt(15));
        }
        //setting the sec num
        //to be done later
        //for now just setting it 6
        int secnum=6;
        int loc = rd.nextInt(11);
        numb[loc]= String.valueOf(secnum);
        ////////////////////////////


        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this,R.layout.simplelistitem, R.id.secNumGrid,numb);
        textGridView.setAdapter(adapter);



//        textGridView.setAdapter(textViewAdapter);
//
//
//        textViewAdapter = new TextViewAdapter(this, numb);
//        //textViewAdapter.getView();
        textGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), "HI "+textGridView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                //view.setBackgroundColor(R.color.red);
                View cell = textGridView.getChildAt(i);
                TextView temp = (TextView) cell.findViewById(R.id.secNumGrid);
                temp.setTextColor(getResources().getColor(R.color.color1));
                                //Object temp = textGridView.getItemAtPosition(i);
                //A.setBackgroundColor(R.color.red);
            }
        });
       // for (int l=1;l<12;l++){
            //Object cell = textGridView.getItemAtPosition(l);
           // System.out.println(cell.toString());
            // TextView temp = (TextView) cell.findViewById(R.id.secNumGrid);
            //temp.setTextColor(getResources().getColor(R.color.color1));

        //}
}
        public void showColors(View view){
            int temColor[]=getResources().getIntArray(R.array.default_colors);

            CheckBox C = findViewById(R.id.showColor);

            if (C.isChecked())
            {
                for (int l=0;l<12;l++){
                    View cell = textGridView.getChildAt(l);
                    TextView temp = (TextView) cell.findViewById(R.id.secNumGrid);
                    temp.setTextColor(getResources().getColor(R.color.color4));

                }
            }
            else {
                for (int l = 0; l < 12; l++) {
                    View cell = textGridView.getChildAt(l);
                    TextView temp = (TextView) cell.findViewById(R.id.secNumGrid);
                    temp.setTextColor(getResources().getColor(R.color.color2));

                }
            }
        }
        public void shuffleColors()
        {
            Random rnd = new Random();
            for (int i = colors.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                if (i == index) {
                    ++i;
                } else {
                    int a = colors[index];
                    colors[index] = colors[i];
                    colors[i] = a;
                }
            }
        }
//        @Override
//        private void
}