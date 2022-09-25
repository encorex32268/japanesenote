package com.lihan.japanesenote.presentation.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.japanesenote.domain.model.Sentence
import org.w3c.dom.Text
import java.text.SimpleDateFormat

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    word : String ,
    wordFontSize : TextUnit = 24.sp,
    hiragana : String ,
    hiraganaFontSize : TextUnit = 16.sp,
    type : List<String>,
    typeFontSize: TextUnit = 12.sp,
    createDate  : Long ,
    createDateFontSize : TextUnit = 9.sp,
    sentences : List<Sentence> ,
    sentenceFontSize : TextUnit = 12.sp,
    subSentenceFontSize : TextUnit = 9.sp,
    isExpand : Boolean = false
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
        ,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = word,
                    fontSize = wordFontSize,
                    fontWeight = FontWeight.ExtraBold
                )
                val pattern = "yyyy/MM/dd HH:mm:ss"
                val simpleDataFormat = SimpleDateFormat(pattern)
                Text(
                    text = simpleDataFormat.format(createDate),
                    fontSize = createDateFontSize
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = hiragana,
                fontSize = hiraganaFontSize,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                modifier = modifier.fillMaxWidth()
            ) {
                type.forEach {
                    Text(
                        text = it,
                        fontSize = typeFontSize
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }
            Divider(
                modifier = Modifier
                    .height(4.dp),
                color = Color.Red,
                thickness = 4.dp
            )
            sentences.forEach {
                Text(
                    text = "．${it.example}",
                    fontSize = sentenceFontSize
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    modifier = modifier.padding(4.dp),
                    text = it.explain,
                    fontSize = subSentenceFontSize
                )
            }


        }
    }

}