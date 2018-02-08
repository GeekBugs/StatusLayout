package com.f1reking.statuslayout

import android.annotation.SuppressLint
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

  @SuppressLint("PrivateResource") private fun initView() {
    statusLayout = StatusLayout.Builder(tv_content)
        .setOnLoadingText("加载中...")
        .setOnEmptyText("空数据了")
        .setOnErrorText("错误了...")
        .setOnEmptyClickText("刷新...")
        .setOnErrorClickText("重新加载...")
        .setOnEmptyImg(R.drawable.ic_empty_sample)
        .setOnErrorImg(R.drawable.ic_error_sample)
        .setOnLoadingTextColor(R.color.material_blue_grey_900)
        .setOnErrorTextColor(R.color.material_blue_grey_900)
        .setOnErrorClickTextColor(R.color.material_blue_grey_900)
        .setOnEmptyTextColor(R.color.material_blue_grey_900)
        .setOnEmptyClickTextColor(resources.getColor(R.color.white))
        .setOnStatusClickListener(object : StatusClickListener {
          override fun onEmptyClick(view: View) {
            Toast.makeText(this@MainActivity, "点击了数据空", Toast.LENGTH_SHORT)
                .show()
          }

          override fun onErrorClick(view: View) {
            Toast.makeText(this@MainActivity, "点击了错误", Toast.LENGTH_SHORT)
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

    R.id.menu_empty -> consume {
      statusLayout.showEmptyLayout()
    }

    R.id.menu_error -> consume {
      statusLayout.showErrorLayout()
    }
    else -> super.onOptionsItemSelected(item)
  }
}

inline fun consume(f: () -> Unit): Boolean {
  f()
  return true
}
