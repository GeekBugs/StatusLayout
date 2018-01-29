package com.f1reking.statuslayout.library

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