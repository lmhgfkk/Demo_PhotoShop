package com.example.lmhgfkk.demo_photoshop;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lmhgfkk.demo_photoshop.utils.ImageHelper;

/**
 * Created by lmhgfkk on 16/10/5.
 */
public class Pixel_PS extends AppCompatActivity implements View.OnClickListener {


    private ImageView imageview;
    private Bitmap bitmap;
    private Button btn_dipian;
    private Button btn_reset;
    private Button btn_huaijiu;
    private Button btn_fudiao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixel);

        imageview = (ImageView) findViewById(R.id.imageview);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.one);
        btn_dipian = (Button) findViewById(R.id.btn_dipian);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_huaijiu = (Button) findViewById(R.id.btn_huaijiu);
        btn_dipian.setOnClickListener(this);
        btn_fudiao = (Button) findViewById(R.id.btn_fudiao);

        btn_reset.setOnClickListener(this);
        btn_huaijiu.setOnClickListener(this);
        btn_fudiao.setOnClickListener(this);

        imageview.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dipian:
                Bitmap bitmapdipian = ImageHelper.handleImageDiPian(this.bitmap);
                imageview.setImageBitmap(bitmapdipian);
                break;
            case R.id.btn_reset:
                imageview.setImageBitmap(bitmap);
                break;
            case R.id.btn_huaijiu:
                Bitmap bitmaphuaijiu = ImageHelper.handleImageHuaijiu(this.bitmap);
                imageview.setImageBitmap(bitmaphuaijiu);
                break;
            case R.id.btn_fudiao:
                Bitmap bitmapfudiao = ImageHelper.handleImageFudiao(this.bitmap);
                imageview.setImageBitmap(bitmapfudiao);
                break;
        }
    }
}
