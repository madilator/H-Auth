package com.example.healthauth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registration2 extends AppCompatActivity {

    GridView gridView;
//    public int[][] imagePhoto ={
//            {R.drawable.image1,0},
//            {R.drawable.image2,0},
//            {R.drawable.image3,0},
//            {R.drawable.image4,0},
//            {R.drawable.image5,0},
//            {R.drawable.image6,0},
//            {R.drawable.image7,0},
//            {R.drawable.image8,0},
//            {R.drawable.image9,0},
//            {R.drawable.image10,0},{R.drawable.image11,0},{R.drawable.image12,0},{R.drawable.image13,0},{R.drawable.image14,0},{R.drawable.image15,0},{R.drawable.image16,0},{R.drawable.image17,0},{R.drawable.image18,0},{R.drawable.image19,0},{R.drawable.image20,0}};//,R.drawable.image21};
    private int img [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int countSelect=0;
   // private int abc[]= new int[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        gridView = findViewById(R.id.gridPic);
        gridView.setDrawSelectorOnTop(true);
        CustomAdapter customAdapter = new CustomAdapter(this);
        customAdapter.rand();
            gridView.setAdapter(customAdapter);

//            for (int j=0;j<20;j++)
//            {
//                abc[j]=gridView.getChildAt(j).getId();
//            }

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                View viewPrev;
                @SuppressLint("ResourceAsColor")
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //gridView.ge
                   // customAdapter.setSelectedPosition(i);
                   // customAdapter.notifyDataSetChanged();
                    //ImageView it = (ImageView) adapterView.getItemAtPosition(i);
//                    Long s_id = adapterView.getItemIdAtPosition(i);
                    View v = gridView.getChildAt(i);
                    //ImageView temp = (ImageView) v.findViewById(R.id.image_for_grid);
                    //temp.setImageResource(R.drawable.image7);
//                    for (int i=0,i<imagePhoto.length;i++)
//                    {
//                        if (v.get()==imagePhoto[i][0])
//                    }
                    //img[i]=1;
                    //System.out.println(img[i]+ " "+i);
                    if (img[i]==0) {
                        if (countSelect<=2) {
                            v.setBackgroundResource(R.drawable.borders);
                            img[i] = 1;
                            countSelect += 1;
                        }
                        else
                            Toast.makeText(view.getContext(),"Already Selected 3 images",Toast.LENGTH_SHORT).show();
                        //System.out.println("You selected "+abc[i]);
                        //System.out.println("false area" + v.isSelected());
                    }
                    else
                        //v.setBackground(null);
                    {
                        v.setBackgroundResource(R.drawable.bordersblack);
                        //v.setSelected(false);
                        //System.out.println(v.isSelected());
                        countSelect-=1;
                        img[i]=0;
                    }



                    //gridView.setBackgroundColor(Color.RED);
                   // gridView.setVerticalSpacing(1);
                    //gridView.setHorizontalSpacing(1);
                    //temp.setColorFilter(R.color.red);
                    // temp.setBackground((Drawable) R.drawable.borders);
                    //gridView.getChildAt(i).setOutlineSpotShadowColor(R.color.red);
                    //System.out.println(s_id);
                    //gridView.setSelection(i);
                    //Object Child = adapterView.getItemAtPosition(i);
                    //Child.setbac
                    //System.out.println(Child.toString());
                    //Child.setBackgroundColor(R.color.red);
                    //adapterView.setBackgroundColor(R.color.red);
  //                  viewPrev = (View) gridView.getChildAt(i);
    //                viewPrev.setBackgroundColor(R.color.red);

                    //System.out.println(customAdapter.getItem(i));
                }
            });
    }
    public void openReg3(View view)
    {
        Intent intent = new Intent(registration2.this, registration3.class);
        startActivity(intent);

    }



}