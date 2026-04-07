package vip.xsinfo.xslearn.xslearn.shared.utils

import androidx.compose.runtime.Composable
import vip.xsinfo.xslearn.xslearn.core.navigation.DeviceType

/**
 * 获取当前设备类型
 * @return 设备类型（手机或平板）
 */
@Composable
expect fun getDeviceType(): DeviceType
