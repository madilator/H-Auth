package com.example.healthauth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.Random;


public class CustomAdapter extends BaseAdapter {

    public int[] imagePhoto ={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12,R.drawable.image13,R.drawable.image14,R.drawable.image15,R.drawable.image16,R.drawable.image17,R.drawable.image18,R.drawable.image19,R.drawable.image20};//,R.drawable.image21};
    private  Context context;
    private int selectedPosition = -1;
    private  LayoutInflater layoutInflater;

//    int[] imagePhoto1,
    public CustomAdapter( Context context1) {
      //  this.imagePhoto = imagePhoto1;
        this.context = context1;
      //  this.layoutInflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

    }
    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }
    public void rand()
    {
        int array[]=imagePhoto;
        int a=imagePhoto.length;
        // Creating object for Random class
        Random rd = new Random();

        // Starting from the last element and swapping one by one.
        for (int i = a-1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = rd.nextInt(i+1);

            // Swap array[i] with the element at random index
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        imagePhoto = array;
        // Printing the random generated array
        //System.out.println(Arrays.toString(array));
    }

    @Override
    public int getCount() {
        return imagePhoto.length;
    }

    @Override
    public Object getItem(int i) {
        return imagePhoto[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imView= new ImageView(context);
        imView.setImageResource(imagePhoto[i]);
        imView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //imView.setColorFilter(R.color.red);
        imView.setLayoutParams(new ViewGroup.LayoutParams(250,250));
        imView.setBackgroundResource(R.drawable.bordersblack);
        return imView;
        //        System.out.println("message");
//        if (view == null)
//        {
//
//            view=layoutInflater.inflate(R.layout.row_items,viewGroup,false);
//        }
//        ImageView imView= view.findViewById(R.id.image_for_grid);
//        imView.setImageResource(imagePhoto[i]);
//        return imView;
    }
}
