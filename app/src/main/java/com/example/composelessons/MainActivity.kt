package com.example.composelessons

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelessons.ui.theme.ComposeLessonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLessonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    Hello(name = "Compose")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//Создание тестовой функции
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Hello(name: String) {
    Text(
        //text = "Hello $name",
        //text = stringResource(R.string.hello_template, name),// строка из ресурсов
        //text = pluralStringResource(R.plurals.jetpack, 1, 1), //c подстановкой номера
        text = pluralStringResource(R.plurals.jetpack_without_count, 1),//без подстановки
        //modifier = Modifier.padding(32.dp),
        modifier = Modifier.padding(dimensionResource(R.dimen.padding)),// работа с dimens
        color = colorResource(R.color.purple_700),
        //fontSize = 22.sp
        fontSize = with(LocalDensity.current) {
            dimensionResource(R.dimen.fontSize22).toSp() //Установка размера шрифта из ресурсов
        }

    )
    Image(
        painter = painterResource(id = R.drawable.android_logo),
        contentDescription = null,
        modifier = Modifier.padding(dimensionResource(R.dimen.padding))
        //modifier = Modifier.align(Alignment.TopCenter) //Не сработало
    )
}


//Функция для preview composable функции, которую мы указали
@Preview(
    showBackground = true,
    fontScale = 2f,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Composable
fun HelloPreview() {
    Hello(name = "Compose")
}

//Посмотреть три разных варианта из класса HelloPreviewParameterProvider
//@Preview(showBackground = true)
//@Composable
//fun HelloPreview(
//    @PreviewParameter(HelloPreviewParameterProvider::class)
//    hello: String
//) {
//    Hello(name = hello)
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeLessonsTheme {
//        Greeting("Android")
//    }
//}