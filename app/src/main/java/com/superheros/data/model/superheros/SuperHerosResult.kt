package com.superheros.data.model.superheros

import com.google.gson.annotations.SerializedName

data class SuperHerosResult(
    @SerializedName("results")
    val superheros: List<Superhero>
    ) {
    data class Superhero(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("thumbnail")
        val thumbnail: Thumbnail?,
        @SerializedName("urls")
        val urls: List<Urls>?

    )
}