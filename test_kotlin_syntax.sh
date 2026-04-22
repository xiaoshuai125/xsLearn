#!/bin/bash

# 使用 Java 17
export JAVA_HOME=/root/.local/share/mise/installs/java/17.0.2
export PATH=$JAVA_HOME/bin:$PATH

# 检查是否有 kotlinc
if ! command -v kotlinc &> /dev/null; then
    echo "kotlinc not found"
    exit 1
fi

echo "Java version:"
java -version

# 编译一些简单的 Kotlin 代码来验证环境
cat > /tmp/test_simple.kt << 'EOF'
fun main() {
    println("Hello, Kotlin!")
}
EOF

echo "Testing simple Kotlin compilation..."
kotlinc /tmp/test_simple.kt -include-runtime -d /tmp/test_simple.jar

if [ $? -eq 0 ]; then
    echo "✓ Simple Kotlin compilation successful!"
else
    echo "✗ Simple Kotlin compilation failed!"
    exit 1
fi

# 现在尝试编译我们添加的源文件，检查是否有语法错误
# 收集源文件
SOURCE_DIRS=(
    "composeApp/src/commonMain/kotlin/vip/xsinfo/xslearn/xslearn/feature/vocabulary/data"
    "composeApp/src/commonMain/kotlin/vip/xsinfo/xslearn/xslearn/feature/vocabulary/data/wordlists"
    "composeApp/src/commonMain/kotlin/vip/xsinfo/xslearn/xslearn/feature/study"
)

# 创建一个临时目录
TMP_DIR=$(mktemp -d)
cd "$TMP_DIR" || exit 1

# 复制源文件到临时目录，保持目录结构
for dir in "${SOURCE_DIRS[@]}"; do
    if [ -d "/workspace/$dir" ]; then
        find "/workspace/$dir" -name "*.kt" -print0 | while IFS= read -r -d '' file; do
            # 创建目标目录
            rel_path=$(echo "$file" | sed "s|/workspace/||")
            target_dir=$(dirname "$rel_path")
            mkdir -p "$target_dir"
            cp "$file" "$rel_path"
        done
    fi
done

# 列出所有找到的 Kotlin 文件
echo
echo "Found Kotlin source files:"
find . -name "*.kt"

# 尝试编译
echo
echo "Testing compilation of our source files..."
kotlinc -jvm-target 17 $(find . -name "*.kt" | sort) -d /tmp/wordlibs_test.jar 2>&1

if [ $? -eq 0 ]; then
    echo
    echo "✅ SUCCESS! All Kotlin files compile without syntax errors!"
    echo
    # 清理临时文件
    rm -rf "$TMP_DIR" /tmp/test_simple.kt /tmp/test_simple.jar /tmp/wordlibs_test.jar
    exit 0
else
    echo
    echo "❌ FAILED! There are compilation errors!"
    # 保留临时文件以便调试
    echo
    echo "Temporary files are in: $TMP_DIR"
    exit 1
fi
