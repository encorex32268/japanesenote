package com.lihan.japanesenote.presentation.home.component

sealed class HomeEvent{
    data class SearchQuery(val string : String ) : HomeEvent()
    object  OnSearch : HomeEvent()
    data class OnSearchFocusChange(val isFocused: Boolean): HomeEvent()

}
