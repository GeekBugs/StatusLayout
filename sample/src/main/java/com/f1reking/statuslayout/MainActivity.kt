package com.f1reking.statuslayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.f1reking.statuslayout.R.id.tv_content
import com.f1reking.statuslayout.library.StatusClickListener
import com.f1reking.statuslayout.library.StatusLayout
import kotlinx.android.synthetic.main.activity_main.tv_content

class MainActivity : AppCompatActivity() {

    private lateinit var statusLayout: StatusLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        statusLayout = StatusLayout.Builder(tv_content)
            .setLoadingText("加载中...")
            .setEmptyText("空数据了\ndadwadwadwad")
            .setErrorText("错误了...")
            .setStatusClickListener(object :StatusClickListener{
                override fun onEmptyClick(view: View) {
                    println("数据空")
                    Toast.makeText(this@MainActivity,"数据空",Toast.LENGTH_SHORT).show()
                }

                override fun onErrorClick(view: View) {
                    println("错误")
                    Toast.makeText(this@MainActivity,"错误",Toast.LENGTH_SHORT).show()
                }
            })
            .build()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_content -> {
                statusLayout.showContentLayout()
                return true
            }
            R.id.menu_loading -> {
                statusLayout.showLoadingLayout()
                return true
            }
            R.id.menu_empty   -> {
                statusLayout.showEmptyLayout()
                return true
            }
            R.id.menu_error   -> {
                statusLayout.showErrorLayout()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
