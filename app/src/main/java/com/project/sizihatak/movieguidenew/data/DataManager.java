package com.project.sizihatak.movieguidenew.data;

import com.project.sizihatak.movieguidenew.data.network.MovieGuideApi;

public interface DataManager {
    MovieGuideApi getApi();
    String getEndPoint();
    String getPosterEndPoint();
}
