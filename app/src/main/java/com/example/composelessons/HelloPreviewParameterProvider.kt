package com.example.composelessons

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

//Класс для просмотра, как интерфейс будет выглядеть с различными данными
class HelloPreviewParameterProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf(
        "Compose", "Android", "World"
    )
}