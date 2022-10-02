package com.lihan.japanesenote.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lihan.japanesenote.presentation.home.component.HomeEvent
import com.lihan.japanesenote.presentation.home.component.NoteItem
import com.lihan.japanesenote.presentation.home.component.NoteSearchBar

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    viewModel : HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusController = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        NoteSearchBar(
            text = state.searchQuery,
            shouldShowHint = state.isShowHint,
            onValueChange = {
                viewModel.onEvent(HomeEvent.SearchQuery(it))
            },
            onSearch = {
                keyboardController?.hide()
                focusController.clearFocus(true)
                viewModel.onEvent(HomeEvent.OnSearch)
            },
            onFocusChanged = {
                viewModel.onEvent(HomeEvent.OnSearchFocusChange(it.isFocused))
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            items(state.notes){ note ->
                NoteItem(
                    note
                )
            }
        }

    }


}