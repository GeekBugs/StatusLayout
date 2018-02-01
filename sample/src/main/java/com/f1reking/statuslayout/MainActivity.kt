package com.f1reking.statuslayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.f1reking.library.statuslayout.StatusClickListener
import com.f1reking.library.statuslayout.StatusLayout
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
            .setEmptyText("空数据了")
            .setErrorText("错误了...")
            .setEmptyClickText("刷新...")
            .setErrorClickText("重新加载...")
            .setErrorTextColor(R.color.material_blue_grey_900)
            .setErrorClickTextColor(R.color.material_blue_grey_900)
            .setEmptyTextColor(R.color.material_blue_grey_900)
            .setEmptyClickTextColor(R.color.material_blue_grey_900)
            .setStatusClickListener(object : StatusClickListener {
                override fun onEmptyClick(view: View) {
                    println("数据空")
                    Toast.makeText(this@MainActivity, "数据空", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onErrorClick(view: View) {
                    println("错误")
                    Toast.makeText(this@MainActivity, "错误", Toast.LENGTH_SHORT)
                        .show()
                }
            })
            .build()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_content -> consume {
            statusLayout.showContentLayout()
        }

        R.id.menu_loading -> consume {
            statusLayout.showLoadingLayout()
        }

        R.id.menu_empty   -> consume {
            statusLayout.showEmptyLayout()
        }

        R.id.menu_error   -> consume {
            statusLayout.showErrorLayout()
        }
        else              -> super.onOptionsItemSelected(item)
    }
}

inline fun consume(f: () -> Unit): Boolean {
    f()
    return true
}
