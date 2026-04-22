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
            SubjectType.JUNIOR_COLLEGE_TO_UNIVERSITY_ENGLISH -> juniorCollegeToUniversityEnglishWords
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
        ),
        Word(
            word = "abroad",
            meaning = "在国外，到国外",
            phonetic = "əˈbrɔːd",
            example = "He studied abroad for three years.",
            collocations = listOf("go abroad", "study abroad", "live abroad")
        ),
        Word(
            word = "absence",
            meaning = "缺席，不在场",
            phonetic = "ˈæbsəns",
            example = "His absence from the meeting was noticed.",
            collocations = listOf("absence from", "in the absence of", "absence of evidence")
        ),
        Word(
            word = "absolute",
            meaning = "绝对的，完全的",
            phonetic = "ˈæbsəluːt",
            example = "The absolute truth is hard to find.",
            collocations = listOf("absolute truth", "absolute power", "absolute majority")
        ),
        Word(
            word = "absorb",
            meaning = "吸收，吸引",
            phonetic = "əbˈsɔːrb",
            example = "The sponge absorbs water quickly.",
            collocations = listOf("absorb water", "absorb information", "absorb costs")
        ),
        Word(
            word = "abstract",
            meaning = "抽象的，理论的",
            phonetic = "ˈæbstrækt",
            example = "Abstract art can be difficult to understand.",
            collocations = listOf("abstract concept", "abstract idea", "abstract thinking")
        )
    )
    
    /**
     * 专升本英语词汇库
     */
    private val juniorCollegeToUniversityEnglishWords = listOf(
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
        ),
        Word(
            word = "abroad",
            meaning = "在国外，到国外",
            phonetic = "əˈbrɔːd",
            example = "He studied abroad for three years.",
            collocations = listOf("go abroad", "study abroad", "live abroad")
        ),
        Word(
            word = "absence",
            meaning = "缺席，不在场",
            phonetic = "ˈæbsəns",
            example = "His absence from the meeting was noticed.",
            collocations = listOf("absence from", "in the absence of", "absence of evidence")
        ),
        Word(
            word = "absolute",
            meaning = "绝对的，完全的",
            phonetic = "ˈæbsəluːt",
            example = "The absolute truth is hard to find.",
            collocations = listOf("absolute truth", "absolute power", "absolute majority")
        ),
        Word(
            word = "absorb",
            meaning = "吸收，吸引",
            phonetic = "əbˈsɔːrb",
            example = "The sponge absorbs water quickly.",
            collocations = listOf("absorb water", "absorb information", "absorb costs")
        ),
        Word(
            word = "abstract",
            meaning = "抽象的，理论的",
            phonetic = "ˈæbstrækt",
            example = "Abstract art can be difficult to understand.",
            collocations = listOf("abstract concept", "abstract idea", "abstract thinking")
        ),
        Word(
            word = "abundant",
            meaning = "丰富的，充足的",
            phonetic = "əˈbʌndənt",
            example = "The region has abundant natural resources.",
            collocations = listOf("abundant resources", "abundant evidence", "abundant supply")
        ),
        Word(
            word = "abuse",
            meaning = "滥用，虐待",
            phonetic = "əˈbjuːs",
            example = "The abuse of power is a serious issue.",
            collocations = listOf("abuse of power", "drug abuse", "child abuse")
        ),
        Word(
            word = "academic",
            meaning = "学术的，教学的",
            phonetic = "ˌækəˈdemɪk",
            example = "She has an academic background in physics.",
            collocations = listOf("academic research", "academic career", "academic performance")
        ),
        Word(
            word = "accelerate",
            meaning = "加速，促进",
            phonetic = "əkˈseləreɪt",
            example = "The car accelerated quickly.",
            collocations = listOf("accelerate growth", "accelerate development", "accelerate process")
        ),
        Word(
            word = "access",
            meaning = "接近，进入",
            phonetic = "ˈækses",
            example = "Students have access to the library.",
            collocations = listOf("access to", "gain access", "deny access")
        ),
        Word(
            word = "accommodate",
            meaning = "容纳，适应",
            phonetic = "əˈkɑːmədeɪt",
            example = "The hotel can accommodate 100 guests.",
            collocations = listOf("accommodate guests", "accommodate needs", "accommodate changes")
        ),
        Word(
            word = "accompany",
            meaning = "陪伴，陪同",
            phonetic = "əˈkʌmpəni",
            example = "She accompanied her friend to the doctor.",
            collocations = listOf("accompany someone", "accompanied by", "accompany with")
        ),
        Word(
            word = "accomplish",
            meaning = "完成，实现",
            phonetic = "əˈkɑːmplɪʃ",
            example = "She accomplished her goal of becoming a doctor.",
            collocations = listOf("accomplish goal", "accomplish task", "accomplish objective")
        ),
        Word(
            word = "accordance",
            meaning = "一致，和谐",
            phonetic = "əˈkɔːrdns",
            example = "In accordance with the rules, he was disqualified.",
            collocations = listOf("in accordance with", "accordance with the law", "accordance of views")
        ),
        Word(
            word = "account",
            meaning = "账户，说明",
            phonetic = "əˈkaʊnt",
            example = "I have a bank account.",
            collocations = listOf("bank account", "account for", "take into account")
        ),
        Word(
            word = "accumulate",
            meaning = "积累，堆积",
            phonetic = "əˈkjuːmjuleɪt",
            example = "He accumulated a lot of wealth over the years.",
            collocations = listOf("accumulate wealth", "accumulate knowledge", "accumulate experience")
        ),
        Word(
            word = "accuracy",
            meaning = "准确性，精确度",
            phonetic = "ˈækjərəsi",
            example = "The accuracy of the report is important.",
            collocations = listOf("accuracy of", "high accuracy", "measurement accuracy")
        ),
        Word(
            word = "accurate",
            meaning = "准确的，精确的",
            phonetic = "ˈækjərət",
            example = "The watch is very accurate.",
            collocations = listOf("accurate information", "accurate prediction", "accurate measurement")
        ),
        Word(
            word = "accuse",
            meaning = "指责，控告",
            phonetic = "əˈkjuːz",
            example = "He was accused of theft.",
            collocations = listOf("accuse someone of", "false accusation", "accuse falsely")
        ),
        Word(
            word = "achieve",
            meaning = "实现，达到",
            phonetic = "əˈtʃiːv",
            example = "She achieved her dream of becoming a writer.",
            collocations = listOf("achieve goal", "achieve success", "achieve results")
        ),
        Word(
            word = "achievement",
            meaning = "成就，成绩",
            phonetic = "əˈtʃiːvmənt",
            example = "His achievements are impressive.",
            collocations = listOf("great achievement", "academic achievement", "personal achievement")
        ),
        Word(
            word = "acid",
            meaning = "酸的，酸性的",
            phonetic = "ˈæsɪd",
            example = "Lemon juice is acidic.",
            collocations = listOf("acid rain", "acid test", "acidic solution")
        ),
        Word(
            word = "acknowledge",
            meaning = "承认，感谢",
            phonetic = "əkˈnɑːlɪdʒ",
            example = "He acknowledged his mistake.",
            collocations = listOf("acknowledge mistake", "acknowledge receipt", "acknowledge contribution")
        ),
        Word(
            word = "acquaintance",
            meaning = "熟人，认识",
            phonetic = "əˈkweɪntəns",
            example = "I have an acquaintance who works there.",
            collocations = listOf("make acquaintance", "acquaintance with", "close acquaintance")
        ),
        Word(
            word = "acquire",
            meaning = "获得，学到",
            phonetic = "əˈkwaɪər",
            example = "She acquired a new skill.",
            collocations = listOf("acquire skill", "acquire knowledge", "acquire property")
        ),
        Word(
            word = "acquisition",
            meaning = "获得，习得",
            phonetic = "ˌækwɪˈzɪʃn",
            example = "The company's acquisition of the smaller firm was successful.",
            collocations = listOf("business acquisition", "language acquisition", "knowledge acquisition")
        ),
        Word(
            word = "across",
            meaning = "穿过，横过",
            phonetic = "əˈkrɔːs",
            example = "He walked across the street.",
            collocations = listOf("across the street", "across the country", "come across")
        ),
        Word(
            word = "act",
            meaning = "行动，表演",
            phonetic = "ækt",
            example = "He acted quickly to save the child.",
            collocations = listOf("act quickly", "act on", "act out")
        ),
        Word(
            word = "action",
            meaning = "行动，行为",
            phonetic = "ˈækʃn",
            example = "The government took action to address the issue.",
            collocations = listOf("take action", "action plan", "course of action")
        ),
        Word(
            word = "active",
            meaning = "活跃的，积极的",
            phonetic = "ˈæktɪv",
            example = "She is an active member of the club.",
            collocations = listOf("active member", "active participation", "active role")
        ),
        Word(
            word = "activity",
            meaning = "活动，行动",
            phonetic = "ækˈtɪvəti",
            example = "The school organizes various activities.",
            collocations = listOf("outdoor activity", "social activity", "physical activity")
        ),
        Word(
            word = "actual",
            meaning = "实际的，真实的",
            phonetic = "ˈæktʃuəl",
            example = "The actual cost was higher than expected.",
            collocations = listOf("actual cost", "actual situation", "in actual fact")
        ),
        Word(
            word = "actually",
            meaning = "实际上，事实上",
            phonetic = "ˈæktʃuəli",
            example = "Actually, I don't like coffee.",
            collocations = listOf("actually, ", "in fact, actually", "actually speaking")
        ),
        Word(
            word = "adapt",
            meaning = "适应，调整",
            phonetic = "əˈdæpt",
            example = "She adapted quickly to the new environment.",
            collocations = listOf("adapt to", "adapt for", "adapt oneself to")
        ),
        Word(
            word = "adaptation",
            meaning = "适应，改编",
            phonetic = "ˌædæpˈteɪʃn",
            example = "The adaptation of the novel into a movie was successful.",
            collocations = listOf("film adaptation", "adaptation to", "cultural adaptation")
        ),
        Word(
            word = "add",
            meaning = "添加，增加",
            phonetic = "æd",
            example = "Please add sugar to the coffee.",
            collocations = listOf("add to", "add up", "add in")
        ),
        Word(
            word = "addict",
            meaning = "使上瘾，成瘾者",
            phonetic = "ˈædɪkt",
            example = "He is addicted to video games.",
            collocations = listOf("addicted to", "drug addict", "addict oneself to")
        ),
        Word(
            word = "addition",
            meaning = "加法，增加",
            phonetic = "əˈdɪʃn",
            example = "The addition of new features made the product more popular.",
            collocations = listOf("in addition", "addition to", "mathematical addition")
        ),
        Word(
            word = "additional",
            meaning = "额外的，附加的",
            phonetic = "əˈdɪʃnəl",
            example = "We need additional help.",
            collocations = listOf("additional help", "additional cost", "additional information")
        ),
        Word(
            word = "adequate",
            meaning = "足够的，适当的",
            phonetic = "ˈædɪkwət",
            example = "The food was adequate for the guests.",
            collocations = listOf("adequate for", "adequate supply", "adequate preparation")
        ),
        Word(
            word = "adjust",
            meaning = "调整，适应",
            phonetic = "əˈdʒʌst",
            example = "He adjusted the temperature.",
            collocations = listOf("adjust to", "adjust for", "adjust settings")
        ),
        Word(
            word = "adjustment",
            meaning = "调整，适应",
            phonetic = "əˈdʒʌstmənt",
            example = "The adjustment to the new job was difficult.",
            collocations = listOf("make adjustment", "adjustment to", "necessary adjustment")
        ),
        Word(
            word = "administer",
            meaning = "管理，执行",
            phonetic = "ədˈmɪnɪstər",
            example = "The manager administers the company.",
            collocations = listOf("administer a company", "administer medicine", "administer an oath")
        ),
        Word(
            word = "administration",
            meaning = "管理，行政",
            phonetic = "ədˌmɪnɪˈstreɪʃn",
            example = "The administration of the school is efficient.",
            collocations = listOf("school administration", "business administration", "public administration")
        ),
        Word(
            word = "admire",
            meaning = "钦佩，赞美",
            phonetic = "ədˈmaɪər",
            example = "I admire her courage.",
            collocations = listOf("admire someone", "admire for", "greatly admire")
        ),
        Word(
            word = "admission",
            meaning = "承认，入场",
            phonetic = "ədˈmɪʃn",
            example = "Admission to the museum is free.",
            collocations = listOf("admission to", "admission fee", "admission ticket")
        ),
        Word(
            word = "admit",
            meaning = "承认，允许进入",
            phonetic = "ədˈmɪt",
            example = "He admitted his mistake.",
            collocations = listOf("admit mistake", "admit to", "admit into")
        ),
        Word(
            word = "adolescent",
            meaning = "青少年",
            phonetic = "ˌædəˈlesnt",
            example = "Adolescents often face many challenges.",
            collocations = listOf("adolescent behavior", "adolescent development", "adolescent years")
        ),
        Word(
            word = "adopt",
            meaning = "采用，收养",
            phonetic = "əˈdɑːpt",
            example = "The company adopted a new policy.",
            collocations = listOf("adopt a policy", "adopt a child", "adopt a method")
        ),
        Word(
            word = "adoption",
            meaning = "采用，收养",
            phonetic = "əˈdɑːpʃn",
            example = "The adoption of the new technology was successful.",
            collocations = listOf("adoption of", "child adoption", "technology adoption")
        ),
        Word(
            word = "adult",
            meaning = "成年人",
            phonetic = "ˈædʌlt",
            example = "He is now an adult.",
            collocations = listOf("adult education", "adult life", "adult responsibility")
        ),
        Word(
            word = "advance",
            meaning = "前进，推进",
            phonetic = "ədˈvæns",
            example = "The army advanced towards the enemy.",
            collocations = listOf("advance towards", "in advance", "advance payment")
        ),
        Word(
            word = "advanced",
            meaning = "先进的，高级的",
            phonetic = "ədˈvænst",
            example = "She has advanced knowledge of computer science.",
            collocations = listOf("advanced technology", "advanced level", "advanced course")
        ),
        Word(
            word = "advantage",
            meaning = "优势，有利条件",
            phonetic = "ədˈvæntɪdʒ",
            example = "His experience gave him an advantage.",
            collocations = listOf("take advantage of", "have an advantage", "competitive advantage")
        ),
        Word(
            word = "adventure",
            meaning = "冒险，奇遇",
            phonetic = "ədˈventʃər",
            example = "They went on an adventure in the jungle.",
            collocations = listOf("go on an adventure", "adventure story", "adventure travel")
        ),
        Word(
            word = "advertise",
            meaning = "做广告，宣传",
            phonetic = "ˈædvərtaɪz",
            example = "The company advertised its new product.",
            collocations = listOf("advertise a product", "advertise for", "advertise on TV")
        ),
        Word(
            word = "advertisement",
            meaning = "广告",
            phonetic = "ˌædvərˈtaɪzmənt",
            example = "I saw an advertisement for a new job.",
            collocations = listOf("newspaper advertisement", "TV advertisement", "online advertisement")
        ),
        Word(
            word = "advice",
            meaning = "建议，忠告",
            phonetic = "ədˈvaɪs",
            example = "He gave me some good advice.",
            collocations = listOf("give advice", "take advice", "seek advice")
        ),
        Word(
            word = "advise",
            meaning = "建议，忠告",
            phonetic = "ədˈvaɪz",
            example = "I advise you to study hard.",
            collocations = listOf("advise someone to", "advise against", "advise on")
        ),
        Word(
            word = "advocate",
            meaning = "提倡，拥护",
            phonetic = "ˈædvəkeɪt",
            example = "She advocates for environmental protection.",
            collocations = listOf("advocate for", "advocate change", "advocate policy")
        ),
        Word(
            word = "aerial",
            meaning = "空中的，航空的",
            phonetic = "ˈerɪəl",
            example = "The aerial view of the city is beautiful.",
            collocations = listOf("aerial view", "aerial photography", "aerial survey")
        ),
        Word(
            word = "aeroplane",
            meaning = "飞机",
            phonetic = "ˈerəpleɪn",
            example = "The aeroplane took off on time.",
            collocations = listOf("board an aeroplane", "aeroplane ticket", "aeroplane crash")
        ),
        Word(
            word = "affair",
            meaning = "事务，事件",
            phonetic = "əˈfer",
            example = "The company's affairs are well managed.",
            collocations = listOf("business affairs", "personal affairs", "current affairs")
        ),
        Word(
            word = "affect",
            meaning = "影响，感动",
            phonetic = "əˈfekt",
            example = "The weather affected our plans.",
            collocations = listOf("affect someone", "be affected by", "affect development")
        ),
        Word(
            word = "affection",
            meaning = "喜爱，感情",
            phonetic = "əˈfekʃn",
            example = "She has great affection for her children.",
            collocations = listOf("show affection", "affection for", "deep affection")
        ),
        Word(
            word = "affirm",
            meaning = "确认，肯定",
            phonetic = "əˈfɜːrm",
            example = "He affirmed his commitment to the project.",
            collocations = listOf("affirm commitment", "affirm belief", "affirm statement")
        ),
        Word(
            word = "afford",
            meaning = "买得起，负担得起",
            phonetic = "əˈfɔːrd",
            example = "I can afford a new car.",
            collocations = listOf("afford to", "cannot afford", "afford luxury")
        ),
        Word(
            word = "afraid",
            meaning = "害怕的，担心的",
            phonetic = "əˈfreɪd",
            example = "She is afraid of spiders.",
            collocations = listOf("be afraid of", "afraid to", "afraid that")
        ),
        Word(
            word = "Africa",
            meaning = "非洲",
            phonetic = "ˈæfrɪkə",
            example = "He traveled to Africa last year.",
            collocations = listOf("South Africa", "Africa continent", "African countries")
        ),
        Word(
            word = "African",
            meaning = "非洲的，非洲人",
            phonetic = "ˈæfrɪkən",
            example = "She is an African woman.",
            collocations = listOf("African countries", "African culture", "African people")
        ),
        Word(
            word = "after",
            meaning = "在...之后",
            phonetic = "ˈæftər",
            example = "He came after me.",
            collocations = listOf("after that", "after school", "look after")
        ),
        Word(
            word = "afternoon",
            meaning = "下午",
            phonetic = "ˌæftərˈnuːn",
            example = "We will meet in the afternoon.",
            collocations = listOf("good afternoon", "in the afternoon", "afternoon tea")
        ),
        Word(
            word = "afterward",
            meaning = "后来，以后",
            phonetic = "ˈæftərwərd",
            example = "We had dinner and went home afterward.",
            collocations = listOf("shortly afterward", "soon afterward", "immediately afterward")
        ),
        Word(
            word = "again",
            meaning = "再，又",
            phonetic = "əˈɡen",
            example = "Please say it again.",
            collocations = listOf("again and again", "once again", "try again")
        ),
        Word(
            word = "against",
            meaning = "反对，逆",
            phonetic = "əˈɡeɪnst",
            example = "He is against the plan.",
            collocations = listOf("against the law", "go against", "play against")
        ),
        Word(
            word = "age",
            meaning = "年龄，时代",
            phonetic = "eɪdʒ",
            example = "What is your age?",
            collocations = listOf("at the age of", "old age", "age group")
        ),
        Word(
            word = "agency",
            meaning = "代理，机构",
            phonetic = "ˈeɪdʒənsi",
            example = "She works for a travel agency.",
            collocations = listOf("travel agency", "government agency", "advertising agency")
        ),
        Word(
            word = "agent",
            meaning = "代理人，经纪人",
            phonetic = "ˈeɪdʒənt",
            example = "He is a real estate agent.",
            collocations = listOf("real estate agent", "travel agent", "secret agent")
        ),
        Word(
            word = "aggression",
            meaning = "侵略，攻击",
            phonetic = "əˈɡreʃn",
            example = "The country condemned the aggression.",
            collocations = listOf("acts of aggression", "aggression against", "military aggression")
        ),
        Word(
            word = "aggressive",
            meaning = "侵略性的，有进取心的",
            phonetic = "əˈɡresɪv",
            example = "He is an aggressive businessman.",
            collocations = listOf("aggressive behavior", "aggressive tactics", "aggressive marketing")
        ),
        Word(
            word = "ago",
            meaning = "以前",
            phonetic = "əˈɡoʊ",
            example = "I saw him three days ago.",
            collocations = listOf("long ago", "years ago", "a while ago")
        ),
        Word(
            word = "agree",
            meaning = "同意，一致",
            phonetic = "əˈɡriː",
            example = "I agree with you.",
            collocations = listOf("agree with", "agree to", "agree on")
        ),
        Word(
            word = "agreement",
            meaning = "协议，同意",
            phonetic = "əˈɡriːmənt",
            example = "They reached an agreement.",
            collocations = listOf("reach an agreement", "written agreement", "agreement with")
        ),
        Word(
            word = "agricultural",
            meaning = "农业的",
            phonetic = "ˌæɡrɪˈkʌltʃərəl",
            example = "The country has a strong agricultural sector.",
            collocations = listOf("agricultural industry", "agricultural products", "agricultural land")
        ),
        Word(
            word = "agriculture",
            meaning = "农业",
            phonetic = "ˈæɡrɪkʌltʃər",
            example = "Agriculture is important for the economy.",
            collocations = listOf("modern agriculture", "agriculture sector", "agriculture policy")
        ),
        Word(
            word = "ahead",
            meaning = "在前面，提前",
            phonetic = "əˈhed",
            example = "He is ahead of us.",
            collocations = listOf("ahead of", "go ahead", "ahead of time")
        ),
        Word(
            word = "aid",
            meaning = "帮助，援助",
            phonetic = "eɪd",
            example = "They provided aid to the victims.",
            collocations = listOf("provide aid", "foreign aid", "emergency aid")
        ),
        Word(
            word = "aim",
            meaning = "目标，瞄准",
            phonetic = "eɪm",
            example = "Her aim is to become a doctor.",
            collocations = listOf("aim at", "aim for", "take aim")
        ),
        Word(
            word = "air",
            meaning = "空气，天空",
            phonetic = "er",
            example = "The air is fresh.",
            collocations = listOf("fresh air", "air pollution", "air conditioning")
        ),
        Word(
            word = "aircraft",
            meaning = "飞机，航空器",
            phonetic = "ˈerkræft",
            example = "The aircraft took off.",
            collocations = listOf("commercial aircraft", "military aircraft", "aircraft carrier")
        ),
        Word(
            word = "airline",
            meaning = "航空公司",
            phonetic = "ˈerlaɪn",
            example = "She works for an airline.",
            collocations = listOf("international airline", "domestic airline", "airline ticket")
        ),
        Word(
            word = "airport",
            meaning = "机场",
            phonetic = "ˈerpɔːrt",
            example = "We arrived at the airport.",
            collocations = listOf("international airport", "airport terminal", "airport security")
        ),
        Word(
            word = "aisle",
            meaning = "过道，通道",
            phonetic = "aɪl",
            example = "Please walk down the aisle.",
            collocations = listOf("aisle seat", "down the aisle", "aisle of a store")
        ),
        Word(
            word = "alarm",
            meaning = "警报，闹钟",
            phonetic = "əˈlɑːrm",
            example = "The alarm went off.",
            collocations = listOf("alarm clock", "fire alarm", "burglar alarm")
        ),
        Word(
            word = "album",
            meaning = "相册，专辑",
            phonetic = "ˈælbəm",
            example = "She has a photo album.",
            collocations = listOf("photo album", "music album", "album cover")
        ),
        Word(
            word = "alcohol",
            meaning = "酒精，酒",
            phonetic = "ˈælkəhɔːl",
            example = "He doesn't drink alcohol.",
            collocations = listOf("alcohol content", "alcohol abuse", "alcoholic beverage")
        ),
        Word(
            word = "alert",
            meaning = "警觉的，警报",
            phonetic = "əˈlɜːrt",
            example = "Be alert for danger.",
            collocations = listOf("be alert", "alert someone", "alert system")
        ),
        Word(
            word = "alike",
            meaning = "相似的，同样地",
            phonetic = "əˈlaɪk",
            example = "They look alike.",
            collocations = listOf("look alike", "think alike", "treat alike")
        ),
        Word(
            word = "alive",
            meaning = "活着的，活跃的",
            phonetic = "əˈlaɪv",
            example = "The plant is still alive.",
            collocations = listOf("stay alive", "alive and well", "come alive")
        ),
        Word(
            word = "all",
            meaning = "全部，所有",
            phonetic = "ɔːl",
            example = "All students must attend.",
            collocations = listOf("all of", "all day", "all night")
        ),
        Word(
            word = "allocate",
            meaning = "分配，分派",
            phonetic = "ˈæləkeɪt",
            example = "The company allocated funds for the project.",
            collocations = listOf("allocate funds", "allocate resources", "allocate time")
        ),
        Word(
            word = "allow",
            meaning = "允许，许可",
            phonetic = "əˈlaʊ",
            example = "The teacher allowed us to leave early.",
            collocations = listOf("allow someone to", "allow for", "not allowed")
        ),
        Word(
            word = "allowance",
            meaning = "津贴，零用钱",
            phonetic = "əˈlaʊəns",
            example = "He gets an allowance from his parents.",
            collocations = listOf("weekly allowance", "allowance for", "travel allowance")
        ),
        Word(
            word = "ally",
            meaning = "同盟者，支持者",
            phonetic = "ˈælaɪ",
            example = "The two countries are allies.",
            collocations = listOf("political ally", "close ally", "ally with")
        ),
        Word(
            word = "almost",
            meaning = "几乎，差不多",
            phonetic = "ˈɔːlmoʊst",
            example = "I almost forgot.",
            collocations = listOf("almost all", "almost every", "almost never")
        ),
        Word(
            word = "alone",
            meaning = "单独的，独自地",
            phonetic = "əˈloʊn",
            example = "She lives alone.",
            collocations = listOf("live alone", "alone time", "leave alone")
        ),
        Word(
            word = "along",
            meaning = "沿着，顺着",
            phonetic = "əˈlɔːŋ",
            example = "Walk along the street.",
            collocations = listOf("along the way", "get along", "along with")
        ),
        Word(
            word = "alongside",
            meaning = "在...旁边，与...一起",
            phonetic = "əˌlɔːŋˈsaɪd",
            example = "He stood alongside his friend.",
            collocations = listOf("alongside with", "work alongside", "alongside the road")
        ),
        Word(
            word = "aloud",
            meaning = "出声地，大声地",
            phonetic = "əˈlaʊd",
            example = "Please read aloud.",
            collocations = listOf("read aloud", "think aloud", "speak aloud")
        ),
        Word(
            word = "alphabet",
            meaning = "字母表",
            phonetic = "ˈælfəbet",
            example = "The English alphabet has 26 letters.",
            collocations = listOf("English alphabet", "alphabetical order", "learn the alphabet")
        ),
        Word(
            word = "already",
            meaning = "已经",
            phonetic = "ɔːlˈredi",
            example = "I have already eaten.",
            collocations = listOf("already done", "already know", "not yet, already")
        ),
        Word(
            word = "also",
            meaning = "也，还",
            phonetic = "ˈɔːlsoʊ",
            example = "I also like coffee.",
            collocations = listOf("also known as", "not only...but also", "also important")
        ),
        Word(
            word = "alter",
            meaning = "改变，修改",
            phonetic = "ˈɔːltər",
            example = "He altered his plans.",
            collocations = listOf("alter plans", "alter appearance", "alter course")
        ),
        Word(
            word = "alternative",
            meaning = "替代的，选择",
            phonetic = "ɔːlˈtɜːrnətɪv",
            example = "We have alternative options.",
            collocations = listOf("alternative option", "alternative solution", "alternative energy")
        ),
        Word(
            word = "although",
            meaning = "虽然，尽管",
            phonetic = "ɔːlˈðoʊ",
            example = "Although it rained, we had fun.",
            collocations = listOf("although...", "even though", "though")
        ),
        Word(
            word = "altitude",
            meaning = "高度，海拔",
            phonetic = "ˈæltɪtuːd",
            example = "The altitude of the mountain is 5000 meters.",
            collocations = listOf("high altitude", "altitude sickness", "at altitude")
        ),
        Word(
            word = "altogether",
            meaning = "总共，完全",
            phonetic = "ˌɔːltəˈɡeðər",
            example = "Altogether, there are 50 students.",
            collocations = listOf("altogether", "altogether different", "altogether new")
        ),
        Word(
            word = "aluminium",
            meaning = "铝",
            phonetic = "ˌæljəˈmɪniəm",
            example = "The can is made of aluminium.",
            collocations = listOf("aluminium can", "aluminium foil", "aluminium alloy")
        ),
        Word(
            word = "always",
            meaning = "总是，一直",
            phonetic = "ˈɔːlweɪz",
            example = "He always arrives on time.",
            collocations = listOf("always be", "almost always", "not always")
        ),
        Word(
            word = "amateur",
            meaning = "业余的，业余爱好者",
            phonetic = "ˈæmətər",
            example = "He is an amateur photographer.",
            collocations = listOf("amateur photographer", "amateur sports", "amateur hour")
        ),
        Word(
            word = "amaze",
            meaning = "使惊奇，使惊愕",
            phonetic = "əˈmeɪz",
            example = "The view amazed us.",
            collocations = listOf("amaze someone", "be amazed at", "amazing sight")
        ),
        Word(
            word = "ambassador",
            meaning = "大使",
            phonetic = "æmˈbæsədər",
            example = "He is the ambassador to France.",
            collocations = listOf("ambassador to", "ambassadorial duties", "diplomatic ambassador")
        ),
        Word(
            word = "ambiguous",
            meaning = "模棱两可的，含糊的",
            phonetic = "æmˈbɪɡjuəs",
            example = "The statement was ambiguous.",
            collocations = listOf("ambiguous statement", "ambiguous meaning", "ambiguous situation")
        ),
        Word(
            word = "ambition",
            meaning = "雄心，抱负",
            phonetic = "æmˈbɪʃn",
            example = "She has great ambition.",
            collocations = listOf("great ambition", "ambition to", "fulfill ambition")
        ),
        Word(
            word = "ambitious",
            meaning = "有雄心的，野心勃勃的",
            phonetic = "æmˈbɪʃəs",
            example = "He is an ambitious young man.",
            collocations = listOf("ambitious plan", "ambitious goal", "ambitious project")
        ),
        Word(
            word = "ambulance",
            meaning = "救护车",
            phonetic = "ˈæmbjələns",
            example = "The ambulance arrived quickly.",
            collocations = listOf("call an ambulance", "ambulance service", "ambulance driver")
        ),
        Word(
            word = "America",
            meaning = "美国，美洲",
            phonetic = "əˈmerɪkə",
            example = "He lives in America.",
            collocations = listOf("North America", "South America", "Central America")
        ),
        Word(
            word = "American",
            meaning = "美国的，美国人",
            phonetic = "əˈmerɪkən",
            example = "She is an American citizen.",
            collocations = listOf("American culture", "American English", "American people")
        ),
        Word(
            word = "amiable",
            meaning = "和蔼可亲的，友好的",
            phonetic = "ˈeɪmiəbl",
            example = "He is an amiable person.",
            collocations = listOf("amiable person", "amiable smile", "amiable conversation")
        ),
        Word(
            word = "among",
            meaning = "在...之中",
            phonetic = "əˈmʌŋ",
            example = "He is among the best students.",
            collocations = listOf("among us", "among others", "among the crowd")
        ),
        Word(
            word = "amount",
            meaning = "数量，总额",
            phonetic = "əˈmaʊnt",
            example = "The amount of money is large.",
            collocations = listOf("amount of", "large amount", "small amount")
        ),
        Word(
            word = "ample",
            meaning = "充足的，丰富的",
            phonetic = "ˈæmpl",
            example = "We have ample time.",
            collocations = listOf("ample time", "ample space", "ample opportunity")
        ),
        Word(
            word = "amplify",
            meaning = "放大，增强",
            phonetic = "ˈæmplɪfaɪ",
            example = "The amplifier amplifies the sound.",
            collocations = listOf("amplify sound", "amplify signal", "amplify voice")
        ),
        Word(
            word = "amuse",
            meaning = "逗乐，娱乐",
            phonetic = "əˈmjuːz",
            example = "The joke amused us.",
            collocations = listOf("amuse someone", "be amused by", "amusing story")
        ),
        Word(
            word = "analyze",
            meaning = "分析，解析",
            phonetic = "ˈænəlaɪz",
            example = "We need to analyze the data.",
            collocations = listOf("analyze data", "analyze situation", "analyze problem")
        ),
        Word(
            word = "analysis",
            meaning = "分析，解析",
            phonetic = "əˈnæləsɪs",
            example = "The analysis shows that...",
            collocations = listOf("data analysis", "analysis of", "detailed analysis")
        ),
        Word(
            word = "analytical",
            meaning = "分析的，解析的",
            phonetic = "ˌænəˈlɪtɪkl",
            example = "He has an analytical mind.",
            collocations = listOf("analytical mind", "analytical skills", "analytical approach")
        ),
        Word(
            word = "ancient",
            meaning = "古代的，古老的",
            phonetic = "ˈeɪnʃənt",
            example = "The ancient ruins are impressive.",
            collocations = listOf("ancient civilization", "ancient history", "ancient culture")
        ),
        Word(
            word = "and",
            meaning = "和，与",
            phonetic = "ænd",
            example = "I like coffee and tea.",
            collocations = listOf("and so on", "and then", "and also")
        ),
        Word(
            word = "anecdote",
            meaning = "轶事，趣闻",
            phonetic = "ˈænɪkdoʊt",
            example = "He told an anecdote about his childhood.",
            collocations = listOf("tell an anecdote", "funny anecdote", "interesting anecdote")
        ),
        Word(
            word = "anger",
            meaning = "愤怒，怒气",
            phonetic = "ˈæŋɡər",
            example = "His anger was evident.",
            collocations = listOf("show anger", "anger management", "in anger")
        ),
        Word(
            word = "angle",
            meaning = "角度，视角",
            phonetic = "ˈæŋɡl",
            example = "The angle of the sun is low.",
            collocations = listOf("angle of", "view from an angle", "right angle")
        ),
        Word(
            word = "angry",
            meaning = "生气的，愤怒的",
            phonetic = "ˈæŋɡri",
            example = "She is angry with him.",
            collocations = listOf("be angry with", "angry at", "get angry")
        ),
        Word(
            word = "animal",
            meaning = "动物",
            phonetic = "ˈænɪml",
            example = "The zoo has many animals.",
            collocations = listOf("wild animal", "domestic animal", "animal rights")
        ),
        Word(
            word = "ankle",
            meaning = "脚踝",
            phonetic = "ˈæŋkl",
            example = "He twisted his ankle.",
            collocations = listOf("twist ankle", "ankle injury", "sprained ankle")
        ),
        Word(
            word = "anniversary",
            meaning = "周年纪念日",
            phonetic = "ˌænɪˈvɜːrsəri",
            example = "Today is our wedding anniversary.",
            collocations = listOf("wedding anniversary", "anniversary celebration", "10th anniversary")
        ),
        Word(
            word = "announce",
            meaning = "宣布，通告",
            phonetic = "əˈnaʊns",
            example = "The president announced the decision.",
            collocations = listOf("announce decision", "announce results", "announce plans")
        ),
        Word(
            word = "announcement",
            meaning = "公告，声明",
            phonetic = "əˈnaʊnsmənt",
            example = "The announcement was made yesterday.",
            collocations = listOf("official announcement", "public announcement", "announcement of")
        ),
        Word(
            word = "annoy",
            meaning = "使烦恼，使生气",
            phonetic = "əˈnɔɪ",
            example = "His behavior annoys me.",
            collocations = listOf("annoy someone", "be annoyed by", "annoying habit")
        ),
        Word(
            word = "annual",
            meaning = "每年的，年度的",
            phonetic = "ˈænjuəl",
            example = "The annual report is due.",
            collocations = listOf("annual report", "annual meeting", "annual salary")
        ),
        Word(
            word = "another",
            meaning = "另一个，又一个",
            phonetic = "əˈnʌðər",
            example = "I need another book.",
            collocations = listOf("another one", "one after another", "another day")
        ),
        Word(
            word = "answer",
            meaning = "回答，答案",
            phonetic = "ˈænsər",
            example = "He gave a good answer.",
            collocations = listOf("answer a question", "give an answer", "correct answer")
        ),
        Word(
            word = "antenna",
            meaning = "天线",
            phonetic = "ænˈtenə",
            example = "The antenna is broken.",
            collocations = listOf("radio antenna", "TV antenna", "cellular antenna")
        ),
        Word(
            word = "anticipate",
            meaning = "预期，预料",
            phonetic = "ænˈtɪsɪpeɪt",
            example = "We anticipate good results.",
            collocations = listOf("anticipate results", "anticipate problems", "anticipate needs")
        ),
        Word(
            word = "antique",
            meaning = "古董，古老的",
            phonetic = "ænˈtiːk",
            example = "The shop sells antiques.",
            collocations = listOf("antique shop", "antique furniture", "antique collection")
        ),
        Word(
            word = "anxiety",
            meaning = "焦虑，忧虑",
            phonetic = "æŋˈzaɪəti",
            example = "She suffers from anxiety.",
            collocations = listOf("anxiety disorder", "feel anxiety", "anxiety about")
        ),
        Word(
            word = "anxious",
            meaning = "焦虑的，渴望的",
            phonetic = "ˈæŋkʃəs",
            example = "She is anxious about the exam.",
            collocations = listOf("be anxious about", "anxious to", "anxious for")
        ),
        Word(
            word = "any",
            meaning = "任何，一些",
            phonetic = "ˈeni",
            example = "Do you have any questions?",
            collocations = listOf("any time", "any day", "any one")
        ),
        Word(
            word = "anybody",
            meaning = "任何人",
            phonetic = "ˈenibɑːdi",
            example = "Anybody can do it.",
            collocations = listOf("anybody else", "not anybody", "anybody at all")
        ),
        Word(
            word = "anyhow",
            meaning = "无论如何，不管怎样",
            phonetic = "ˈenihaʊ",
            example = "Anyhow, we need to finish the work.",
            collocations = listOf("anyhow", "anyway", "in any case")
        ),
        Word(
            word = "anyone",
            meaning = "任何人",
            phonetic = "ˈeniwʌn",
            example = "Anyone can join.",
            collocations = listOf("anyone else", "not anyone", "anyone at all")
        ),
        Word(
            word = "anything",
            meaning = "任何事物",
            phonetic = "ˈeniθɪŋ",
            example = "I can do anything.",
            collocations = listOf("anything else", "not anything", "anything at all")
        ),
        Word(
            word = "anyway",
            meaning = "无论如何，不管怎样",
            phonetic = "ˈeniweɪ",
            example = "Anyway, let's proceed.",
            collocations = listOf("anyway", "anyhow", "in any case")
        ),
        Word(
            word = "anywhere",
            meaning = "任何地方",
            phonetic = "ˈeniwer",
            example = "You can go anywhere.",
            collocations = listOf("anywhere else", "not anywhere", "anywhere at all")
        ),
        Word(
            word = "apart",
            meaning = "分开，相距",
            phonetic = "əˈpɑːrt",
            example = "They live apart.",
            collocations = listOf("apart from", "take apart", "set apart")
        ),
        Word(
            word = "apartment",
            meaning = "公寓",
            phonetic = "əˈpɑːrtmənt",
            example = "She lives in an apartment.",
            collocations = listOf("apartment building", "rental apartment", "apartment complex")
        ),
        Word(
            word = "apologize",
            meaning = "道歉，认错",
            phonetic = "əˈpɑːlədʒaɪz",
            example = "He apologized for his mistake.",
            collocations = listOf("apologize for", "apologize to", "sincerely apologize")
        ),
        Word(
            word = "apology",
            meaning = "道歉，歉意",
            phonetic = "əˈpɑːlədʒi",
            example = "He made an apology.",
            collocations = listOf("make an apology", "apology for", "sincere apology")
        ),
        Word(
            word = "appear",
            meaning = "出现，似乎",
            phonetic = "əˈpɪr",
            example = "He appeared suddenly.",
            collocations = listOf("appear suddenly", "appear to be", "appear on stage")
        ),
        Word(
            word = "appearance",
            meaning = "外观，出现",
            phonetic = "əˈpɪrəns",
            example = "Her appearance is beautiful.",
            collocations = listOf("physical appearance", "make an appearance", "appearance of")
        ),
        Word(
            word = "apple",
            meaning = "苹果",
            phonetic = "ˈæpl",
            example = "I ate an apple.",
            collocations = listOf("apple pie", "apple juice", "apple tree")
        ),
        Word(
            word = "application",
            meaning = "应用，申请",
            phonetic = "ˌæplɪˈkeɪʃn",
            example = "The application was approved.",
            collocations = listOf("job application", "application form", "application process")
        ),
        Word(
            word = "apply",
            meaning = "应用，申请",
            phonetic = "əˈplaɪ",
            example = "I applied for the job.",
            collocations = listOf("apply for", "apply to", "apply knowledge")
        ),
        Word(
            word = "appoint",
            meaning = "任命，指定",
            phonetic = "əˈpɔɪnt",
            example = "He was appointed manager.",
            collocations = listOf("appoint someone as", "appoint a time", "appoint a place")
        ),
        Word(
            word = "appointment",
            meaning = "任命，约会",
            phonetic = "əˈpɔɪntmənt",
            example = "I have an appointment.",
            collocations = listOf("make an appointment", "doctor's appointment", "business appointment")
        ),
        Word(
            word = "appreciate",
            meaning = "欣赏，感激",
            phonetic = "əˈpriːʃieɪt",
            example = "I appreciate your help.",
            collocations = listOf("appreciate help", "appreciate beauty", "appreciate efforts")
        ),
        Word(
            word = "approach",
            meaning = "接近，方法",
            phonetic = "əˈproʊtʃ",
            example = "He approached the problem carefully.",
            collocations = listOf("approach a problem", "approach someone", "new approach")
        ),
        Word(
            word = "appropriate",
            meaning = "适当的，合适的",
            phonetic = "əˈproʊpriət",
            example = "The dress is appropriate for the occasion.",
            collocations = listOf("appropriate for", "appropriate behavior", "appropriate response")
        )
    )
}