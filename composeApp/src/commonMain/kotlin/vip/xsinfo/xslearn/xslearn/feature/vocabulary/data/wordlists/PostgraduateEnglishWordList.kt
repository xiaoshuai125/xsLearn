package vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.wordlists

import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.Example
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.Word

/**
 * 考研英语二词库
 */
object PostgraduateEnglishWordList {
    val words = listOf(
        Word(
            word = "abandon",
            meaning = "放弃，抛弃",
            phonetic = "əˈbændən",
            examples = listOf(
                Example(
                    english = "The project was abandoned due to lack of funding.",
                    chinese = "由于缺乏资金，该项目被放弃了。"
                ),
                Example(
                    english = "She abandoned her dream of becoming a doctor.",
                    chinese = "她放弃了成为医生的梦想。"
                ),
                Example(
                    english = "The old building was abandoned and left to decay.",
                    chinese = "那座旧建筑被废弃，任其衰败。"
                )
            ),
            collocations = listOf("abandon hope", "abandon ship", "abandoned building")
        ),
        Word(
            word = "ability",
            meaning = "能力，才能",
            phonetic = "əˈbɪləti",
            examples = listOf(
                Example(
                    english = "His ability to solve complex problems is impressive.",
                    chinese = "他解决复杂问题的能力令人印象深刻。"
                ),
                Example(
                    english = "The job requires a high level of technical ability.",
                    chinese = "这份工作需要高水平的技术能力。"
                ),
                Example(
                    english = "She has the ability to learn languages quickly.",
                    chinese = "她有快速学习语言的能力。"
                )
            ),
            collocations = listOf("have the ability to", "ability to do sth", "mental ability")
        ),
        Word(
            word = "abnormal",
            meaning = "反常的，异常的",
            phonetic = "æbˈnɔːrml",
            examples = listOf(
                Example(
                    english = "The test results showed abnormal levels of cholesterol.",
                    chinese = "测试结果显示胆固醇水平异常。"
                ),
                Example(
                    english = "His abnormal behavior raised concerns among his colleagues.",
                    chinese = "他的反常行为引起了同事们的担忧。"
                ),
                Example(
                    english = "The machine is making an abnormal noise.",
                    chinese = "机器发出异常的噪音。"
                )
            ),
            collocations = listOf("abnormal behavior", "abnormal condition", "abnormal growth")
        ),
        Word(
            word = "abolish",
            meaning = "废除，废止",
            phonetic = "əˈbɑːlɪʃ",
            examples = listOf(
                Example(
                    english = "The government decided to abolish the tax.",
                    chinese = "政府决定废除这项税收。"
                ),
                Example(
                    english = "Slavery was abolished in the United States in 1865.",
                    chinese = "美国于1865年废除了奴隶制。"
                ),
                Example(
                    english = "The company abolished the old system and introduced a new one.",
                    chinese = "公司废除了旧制度，引入了新制度。"
                )
            ),
            collocations = listOf("abolish slavery", "abolish a law", "abolish a system")
        ),
        Word(
            word = "abound",
            meaning = "大量存在，充满",
            phonetic = "əˈbaʊnd",
            examples = listOf(
                Example(
                    english = "The forest abounds with wildlife.",
                    chinese = "森林里充满了野生动物。"
                ),
                Example(
                    english = "The region abounds in natural resources.",
                    chinese = "该地区自然资源丰富。"
                ),
                Example(
                    english = "Opportunities abound for those who are prepared.",
                    chinese = "机会对于有准备的人来说比比皆是。"
                )
            ),
            collocations = listOf("abound with", "abound in", "abound in possibilities")
        )
    )
}