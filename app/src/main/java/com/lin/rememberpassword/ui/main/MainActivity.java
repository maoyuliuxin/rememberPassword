package com.lin.rememberpassword.ui.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.lin.rememberpassword.R;
import com.lin.rememberpassword.Utils.ToastUtils;
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

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

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
            case R.id.select_all:
                mPresenter.onClick(R.id.select_all);
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
        return null;
    }

    private long mPreTime;

    @Override
    public void onBackPressed() {
        long curTime = SystemClock.elapsedRealtime();
        if (curTime - mPreTime > 1500) {
            ToastUtils.toast("再次点击退出");
            mPreTime = curTime;
        } else {
            super.onBackPressed();
        }
    }
}
