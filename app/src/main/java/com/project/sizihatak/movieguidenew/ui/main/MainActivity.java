package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;

import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter<MainContract.View>>
        implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onError(String message) {

    }
}
