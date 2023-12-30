package com.second.calculator

sealed class CalculatorAction{
    data class Number(val number:Int):CalculatorAction()
    object clear:CalculatorAction()
    object delete:CalculatorAction()
    object decimal:CalculatorAction()
    data class operation(val operation:CalculationOperation):CalculatorAction()
    object calculate:CalculatorAction()
}
