package vip.xsinfo.xslearn.xslearn.screens.vocabulary.viewmodel

import androidx.lifecycle.ViewModel
import vip.xsinfo.xslearn.xslearn.screens.study.SubjectType

/**
 * 背单词页面 ViewModel
 */
class VocabularyViewModel : ViewModel() {
    
    // 当前选择的科目类型
    var subjectType: SubjectType = SubjectType.DEGREE_ENGLISH
    
    // 返回回调
    var onBack: (() -> Unit)? = null
    
    // 当前导航路由
    var currentRoute: String? = null
    
    /**
     * 设置返回回调
     */
    fun setOnBackCallback(callback: () -> Unit) {
        onBack = callback
    }
    
    /**
     * 执行返回操作
     */
    fun back() {
        onBack?.invoke()
    }
}
