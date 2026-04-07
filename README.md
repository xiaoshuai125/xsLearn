# XsLearn - 个人专属备考学习APP

## 项目概述

XsLearn 是一个基于 Kotlin Multiplatform (KMP) 开发的个人专属备考学习APP，支持 Android、iOS、Web、桌面 (JVM) 等多平台。该APP专注于「学位英语→考研计算机」的全备考流程，实现「计划-学习-刷题-模考-复盘-数据追踪」的完整闭环。

## 架构设计理念

### 核心设计原则

1. **分层架构**：采用清晰的分层结构，将代码按职责分离
2. **模块化设计**：每个功能模块独立成一个子目录，便于维护和扩展
3. **平台无关性**：遵循 KMP 设计理念，平台通用代码放在 commonMain 中
4. **关注点分离**：将不同职责的代码分离到不同目录

### 目录结构

```
composeApp/src/commonMain/kotlin/vip/xsinfo/xslearn/xslearn/
├── core/                    # 核心层
│   ├── navigation/         # 导航管理
│   │   ├── DeviceType.kt   # 设备类型枚举
│   │   ├── NavRoutes.kt    # 导航路由定义
│   │   └── NavigationComponents.kt # 导航组件
│   └── theme/              # 主题
│       ├── Color.kt        # 颜色定义
│       └── Theme.kt        # 主题配置
├── feature/                # 功能模块
│   ├── home/              # 首页模块
│   │   ├── components/    # 首页组件
│   │   └── HomeScreen.kt  # 首页主屏幕
│   ├── study/             # 学习中心模块
│   │   ├── components/    # 学习组件
│   │   └── StudyScreen.kt # 学习中心主屏幕
│   ├── vocabulary/        # 背单词模块
│   │   ├── components/    # 背单词组件
│   │   ├── data/          # 背单词数据
│   │   ├── viewmodel/     # 背单词状态管理
│   │   └── VocabularyScreen.kt # 背单词主屏幕
│   ├── settings/          # 设置模块
│   │   ├── components/    # 设置组件
│   │   └── SettingsScreen.kt # 设置主屏幕
│   └── errorbook/         # 错题本模块
│       ├── components/    # 错题本组件
│       └── ErrorBookScreen.kt # 错题本主屏幕
├── shared/                 # 共享层
│   └── utils/             # 工具类
│       └── DeviceUtils.kt # 设备类型检测工具
└── App.kt                 # 应用入口
```

### 架构优势

1. **可维护性**：代码结构清晰，易于理解和修改
2. **可扩展性**：新增功能只需在 feature 目录下创建对应模块
3. **可测试性**：模块化设计便于单元测试和集成测试
4. **代码重用**：共享层的工具类可以被多个功能模块使用
5. **符合 KMP 规范**：平台相关代码放在对应的平台目录中

## 平台特定代码

- **/composeApp/src/androidMain/**：Android 平台特定代码
- **/composeApp/src/iosMain/**：iOS 平台特定代码
- **/composeApp/src/jvmMain/**：桌面 (JVM) 平台特定代码
- **/composeApp/src/webMain/**：Web 平台特定代码

## 构建和运行

### Android 应用

```shell
# macOS/Linux
./gradlew :composeApp:assembleDebug

# Windows
.radlew.bat :composeApp:assembleDebug
```

### 桌面 (JVM) 应用

```shell
# macOS/Linux
./gradlew :composeApp:run

# Windows
.radlew.bat :composeApp:run
```

### Web 应用

- **Wasm 目标** (更快，支持现代浏览器)：
  ```shell
  # macOS/Linux
  ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
  
  # Windows
  .radlew.bat :composeApp:wasmJsBrowserDevelopmentRun
  ```

- **JS 目标** (较慢，支持较旧浏览器)：
  ```shell
  # macOS/Linux
  ./gradlew :composeApp:jsBrowserDevelopmentRun
  
  # Windows
  .radlew.bat :composeApp:jsBrowserDevelopmentRun
  ```

### iOS 应用

使用 IDE 工具栏中的运行配置，或在 Xcode 中打开 [/iosApp](./iosApp) 目录并从那里运行。

## 未来文件放置规划

### 新增功能模块

当需要新增功能模块时，应在 `feature` 目录下创建新的子目录，遵循以下结构：

```
feature/
└── new_feature/           # 新功能模块
    ├── components/        # 功能组件
    ├── data/              # 数据模型
    ├── viewmodel/         # 状态管理
    └── NewFeatureScreen.kt # 主屏幕
```

### 共享组件

通用的 UI 组件应放置在 `shared/components/` 目录下：

```
shared/
├── components/            # 通用 UI 组件
│   ├── Button.kt          # 自定义按钮
│   ├── Card.kt            # 卡片组件
│   └── Dialog.kt          # 对话框组件
└── utils/                 # 工具类
```

### 数据层

未来的数据层代码应放置在 `core/data/` 目录下：

```
core/
├── data/                  # 数据层
│   ├── repository/        # 数据仓库
│   ├── database/          # 本地数据库
│   └── network/           # 网络请求
├── navigation/            # 导航管理
└── theme/                 # 主题
```

### 业务逻辑

复杂的业务逻辑应放置在 `core/domain/` 目录下：

```
core/
├── domain/                # 业务逻辑
│   ├── usecase/           # 用例
│   └── model/             # 领域模型
├── data/                  # 数据层
├── navigation/            # 导航管理
└── theme/                 # 主题
```

## 技术栈

- **Kotlin Multiplatform**：跨平台开发
- **Compose Multiplatform**：跨平台 UI
- **Kotlin Coroutines**：异步编程
- **Ktor**：网络请求
- **SQLDelight**：本地数据库 (未来计划)

## 开发规范

详细的开发规范请参考 [doc](./doc) 目录下的约束文件。

## 贡献指南

1. 遵循项目的目录结构和命名规范
2. 编写清晰的代码注释
3. 为工具类编写单元测试
4. 确保代码编译通过

## 联系方式

如有问题或建议，请联系项目维护者。