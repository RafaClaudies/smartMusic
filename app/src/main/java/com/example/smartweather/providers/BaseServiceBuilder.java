package com.example.smartweather.providers;


import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseServiceBuilder<T> {

    protected final Retrofit.Builder mBuilder;
    private final String URL_BASE = "https://deezerdevs-deezer.p.rapidapi.com/";

    protected BaseServiceBuilder() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();
        okHttpClientBuilder.addInterceptor(chain -> {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com")
                    .addHeader("X-RapidAPI-Key", "86a10cff49msh4cabf3188623594p1f23c3jsn43dc65cd90cd")
                    .build();
            return chain.proceed(request);
        });

        okHttpClientBuilder
                .addInterceptor(loggingInterceptor)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true);
        OkHttpClient client = okHttpClientBuilder.build();


        mBuilder = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create());

    }

    public abstract T build();

}
