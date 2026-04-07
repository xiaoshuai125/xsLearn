package vip.xsinfo.xslearn.xslearn.shared.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import vip.xsinfo.xslearn.xslearn.core.navigation.DeviceType

/**
 * Android 平台的设备类型检测实现
 */
@Composable
actual fun getDeviceType(): DeviceType {
    val configuration = LocalConfiguration.current
    
    // 创建设备类型状态，使用LocalConfiguration作为key，当配置变化时会自动重新计算
    val deviceTypeState: MutableState<DeviceType> = remember(configuration) {
        mutableStateOf(calculateDeviceType(configuration.screenWidthDp))
    }
    
    return deviceTypeState.value
}

/**
 * 计算当前设备类型
 */
private fun calculateDeviceType(screenWidthDp: Int): DeviceType {
    // 以最小宽度600dp作为平板的判断标准
    return if (screenWidthDp >= 600) {
        DeviceType.TABLET
    } else {
        DeviceType.PHONE
    }
}
