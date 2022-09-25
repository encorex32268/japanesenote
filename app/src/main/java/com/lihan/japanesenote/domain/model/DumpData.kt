package com.lihan.japanesenote.domain.model

object DumpData {
    val data = arrayListOf(
        Note(
            word = "積極的",
            hiragana = "せっきょくてき",
            type = arrayListOf("な形容詞"),
            createDate = System.currentTimeMillis()+1,
            sentences = arrayListOf(
                Sentence(
                    example = "積極的な態度にする",
                    explain = "採取積極的態度"
                )
            )
        ),
        Note(
            word = "売却",
            hiragana = "ばいきゃく",
            type = arrayListOf("する名詞、他動詞"),
            createDate = System.currentTimeMillis()+1,
            sentences = arrayListOf(
                Sentence(
                    example = "家屋を売却する",
                    explain = "變賣房產"
                ),
                Sentence(
                    example = "売却します",
                    explain = "變賣"
                )
            )
        ),

    )
}