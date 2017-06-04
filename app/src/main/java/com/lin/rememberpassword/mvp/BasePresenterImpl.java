package com.lin.rememberpassword.mvp;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter<V>{
    protected V mView;
    @Override
    public void attachView(V view) {
        mView=view;
    }

    @Override
    public void detachView() {
        mView=null;
    }
}
