# StatusLayout
[![](https://www.jitpack.io/v/F1ReKing/StatusLayout.svg)](https://www.jitpack.io/#F1ReKing/StatusLayout)

一个在Android上可切换数据状态的布局，包含了加载布局，空数据布局，错误布局

## 特性

1. 支持链式调用
2. 支持动态切换加载，空数据，错误，内容布局
3. 懒加载布局，没有布局层叠问题
4. 支持点击监听事件处理

## 预览图

<a href="res/statusLayout.gif"><img src="res/statusLayout.gif" width="30%"/></a>

## 引入

#### Step 1. Add the JitPack repository to your build file

```
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```

#### Step 2. Add the dependency

```
dependencies {
       compile 'com.github.F1ReKing:StatusLayout:1.2.0'
}
```

## 使用

### 默认使用

- kotlin用法

  ```Kotlin
  private lateinit var statusLayout: StatusLayout

  statusLayout = StatusLayout.Builder(congtentLayout)
          .setStatusClickListener(object : StatusClickListener {
            override fun onEmptyClick(view: View) {
            }

            override fun onErrorClick(view: View) {
            }
          })
          .build()
  ```

- Java 用法

  ```java

  ```

  ​

## 版本开发记录

#### v1.2.0

- 添加了能修改加载布局提示字体颜色

#### v1.1.1

- 更改包名

#### v1.1.0

- 新增修改字体颜色

#### v1.0.1

- 优化布局和功能

#### v1.0

- 初始化提交
- 支持加载布局，空数据布局，出错布局


## License

```
Copyright 2018 F1ReKing. 

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

