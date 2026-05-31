package com.example.cryptotracker

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var tvError: TextView

    // adapter
    private lateinit var adapter: CryptoAdapter

    // CoinGecko API URL
    private val apiUrl = "https://api.coingecko.com/api/v3/coins/markets" +
            "?vs_currency=usd&order=market_cap_desc&per_page=10&page=1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect views to variables
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        tvError = findViewById(R.id.tvError)

        // Set up RecyclerView
        adapter = CryptoAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Fetch the data
        fetchCryptoData()
    }

    private fun fetchCryptoData() {
        // Show spinner when loading, hide recyclerView and tvError
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        tvError.visibility = View.GONE

        // Automatically cancels if the Activity is destroyed
        lifecycleScope.launch {
            try {
                // Make the network call
                val coins: List<CryptoCoin> = KtorClient.client
                    .get(apiUrl)
                    .body()

                // hide spinner, show list
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                adapter.updateData(coins)

            } catch (e: Exception) {
                // if network call failed, show error message
                progressBar.visibility = View.GONE
                tvError.visibility = View.VISIBLE
                tvError.text = "Failed to load data.\n${e.message}"
            }
        }
    }
}