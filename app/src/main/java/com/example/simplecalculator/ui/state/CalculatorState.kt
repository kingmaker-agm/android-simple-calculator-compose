package com.example.simplecalculator.ui.state

data class CalculatorState(
    val number1: String = "",
    val operator: CalculatorOperator? = null,
    val number2: String = "",
) {
    fun hasNumber1() = number1.isNotBlank()
    fun parseNumber1(): Double? = number1.toDoubleOrNull()
    fun hasNumber2() = number2.isNotBlank()
    fun parseNumber2(): Double? = number2.toDoubleOrNull()
    fun hasOperator() = operator !== null
}
