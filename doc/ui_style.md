# UI 风格统一规范

## 1. 颜色系统

### 1.1 主色调
- **主色**：`AppColor.Primary` (0xFF4CAF50) - 用于主要按钮、高亮元素
- **主色暗**：`AppColor.PrimaryDark` (0xFF388E3C) - 用于按下状态、渐变
- **主色亮**：`AppColor.PrimaryLight` (0xFF81C784) - 用于背景、次要元素

### 1.2 辅助色
- **辅助色**：`AppColor.Secondary` (0xFF2196F3) - 用于强调、链接
- **辅助色暗**：`AppColor.SecondaryDark` (0xFF1976D2) - 用于按下状态
- **辅助色亮**：`AppColor.SecondaryLight` (0xFF64B5F6) - 用于背景

### 1.3 功能色
- **成功**：`AppColor.Success` (0xFF4CAF50) - 用于成功状态
- **警告**：`AppColor.Warning` (0xFFFFC107) - 用于警告状态
- **错误**：`AppColor.Error` (0xFFF44336) - 用于错误状态
- **信息**：`AppColor.Info` (0xFF2196F3) - 用于信息状态

### 1.4 中性色
- **白色**：`AppColor.White` (0xFFFFFFFF) - 用于背景、卡片
- **黑色**：`AppColor.Black` (0xFF000000) - 用于文字
- **灰色**：`AppColor.Gray` (0xFF9E9E9E) - 用于次要文字
- **浅灰**：`AppColor.LightGray` (0xFFF5F5F5) - 用于背景
- **深灰**：`AppColor.DarkGray` (0xFF616161) - 用于文字

### 1.5 背景色
- **背景**：`AppColor.Background` (0xFFF5F5F5) - 应用背景
- **表面**：`AppColor.Surface` (0xFFFFFFFF) - 卡片、组件背景

### 1.6 文字色
- **主要文字**：`AppColor.TextPrimary` (0xFF212121) - 标题、正文
- **次要文字**：`AppColor.TextSecondary` (0xFF757575) - 辅助文字
- **禁用文字**：`AppColor.TextDisabled` (0xFFBDBDBD) - 禁用状态

### 1.7 边框色
- **边框**：`AppColor.Border` (0xFFE0E0E0) - 组件边框
- **分割线**：`AppColor.Divider` (0xFFEEEEEE) - 分割线

## 2. 排版系统

### 2.1 字体
- **默认字体**：DouyinSansBold
- **字体家族**：统一使用 `defaultFontFamily`

### 2.2 文字大小
- **标题大**：24sp - 页面标题
- **标题中**：20sp - 区块标题
- **标题小**：18sp - 小组件标题
- **正文大**：16sp - 主要内容
- **正文**：14sp - 常规内容
- **正文小**：12sp - 辅助信息

### 2.3 文字样式
- **标题**：粗体，`fontWeight = FontWeight.Bold`
- **正文**：常规，`fontWeight = FontWeight.Normal`
- **辅助文字**：常规，`fontWeight = FontWeight.Normal`

## 3. 组件样式

### 3.1 卡片
- **形状**：圆角 12dp，`RoundedCornerShape(12.dp)`
- **阴影**：高度 4dp，`CardDefaults.cardElevation(4.dp)`
- **背景**：`AppColor.Surface`
- **内边距**：16dp

### 3.2 按钮
- **主要按钮**：
  - 背景色：`AppColor.Primary`
  - 文字色：`AppColor.White`
  - 圆角：8dp
  - 高度：48dp
  - 内边距：16dp

- **次要按钮**：
  - 背景色：`AppColor.Surface`
  - 文字色：`AppColor.Primary`
  - 边框：1dp `AppColor.Primary`
  - 圆角：8dp
  - 高度：48dp
  - 内边距：16dp

- **文本按钮**：
  - 文字色：`AppColor.Primary`
  - 无背景
  - 内边距：8dp

### 3.3 输入框
- **背景**：`AppColor.Surface`
- **边框**：1dp `AppColor.Border`
- **圆角**：8dp
- **内边距**：16dp
- **聚焦边框**：2dp `AppColor.Primary`

