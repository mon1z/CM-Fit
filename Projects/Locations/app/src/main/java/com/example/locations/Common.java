package com.example.locations;

import com.example.locations.Remote.IGoogleAPIService;
import com.example.locations.Remote.RetrofitClient;

public class Common {
    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/";

    public static IGoogleAPIService getGoogleApiService(){
        return RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }
}

