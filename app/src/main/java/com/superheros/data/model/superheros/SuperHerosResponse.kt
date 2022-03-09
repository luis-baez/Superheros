package com.superheros.data.model.superheros

import com.google.gson.annotations.SerializedName

data class SuperHerosResponse (
    @SerializedName("data")
    val dataSuperheros: SuperHerosResult
)