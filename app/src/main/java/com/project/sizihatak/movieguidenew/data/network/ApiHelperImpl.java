package com.project.sizihatak.movieguidenew.data.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.project.sizihatak.movieguidenew.BuildConfig;
import com.project.sizihatak.movieguidenew.data.network.model.ApiError;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class ApiHelperImpl implements ApiHelper<MovieGuideApi> {

    private final MovieGuideApi api;
    private static final int TIME_OUT = 15;

    public ApiHelperImpl() {

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
