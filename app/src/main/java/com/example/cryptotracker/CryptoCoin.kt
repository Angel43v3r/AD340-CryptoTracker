package com.example.cryptotracker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CryptoCoin (
    val id: String,
    val symbol: String,
    val name: String,

    @SerialName("current_price")
    val currentPrice: Double,

    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double?,

    @SerialName("market_cap")
    val marketCap: Long,

    val image: String
)