package com.example.findthefake;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Animation zoom_anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.AppLogo);
        textView = findViewById(R.id.AppTitle);

        zoom_anim = AnimationUtils.loadAnimation(this,R.anim.zoom_animation);

        imageView.setAnimation(zoom_anim);
        textView.setAnimation(zoom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                Pair<View,String> p1 = Pair.create(imageView,"AppLogo");
                Pair<View,String> p2 = Pair.create(textView,"AppTitle");
                Pair<View,String>[] pairs = new Pair[2];
                pairs[0]=p1;
                pairs[1]=p2;
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);
                startActivity(intent,options.toBundle());
            }
        },3000);
    }
}