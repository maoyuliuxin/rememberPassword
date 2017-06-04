package com.lin.rememberpassword.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lin.rememberpassword.R;

/**
 * Created by Administrator on 2017/6/4 0004.
 */

public class InputItemView extends LinearLayout {

    private TextView mTvHint;
    private EditText mEtContent;
    private ImageView mIvSelect;

    public InputItemView(Context context) {
        super(context);
        initView();
    }

    public InputItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public InputItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.input_item_view, this);
        mTvHint = (TextView) findViewById(R.id.tv_hint);
        mEtContent = (EditText) findViewById(R.id.et_content);
        mIvSelect = (ImageView) findViewById(R.id.iv_select);
    }

    public void setItem(String title, String hint, OnClickListener onClickListener) {
        if (onClickListener != null) {
            mIvSelect.setOnClickListener(onClickListener);
            mIvSelect.setVisibility(VISIBLE);
        }
        mTvHint.setText(title);
        mEtContent.setHint(hint);
    }

    public void setText(String content) {
        mEtContent.setText(content);
    }

    public String getContent() {
        return mEtContent.getText().toString().trim();
    }
}
