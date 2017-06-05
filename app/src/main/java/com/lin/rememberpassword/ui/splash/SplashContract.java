package com.lin.rememberpassword.ui.splash;

import com.lin.rememberpassword.mvp.BasePresenter;
import com.lin.rememberpassword.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class SplashContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        void onClick();
    }
}
