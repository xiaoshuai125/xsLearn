package vip.xsinfo.xslearn.xslearn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlin.js.js

/**
 * Web 平台的设备类型检测实现
 */
@Composable
actual fun getDeviceType(): DeviceType {
    // 创建设备类型状态
    val deviceTypeState: MutableState<DeviceType> = remember {
        mutableStateOf(calculateDeviceType())
    }
    
    // 监听窗口大小变化
    val currentWindow = js("window")
    DisposableEffect(currentWindow) {
        val resizeHandler: (dynamic) -> Unit = {
            deviceTypeState.value = calculateDeviceType()
        }
        
        // 添加 resize 事件监听器
        currentWindow?.addEventListener("resize", resizeHandler)
        
        // 清理函数
        onDispose {
            currentWindow?.removeEventListener("resize", resizeHandler)
        }
    }
    
    return deviceTypeState.value
}

/**
 * 计算当前设备类型
 */
private fun calculateDeviceType(): DeviceType {
    val currentWindow = js("window")
    val screenWidth = currentWindow?.innerWidth ?: 0
    
    // 以屏幕宽度768像素作为平板的判断标准
    return if (screenWidth >= 768) {
        DeviceType.TABLET
    } else {
        DeviceType.PHONE
    }
}
