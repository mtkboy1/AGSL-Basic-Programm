package com.u063.agslcalcs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(new DrawView(this));
    }

    class DrawView extends View{
        Context c;
        DrawView(Context c){
            super(c);
            this.c = c;
        }
        @Override
        protected void onDraw(Canvas canvas){
            Bitmap b = Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888);
            @SuppressLint("DrawAllocation")
            RuntimeShader runtimeShader = new RuntimeShader(new AGSLReader().readFrom(R.raw.main,c));
            @SuppressLint("DrawAllocation")
            Paint paint = new Paint();
            runtimeShader.setFloatUniform("h", 0.5f);
            runtimeShader.setFloatUniform("size", getWidth(),getHeight());
            paint.setShader(runtimeShader);
            canvas.drawPaint(paint);

        }
    }
}