package com.f1reking.statuslayout.library

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View

/**
 * @author: F1ReKing
 * @date: 2018/1/29 09:08
 * @desc:
 */
class StatusLayout {

    private var contentLayout: View? = null
    private var loadingLayout: View? = null
    private var emptyLayout: View? = null
    private var errorLayout: View? = null

    @LayoutRes private var loadingLayoutID: Int = 0
    @LayoutRes private var emptyLayoutID: Int = 0
    @LayoutRes private var errorLayoutID: Int = 0

    private var inflater: LayoutInflater? = null
    private var statusLayoutHelper: StatusLayoutHelper? = null

    private fun inflater(@LayoutRes resource: Int): View {
        if (null == inflater) {
            inflater = LayoutInflater.from(contentLayout?.context)
        }
        return inflater!!.inflate(resource, null)
    }

    constructor(builder: Builder) {
        this.contentLayout = builder.contentLayout

        this.loadingLayout = builder.loadingLayout
        this.loadingLayoutID = builder.loadingLayoutID

        this.emptyLayout = builder.emptyLayout
        this.emptyLayoutID = builder.emptyLayoutID

        this.errorLayout = builder.errorLayout
        this.errorLayoutID = builder.errorLayoutID
        this.statusLayoutHelper = StatusLayoutHelper(contentLayout)
    }

    /**
     * 显示内容布局
     */
    fun showContentLayout() {
        statusLayoutHelper?.defaultLayout()
    }

    /**
     * 显示加载布局
     */
    fun showLoadingLayout() {
        createLoadingLayout()
        statusLayoutHelper?.showStatusLayout(loadingLayout!!)
    }

    private fun createLoadingLayout() {
        if (null == loadingLayout) {
            loadingLayout = inflater(loadingLayoutID)
        } //todo 加载布局的控件处理
    }

    /**
     * 显示空布局
     */
    fun showEmptyLayout() {
        createEmptyLayout()
        statusLayoutHelper?.showStatusLayout(emptyLayout!!)
    }

    private fun createEmptyLayout() {
        if (null == emptyLayout) {
            emptyLayout = inflater(emptyLayoutID)
        }
    }

    /**
     * 显示错误布局
     */
    fun showErrorLayout() {
        createErrorLayout()
        statusLayoutHelper?.showStatusLayout(errorLayout!!)
    }

    private fun createErrorLayout() {
        if (null == errorLayout) {
            errorLayout = inflater(errorLayoutID)
        }
    }

    class Builder {

        var contentLayout: View? = null
        var loadingLayout: View? = null
        var emptyLayout: View? = null
        var errorLayout: View? = null

        @LayoutRes var loadingLayoutID: Int = 0
        @LayoutRes var emptyLayoutID: Int = 0
        @LayoutRes var errorLayoutID: Int = 0

        constructor(contentLayout: View) {
            this.contentLayout = contentLayout
            this.loadingLayoutID = R.layout.layout_loading
            this.emptyLayoutID = R.layout.layout_empty
            this.errorLayoutID = R.layout.layout_error //todo 处理布局中控件
        }

        fun build(): StatusLayout {
            return StatusLayout(this)
        }

        fun setLoadingLayout(@LayoutRes loadingLayoutID: Int): Builder {
            this.loadingLayoutID = loadingLayoutID
            return this
        }

        fun setLoadingLayout(loadingLayout: View): Builder {
            this.loadingLayout = loadingLayout
            return this
        }

        fun setEmptyLayout(@LayoutRes emptyLayoutID: Int): Builder {
            this.emptyLayoutID = emptyLayoutID
            return this
        }

        fun setEmptyLayout(emptyLayout: View): Builder {
            this.emptyLayout = emptyLayout
            return this
        }

        fun setErrorLayout(@LayoutRes errorLayoutID: Int): Builder {
            this.errorLayoutID = errorLayoutID
            return this
        }

        fun setErrorLayout(errorLayout: View): Builder {
            this.errorLayout = errorLayout
            return this
        }
    }
}