### 3.4 图标
- **默认大小**：24dp
- **小型图标**：16dp
- **大型图标**：32dp
- **颜色**：`AppColor.TextPrimary` 或 `AppColor.Primary`

## 4. 布局规范

### 4.1 间距系统
- **微型**：4dp - 组件内部元素间距
- **小型**：8dp - 小型组件间距
- **中型**：12dp - 常规组件间距
- **大型**：16dp - 区块间距
- **特大**：20dp - 页面主要区块间距

### 4.2 页面布局
- **顶部状态栏**：固定高度 56dp
- **底部导航栏**：固定高度 56dp
- **内容区域**：左右边距 16dp，上下边距 16dp
- **滚动区域**：使用 `LazyColumn` 或 `ScrollableColumn`

### 4.3 响应式布局
- **手机**：单列布局，底部导航
- **平板**：双列或三列布局，侧边导航
- **桌面**：多列布局，顶部导航

## 5. 动画规范

### 5.1 过渡动画
- **页面切换**：淡入淡出 + 缩放，300ms
- **组件出现**：淡入 + 上移，300ms
- **组件消失**：淡出 + 下移，300ms

### 5.2 交互动画
- **按钮点击**：缩放 0.95，100ms
- **卡片悬停**：阴影增加，200ms
- **列表项滑动**：平移 + 淡入淡出，200ms

## 6. 图标规范

### 6.1 图标风格
- **线条图标**：2px 线条宽度，统一风格
- **填充图标**：用于强调状态
- **品牌图标**：应用 logo，使用 SVG 格式

### 6.2 图标使用
- **导航图标**：24dp，居中显示
- **操作图标**：20dp，与文字对齐
- **状态图标**：16dp，用于指示状态

## 7. 图片规范

### 7.1 图片格式
- **图标**：SVG 格式
- **照片**：JPEG 或 WebP 格式
- **插图**：PNG 或 SVG 格式

### 7.2 图片尺寸
- **头像**：48x48dp
- **卡片图片**：根据布局自适应
- **背景图片**：根据屏幕尺寸自适应

## 8. 统一实现

### 8.1 主题实现
- 修改 `Theme.kt`，使用 `AppColor` 定义的颜色
- 统一 `Typography`，设置标准文字大小和样式

### 8.2 组件实现
- 创建统一的卡片、按钮、输入框等组件
- 确保所有页面使用统一的组件样式

### 8.3 布局实现
- 统一页面布局结构
- 确保所有页面使用相同的间距和边距

## 9. 检查清单

- [ ] 所有页面使用统一的颜色
- [ ] 所有页面使用统一的排版
- [ ] 所有组件使用统一的样式
- [ ] 所有页面使用统一的布局
- [ ] 所有交互使用统一的动画
- [ ] 所有图标使用统一的风格
- [ ] 所有图片使用统一的格式

## 10. 最佳实践

- **一致性**：保持所有页面和组件的风格一致
- **简洁性**：使用简洁的设计，避免过度装饰
- **可读性**：确保文字清晰可读，颜色对比度适中
- **响应式**：确保在不同设备上的良好显示
- **性能**：优化动画和过渡效果，确保流畅体验

## 11. 示例

### 11.1 卡片示例
```kotlin
Card(
    modifier = modifier,
    shape = RoundedCornerShape(12.dp),
    elevation = CardDefaults.cardElevation(4.dp),
    colors = CardDefaults.cardColors(
        containerColor = AppColor.Surface
    )
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        // 卡片内容
    }
}
```

### 11.2 按钮示例
```kotlin
Button(
    onClick = onClick,
    modifier = Modifier.height(48.dp),
    shape = RoundedCornerShape(8.dp),
    colors = ButtonDefaults.buttonColors(
        containerColor = AppColor.Primary,
        contentColor = AppColor.White
    )
) {
    Text(text = text)
}
```

### 11.3 标题示例
```kotlin
Text(
    text = title,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    color = AppColor.TextPrimary
)
```

### 11.4 布局示例
```kotlin
Column(modifier = Modifier.fillMaxSize()) {
    // 顶部状态栏
    TopBar()
    
    // 内容区域
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 内容项
    }
}
```