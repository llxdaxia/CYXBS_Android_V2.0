package com.mredrock.cyxbs.presenter.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * A splash activity
 * <p>
 * Created by David on 15/5/17.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        this.finish();
    }
}
