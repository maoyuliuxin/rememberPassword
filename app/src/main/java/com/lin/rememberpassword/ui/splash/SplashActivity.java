package com.lin.rememberpassword.ui.splash;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lin.rememberpassword.R;
import com.lin.rememberpassword.mvp.MVPBaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SplashActivity extends MVPBaseActivity<SplashContract.View, SplashPresenter> implements SplashContract.View {

    @BindView(R.id.tv_jiesuo)
    TextView mTvJiesuo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.initData();
    }

    @OnClick(R.id.tv_jiesuo)
    public void onViewClicked() {
        mPresenter.onClick();
    }
}
