package com.project.sizihatak.movieguidenew.data.network;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.project.sizihatak.movieguidenew.BuildConfig;
import com.project.sizihatak.movieguidenew.data.network.model.ApiError;
import com.project.sizihatak.movieguidenew.di.qualifiers.AppContext;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.net.sip.SipErrorCode.TIME_OUT;

@Singleton
public class ApiHelperImpl implements ApiHelper<MovieGuideApi> {

    private final MovieGuideApi api;

    @Inject
    ApiHelperImpl(@AppContext Context context) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        api = retrofit.create(MovieGuideApi.class);
    }


    @Override
    public MovieGuideApi getApi() {
        return api;
    }

    @Override
    public ApiError obtainError(Throwable throwable) {
        return null;
    }
}
