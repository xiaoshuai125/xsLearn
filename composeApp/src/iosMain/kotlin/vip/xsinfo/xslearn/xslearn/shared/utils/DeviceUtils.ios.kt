package vip.xsinfo.xslearn.xslearn.shared.utils

import androidx.compose.runtime.Composable
import platform.UIKit.UIDevice
import vip.xsinfo.xslearn.xslearn.core.navigation.DeviceType

/**
 * iOS 平台的设备类型检测实现
 */
@Composable
actual fun getDeviceType(): DeviceType {
    val device = UIDevice.currentDevice()
    val model = device.model ?: ""
    
    // 简单判断：如果模型名称包含 iPad，则认为是平板
    return if (model.contains("iPad")) {
        DeviceType.TABLET
    } else {
        DeviceType.PHONE
    }
}
