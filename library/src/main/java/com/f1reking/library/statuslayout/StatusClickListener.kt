/*
 *  Copyright (c) 2018 F1ReKing
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.f1reking.library.statuslayout

import android.view.View

/**
 * @author: F1ReKing
 * @date: 2018/1/29 16:57
 * @desc:
 */
interface StatusClickListener {

    /**
     * 空数据布局点击方法
     * @param view 被点击的view
     */
    fun onEmptyClick(view: View)

    /**
     * 错误数据布局点击方法
     * @param view 被点击的view
     */
    fun onErrorClick(view: View)

}