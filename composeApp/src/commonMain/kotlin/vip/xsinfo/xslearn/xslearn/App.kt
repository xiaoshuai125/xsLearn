package vip.xsinfo.xslearn.xslearn

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import vip.xsinfo.xslearn.xslearn.core.navigation.BottomNavigationBar
import vip.xsinfo.xslearn.xslearn.core.navigation.DeviceType
import vip.xsinfo.xslearn.xslearn.core.navigation.HOME_ROUTE
import vip.xsinfo.xslearn.xslearn.core.navigation.STUDY_ROUTE
import vip.xsinfo.xslearn.xslearn.core.navigation.SETTINGS_ROUTE
import vip.xsinfo.xslearn.xslearn.core.navigation.ERROR_BOOK_ROUTE
import vip.xsinfo.xslearn.xslearn.core.navigation.SideNavigationDrawer
import vip.xsinfo.xslearn.xslearn.shared.utils.getDeviceType
import vip.xsinfo.xslearn.xslearn.feature.home.HomeScreen
import vip.xsinfo.xslearn.xslearn.feature.study.StudyScreen
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.VocabularyScreen
import vip.xsinfo.xslearn.xslearn.feature.vocabulary.viewmodel.VocabularyViewModel
import vip.xsinfo.xslearn.xslearn.feature.settings.SettingsScreen
import vip.xsinfo.xslearn.xslearn.feature.errorbook.ErrorBookScreen
import vip.xsinfo.xslearn.xslearn.core.theme.AppTheme
import vip.xsinfo.xslearn.xslearn.shared.components.DynamicBackground

@Composable
@Preview
@PreviewScreenSizes
fun App() {
    var currentPage by remember { mutableStateOf<Page>(Page.AppBase) }
    val vocabularyViewModel = remember { VocabularyViewModel() }
    
    vocabularyViewModel.setOnBackCallback { currentPage = Page.AppBase }

    Box(modifier = Modifier.fillMaxSize()) {
        AnimatedContent(
            targetState = currentPage,
            transitionSpec = {
                ContentTransform(
                    targetContentEnter = fadeIn(tween(300)) + scaleIn(tween(300)),
                    initialContentExit = fadeOut(tween(300)) + scaleOut(tween(300))
                )
            },
            label = "Page Transition"
        ) {
            when (it) {
                Page.AppBase -> AppBase(
                    viewModel = vocabularyViewModel,
                    onNavigateToVocabulary = {
                        vocabularyViewModel.currentRoute = STUDY_ROUTE
                        currentPage = Page.Vocabulary
                    }
                )
                Page.Vocabulary -> VocabularyScreen(viewModel = vocabularyViewModel)
            }
        }
    }
}

enum class Page {
    AppBase,
    Vocabulary
}

@Composable
@PreviewScreenSizes
fun AppBase(
    viewModel: VocabularyViewModel,
    onNavigateToVocabulary: () -> Unit
) {
    AppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            // 动态背景
            DynamicBackground()
            
            val navController = rememberNavController()
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            val deviceType = getDeviceType()

            when (deviceType) {
                DeviceType.PHONE -> PhoneLayout(
                    navController = navController,
                    currentRoute = currentRoute,
                    viewModel = viewModel,
                    onNavigateToVocabulary = onNavigateToVocabulary
                )
                DeviceType.TABLET -> TabletLayout(
                    navController = navController,
                    currentRoute = currentRoute,
                    viewModel = viewModel,
                    onNavigateToVocabulary = onNavigateToVocabulary
                )
            }
        }
    }
}

@Composable
private fun PhoneLayout(
    navController: NavHostController,
    currentRoute: String?,
    viewModel: VocabularyViewModel,
    onNavigateToVocabulary: () -> Unit
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController, currentRoute) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(HOME_ROUTE) { HomeScreen() }
            composable(STUDY_ROUTE) {
                StudyScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onNavigateToVocabulary = onNavigateToVocabulary
                )
            }
            composable(SETTINGS_ROUTE) { SettingsScreen() }
            composable(ERROR_BOOK_ROUTE) { ErrorBookScreen() }
        }
    }
}

@Composable
private fun TabletLayout(
    navController: NavHostController,
    currentRoute: String?,
    viewModel: VocabularyViewModel,
    onNavigateToVocabulary: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        SideNavigationDrawer(navController, currentRoute)
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(HOME_ROUTE) { HomeScreen() }
            composable(STUDY_ROUTE) {
                StudyScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onNavigateToVocabulary = onNavigateToVocabulary
                )
            }
            composable(SETTINGS_ROUTE) { SettingsScreen() }
            composable(ERROR_BOOK_ROUTE) { ErrorBookScreen() }
        }
    }
}