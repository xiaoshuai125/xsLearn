package vip.xsinfo.xslearn.xslearn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import java.awt.Component
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JFrame

/**
 * JVM（桌面）平台的设备类型检测实现
 */
@Composable
actual fun getDeviceType(): DeviceType {
    // 创建设备类型状态
    val deviceTypeState: MutableState<DeviceType> = remember {
        mutableStateOf(calculateDeviceType())
    }
    
    // 监听窗口大小变化
    DisposableEffect(Unit) {
        val componentListener = object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent) {
                deviceTypeState.value = calculateDeviceType()
            }
        }
        
        // 获取当前窗口并添加监听器
        val window = JFrame.getFrames().firstOrNull()
        window?.addComponentListener(componentListener)
        
        // 清理函数
        onDispose {
            window?.removeComponentListener(componentListener)
        }
    }
    
    return deviceTypeState.value
}

/**
 * 计算当前设备类型
 */
private fun calculateDeviceType(): DeviceType {
    // 获取当前窗口的宽度
    val window = JFrame.getFrames().firstOrNull()
    val windowWidth = window?.width ?: 0
    
    // 如果没有获取到窗口宽度，使用屏幕宽度
    val width = if (windowWidth > 0) windowWidth else Toolkit.getDefaultToolkit().screenSize.width
    
    // 以宽度768像素作为平板/桌面的判断标准
    return if (width >= 768) {
        DeviceType.TABLET
    } else {
        DeviceType.PHONE
    }
}
