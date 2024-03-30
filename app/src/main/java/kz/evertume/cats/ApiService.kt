package kz.evertume.cats


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("X-Api-Key:Dhkp2oUOQvbGKd1ziMJ/YA==KsTwV0NpePDE2HcR")
    @GET("cats")
    fun getCatsByName(@Query("name") name: String): Call<List<Cat>>
}