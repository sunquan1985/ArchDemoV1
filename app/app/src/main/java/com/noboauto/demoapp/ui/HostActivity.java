package com.noboauto.demoapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.noboauto.demoapp.R;

/**
 * 宿主Activity
 *
 * @author zhongjiaxing
 */
public class HostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_activity);
    }
}