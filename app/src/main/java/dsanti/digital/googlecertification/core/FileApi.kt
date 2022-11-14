package dsanti.digital.googlecertification.core

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface FileApi {

    @GET("/8/88/Bandeira_de_Alagoas.svg/500px-Bandeira_de_Alagoas.svg.png")
    suspend fun downloadImage(): Response<ResponseBody>


    companion object {
        val instance: FileApi by lazy {
            Retrofit.Builder()
                .baseUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/")
                .build()
                .create(FileApi::class.java)
        }
    }
}