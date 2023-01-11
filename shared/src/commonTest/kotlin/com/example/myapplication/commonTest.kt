package com.example.myapplication

import com.example.myapplication.products.api.ProductDetailApi
import com.example.myapplication.products.api.SearchProductsApi
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greet().contains("Hello"), "Check 'Hello' is mentioned")
    }

    @Test
    fun testSearch() {
        runBlocking {
            val response = SearchProductsApi().search("Samsung")
            assertNotNull(response)
        }
    }

    @Test
    fun testProductDetail() {
        runBlocking {
            val response = ProductDetailApi().productById("MLA13316403")
            assertNotNull(response)
        }
    }
}