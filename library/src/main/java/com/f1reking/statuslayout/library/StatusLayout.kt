package com.f1reking.statuslayout.library

import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
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

    @DrawableRes private var emptyImgID: Int = 0
    @DrawableRes private var errorImgID: Int = 0

    private var inflater: LayoutInflater? = null
    private var statusLayoutHelper: StatusLayoutHelper? = null
    private var statusClickListener: StatusClickListener? = null

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
        this.emptyImgID = builder.emptyImgID

        this.errorLayout = builder.errorLayout
        this.errorLayoutID = builder.errorLayoutID
        this.errorText = builder.errorText
        this.errorImgID = builder.errorImgID

        this.statusClickListener = builder.statusClickListener
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
        if (statusClickListener == null) { //防止出错
            return
        }

        if (emptyImgID > 0) {
            val emptyImageView = emptyLayout!!.findViewById<ImageView>(R.id.iv_status_empty)
            emptyImageView?.setImageResource(emptyImgID)
        }

        val emptyClickView = emptyLayout!!.findViewById<TextView>(R.id.tv_click_empty)
        if (null == emptyClickView) { //防止自定义布局ID出错
            return
        }
        emptyClickView.setOnClickListener {
            statusClickListener!!.onEmptyClick(it)
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
        if (statusClickListener == null) { //防止出错
            return
        }

        if (errorImgID > 0) {
            val emptyImageView = errorLayout!!.findViewById<ImageView>(R.id.iv_status_error)
            emptyImageView?.setImageResource(errorImgID)
        }

        val view = errorLayout!!.findViewById<TextView>(R.id.tv_click_error)
        if (null == view) { //防止自定义布局ID出错
            return
        }
        view.setOnClickListener {
            statusClickListener!!.onErrorClick(it)
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

        @DrawableRes var emptyImgID: Int = 0
        @DrawableRes var errorImgID: Int = 0

        lateinit var statusClickListener: StatusClickListener

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

        fun setEmptyImg(@DrawableRes emptyImgID: Int): Builder {
            this.emptyImgID = emptyImgID
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

        fun setErrorImg(@DrawableRes errorImgID: Int): Builder {
            this.errorImgID = errorImgID
            return this
        }

        fun setErrorText(@StringRes errorTextStringRes: Int): Builder {
            this.errorText = contentLayout?.context?.resources?.getString(errorTextStringRes)!!
            return this
        }

        fun setStatusClickListener(listener: StatusClickListener): Builder {
            this.statusClickListener = listener
            return this
        }
    }
}