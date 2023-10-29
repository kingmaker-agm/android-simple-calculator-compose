package com.example.simplecalculator.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.ui.theme.Orange

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = symbol,
            color = Color.White,
            fontSize = 36.sp
        )
    }
}

@Composable
@Preview(name = "Button Test")
fun CalculatorButtonPreview() {
    CalculatorButton(
        symbol = "x",
        modifier = Modifier
            .width(48.dp)
            .aspectRatio(1f)
            .background(Orange),
        onClick = {}
    )
}