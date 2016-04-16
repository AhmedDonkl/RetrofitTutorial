package com.ahmeddonkl.retrofittutorial.Service.API;

import com.ahmeddonkl.retrofittutorial.Constants;

import retrofit.RestAdapter;

/**
 * Created by OmarAli on 16/10/2015.
 */
public class ServiceBuilder {
    private RestAdapter restAdapter;
    public ServiceBuilder(){
        restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setEndpoint(Constants.BASE_URL).build();
    }
    public API.Routes BuildMovies(){
        return restAdapter.create(API.Routes.class);
    }

/*    public API.Trailers BuildTrailers(){
        return restAdapter.create(API.Trailers.class);
    }
    public API.Reviews BuildReviews(){
        return restAdapter.create(API.Reviews.class);
    } */
}
