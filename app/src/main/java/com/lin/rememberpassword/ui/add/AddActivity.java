package com.lin.rememberpassword.ui.add;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lin.rememberpassword.R;
import com.lin.rememberpassword.mvp.MVPBaseActivity;
import com.lin.rememberpassword.widget.InputItemView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AddActivity extends MVPBaseActivity<AddContract.View, AddPresenter> implements AddContract.View {

    public static final String ID_DATA = "id_data";
    public static final int OPEN_ADD = 100;
    public static final int CLOSE_ADD = 110;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.input_tab_name)
    InputItemView mInputTabName;
    @BindView(R.id.input_number)
    InputItemView mInputNumber;
    @BindView(R.id.input_psd)
    InputItemView mInputPsd;
    @BindView(R.id.input_date)
    InputItemView mInputDate;
    @BindView(R.id.input_tag1_name)
    InputItemView mInputTag1Name;
    @BindView(R.id.input_tag1)
    InputItemView mInputTag1;
    @BindView(R.id.input_tag2_name)
    InputItemView mInputTag2Name;
    @BindView(R.id.input_tag2)
    InputItemView mInputTag2;
    @BindView(R.id.input_tag3_name)
    InputItemView mInputTag3Name;
    @BindView(R.id.input_tag3)
    InputItemView mInputTag3;
    @BindView(R.id.tv_finish)
    TextView mTvFinish;

    public static void start(Activity context) {
        context.startActivityForResult(new Intent(context, AddActivity.class), OPEN_ADD);
    }

    public static void start(Activity context, Long id) {
        Intent intent = new Intent(context, AddActivity.class);
        intent.putExtra(ID_DATA, id);
        context.startActivityForResult(intent, OPEN_ADD);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scrolling;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mPresenter.initView();
        mPresenter.initData();
    }

    @Override
    public InputItemView getTabName() {
        return mInputTabName;
    }

    @Override
    public InputItemView getNumber() {
        return mInputNumber;
    }

    @Override
    public InputItemView getPsd() {
        return mInputPsd;
    }

    @Override
    public InputItemView getDate() {
        return mInputDate;
    }

    @Override
    public InputItemView getTag1Name() {
        return mInputTag1Name;
    }

    @Override
    public InputItemView getTag1() {
        return mInputTag1;
    }

    @Override
    public InputItemView getTag2Name() {
        return mInputTag2Name;
    }

    @Override
    public InputItemView getTag2() {
        return mInputTag2;
    }

    @Override
    public InputItemView getTag3Name() {
        return mInputTag3Name;
    }

    @Override
    public InputItemView getTag3() {
        return mInputTag3;
    }

    @OnClick(R.id.tv_finish)
    public void onViewClicked() {
        mPresenter.onFinish();
    }
}
