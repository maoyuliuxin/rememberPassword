package com.lin.rememberpassword.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.lin.rememberpassword.R;
import com.lin.rememberpassword.mvp.MVPBaseActivity;
import com.lin.rememberpassword.ui.add.AddActivity;

import butterknife.BindView;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.list_view)
    ListView mListView;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
        mPresenter.initView();
        mPresenter.initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                mPresenter.onClick(R.id.add);
                break;
            case R.id.select:
                mPresenter.onClick(R.id.select);
                break;
            case R.id.delete_selector:
                mPresenter.onClick(R.id.delete_selector);
                break;
            case R.id.delete_all:
                mPresenter.onClick(R.id.delete_all);
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AddActivity.OPEN_ADD && resultCode == AddActivity.CLOSE_ADD) {
            mPresenter.update();
        }
    }

    @Override
    public ListView getList() {
        return mListView;
    }

    @Override
    public FloatingActionButton getFAB() {
        return mFab;
    }
}
