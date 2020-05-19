# StatusLayout
[![](https://www.jitpack.io/v/F1ReKing/StatusLayout.svg)](https://www.jitpack.io/#F1ReKing/StatusLayout)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/F1ReKing/StatusLayout/blob/master/LICENSE)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)

> A zero-invasion layout that switches data states

A layout that can switch the data state on Android, including loading layout, empty data layout, and error layout

## Feature

1. Support chain call
2. Support dynamic switch loading, empty data, error, content layout
3. Lazy loading layout, no layout cascading problem
4. Support click listen event processing

## Preview

<a href="art/statusLayout.gif"><img src="art/statusLayout.gif" width="30%"/></a>

## Introduce

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
       implementation 'com.github.F1ReKing:StatusLayout:x.y.z'
}
```
Current latest version: [![](https://www.jitpack.io/v/F1ReKing/StatusLayout.svg)](https://www.jitpack.io/#F1ReKing/StatusLayout)

## Use

#### Quick usage

- kotlin

  ```Kotlin
  private lateinit var mStatusLayout: StatusLayout

  mStatusLayout = StatusLayout.Builder(congtentLayout)
          .setOnStatusClickListener(object : StatusClickListener {
            override fun onEmptyClick(view: View) {
            }

            override fun onErrorClick(view: View) {
            }
          })
          .build()
  ```

- Java

  ```java
  private StatusLayout mStatusLayout;

  mStatusLayout =
     new StatusLayout.Builder(congtentLayout).setOnStatusClickListener(new StatusClickListener() {
            @Override
            public void onEmptyClick(View view) {
            }

            @Override
            public void onErrorClick(View view) {
            }
          }).build();
  ```

- Unified call

  ```java
  //Display content layout
  mStatusLayout.showContentLayout();
  //Display loading layout
  mStatusLayout.showLoadingLayout();
  //Display empty data layout
  mStatusLayout.showEmptyLayout();
  //Display data wrong layout
  mStatusLayout.showErrorLayout();
  ```

#### API

1. Configuration layout

   **Note: The id in the custom layout must be consistent with the lib**

   | Method name                                      | Explanation       | layout ID                                |
   | ---------------------------------------- | -------- | ---------------------------------------- |
   | setOnLoadingLayout(@LayoutRes loadingLayoutID: Int) | Configure loading layout   | tv_status_loading                        |
   | setOnLoadingLayout(loadingLayout: View)  | Configure loading layout   | tv_status_loading                        |
   | setOnEmptyLayout(@LayoutRes emptyLayoutID: Int) | Configure data empty layout  | iv_status_empty<br />tv_status_empty<br />tv_click_empty |
   | setOnEmptyLayout(emptyLayout: View)      | Configure data empty layout  | iv_status_empty<br />tv_status_empty<br />tv_click_empty |
   | setOnErrorLayout(@LayoutRes errorLayoutID: Int) | Configuration data error layout | iv_status_error<br />tv_status_error<br />tv_click_error |
   | setOnErrorLayout(errorLayout: View)      | Configuration data error layout | iv_status_error<br />tv_status_error<br />tv_click_error |

2. Configure text, font color and other attributes

   | Method name                                      | Explanation           |
   | ---------------------------------------- | ------------ |
   | setOnLoadingText(loadingText: String)    | Set loading prompt text     |
   | setOnLoadingtext(@StringRes loadingTextStringRes: Int) | Set loading prompt text     |
   | setOnLoadingTextColor(loadingTextColorRes: Int) | Set the loading prompt text color   |
   | setOnEmptyText(emptyText: String)        | Set the data prompt text    |
   | setOnEmptyText(@StringRes emptyTextStringRes: Int) | Set the data prompt text    |
   | setOnEmptyClickText(emptyClickText: String) | Set data empty click text    |
   | setOnEmptyClickText(@StringRes emptyClickTextStringRes: Int) | Set data empty click text    |
   | setOnEmptyTextColor(emptyTextStringRes: Int) | Set the data text color  |
   | setOnEmptyClickTextColor(emptyClickTextColorRes: Int) | Set data empty click text color  |
   | setOnErrorText(errorText: String)        | Set error text   |
   | setOnErrorText(@StringRes errorTextStringRes: Int) | Set error text   |
   | setOnErrorClickText(errorClickText: String) | Set data error click text   |
   | setOnErrorClickText(@StringRes errorClickTextStringRes: Int) | Set data error click text   |
   | setOnErrorTextColor(errorTextStringRes: Int) | Set the text color of the data error prompt |
   | setOnErrorClickTextColor(errorClickTextColorRes: Int) | Set data error click text color |

3. Configure picture

   | Method name                                      | Explanation       |
   | ---------------------------------------- | -------- |
   | setOnEmptyImg(@DrawableRes emptyImgID: Int) | Set data empty picture  |
   | setOnErrorImg(@DrawableRes errorImgID: Int) | Set data error picture |

   
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

