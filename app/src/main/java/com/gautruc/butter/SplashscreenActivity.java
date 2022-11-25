package com.gautruc.butter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.window.SplashScreen;

import com.gautruc.butter.databinding.ActivitySplashscreenBinding;

public class SplashscreenActivity extends AppCompatActivity {



    ActivitySplashscreenBinding binding;
    public Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splashscreen);
        binding = ActivitySplashscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public Thread myThread = new Thread(){
        public void run(){
           Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
           startActivity(intent);
           finish();
        }
    };

    @Override
    protected void onResume(){
        super.onResume();
        //Set time to delay for splash screen ->  run  after 300 millis of time elapses
        handler.postDelayed(myThread, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Remove any pending posts of myThread that are in the message queue.
        handler.removeCallbacks(myThread);
    }

    };

