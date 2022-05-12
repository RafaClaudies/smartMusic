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

public abstract class BaseServiceBuilder<T extends Object> {

    protected final Retrofit.Builder mBuilder;
    private final String URL_BASE = "https://origamicode.com.mx/Sloping/api/";

    protected BaseServiceBuilder() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();
        okHttpClientBuilder.interceptors().clear();

        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_1, TlsVersion.TLS_1_2)
                .cipherSuites(
                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,
                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256)
                .build();

        okHttpClientBuilder
                .addInterceptor(loggingInterceptor)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true);
        okHttpClientBuilder.connectionSpecs(Collections.singletonList(spec));
        OkHttpClient client = okHttpClientBuilder.build();

        mBuilder = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create());

    }

    public abstract T build();

}
