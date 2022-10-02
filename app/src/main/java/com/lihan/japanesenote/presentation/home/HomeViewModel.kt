package com.lihan.japanesenote.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lihan.japanesenote.domain.model.DumpData
import com.lihan.japanesenote.presentation.home.component.HomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(){

    var state by mutableStateOf(HomeState())
        private set

    init {
        state = state.copy(
            notes = DumpData.data
        )

    }

    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.OnSearch->{
                state = state.copy(
                    searchQuery = "",
                    isShowHint = true
                )
            }
            is HomeEvent.SearchQuery->{
                state = state.copy(
                    searchQuery = event.string
                )
            }
            is HomeEvent.OnSearchFocusChange->{
                state = state.copy(
                    isShowHint = !event.isFocused && state.searchQuery.isBlank()
                )
            }
        }

    }



}