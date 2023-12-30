package com.second.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel // Add this import
import com.plcoding.calculatorprep.CalculatorButton
import com.second.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorContent();
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview(showSystemUi = true,)
fun CalculatorContent() {
    CalculatorTheme {
        val viewModel = viewModel<CalculatorViewModel>()
        val state = viewModel.state
        val buttonSpacing = 8.dp

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .padding(16.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter), verticalArrangement = Arrangement.spacedBy(buttonSpacing))
            {
                Text(text=state.number1+(state.operation?.symbol?:"")+state.number2, textAlign = TextAlign.End,modifier= Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp), fontWeight = FontWeight.Light,fontSize=80.sp,color=Color.White,maxLines=2);
                Row (modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
                {
                    CalculatorButton(symbol = "AC", color = Color.LightGray, modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f))
                    {
                        viewModel.onAction(CalculatorAction.clear)
                    }

                    CalculatorButton(symbol = "Del",color=Color.LightGray,modifier= Modifier
                        .aspectRatio(1f)
                        .weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.delete)
                    }

                    CalculatorButton(symbol = "/",color=Color.LightGray, modifier = Modifier.aspectRatio(1f).weight(1f))
                    {
                       viewModel.onAction(CalculatorAction.operation(CalculationOperation.divison))
                    }
                }


                Row (modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
                {
                    CalculatorButton(symbol = "7",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(7));
                    }

                    CalculatorButton(symbol = "8",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(8));
                    }

                    CalculatorButton(symbol = "9",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(9));
                    }

                    CalculatorButton(symbol = "x",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.operation(CalculationOperation.multiply))
                    }
                }

                Row (modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
                {
                    CalculatorButton(symbol = "4",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(4));
                    }

                    CalculatorButton(symbol = "5",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(5));
                    }

                    CalculatorButton(symbol = "6",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(6));
                    }

                    CalculatorButton(symbol = "-",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.operation(CalculationOperation.subtract))
                    }
                }

                Row (modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
                {
                    CalculatorButton(symbol = "1",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(1));
                    }

                    CalculatorButton(symbol = "2",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(2));
                    }

                    CalculatorButton(symbol = "3",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.Number(3));
                    }

                    CalculatorButton(symbol = "+",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.operation(CalculationOperation.add))
                    }
                }

                Row (modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
                {
                    CalculatorButton(symbol = "0",color=Color.LightGray,modifier=Modifier.aspectRatio(2f).weight(2f))
                    {
                        viewModel.onAction(CalculatorAction.Number(0));
                    }

                    CalculatorButton(symbol = ".",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.decimal);
                    }

                    CalculatorButton(symbol = "=",color=Color.LightGray,modifier=Modifier.aspectRatio(1f).weight(1f))
                    {
                        viewModel.onAction(CalculatorAction.calculate);
                    }


                }



            }
        }
    }
}

