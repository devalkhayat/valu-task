package com.valu.domain.home.models

import com.google.gson.annotations.SerializedName

data class Rating (

  @SerializedName("rate"  ) var rate  : Float? = null,
  @SerializedName("count" ) var count : Int?    = null

):java.io.Serializable