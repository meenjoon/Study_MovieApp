package com.kennethss.movie.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kennethss.movie.BuildConfig
import com.kennethss.movie.remote.interceptor.KeyInterceptor
import com.kennethss.movie.remote.service.MovieDbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule { //retrofit은 외부라이브러리 이기 때문에 constructor-inject를 해줄 수 없기 때문에 @Module 어노테이션을 이용한다.

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient //외부 라이브러리인 OKHttpClient 인스턴스를 제공
        .Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
        )
        .addInterceptor(KeyInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @OptIn(ExperimentalSerializationApi::class)

    @Provides
    @Singleton
    fun provideChoShopService(client: OkHttpClient): MovieDbService { //외부라이브러리인 OKHttpClient을 주입을 받고 MovieDbService라는 타입의 인스턴스를 제공한다.
        val contentType = "application/json".toMediaType()
        val factory = Json {
            isLenient = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }.asConverterFactory(contentType)

        return Retrofit.Builder()
            .addConverterFactory(factory)
            .client(client)
            .baseUrl("https://api.themoviedb.org/")
            .build()
            .create(MovieDbService::class.java)
    }
}
