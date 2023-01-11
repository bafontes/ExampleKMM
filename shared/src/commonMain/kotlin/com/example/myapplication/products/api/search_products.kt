package com.example.myapplication.products.api

import SearchResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class SearchProductsApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun search(query: String): SearchResponse {
        val path = "https://api.mercadolibre.com/products/search"

        val response: SearchResponse = httpClient.get(path) {
            url {
                parameters.append("status", "active")
                parameters.append("site_id", "MLA")
                parameters.append("q", query)
            }
        }.body()
        return response
    }
}