package com.example.cryptomvvmtutorial.presentation.coin_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cryptomvvmtutorial.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text     = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style    = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text      = if(coin.isActive) "active" else "inactive",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style     = MaterialTheme.typography.bodySmall,
            modifier  = Modifier.align(CenterVertically),
        )
    }
}