package com.example.simplecalculator.ui.state

sealed class CalculatorOperator(val symbol: String) {
    object Add: CalculatorOperator("+")
    object Subtract: CalculatorOperator("-")
    object Multiply: CalculatorOperator("x")
    object Division: CalculatorOperator("/")
}
