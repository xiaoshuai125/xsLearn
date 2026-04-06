package vip.xsinfo.xslearn.xslearn

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vip.xsinfo.xslearn.xslearn.navigation.BottomNavigationBar
import vip.xsinfo.xslearn.xslearn.navigation.DeviceType
import vip.xsinfo.xslearn.xslearn.navigation.HOME_ROUTE
import vip.xsinfo.xslearn.xslearn.navigation.STUDY_ROUTE
import vip.xsinfo.xslearn.xslearn.navigation.SETTINGS_ROUTE
import vip.xsinfo.xslearn.xslearn.navigation.ERROR_BOOK_ROUTE
import vip.xsinfo.xslearn.xslearn.navigation.SideNavigationDrawer
import vip.xsinfo.xslearn.xslearn.navigation.getDeviceType
import vip.xsinfo.xslearn.xslearn.screens.home.HomeScreen
import vip.xsinfo.xslearn.xslearn.screens.study.StudyScreen
import vip.xsinfo.xslearn.xslearn.screens.study.SubjectType
import vip.xsinfo.xslearn.xslearn.screens.vocabulary.VocabularyScreen
import vip.xsinfo.xslearn.xslearn.screens.vocabulary.viewmodel.VocabularyViewModel
import vip.xsinfo.xslearn.xslearn.screens.settings.SettingsScreen
import vip.xsinfo.xslearn.xslearn.screens.errorbook.ErrorBookScreen
import vip.xsinfo.xslearn.xslearn.theme.AppTheme



/**
 * 应用主入口
 */
@Composable
@Preview
@PreviewScreenSizes
fun App() {
    // 页面状态管理
    var currentPage by remember {
        mutableStateOf<Page>(Page.AppBase)
    }
    
    // 背单词页面 ViewModel
    val vocabularyViewModel = remember { VocabularyViewModel() }
    
    // 设置背单词页面的返回回调
    vocabularyViewModel.setOnBackCallback {
        currentPage = Page.AppBase
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // 页面切换动画
        AnimatedContent(
            targetState = currentPage,
            transitionSpec = {
                // 切入特效：淡入缩放
                ContentTransform(
                    targetContentEnter = fadeIn(animationSpec = tween(300)) + scaleIn(animationSpec = tween(300)),
                    initialContentExit = fadeOut(animationSpec = tween(300)) + scaleOut(animationSpec = tween(300))
                )
            },
            label = "Page Transition"
        ) {
            when (it) {
                Page.AppBase -> {
                    // 基础导航信息页
                    AppBase(
                        viewModel = vocabularyViewModel,
                        onNavigateToVocabulary = {
                            // 保存当前导航路由
                            // 注意：这里我们假设 AppBase 会在导航到背单词页面之前保存当前路由
                            currentPage = Page.Vocabulary
                        }
                    )
                }
                Page.Vocabulary -> {
                    // 背单词页面
                    VocabularyScreen(viewModel = vocabularyViewModel)
                }
            }
        }
    }
}

/**
 * 页面类型
 */
enum class Page {
    AppBase,      // 基础导航页面
    Vocabulary    // 背单词页面
}



/**
 * 应用主入口
 * @param viewModel 背单词页面 ViewModel
 * @param onNavigateToVocabulary 导航到背单词页面的回调
 */
@Composable
@PreviewScreenSizes
fun AppBase(
    viewModel: VocabularyViewModel,
    onNavigateToVocabulary: () -> Unit
) {
    AppTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        val deviceType = getDeviceType()

        when (deviceType) {
            DeviceType.PHONE -> {
                // 手机设备使用底部导航栏
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController, currentRoute)
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = HOME_ROUTE,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        composable(HOME_ROUTE) {
                            HomeScreen()
                        }
                        composable(STUDY_ROUTE) {
                            StudyScreen(
                                navController = navController,
                                viewModel = viewModel,
                                onNavigateToVocabulary = {
                                    // 保存当前导航路由
                                    viewModel.currentRoute = STUDY_ROUTE
                                    onNavigateToVocabulary()
                                }
                            )
                        }
                        composable(SETTINGS_ROUTE) {
                            SettingsScreen()
                        }
                        composable(ERROR_BOOK_ROUTE) {
                            ErrorBookScreen()
                        }

                    }
                }
            }
            DeviceType.TABLET -> {
                // 平板设备使用侧边导航栏
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    // 左侧导航栏
                    SideNavigationDrawer(navController, currentRoute)
                    // 右侧内容区域
                    NavHost(
                        navController = navController,
                        startDestination = HOME_ROUTE,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable(HOME_ROUTE) {
                            HomeScreen()
                        }
                        composable(STUDY_ROUTE) {
                            StudyScreen(
                                navController = navController,
                                viewModel = viewModel,
                                onNavigateToVocabulary = {
                                    // 保存当前导航路由
                                    viewModel.currentRoute = STUDY_ROUTE
                                    onNavigateToVocabulary()
                                }
                            )
                        }
                        composable(SETTINGS_ROUTE) {
                            SettingsScreen()
                        }
                        composable(ERROR_BOOK_ROUTE) {
                            ErrorBookScreen()
                        }

                    }
                }
            }
        }
    }
}