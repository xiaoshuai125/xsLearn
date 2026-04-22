package vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.wordlists

import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.Word

/**
 * 学位英语词库
 */
object DegreeEnglishWordList {
    val words = listOf(
        Word(
            word = "abandon",
            meaning = "放弃，抛弃",
            phonetic = "əˈbændən",
            example = "She abandoned her plans to become an actress.",
            collocations = listOf("abandon hope", "abandon ship", "abandoned building")
        ),
        Word(
            word = "ability",
            meaning = "能力，才能",
            phonetic = "əˈbɪləti",
            example = "She has the ability to speak five languages.",
            collocations = listOf("have the ability to", "ability to do sth", "mental ability")
        ),
        Word(
            word = "able",
            meaning = "能够，有能力的",
            phonetic = "ˈeɪbl",
            example = "I am able to swim.",
            collocations = listOf("be able to", "able to do sth", "financially able")
        ),
        Word(
            word = "about",
            meaning = "关于，大约",
            phonetic = "əˈbaʊt",
            example = "Let's talk about the weather.",
            collocations = listOf("about time", "about face", "around about")
        ),
        Word(
            word = "above",
            meaning = "在...上面",
            phonetic = "əˈbʌv",
            example = "The bird is flying above the tree.",
            collocations = listOf("above all", "above average", "above sea level")
        )
    )
}