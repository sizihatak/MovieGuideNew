package com.project.sizihatak.movieguidenew.data;

import com.project.sizihatak.movieguidenew.data.network.ApiHelper;
import com.project.sizihatak.movieguidenew.data.network.MovieGuideApi;

import javax.inject.Inject;

public class AppDataManager implements DataManager{

    private ApiHelper<MovieGuideApi> apiHelper;

    @Inject
    public AppDataManager(ApiHelper<MovieGuideApi> apiHelper) {
        this.apiHelper = apiHelper;
    }


    @Override
    public MovieGuideApi getApi() {
        return apiHelper.getApi();
    }
}
