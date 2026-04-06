package vip.xsinfo.xslearn.xslearn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
                            StudyScreen()
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
                            StudyScreen()
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