package vip.xsinfo.xslearn.xslearn.feature.study

/**
 * 科目类型枚举
 */
enum class SubjectType(
    val displayName: String,
    val isEnglish: Boolean = false,
    val isMath: Boolean = false,
    val isPolitics: Boolean = false,
    val isCS408: Boolean = false
) {
    // 英语类科目
    DEGREE_ENGLISH("学位英语", isEnglish = true),
    POSTGRADUATE_ENGLISH_2("考研英语二", isEnglish = true),
    JUNIOR_COLLEGE_TO_UNIVERSITY_ENGLISH("专升本英语", isEnglish = true),
    
    // 数学类科目
    POSTGRADUATE_MATH_2("考研数学二", isMath = true),
    
    // 政治类科目
    POSTGRADUATE_POLITICS("考研政治", isPolitics = true),
    
    // 408专业课
    DATA_STRUCTURE("数据结构", isCS408 = true),
    COMPUTER_ORGANIZATION("计算机组成原理", isCS408 = true),
    OPERATING_SYSTEM("操作系统", isCS408 = true),
    COMPUTER_NETWORK("计算机网络", isCS408 = true)
}
