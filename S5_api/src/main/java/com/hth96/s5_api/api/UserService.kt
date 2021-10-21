package com.hth96.s5_api.api

import com.hth96.s5_api.model.UserList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("users")
    suspend fun getUsers(@Query("page") page: Int? = 1) : Response<UserList?>

    companion object {
        private const val BASE_URL = "https://reqres.in/api/"

        private fun provideRubbishService() : UserService {
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addConverterFactory(NullOnEmptyConverterFactory())
                .client(httpClient.build())
                .build()
            return retrofit.create(UserService::class.java)
        }

        val api = provideRubbishService()
    }
}