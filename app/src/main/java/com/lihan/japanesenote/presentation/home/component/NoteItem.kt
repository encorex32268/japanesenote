package com.lihan.japanesenote.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.japanesenote.domain.model.Note
import com.lihan.japanesenote.domain.model.Sentence
import org.w3c.dom.Text
import java.text.SimpleDateFormat

@Composable
fun NoteItem(
    note : Note ,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(note.color))
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = note.word,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.ExtraBold
                )
                val pattern = "yyyy/MM/dd HH:mm:ss"
                val simpleDataFormat = SimpleDateFormat(pattern)
                Text(
                    text = simpleDataFormat.format(note.createDate),
                    style = MaterialTheme.typography.body2
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = note.hiragana,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                modifier = modifier.fillMaxWidth()
            ) {
                note.type.forEach {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.subtitle1
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
            note.sentences.forEach {
                Text(
                    text = "．${it.example}",
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    modifier = modifier.padding(4.dp),
                    text = it.explain,
                    style = MaterialTheme.typography.subtitle2
                )
            }


        }
    }

}