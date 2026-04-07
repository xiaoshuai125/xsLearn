# 代码风格规范

## 1. 代码格式

### 1.1 缩进和空格
- 使用 4 个空格进行缩进（不使用制表符）
- 每行代码长度不超过 100 个字符
- 操作符前后添加空格
- 逗号后添加空格

### 1.2 空行
- 类、函数、属性之间使用空行分隔
- 逻辑块之间使用空行分隔
- 文件末尾保留一个空行

### 1.3 括号
- 大括号 `{` 与前面的语句在同一行
- 小括号 `()` 内不添加空格
- 中括号 `[]` 内不添加空格

## 2. 命名规范

### 2.1 包名
- 使用小写字母和点号
- 遵循反向域名命名规则
- 示例：`vip.xsinfo.xslearn.xslearn.core.navigation`

### 2.2 类名
- 使用 PascalCase（大驼峰命名法）
- 示例：`HomeScreen`、`VocabularyViewModel`

### 2.3 函数名
- 使用 camelCase（小驼峰命名法）
- 动词开头
- 示例：`navigateToVocabulary`、`getDeviceType`

### 2.4 属性名
- 使用 camelCase（小驼峰命名法）
- 示例：`currentPage`、`vocabularyViewModel`

### 2.5 常量名
- 使用 UPPER_SNAKE_CASE（全大写蛇形命名法）
- 示例：`HOME_ROUTE`、`ANIMATION_DURATION`

### 2.6 枚举名
- 使用 PascalCase（大驼峰命名法）
- 枚举值使用 UPPER_SNAKE_CASE
- 示例：
  ```kotlin
  enum class DeviceType {
      PHONE,
      TABLET
  }
  ```

## 3. 注释规范

### 3.1 类注释
- 使用 KDoc 格式
- 描述类的功能和用途
- 示例：
  ```kotlin
  /**
   * 应用主入口
   */
  @Composable
  fun App() {
      // 代码
  }
  ```

### 3.2 函数注释
- 使用 KDoc 格式
- 描述函数的功能、参数和返回值
- 示例：
  ```kotlin
  /**
   * 应用主入口
   * @param viewModel 背单词页面 ViewModel
   * @param onNavigateToVocabulary 导航到背单词页面的回调
   */
  @Composable
  fun AppBase(
      viewModel: VocabularyViewModel,
      onNavigateToVocabulary: () -> Unit
  ) {
      // 代码
  }
  ```

### 3.3 代码注释
- 对复杂逻辑添加注释
- 解释代码的目的和实现思路
- 避免冗余注释

## 4. 代码组织

### 4.1 导入语句
- 按包名字母顺序排序
- 标准库导入在前
- 第三方库导入在中
- 项目内部导入在后
- 不同类型的导入之间使用空行分隔

### 4.2 函数组织
- 公共函数在前
- 私有函数在后
- 辅助函数放在使用它们的函数附近

### 4.3 类组织
- 属性声明在前
- 构造函数在中
- 方法在后

## 5. Compose 特定规范

### 5.1 Composable 函数
- 使用 `@Composable` 注解
- 函数名使用 PascalCase
- 避免在 Composable 函数中执行耗时操作
- 示例：
  ```kotlin
  @Composable
  fun HomeScreen() {
      // 代码
  }
  ```

### 5.2 状态管理
- 使用 `remember` 存储状态
- 使用 `mutableStateOf` 声明可变状态
- 避免在 Composable 函数中直接修改状态

### 5.3 布局
- 使用 Modifier 链式调用
- 避免嵌套过深的布局
- 提取重复的布局为单独的 Composable 函数

## 6. 错误处理

### 6.1 异常处理
- 使用 try-catch 处理可能的异常
- 提供合理的错误提示
- 避免捕获所有异常

### 6.2 空安全
- 使用 Kotlin 的空安全特性
- 避免使用 `!!` 操作符
- 合理使用 `?.`、`?:` 操作符

## 7. 性能优化

### 7.1 避免不必要的重组合
- 使用 `remember` 缓存计算结果
- 使用 `key` 参数优化列表项的重组
- 避免在 Composable 函数中创建新的对象

### 7.2 资源使用
- 合理使用内存
- 及时释放不再使用的资源
- 避免内存泄漏

## 8. 版本控制

### 8.1 提交消息
- 提交消息应清晰描述变更内容
- 使用英文编写提交消息
- 遵循 conventional commits 规范

### 8.2 分支管理
- 使用主分支（main）作为稳定版本
- 使用特性分支开发新功能
- 使用修复分支修复 bug

## 9. 代码审查

### 9.1 审查标准
- 代码是否符合规范
- 逻辑是否正确
- 性能是否优化
- 可读性是否良好

### 9.2 审查流程
- 提交代码前进行自我审查
- 团队成员进行代码审查
- 解决审查中提出的问题

## 10. 最佳实践

- 遵循 Kotlin 语言最佳实践
- 遵循 Compose 最佳实践
- 保持代码简洁明了
- 优先考虑可读性和可维护性