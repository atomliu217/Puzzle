package com.example.administrator.puzzle;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/6/11.
 */
public class MainView extends View {
    private Context context;
    private Paint paint;
    private Bitmap back;
    public MainView(Context context) {
        super(context);
        paint = new Paint();
        this.context=context;
        init();
        invalidate();
    }
    private void init(){
        AssetManager assetManager= context.getAssets();
        try {
            InputStream assetInputStream=assetManager.open("back.jpg");
            Bitmap bitmap= BitmapFactory.decodeStream(assetInputStream);
            back=Bitmap.createScaledBitmap(bitmap,
                    MainActivity.getScreenWidth(),MainActivity.getScreenHeight(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(back,0,0,paint);
    }
}
