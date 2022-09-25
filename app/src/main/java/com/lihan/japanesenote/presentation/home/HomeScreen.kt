package com.lihan.japanesenote.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lihan.japanesenote.presentation.home.component.NoteItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel : HomeViewModel = hiltViewModel()
) {

    viewModel.onEvent()
    val state = viewModel.state
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        //Search View  ?
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn{
            item {
                //search view ?
            }
            items(state.notes){ note ->
                NoteItem(
                    word = note.word,
                    hiragana = note.hiragana,
                    type = note.type,
                    createDate = note.createDate,
                    sentences = note.sentences
                )



            }
        }

    }


}