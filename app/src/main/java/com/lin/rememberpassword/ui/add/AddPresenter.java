package com.lin.rememberpassword.ui.add;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;

import com.lin.rememberpassword.Utils.DialogUtil;
import com.lin.rememberpassword.Utils.WenTiStringUtils;
import com.lin.rememberpassword.bean.PasswordBean;
import com.lin.rememberpassword.db.DbRememberPassWord;
import com.lin.rememberpassword.mvp.BasePresenterImpl;
import com.lin.rememberpassword.widget.InputItemView;

import java.util.Calendar;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class AddPresenter extends BasePresenterImpl<AddContract.View> implements AddContract.Presenter {

    @Override
    public void initData() {
        long id = mView.getIntent().getLongExtra(AddActivity.ID_DATA, -1);
        if (id != -1) {
            PasswordBean passwordBean = DbRememberPassWord.get().getBeanById(id);
            mView.getTabName().setText(passwordBean.getTabName());
            mView.getNumber().setText(passwordBean.getNumber());
            mView.getPsd().setText(passwordBean.getPassWord());
            mView.getDate().setText(passwordBean.getDate());
            mView.getTag1Name().setText(passwordBean.getTag1Name());
            mView.getTag1().setText(passwordBean.getTag1());
            mView.getTag2Name().setText(passwordBean.getTag2Name());
            mView.getTag2().setText(passwordBean.getTag2());
            mView.getTag3Name().setText(passwordBean.getTag3Name());
            mView.getTag3().setText(passwordBean.getTag3());
        }
    }

    @Override
    public void initView() {
        mView.getTabName().setItem("账户类型", "请输入密码类型", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectType();
            }
        });
        mView.getNumber().setItem("账户账号", "请输入账号", null);
        mView.getPsd().setItem("账户密码", "请输入密码", null);
        mView.getDate().setItem("注册日期", "请输入注册日期", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });
        mView.getTag1Name().setItem("备注类型1", "请输入备注类型", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectWenTi(mView.getTag1Name());
            }
        });
        mView.getTag1().setItem("备注1", "请输入备注", null);

        mView.getTag2Name().setItem("备注类型2", "请输入备注类型", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectWenTi(mView.getTag2Name());
            }
        });
        mView.getTag2().setItem("备注2", "请输入备注", null);

        mView.getTag3Name().setItem("备注类型3", "请输入备注类型", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectWenTi(mView.getTag3Name());
            }
        });
        mView.getTag3().setItem("备注3", "请输入备注", null);
    }

    private void selectWenTi(final InputItemView view) {
        final String[] strings = WenTiStringUtils.get();
        DialogUtil.setItemDialog(mView.getContext(), strings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                view.setText(strings[which]);
                dialog.dismiss();
            }
        });
    }

    private void selectDate() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(mView.getContext(),
                0,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mView.getDate().setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));//后边三个参数为显示dialog时默认的日期，月份从0开始，0-11对应1-12个月
        dialog.show();
    }

    private void selectType() {
        final String[] strings = new String[]{"微信", "QQ", "微博", "支付宝", "天猫", "京东", "网易云音乐"};
        DialogUtil.setItemDialog(mView.getContext(), strings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mView.getTabName().setText(strings[which]);
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onFinish() {
        long id = mView.getIntent().getLongExtra(AddActivity.ID_DATA, -1);
        if (id == -1) {
            DbRememberPassWord.get().insert(mView.getTabName().getContent(),
                    mView.getNumber().getContent(),
                    mView.getPsd().getContent(),
                    mView.getDate().getContent(),
                    mView.getTag1Name().getContent(),
                    mView.getTag1().getContent(),
                    mView.getTag2Name().getContent(),
                    mView.getTag2().getContent(),
                    mView.getTag3Name().getContent(),
                    mView.getTag3().getContent());
        } else {
            DbRememberPassWord.get().update(id,
                    mView.getTabName().getContent(),
                    mView.getNumber().getContent(),
                    mView.getPsd().getContent(),
                    mView.getDate().getContent(),
                    mView.getTag1Name().getContent(),
                    mView.getTag1().getContent(),
                    mView.getTag2Name().getContent(),
                    mView.getTag2().getContent(),
                    mView.getTag3Name().getContent(),
                    mView.getTag3().getContent());
        }

        mView.getActivity().setResult(AddActivity.CLOSE_ADD, new Intent());
        mView.getActivity().finish();
    }
}
