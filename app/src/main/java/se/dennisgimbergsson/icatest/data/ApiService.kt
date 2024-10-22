package se.dennisgimbergsson.icatest.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>

}