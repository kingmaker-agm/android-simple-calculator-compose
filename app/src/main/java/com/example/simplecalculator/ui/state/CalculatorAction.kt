package com.example.simplecalculator.ui.state

sealed class CalculatorAction {
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Calculate: CalculatorAction()
    object Dot: CalculatorAction()
    class NumberAction(val number: Int): CalculatorAction()
    class OperatorAction(val operation: CalculatorOperator): CalculatorAction()
}
