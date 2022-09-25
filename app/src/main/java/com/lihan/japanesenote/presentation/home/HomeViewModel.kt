package com.lihan.japanesenote.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.lihan.japanesenote.domain.model.DumpData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel(){

    var state by mutableStateOf(HomeState())
        private set


    fun onEvent(){
        state = state.copy(
            notes = DumpData.data
        )
    }



}