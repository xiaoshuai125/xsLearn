package vip.xsinfo.xslearn.xslearn.feature.vocabulary.data

import vip.xsinfo.xslearn.xslearn.feature.study.SubjectType
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.wordlists.DegreeEnglishWordList
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.wordlists.JuniorCollegeToUniversityEnglishWordList
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.data.wordlists.PostgraduateEnglishWordList

/**
 * 词汇数据管理
 */
object VocabularyData {
    /**
     * 根据科目类型获取单词列表
     */
    fun getWordList(subjectType: SubjectType): List<Word> {
        return when (subjectType) {
            SubjectType.DEGREE_ENGLISH -> DegreeEnglishWordList.words
            SubjectType.POSTGRADUATE_ENGLISH_2 -> PostgraduateEnglishWordList.words
            SubjectType.JUNIOR_COLLEGE_TO_UNIVERSITY_ENGLISH -> JuniorCollegeToUniversityEnglishWordList.words
            else -> emptyList()
        }
    }
}
