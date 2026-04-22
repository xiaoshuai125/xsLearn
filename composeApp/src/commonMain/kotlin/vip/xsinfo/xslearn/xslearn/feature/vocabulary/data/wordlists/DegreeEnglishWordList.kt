package vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.wordlists

import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.Example
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
            examples = listOf(
                Example(
                    english = "She abandoned her plans to become an actress.",
                    chinese = "她放弃了成为演员的计划。"
                ),
                Example(
                    english = "The company abandoned the project due to lack of funding.",
                    chinese = "由于缺乏资金，公司放弃了这个项目。"
                ),
                Example(
                    english = "He abandoned his family and moved to another city.",
                    chinese = "他抛弃了家人，搬到了另一个城市。"
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
                    english = "She has the ability to speak five languages.",
                    chinese = "她有说五种语言的能力。"
                ),
                Example(
                    english = "His ability to solve problems is impressive.",
                    chinese = "他解决问题的能力令人印象深刻。"
                ),
                Example(
                    english = "The job requires good communication ability.",
                    chinese = "这份工作需要良好的沟通能力。"
                )
            ),
            collocations = listOf("have the ability to", "ability to do sth", "mental ability")
        ),
        Word(
            word = "able",
            meaning = "能够，有能力的",
            phonetic = "ˈeɪbl",
            examples = listOf(
                Example(
                    english = "I am able to swim.",
                    chinese = "我会游泳。"
                ),
                Example(
                    english = "She is able to finish the work on time.",
                    chinese = "她能够按时完成工作。"
                ),
                Example(
                    english = "Are you able to help me with this?",
                    chinese = "你能帮我做这个吗？"
                )
            ),
            collocations = listOf("be able to", "able to do sth", "financially able")
        ),
        Word(
            word = "about",
            meaning = "关于，大约",
            phonetic = "əˈbaʊt",
            examples = listOf(
                Example(
                    english = "Let's talk about the weather.",
                    chinese = "让我们谈谈天气。"
                ),
                Example(
                    english = "The meeting will start at about 3 o'clock.",
                    chinese = "会议将在大约3点钟开始。"
                ),
                Example(
                    english = "I'm thinking about going to college.",
                    chinese = "我正在考虑上大学。"
                )
            ),
            collocations = listOf("about time", "about face", "around about")
        ),
        Word(
            word = "above",
            meaning = "在...上面",
            phonetic = "əˈbʌv",
            examples = listOf(
                Example(
                    english = "The bird is flying above the tree.",
                    chinese = "鸟儿在树上方飞翔。"
                ),
                Example(
                    english = "The temperature is above 30 degrees.",
                    chinese = "温度在30度以上。"
                ),
                Example(
                    english = "He is above average in intelligence.",
                    chinese = "他的智力高于平均水平。"
                )
            ),
            collocations = listOf("above all", "above average", "above sea level")
        )
    )
}