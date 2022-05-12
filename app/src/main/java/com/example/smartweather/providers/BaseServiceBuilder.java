package com.example.smartweather.providers;


import java.util.Collections;
import java.util.concurrent.TimeUnit;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseServiceBuilder<T> {

    protected final Retrofit.Builder mBuilder;
    private final String URL_BASE = "https://pro.openweathermap.org/";

    protected BaseServiceBuilder() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();
        okHttpClientBuilder.interceptors().clear();

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
