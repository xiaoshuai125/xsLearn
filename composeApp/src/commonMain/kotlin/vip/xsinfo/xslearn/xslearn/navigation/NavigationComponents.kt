package vip.xsinfo.xslearn.xslearn.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import compose.icons.CssGgIcons
import compose.icons.cssggicons.Bee
import compose.icons.cssggicons.Home
import compose.icons.cssggicons.Profile
import compose.icons.cssggicons.Toolbox
import compose.icons.cssggicons.EditFade

/**
 * 底部导航栏
 * @param navController 导航控制器
 * @param currentRoute 当前路由
 */
@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    currentRoute: String?
) {
    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == HOME_ROUTE,
            onClick = { navController.navigate(HOME_ROUTE) },
            label = { Text("首页") },
            icon = {
                Icon(CssGgIcons.Home, contentDescription = null)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                unselectedTextColor = LocalContentColor.current,
                indicatorColor = Color.Transparent // 移除背景色高亮
            )
        )
        NavigationBarItem(
            selected = currentRoute == STUDY_ROUTE,
            onClick = { navController.navigate(STUDY_ROUTE) },
            label = { Text("学习") },
            icon = {
                Icon(CssGgIcons.Bee, contentDescription = null)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                unselectedTextColor = LocalContentColor.current,
                indicatorColor = Color.Transparent // 移除背景色高亮
            )
        )
        NavigationBarItem(
            selected = currentRoute == ERROR_BOOK_ROUTE,
            onClick = { navController.navigate(ERROR_BOOK_ROUTE) },
            label = { Text("错题本") },
            icon = {
                Icon(CssGgIcons.EditFade, contentDescription = null)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                unselectedTextColor = LocalContentColor.current,
                indicatorColor = Color.Transparent // 移除背景色高亮
            )
        )
        NavigationBarItem(
            selected = currentRoute == SETTINGS_ROUTE,
            onClick = { navController.navigate(SETTINGS_ROUTE) },
            label = { Text("设置") },
            icon = {
                Icon(CssGgIcons.Toolbox, contentDescription = null)
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                unselectedTextColor = LocalContentColor.current,
                indicatorColor = Color.Transparent // 移除背景色高亮
            )
        )
    }
}

/**
 * 侧边导航栏（紧凑模式）
 * @param navController 导航控制器
 * @param currentRoute 当前路由
 */
@Composable
fun SideNavigationDrawer(
    navController: NavHostController,
    currentRoute: String?
) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 16.dp, start = 5.dp, end = 5.dp)
    ) {
        NavigationDrawerItem(
            label = { Text("首页") },
            icon = { 
                Icon(
                    imageVector = CssGgIcons.Home,
                    contentDescription = "首页",
                    tint = if (currentRoute == HOME_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
            },
            selected = currentRoute == HOME_ROUTE,
            onClick = { navController.navigate(HOME_ROUTE) },
            colors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                unselectedContainerColor = Color.Transparent
            )
        )
        NavigationDrawerItem(
            label = { Text("学习") },
            icon = { 
                Icon(
                    imageVector = CssGgIcons.Bee,
                    contentDescription = "学习",
                    tint = if (currentRoute == STUDY_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
            },
            selected = currentRoute == STUDY_ROUTE,
            onClick = { navController.navigate(STUDY_ROUTE) },
            colors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                unselectedContainerColor = Color.Transparent
            )
        )

        NavigationDrawerItem(
            label = { Text("错题本") },
            icon = {
                Icon(
                    imageVector = CssGgIcons.EditFade,
                    contentDescription = "错题本",
                    tint = if (currentRoute == ERROR_BOOK_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                )
            },
            selected = currentRoute == ERROR_BOOK_ROUTE,
            onClick = { navController.navigate(ERROR_BOOK_ROUTE) },
            colors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                unselectedContainerColor = Color.Transparent
            )
        )
        NavigationDrawerItem(
            label = { Text("设置") },
            icon = { 
                Icon(
                    imageVector = CssGgIcons.Toolbox,
                    contentDescription = "设置",
                    tint = if (currentRoute == SETTINGS_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
            },
            selected = currentRoute == SETTINGS_ROUTE,
            onClick = { navController.navigate(SETTINGS_ROUTE) },
            colors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                unselectedContainerColor = Color.Transparent
            )
        )
    }
}
