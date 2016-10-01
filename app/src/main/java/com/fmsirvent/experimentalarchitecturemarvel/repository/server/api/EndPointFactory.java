package com.fmsirvent.experimentalarchitecturemarvel.repository.server.api;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EndPointFactory {
    private static final String MARVEL_BASE_URL = "http://gateway.marvel.com";

    @Inject
    EndPointFactory() { }

    public Object getService(Class<?> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MARVEL_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }
}
