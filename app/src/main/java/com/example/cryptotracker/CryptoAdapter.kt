package com.example.cryptotracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class CryptoAdapter(
    private var coins: List<CryptoCoin> = emptyList()
) : RecyclerView.Adapter<CryptoAdapter.CoinViewHolder>() {

    // --- Holds references to the views in ONE row ---
    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvCoinName)
        val tvSymbol: TextView = itemView.findViewById(R.id.tvCoinSymbol)
        val tvPrice: TextView = itemView.findViewById(R.id.tvCoinPrice)
        val tvChange: TextView = itemView.findViewById(R.id.tvPriceChange)
    }

    // --- Called when RecyclerView needs a new row view ---
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_crypto_coin, parent, false)
        return CoinViewHolder(view)
    }

    // --- Called to fill a row with data at a given position ---
    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coins[position]

        holder.tvName.text = coin.name
        holder.tvSymbol.text = coin.symbol.uppercase()

        // Format price as dollar currency (example: $60,000.00)
        val formatter = NumberFormat.getCurrencyInstance(Locale.US)
        holder.tvPrice.text = formatter.format(coin.currentPrice)

        // Format 24h change with + or - sign and color green positive and red negative
        val change = coin.priceChangePercentage24h ?: 0.0
        val changeText = String.format(Locale.US,"%.2f%%", change)

        if (change >= 0) {
            holder.tvChange.text = "+$changeText"
            holder.tvChange.setTextColor(Color.parseColor("#2E7D32")) // Green
        } else {
            holder.tvChange.text = changeText
            holder.tvChange.setTextColor(Color.parseColor("#C62828")) // Red
        }
    }

    // --- Tells RecyclerView how many rows to create ---
    override fun getItemCount(): Int = coins.size

    // --- Called from MainActivity to refresh the list ---
    fun updateData(newCoins: List<CryptoCoin>) {
        coins = newCoins
        notifyDataSetChanged()
    }
}