package com.example.simplecalculator.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.ui.state.CalculatorAction
import com.example.simplecalculator.ui.state.CalculatorOperator
import com.example.simplecalculator.ui.state.CalculatorState
import com.example.simplecalculator.ui.theme.LightGray
import com.example.simplecalculator.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    onButtonPressed: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .then(modifier),
        contentAlignment = Alignment.BottomEnd
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = state.number1 + (state.operator?.symbol ?: "") + state.number2,
                color = Color.White,
                fontSize = 48.sp,
                maxLines = 2,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    onClick = { onButtonPressed(CalculatorAction.Clear) },
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f)
                )
                CalculatorButton(
                    symbol = "DEL",
                    onClick = { onButtonPressed(CalculatorAction.Delete) },
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "/",
                    onClick = { onButtonPressed(CalculatorAction.OperatorAction(CalculatorOperator.Division)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "7",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(7)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "8",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(8)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "9",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(9)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "x",
                    onClick = { onButtonPressed(CalculatorAction.OperatorAction(CalculatorOperator.Multiply)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "4",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(4)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "5",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(5)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "6",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(6)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "-",
                    onClick = { onButtonPressed(CalculatorAction.OperatorAction(CalculatorOperator.Subtract)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "1",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(1)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "2",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(2)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "3",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(3)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "+",
                    onClick = { onButtonPressed(CalculatorAction.OperatorAction(CalculatorOperator.Add)) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CalculatorButton(
                    symbol = "0",
                    onClick = { onButtonPressed(CalculatorAction.NumberAction(0)) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(2f)
                        .weight(2f)
                )
                CalculatorButton(
                    symbol = ".",
                    onClick = { onButtonPressed(CalculatorAction.Dot) },
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                )
                CalculatorButton(
                    symbol = "=",
                    onClick = { onButtonPressed(CalculatorAction.Calculate) },
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
@Preview(name = "Calculator Preview")
fun CalculatorPreview() {
    Calculator(
        state = CalculatorState("121.5"),
        onButtonPressed = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}