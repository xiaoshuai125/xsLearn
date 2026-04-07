# 文件放置规范

## 1. 总体目录结构

```
composeApp/src/commonMain/kotlin/vip/xsinfo/xslearn/xslearn/
├── core/                    # 核心层
│   ├── navigation/         # 导航管理
│   ├── theme/              # 主题
│   ├── data/               # 数据层（未来）
│   └── domain/             # 业务逻辑（未来）
├── feature/                # 功能模块
│   ├── home/              # 首页模块
│   ├── study/             # 学习中心模块
│   ├── vocabulary/        # 背单词模块
│   ├── settings/          # 设置模块
│   └── errorbook/         # 错题本模块
├── shared/                 # 共享层
│   ├── components/        # 通用 UI 组件（未来）
│   └── utils/             # 工具类
└── App.kt                 # 应用入口
```

## 2. 核心层 (core/)

### 2.1 导航管理 (core/navigation/)
- **DeviceType.kt**：设备类型枚举
- **NavRoutes.kt**：导航路由定义
- **NavigationComponents.kt**：导航组件（如 BottomNavigationBar、SideNavigationDrawer）

### 2.2 主题 (core/theme/)
- **Color.kt**：颜色定义
- **Theme.kt**：主题配置

### 2.3 数据层 (core/data/) - 未来计划
- **repository/**：数据仓库
- **database/**：本地数据库
- **network/**：网络请求

### 2.4 业务逻辑 (core/domain/) - 未来计划
- **usecase/**：用例
- **model/**：领域模型

## 3. 功能模块 (feature/)

### 3.1 模块结构
每个功能模块应遵循以下结构：

```
feature/
└── module_name/           # 模块名称
    ├── components/        # 模块专用组件
    ├── data/              # 模块数据模型
    ├── viewmodel/         # 模块状态管理
    └── ModuleNameScreen.kt # 模块主屏幕
```

### 3.2 现有模块

#### 3.2.1 首页模块 (feature/home/)
- **components/**：首页专用组件
- **HomeScreen.kt**：首页主屏幕

#### 3.2.2 学习中心模块 (feature/study/)
- **components/**：学习中心专用组件
- **StudyScreen.kt**：学习中心主屏幕

#### 3.2.3 背单词模块 (feature/vocabulary/)
- **components/**：背单词专用组件
- **data/**：背单词数据模型
- **viewmodel/**：背单词状态管理
- **VocabularyScreen.kt**：背单词主屏幕

#### 3.2.4 设置模块 (feature/settings/)
- **components/**：设置专用组件
- **SettingsScreen.kt**：设置主屏幕

#### 3.2.5 错题本模块 (feature/errorbook/)
- **components/**：错题本专用组件
- **ErrorBookScreen.kt**：错题本主屏幕

### 3.3 新增模块

当需要新增功能模块时，应在 `feature` 目录下创建新的子目录，并遵循上述模块结构。

## 4. 共享层 (shared/)

### 4.1 通用 UI 组件 (shared/components/) - 未来计划
- **Button.kt**：自定义按钮
- **Card.kt**：卡片组件
- **Dialog.kt**：对话框组件
- **TextField.kt**：文本输入框
- **...**：其他通用组件

### 4.2 工具类 (shared/utils/)
- **DeviceUtils.kt**：设备类型检测工具
- **DateUtils.kt**：日期处理工具
- **StringUtils.kt**：字符串处理工具
- **...**：其他工具类

## 5. 平台特定代码

- **/composeApp/src/androidMain/**：Android 平台特定代码
- **/composeApp/src/iosMain/**：iOS 平台特定代码
- **/composeApp/src/jvmMain/**：桌面 (JVM) 平台特定代码
- **/composeApp/src/webMain/**：Web 平台特定代码

## 6. 资源文件

- **/composeApp/src/commonMain/resources/**：通用资源文件
- **/composeApp/src/androidMain/resources/**：Android 平台资源文件
- **/composeApp/src/iosMain/resources/**：iOS 平台资源文件
- **/composeApp/src/jvmMain/resources/**：桌面 (JVM) 平台资源文件
- **/composeApp/src/webMain/resources/**：Web 平台资源文件

## 7. 测试文件

- **/composeApp/src/commonTest/**：通用测试代码
- **/composeApp/src/androidTest/**：Android 平台测试代码
- **/composeApp/src/iosTest/**：iOS 平台测试代码
- **/composeApp/src/jvmTest/**：桌面 (JVM) 平台测试代码
- **/composeApp/src/webTest/**：Web 平台测试代码

## 8. 配置文件

- **/composeApp/build.gradle.kts**：Compose 应用构建配置
- **/shared/build.gradle.kts**：共享模块构建配置
- **/server/build.gradle.kts**：服务器模块构建配置
- **/settings.gradle.kts**：项目设置

## 9. 文档文件

- **/doc/**：项目文档
  - **architecture.md**：架构设计规范
  - **code_style.md**：代码风格规范
  - **file_placement.md**：文件放置规范
  - **...**：其他文档

## 10. 命名规范

### 10.1 目录命名
- 使用小写字母和下划线
- 示例：`core/navigation/`、`feature/home/`

### 10.2 文件命名
- 使用 PascalCase（大驼峰命名法）
- 示例：`HomeScreen.kt`、`VocabularyViewModel.kt`

### 10.3 包命名
- 使用小写字母和点号
- 遵循反向域名命名规则
- 示例：`vip.xsinfo.xslearn.xslearn.core.navigation`

## 11. 最佳实践

1. **遵循目录结构**：严格按照规定的目录结构放置文件
2. **模块化设计**：每个功能模块独立成一个子目录
3. **代码重用**：将通用代码提取到共享层
4. **平台分离**：将平台特定代码放在对应的平台目录中
5. **一致性**：保持文件命名和目录结构的一致性
6. **可维护性**：考虑代码的可维护性和可扩展性
7. **测试覆盖**：为工具类和核心逻辑编写测试

## 12. 常见错误

1. **跨目录乱放**：将代码放在不属于它的目录中
2. **命名不规范**：使用不符合规范的命名
3. **重复代码**：在多个地方重复相同的代码
4. **平台代码混放**：将平台特定代码放在通用目录中
5. **缺少注释**：代码缺少必要的注释

## 13. 总结

遵循统一的文件放置规范，有助于提高代码的可读性、可维护性和可扩展性。所有开发者应严格按照本规范进行代码组织和文件放置。