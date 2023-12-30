package com.second.calculator

sealed class CalculationOperation(val symbol:String){
    object add:CalculationOperation("+")
    object subtract:CalculationOperation("-")
    object multiply:CalculationOperation("*")
    object divison:CalculationOperation("/")
}
