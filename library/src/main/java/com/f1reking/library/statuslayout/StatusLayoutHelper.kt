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
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams

/**
 * @author: F1ReKing
 * @date: 2018/1/29 10:35
 * @desc: 替换布局辅助类
 */
class StatusLayoutHelper {

    private var contentLayout: View? = null
    private var currentLayout: View? = null
    private var params: LayoutParams? = null
    private var parentLayout: ViewGroup? = null
    private var viewIndex: Int? = null

    constructor(contentLayout: View?) {
        this.contentLayout = contentLayout
        getContentLayoutParams()
    }

    /**
     * 获取contentLayout布局的参数
     */
    private fun getContentLayoutParams() {
        this.params = contentLayout?.layoutParams
        if (contentLayout?.parent != null) {
            this.parentLayout = contentLayout?.parent as ViewGroup
        } else {
            this.parentLayout = contentLayout?.rootView?.findViewById(android.R.id.content)
        }
        val count = parentLayout?.childCount

        for (index in 0 until count!!) {
            if (contentLayout === parentLayout?.getChildAt(index)) {
                this.viewIndex = index
                break
            }
        }
        this.currentLayout = this.contentLayout
    }

    fun showStatusLayout(view: View?): Boolean {
        if (null == view) {
            return false
        }
        if (currentLayout != view) {
            currentLayout = view
            val parent = view.parent as? ViewGroup
            parent?.removeView(view)
            parentLayout?.removeViewAt(viewIndex!!)
            parentLayout?.addView(view, viewIndex!!, params)
            return true
        }
        return false
    }

    fun setContentLayout(): Boolean {
        return showStatusLayout(contentLayout!!)
    }
}