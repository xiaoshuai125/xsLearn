package vip.xsinfo.xslearn.xslearn.feature.vocabulary.data

import vip.xsinfo.xslearn.xslearn.feature.study.SubjectType

/**
 * 词库数据
 */
object VocabularyData {
    
    /**
     * 根据科目类型获取词库
     */
    fun getWordList(subjectType: SubjectType): List<Word> {
        return when (subjectType) {
            SubjectType.DEGREE_ENGLISH -> degreeEnglishWords
            SubjectType.POSTGRADUATE_ENGLISH_2 -> postgraduateEnglishWords
            else -> emptyList()
        }
    }
    
    /**
     * 学位英语词库
     */
    private val degreeEnglishWords = listOf(
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
    
    /**
     * 考研英语二词库
     */
    private val postgraduateEnglishWords = listOf(
        Word(
            word = "abandon",
            meaning = "放弃，抛弃",
            phonetic = "əˈbændən",
            example = "The project was abandoned due to lack of funding.",
            collocations = listOf("abandon hope", "abandon ship", "abandoned building")
        ),
        Word(
            word = "ability",
            meaning = "能力，才能",
            phonetic = "əˈbɪləti",
            example = "His ability to solve complex problems is impressive.",
            collocations = listOf("have the ability to", "ability to do sth", "mental ability")
        ),
        Word(
            word = "abnormal",
            meaning = "反常的，异常的",
            phonetic = "æbˈnɔːrml",
            example = "The test results showed abnormal levels of cholesterol.",
            collocations = listOf("abnormal behavior", "abnormal condition", "abnormal growth")
        ),
        Word(
            word = "abolish",
            meaning = "废除，废止",
            phonetic = "əˈbɑːlɪʃ",
            example = "The government decided to abolish the tax.",
            collocations = listOf("abolish slavery", "abolish a law", "abolish a system")
        ),
        Word(
            word = "abound",
            meaning = "大量存在，充满",
            phonetic = "əˈbaʊnd",
            example = "The forest abounds with wildlife.",
            collocations = listOf("abound with", "abound in", "abound in possibilities")
        )
    )
}
