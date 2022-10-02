package com.lihan.japanesenote.presentation.home

import com.lihan.japanesenote.domain.model.Note

data class HomeState(
    val notes : List<Note> = arrayListOf(),
    val searchQuery : String = "",
    val isShowHint : Boolean = true,
)
