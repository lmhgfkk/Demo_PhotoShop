package com.example.lmhgfkk.demo_photoshop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by lmhgfkk on 16/10/5.
 */
public class Matrix_PS extends AppCompatActivity {

    private ImageView imageview;
    private GridLayout gridlayout;
    private Button changebtn;
    private Button resetbtn;
    private int mEtWidth, mEtHeight;
    private EditText[] mEts=new EditText[20];
    private float[] colorMatrixs=new float[20];
    private Bitmap bitmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        imageview = (ImageView) findViewById(R.id.imageview);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        gridlayout = (GridLayout) findViewById(R.id.gridlayout);
        changebtn = (Button) findViewById(R.id.changebtn);
        resetbtn = (Button) findViewById(R.id.resetbtn);

        imageview.setImageBitmap(bitmap);

        gridlayout.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth=gridlayout.getWidth()/5;
                mEtHeight=gridlayout.getHeight()/4;
                addEditText();
                initMatrix();
            }
        });


    }



    private void addEditText() {
        for (int i = 0; i < 20; i++) {
            EditText et = new EditText(Matrix_PS.this);
            mEts[i]=et;
            gridlayout.addView(et,mEtWidth,mEtHeight);
        }
    }

    private void initMatrix() {
        for(int i=0;i<20;i++){
            if(i%6==0){
                mEts[i].setText(String.valueOf(1));
            }else {
                mEts[i].setText(String.valueOf(0));
            }
        }
    }

    private void getMatrix() {
        for(int i=0;i<20;i++){
            String s = mEts[i].getText().toString();
            colorMatrixs[i]=Float.valueOf(s);
        }
    }

    private void setImageMatrix() {
        Bitmap bitmap1 = Bitmap.createBitmap(this.bitmap.getWidth(), this.bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap1);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix colorMatrix=new ColorMatrix();
        colorMatrix.set(colorMatrixs);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        canvas.drawBitmap(this.bitmap,0,0,paint);

        imageview.setImageBitmap(bitmap1);
    }

    public void changebtn(View v){
        getMatrix();
        setImageMatrix();
    }
    public void resetbtn(View v){
        initMatrix();
        getMatrix();
        setImageMatrix();
    }
}
