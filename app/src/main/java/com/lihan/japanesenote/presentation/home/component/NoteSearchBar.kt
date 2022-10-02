package com.lihan.japanesenote.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun NoteSearchBar(
    modifier: Modifier = Modifier,
    hintText : String  = "Search Note ...",
    text : String ,
    onValueChange : (String) -> Unit,
    onSearch : () -> Unit,
    shouldShowHint : Boolean = true,
    onFocusChanged : (FocusState) -> Unit
) {

    Box(modifier = modifier){
            BasicTextField(
                value = text,
                onValueChange = {
                    onValueChange(it)
                },
                singleLine = true,
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearch()
                        defaultKeyboardAction(ImeAction.Search)
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search,
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .padding(2.dp)
                    .shadow(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .background(MaterialTheme.colors.surface)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .onFocusChanged {
                        onFocusChanged(it)
                    }

            )
            if (shouldShowHint){
                Text(
                    text = hintText,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Light,
                    color = Color.LightGray,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                )
            }
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = { onSearch() }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription ="Search"
                )
            }

        }


}