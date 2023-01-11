package com.example.myapplication.products.api

import ProductDetailResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ProductDetailApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun productById(id: String): ProductDetailResponse {
        val path = "https://api.mercadolibre.com/products/$id"

        val response: ProductDetailResponse = httpClient.get(path) {
        }.body()
        return response
    }
}