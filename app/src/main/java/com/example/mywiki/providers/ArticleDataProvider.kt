package com.example.mywiki.providers

import com.example.mywiki.models.Urls
import com.example.mywiki.models.WikiResult
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.ResponseHandler
import com.github.kittinunf.fuel.core.isSuccessful
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import java.io.Reader

class ArticleDataProvider
{
    init
    {
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Tester Wikipedia")
    }

    class WikipediaDataDeserializer : ResponseDeserializable<WikiResult>
    {
        override fun deserialize(reader: Reader): WikiResult? =
            Gson().fromJson(reader, WikiResult::class.java)
    }

    fun search(term: String, skip: Int, take: Int, responseHandler: (result: WikiResult) -> Unit?)
    {
        Urls.getSearchUrl(term, skip, take).httpGet()
            .responseObject(WikipediaDataDeserializer()) { _, _, result ->

                val (data, _) = result
                responseHandler.invoke(data as WikiResult)

            }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?)
    {
        Urls.getRandomUrl(take).httpGet()
            .responseObject(WikipediaDataDeserializer()) { _, response, result ->
//                if(response.statusCode != 200)
                if (!response.isSuccessful)
                    throw Exception("Unable to get articles")

                val (data, error) = result
                responseHandler.invoke(data as WikiResult)
            }
    }
}