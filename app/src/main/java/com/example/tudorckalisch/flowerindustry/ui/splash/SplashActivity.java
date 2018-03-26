package com.example.tudorckalisch.flowerindustry.ui.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.tudorckalisch.flowerindustry.R;
import com.example.tudorckalisch.flowerindustry.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashActivity extends Activity implements SplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigateHome();
    }

    @Override
    public void navigateHome() {
        Completable.timer(3, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe(this::startMain);
    }

    private void startMain() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
