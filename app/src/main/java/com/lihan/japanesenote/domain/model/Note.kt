package com.lihan.japanesenote.domain.model

data class Note(
    val word : String ,
    val hiragana : String ,
    val type : List<String> ,
    val createDate : Long,
    val sentences : List<Sentence>
)
