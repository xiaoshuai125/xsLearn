package vip.xsinfo.xslearn.xslearn.shared.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import vip.xsinfo.xslearn.xslearn.core.navigation.DeviceType
import kotlin.js.JsAny
import kotlin.js.Promise

/**
 * 获取 window 对象的 innerWidth 属性
 */
@JsFun("() => window.innerWidth")
external fun getWindowInnerWidth(): Int

/**
 * 添加 resize 事件监听器
 */
@JsFun("""
    (callback) => {
        const handler = () => callback();
        window.addEventListener('resize', handler);
        return handler;
    }
""")
external fun addResizeListener(callback: () -> Unit): JsAny

/**
 * 移除 resize 事件监听器
 */
@JsFun("""
    (handler) => {
        window.removeEventListener('resize', handler);
    }
""")
external fun removeResizeListener(handler: JsAny)

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
    DisposableEffect(Unit) {
        val handler = addResizeListener {
            deviceTypeState.value = calculateDeviceType()
        }

        // 清理函数
        onDispose {
            removeResizeListener(handler)
        }
    }

    return deviceTypeState.value
}

/**
 * 计算当前设备类型
 */
private fun calculateDeviceType(): DeviceType {
    val screenWidth = getWindowInnerWidth()

    // 以屏幕宽度768像素作为平板的判断标准
    return if (screenWidth >= 768) {
        DeviceType.TABLET
    } else {
        DeviceType.PHONE
    }
}
