package com.android.phuston.imgor.api;

import com.android.phuston.imgor.models.ImageQuery;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by patrick on 8/26/15.
 */
public interface SearchDbEndpointInterface {
    @GET("/")
    void getImages(@Query("key") String api_key, @Query("cx") String cx, @Query("searchType") String searchType, @Query("q") String searchTerm, Callback<ImageQuery> cb);
}