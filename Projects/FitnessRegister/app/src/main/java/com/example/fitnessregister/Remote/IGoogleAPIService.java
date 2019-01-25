package com.example.fitnessregister.Remote;

import retrofit2.Call;

import com.example.fitnessregister.Model.MyGyms;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IGoogleAPIService {
    @GET
    Call<MyGyms> getNearByPlaces(@Url String url);
}
