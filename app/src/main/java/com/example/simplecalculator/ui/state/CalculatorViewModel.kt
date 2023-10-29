package com.example.simplecalculator.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.abs

class CalculatorViewModel: ViewModel() {
    var state: CalculatorState by mutableStateOf<CalculatorState>(CalculatorState())
        private set

    fun handleCalculatorActions(action: CalculatorAction): Unit {
        when(action) {
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Delete -> handleDeletePress()
            is CalculatorAction.Dot -> handleDotPress()
            is CalculatorAction.OperatorAction -> handleOperatorPress(action.operation)
            is CalculatorAction.NumberAction -> handleNumberPress(action.number)
            is CalculatorAction.Calculate -> handleEqualsPress()
        }
    }

    private fun handleEqualsPress() {
        if (!state.hasNumber1() || !state.hasNumber2() || !state.hasOperator()) return

        val number1 = state.parseNumber1()!!
        val number2 = state.parseNumber2()!!
        val operator = state.operator!!

        state = state.copy(
            number2 = "",
            operator = null,
            number1 = when(operator) {
                is CalculatorOperator.Add -> number1 + number2
                is CalculatorOperator.Subtract -> number1 - number2
                is CalculatorOperator.Multiply -> number1 * number2
                is CalculatorOperator.Division -> number1 / number2
            }.round(7).toString()
        )
    }

    private fun handleNumberPress(number: Int) {
        state = if (state.hasOperator()) {
            state.copy(number2 = state.number2 + number)
        } else {
            state.copy(number1 = state.number1 + number)
        }
    }

    private fun handleOperatorPress(operation: CalculatorOperator) {
        if (state.hasNumber1()) {
            state = state.copy(operator = operation)
        }
    }

    private fun handleDotPress() {
        if (state.hasNumber2() && !state.number2.contains('.')) {
            state = state.copy(number2 = state.number2 + '.')
        }
        else if (!state.hasNumber2() && !state.hasOperator() && state.hasNumber1() && !state.number1.contains('.')) {
            state = state.copy(number1 = state.number1 + '.')
        }
    }

    private fun handleDeletePress() {
        if (state.hasNumber2()) {
            state = state.copy(number2 = state.number2.dropLast(1))
        }
        else if (state.hasOperator()) {
            state = state.copy(operator = null)
        }
        else if (state.hasNumber1()) {
            state = state.copy(number1 = state.number1.dropLast(1))
        }
    }
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return abs(this * multiplier) / multiplier
}