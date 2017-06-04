package com.lin.rememberpassword.ui.add;

import android.content.Intent;

import com.lin.rememberpassword.mvp.BasePresenter;
import com.lin.rememberpassword.mvp.BaseView;
import com.lin.rememberpassword.widget.InputItemView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AddContract {
    interface View extends BaseView {
        InputItemView getTabName();

        InputItemView getNumber();

        InputItemView getPsd();

        InputItemView getDate();

        InputItemView getTag1Name();

        InputItemView getTag1();

        InputItemView getTag2Name();

        InputItemView getTag2();

        InputItemView getTag3Name();

        InputItemView getTag3();

        Intent getIntent();
    }

    interface Presenter extends BasePresenter<View> {
        void initView();

        void onFinish();
    }
}
