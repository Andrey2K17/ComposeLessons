package com.example.composelessons

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.*
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composelessons.ui.theme.ComposeLessonsTheme
import com.example.composelessons.ui.theme.newColor
import com.example.composelessons.ui.theme.newStyle

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
        text = stringResource(R.string.hello_template, name),// строка из ресурсов
        modifier = Modifier.padding(dimensionResource(R.dimen.padding)),// работа с dimens
        color = MaterialTheme.colors.newColor,
        fontSize = with(LocalDensity.current) {
            dimensionResource(R.dimen.fontSize22).toSp()
        },
        style = MaterialTheme.typography.newStyle
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

@Preview
@Composable
fun NotificationPreview() {
    com.example.composelessons.Notification()
}

val maxWidthGrayModifier = Modifier
    .background(Color.LightGray)
    .fillMaxWidth()
    .padding(16.dp)

val ModifierClick = Modifier
    .clickable(
onClickLabel = "Послушать подкаст" //
) {}

val ModifierClickSemantics = Modifier
        .semantics {
            onClick(label = "Послушать подкаст") {
                true
            }
        }

//Пример: RadioButton
val selected = false
val ModifierStateDescription = Modifier.semantics {
    stateDescription = if (selected) {
        "Выбран"
    } else {
        "Не выбран"
    }
}
@Composable
fun Notification(
    modifier: Modifier = Modifier,
    messageModifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier
) {
    Column(modifier = maxWidthGrayModifier) {
        Text(text = "text", modifier = messageModifier)
        Button(onClick = {}, modifier = buttonModifier.align(Alignment.End)) {
            Text(text = "Ok")
        }
    }
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