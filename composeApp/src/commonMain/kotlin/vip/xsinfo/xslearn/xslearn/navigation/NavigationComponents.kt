package vip.xsinfo.xslearn.xslearn.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
                Text(
                    text = "首",
                    color = if (currentRoute == HOME_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
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
            selected = currentRoute == PROFILE_ROUTE,
            onClick = { navController.navigate(PROFILE_ROUTE) },
            label = { Text("个人资料") },
            icon = { 
                Text(
                    text = "个",
                    color = if (currentRoute == PROFILE_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
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
                Text(
                    text = "设",
                    color = if (currentRoute == SETTINGS_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
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
 * 侧边导航栏
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
            .width(250.dp)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        NavigationDrawerItem(
            label = { Text("首页") },
            icon = { 
                Text(
                    text = "首",
                    color = if (currentRoute == HOME_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
            },
            selected = currentRoute == HOME_ROUTE,
            onClick = { navController.navigate(HOME_ROUTE) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            colors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                unselectedTextColor = LocalContentColor.current,
                selectedContainerColor = Color.Transparent, // 移除背景色高亮
                unselectedContainerColor = Color.Transparent
            )
        )
        NavigationDrawerItem(
            label = { Text("个人资料") },
            icon = { 
                Text(
                    text = "个",
                    color = if (currentRoute == PROFILE_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
            },
            selected = currentRoute == PROFILE_ROUTE,
            onClick = { navController.navigate(PROFILE_ROUTE) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            colors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                unselectedTextColor = LocalContentColor.current,
                selectedContainerColor = Color.Transparent, // 移除背景色高亮
                unselectedContainerColor = Color.Transparent
            )
        )
        NavigationDrawerItem(
            label = { Text("设置") },
            icon = { 
                Text(
                    text = "设",
                    color = if (currentRoute == SETTINGS_ROUTE) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        LocalContentColor.current
                    }
                ) 
            },
            selected = currentRoute == SETTINGS_ROUTE,
            onClick = { navController.navigate(SETTINGS_ROUTE) },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
            colors = NavigationDrawerItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = LocalContentColor.current,
                unselectedTextColor = LocalContentColor.current,
                selectedContainerColor = Color.Transparent, // 移除背景色高亮
                unselectedContainerColor = Color.Transparent
            )
        )
    }
}
