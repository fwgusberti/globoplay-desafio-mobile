package br.com.nerdrapido.themoviedbapp.data.model.login

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field

/**
 * Created By FELIPE GUSBERTI @ 04/03/2020
 */
data class CreateSessionRequest(
    @Field("request_token")
    @SerializedName("request_token")
    val requestToken: String
)