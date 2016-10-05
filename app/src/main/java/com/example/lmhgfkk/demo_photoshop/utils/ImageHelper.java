package com.example.lmhgfkk.demo_photoshop.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by lmhgfkk on 16/10/5.
 */
public class ImageHelper {

    public static Bitmap handleImage(Bitmap btm,float hue,float saturation,float lum){
        Bitmap bitmap=Bitmap.createBitmap(btm.getWidth(),btm.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueMatrix=new ColorMatrix();
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        ColorMatrix saturationMatrix=new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix=new ColorMatrix();
        lumMatrix.setScale(lum,lum,lum,1);

        ColorMatrix imageMatrix=new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));

        canvas.drawBitmap(btm,0,0,paint);//注意这里传进来的是原图!!!

        return bitmap;
    }

    public static Bitmap handleImageDiPian(Bitmap btm){

        int width=btm.getWidth();
        int height=btm.getHeight();
        int[] oldPixels=new int[width*height];
        int[] newPixels=new int[width*height];

        Bitmap bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(btm,0,0,paint);

        bitmap.getPixels(oldPixels,0,width,0,0,width,height);

        for(int i=0;i<width*height;i++){
            int color=oldPixels[i];
            int r= Color.red(color);
            int g=Color.green(color);
            int b=Color.blue(color);
            int a=Color.alpha(color);

            r=255-r;
            g=255-g;
            b=255-b;
            if(r>255){
                r=255;
            }else if(r<0){
                r=0;
            }
            if(g>255){
                g=255;
            }else if(r<0){
                g=0;
            }
            if(b>255){
                b=255;
            }else if(r<0){
                b=0;
            }
            newPixels[i]=Color.argb(a,r,g,b);
        }

        bitmap.setPixels(newPixels,0,width,0,0,width,height);
        return bitmap;

    }


    public static Bitmap handleImageHuaijiu(Bitmap btm) {
        int width=btm.getWidth();
        int height=btm.getHeight();
        int[] oldPixels=new int[width*height];
        int[] newPixels=new int[width*height];

        Bitmap bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(btm,0,0,paint);

        bitmap.getPixels(oldPixels,0,width,0,0,width,height);

        for(int i=0;i<width*height;i++){
            int color=oldPixels[i];
            int r= Color.red(color);
            int g=Color.green(color);
            int b=Color.blue(color);
            int a=Color.alpha(color);

            r=(int)(0.393*r+0.769*g+0.189*b);
            g=(int)(0.349*r+0.686*g+0.168*b);
            b=(int)(0.272*r+0.534*g+0.131*b);
            if(r>255){
                r=255;
            }else if(r<0){
                r=0;
            }
            if(g>255){
                g=255;
            }else if(r<0){
                g=0;
            }
            if(b>255){
                b=255;
            }else if(r<0){
                b=0;
            }
            newPixels[i]=Color.argb(a,r,g,b);
        }

        bitmap.setPixels(newPixels,0,width,0,0,width,height);
        return bitmap;
    }

    public static Bitmap handleImageFudiao(Bitmap btm) {
        int width=btm.getWidth();
        int height=btm.getHeight();
        int[] oldPixels=new int[width*height];
        int[] newPixels=new int[width*height];

        Bitmap bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(btm,0,0,paint);

        bitmap.getPixels(oldPixels,0,width,0,0,width,height);

        for(int i=1;i<width*height;i++){
            int color=oldPixels[i];
            int colorvefore=oldPixels[i-1];

            int r= Color.red(color);
            int g=Color.green(color);
            int b=Color.blue(color);
            int a=Color.alpha(color);

            int rb= Color.red(colorvefore);
            int gb=Color.green(colorvefore);
            int bb=Color.blue(colorvefore);
            int ab=Color.alpha(colorvefore);

            rb=rb-r+127;
            gb=gb-g+127;
            bb=bb-b+127;

            if(rb>255){
                rb=255;
            }else if(rb<0){
                rb=0;
            }
            if(gb>255){
                gb=255;
            }else if(rb<0){
                gb=0;
            }
            if(bb>255){
                bb=255;
            }else if(rb<0){
                bb=0;
            }
            newPixels[i]=Color.argb(ab,rb,gb,bb);
        }

        bitmap.setPixels(newPixels,0,width,0,0,width,height);
        return bitmap;
    }
}
