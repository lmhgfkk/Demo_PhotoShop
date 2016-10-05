package com.example.lmhgfkk.demo_photoshop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.lmhgfkk.demo_photoshop.utils.ImageHelper;

/**
 * Created by lmhgfkk on 16/10/5.
 */
public class SeekBar_PS extends Activity implements SeekBar.OnSeekBarChangeListener {

    private ImageView imageview ;
    private Bitmap bitmap;
    private SeekBar seekbar_hue;
    private SeekBar seekbar_saturation;
    private SeekBar seekbar_lum ;
    private static final int MAX_VALUE=255;
    private static final int MID_VALUE=127;
    private float hue,saturation,lum;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        imageview = (ImageView) findViewById(R.id.imageview);
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.one);

        seekbar_hue = (SeekBar) findViewById(R.id.seekbar_hue);
        seekbar_saturation = (SeekBar) findViewById(R.id.seekbar_saturation);
        seekbar_lum = (SeekBar) findViewById(R.id.seekbar_lum);

        //监听必须在设置前面,否则图像黑屏
        seekbar_hue.setOnSeekBarChangeListener(this);
        seekbar_saturation.setOnSeekBarChangeListener(this);
        seekbar_lum.setOnSeekBarChangeListener(this);

        seekbar_hue.setMax(MAX_VALUE);
        seekbar_hue.setProgress(MID_VALUE);

        seekbar_saturation.setMax(MAX_VALUE);
        seekbar_saturation.setProgress(MID_VALUE);

        seekbar_lum.setMax(MAX_VALUE);
        seekbar_lum.setProgress(MID_VALUE);


        imageview.setImageBitmap(bitmap);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekbar_hue:
                hue=(progress - MID_VALUE) * 1.0F / MID_VALUE * 180;
                System.out.println(hue);
                break;
            case R.id.seekbar_saturation:
                saturation=progress*1.0F/MID_VALUE;
                System.out.println(saturation);
                break;
            case R.id.seekbar_lum:
                lum=progress*1.0F/MID_VALUE;
                System.out.println(lum);
                break;
        }
        imageview.setImageBitmap(ImageHelper.handleImage(bitmap, hue, saturation, lum));


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
