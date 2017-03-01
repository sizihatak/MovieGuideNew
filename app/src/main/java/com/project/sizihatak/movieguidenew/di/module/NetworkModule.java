package com.project.sizihatak.movieguidenew.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.project.sizihatak.movieguidenew.BuildConfig;
import com.project.sizihatak.movieguidenew.data.network.ApiHelper;
import com.project.sizihatak.movieguidenew.data.network.AppApiHelper;
import com.project.sizihatak.movieguidenew.data.network.MovieGuideApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final int TIME_OUT = 15;

    @Provides
    @Singleton
    ApiHelper<MovieGuideApi> provideApiHelper(AppApiHelper apiHelper) {
        return apiHelper;
    }


    @Provides
    @Singleton
    MovieGuideApi provideMovieGuideApi() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(getInterceptorLevel());

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

        return retrofit.create(MovieGuideApi.class);
    }

    HttpLoggingInterceptor.Level getInterceptorLevel() {
        if (BuildConfig.DEBUG) {
            return HttpLoggingInterceptor.Level.BODY;
        } else {
            return HttpLoggingInterceptor.Level.NONE;
        }
    }
}
