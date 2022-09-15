package com.example.healthauth;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import org.pytorch.IValue;
import org.pytorch.LiteModuleLoader;
import org.pytorch.Module;
import org.pytorch.Tensor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class registration3 extends AppCompatActivity implements UtilsFunctions{
    private DrawFragment drawFragment;
    //private SharedViewModel sharedViewModel;
    //private WritingView wv;
    //private TextView tv;
    private SharedViewModel sharedViewModel;
    private Module module;
    private RecognitionFragment recognitionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration3);

//        if (savedInstanceState == null) {
//            recognitionFragment = RecognitionFragment.newInstance();
//            drawFragment = DrawFragment.newInstance();
//
//            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
//                    .add(R.id.fragmentContainerView2, recognitionFragment, "RecognitionFragment")
//                    ///I have added DrawView.. it should be fragmentContainerView
//                    //
//                    //
//                    // .add(R.id.fragmentContainerView, drawFragment, "DrawFragment")
//                    .hide(drawFragment)
//                    .commit();
//        } else {
//            drawFragment = (DrawFragment) getSupportFragmentManager().getFragment(savedInstanceState, "drawFragment");
//            //getSupportFragmentManager().beginTransaction().show(drawFragment)
//            getSupportFragmentManager().beginTransaction().show(drawFragment).commit();
//        }

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);

        module = sharedViewModel.getModule();
        if (module == null) {
            try {
                // Loading serialized TorchScript module from file packaged into app Android asset (app/src/model/assets/modelMNIST_ts_lite.ptl)
                module = LiteModuleLoader.load(assetFilePath(this, "modelMNIST_ts_lite.ptl"));
                sharedViewModel.setModule(module);
            } catch (IOException e) {
                Log.e("IOException", "Error reading assets (module)", e);
                finish();
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    public String digitRecognition(Bitmap bitmap) {
        // Preparing input tensor
        Tensor inputTensor = null;
        try {
            inputTensor = UtilsFunctions.bitmapToFloat32Tensor(bitmap);
        } catch (Exception e) {
            Log.e("Exception", "Error bitmapToFloat32Tensor()", e);
            finish();
        }
        // Running the model
        final Tensor outputTensor = module.forward(IValue.from(inputTensor)).toTensor();

        // Getting tensor content as Java array of floats
        final float[] scores = outputTensor.getDataAsFloatArray();

        // Searching for the index with maximum score
        float maxScore = -Float.MAX_VALUE;
        int maxScoreIdx = -1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxScoreIdx = i;
            }
        }

        return "Recognised Digit: " + maxScoreIdx;
    }
    public static String assetFilePath(Context context, String assetName) throws IOException {
        File file = new File(context.getFilesDir(), assetName);
        if (file.exists() && file.length() > 0) {
            return file.getAbsolutePath();
        }

        try (InputStream is = context.getAssets().open(assetName)) {
            try (OutputStream os = new FileOutputStream(file)) {
                byte[] buffer = new byte[4 * 1024];
                int read;
                while ((read = is.read(buffer)) != -1) {
                    os.write(buffer, 0, read);
                }
                os.flush();
            }
            return file.getAbsolutePath();
        }
    }
}
        //Button clearBtn = findViewById(R.id.game_clear_btn);
        //wv = findViewById(R.id.writingView);
        //tv = findViewById(R.id.result_txt);
        //TextView verifyBtn = findViewById(R.id.game_ok_btn);
//        clearBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv.setText(getResources().getString(R.string.questionMark));
//                wv.clear();
//                wv.invalidate();
//            }
//        });

//        verifyBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv.setText(wv.testNN());
//                wv.clear();
//                wv.invalidate();
//            }
//        });

//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                1001);
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                1002);
    //}
//    public void onNext(View view)
//    {
//        }

    /**
     * Callback received when a permissions request has been completed.
     */
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//
//        switch (requestCode) {
//            case 1001:
//                // BEGIN_INCLUDE(permission_result)
//                // Received permission result for camera permission.
//                Log.i(TAG, "Received response for SDCARD permission request.");
//
//                // Check if the only required permission has been granted
//                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Camera permission has been granted, preview can be displayed
//                    Log.i(TAG, "SDCARD permission has now been granted. Showing preview.");
//
//                } else {
//                    Log.i(TAG, "SDCARD permission was NOT granted.");
//
//                }
//                // END_INCLUDE(permission_result)
//
//                break;
//            case 1002:
//                // BEGIN_INCLUDE(permission_result)
//                // Received permission result for camera permission.
//                Log.i(TAG, "Received response for SDCARD permission request.");
//
//                // Check if the only required permission has been granted
//                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Camera permission has been granted, preview can be displayed
//                    Log.i(TAG, "SDCARD permission has now been granted. Showing preview.");
//
//                } else {
//                    Log.i(TAG, "SDCARD permission was NOT granted.");
//
//                }
//                // END_INCLUDE(permission_result)
//
//                break;
//            default:
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//                break;
//        }
//    }
//}

//public class registration3 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_registration3);
//    }
//}