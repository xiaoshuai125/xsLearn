package vip.xsinfo.xslearn.xslearn.screens.vocabulary.data

/**
 * 单词数据类
 */
data class Word(
    val word: String,      // 单词
    val meaning: String,   // 释义
    val phonetic: String,  // 音标
    val example: String = "",  // 例句
    val collocations: List<String> = emptyList()  // 词组搭配
)
