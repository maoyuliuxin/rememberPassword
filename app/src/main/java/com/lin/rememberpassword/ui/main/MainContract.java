package com.lin.rememberpassword.ui.main;

import android.support.design.widget.FloatingActionButton;
import android.widget.ListView;

import com.lin.rememberpassword.mvp.BasePresenter;
import com.lin.rememberpassword.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainContract {
    interface View extends BaseView {
        ListView getList();

        FloatingActionButton getFAB();
    }

    interface Presenter extends BasePresenter<View> {
        void initView();

        void onClick(int id);

        void update();
    }
}
