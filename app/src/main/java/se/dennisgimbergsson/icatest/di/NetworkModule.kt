package se.dennisgimbergsson.icatest.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import se.dennisgimbergsson.icatest.data.ApiService
import se.dennisgimbergsson.icatest.utils.Constants
import se.dennisgimbergsson.icatest.utils.Constants.Api.TIMEOUT_SECONDS
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    companion object {
        @Singleton
        @Provides
        fun okHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_SECONDS, SECONDS)
                .writeTimeout(TIMEOUT_SECONDS, SECONDS)
                .readTimeout(TIMEOUT_SECONDS, SECONDS)
                .build()


        @Singleton
        @Provides
        fun providesApiService(
            gson: Gson,
            okHttpClient: OkHttpClient
        ): ApiService = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
            .create(ApiService::class.java)
    }
}