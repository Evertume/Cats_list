package kz.evertume.cats

import com.google.gson.annotations.SerializedName

data class Cat(
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("intelligence") val intelligence: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int
)
