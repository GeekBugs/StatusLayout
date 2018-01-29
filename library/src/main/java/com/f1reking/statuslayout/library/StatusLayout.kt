package com.f1reking.statuslayout.library

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

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

    private var loadingText: String = ""
    private var emptyText: String = ""
    private var errorText: String = ""

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
        this.loadingText = builder.loadingText

        this.emptyLayout = builder.emptyLayout
        this.emptyLayoutID = builder.emptyLayoutID
        this.emptyText = builder.emptyText

        this.errorLayout = builder.errorLayout
        this.errorLayoutID = builder.errorLayoutID
        this.errorText = builder.errorText

        this.statusLayoutHelper = StatusLayoutHelper(contentLayout)
    }

    /**
     * 显示内容布局
     */
    fun showContentLayout() {
        statusLayoutHelper?.setContentLayout()
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
        }
        if (!TextUtils.isEmpty(loadingText)) {
            val loadingTextView = loadingLayout!!.findViewById<TextView>(R.id.tv_status_loading)
            loadingTextView?.text = loadingText
        }
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
        if (!TextUtils.isEmpty(emptyText)) {
            val emptyTextView = emptyLayout!!.findViewById<TextView>(R.id.tv_status_empty)
            emptyTextView?.text = emptyText
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
        if (!TextUtils.isEmpty(errorText)) {
            val errorTextView = errorLayout!!.findViewById<TextView>(R.id.tv_status_error)
            errorTextView?.text = errorText
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

        var loadingText: String = ""
        var emptyText: String = ""
        var errorText: String = ""

        constructor(contentLayout: View) {
            this.contentLayout = contentLayout
            this.loadingLayoutID = R.layout.layout_loading
            this.emptyLayoutID = R.layout.layout_empty
            this.errorLayoutID = R.layout.layout_error

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

        fun setLoadingText(loadingText: String): Builder {
            this.loadingText = loadingText
            return this
        }

        fun setLoadingtext(@StringRes loadingTextStringRes: Int): Builder {
            this.loadingText = contentLayout?.context?.resources?.getString(loadingTextStringRes)!!
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

        fun setEmptyText(emptyText: String): Builder {
            this.emptyText = emptyText
            return this
        }

        fun setEmptyText(@StringRes emptyTextStringRes: Int): Builder {
            this.emptyText = contentLayout?.context?.resources?.getString(emptyTextStringRes)!!
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

        fun setErrorText(errorText: String): Builder {
            this.errorText = errorText
            return this
        }

        fun setErrorText(@StringRes errorTextStringRes: Int): Builder {
            this.errorText = contentLayout?.context?.resources?.getString(errorTextStringRes)!!
            return this
        }


    }
}