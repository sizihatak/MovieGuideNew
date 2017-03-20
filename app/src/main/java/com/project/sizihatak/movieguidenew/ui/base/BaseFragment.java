package com.project.sizihatak.movieguidenew.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.View;

import com.project.sizihatak.movieguidenew.MovieGuideApp;
import com.project.sizihatak.movieguidenew.di.component.DaggerFragmentComponent;
import com.project.sizihatak.movieguidenew.di.component.FragmentComponent;
import com.project.sizihatak.movieguidenew.di.module.ActivityModule;
import com.project.sizihatak.movieguidenew.di.module.FragmentModule;
import com.project.sizihatak.movieguidenew.di.scope.PerFragment;

import javax.inject.Inject;

import butterknife.Unbinder;

public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends Fragment implements MvpView {


    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private FragmentComponent fragmentComponent;


    @PerFragment
    @Inject
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent = DaggerFragmentComponent.builder()
                .appComponent(((MovieGuideApp) getBaseActivity().getApplication()).getAppComponent())
                .activityModule(new ActivityModule(getBaseActivity()))
                .fragmentModule(new FragmentModule())
                .build();
        setHasOptionsMenu(false);
    }

    public FragmentComponent getFragmentComponent() {
        return fragmentComponent;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //noinspection unchecked
        presenter.onAttach((V)this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onDetach();
    }


    @Override
    public void showLoading() {
        if (mActivity != null) {
            mActivity.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) {
            mActivity.hideLoading();
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }


    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp(View view);

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }


}
