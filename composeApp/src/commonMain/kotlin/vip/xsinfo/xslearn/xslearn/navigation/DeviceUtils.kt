package vip.xsinfo.xslearn.xslearn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 设备类型枚举
 */
enum class DeviceType {
    PHONE,
    TABLET
}

/**
 * 获取当前设备类型
 * @return 设备类型（手机或平板）
 */
@Composable
expect fun getDeviceType(): DeviceType
