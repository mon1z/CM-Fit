package com.example.fitnessregister;

import com.example.fitnessregister.Remote.IGoogleAPIService;
import com.example.fitnessregister.Remote.RetrofitClient;

public class Common {
    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/";

    public static IGoogleAPIService getGoogleApiService(){
        return RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }
}

