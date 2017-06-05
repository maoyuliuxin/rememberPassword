package com.lin.rememberpassword.ui.splash;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;

import com.lin.rememberpassword.Utils.FingerprintUtil;
import com.lin.rememberpassword.Utils.ToastUtils;
import com.lin.rememberpassword.mvp.BasePresenterImpl;
import com.lin.rememberpassword.ui.main.MainActivity;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SplashPresenter extends BasePresenterImpl<SplashContract.View> implements SplashContract.Presenter {

    @Override
    public void initData() {

    }

    private void onFingerprintClick() {

        FingerprintUtil.callFingerPrint(new FingerprintUtil.OnCallBackListenr() {
            AlertDialog dialog;

            @Override
            public void onSupportFailed() {
                ToastUtils.toast("当前设备不支持指纹");
            }

            @Override
            public void onInsecurity() {
                ToastUtils.toast("当前设备未处于安全保护中");
            }

            @Override
            public void onEnrollFailed() {
                ToastUtils.toast("请到设置中设置指纹");
            }

            @Override
            public void onAuthenticationStart() {
                AlertDialog.Builder builder = new AlertDialog.Builder(mView.getContext());
                builder.setMessage("解锁中，等正确的放置手指");
                builder.setCancelable(false);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FingerprintUtil.cancel();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onAuthenticationError(int errMsgId, CharSequence errString) {
                ToastUtils.toast(errString.toString());
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();

                }
            }

            @Override
            public void onAuthenticationFailed() {
                ToastUtils.toast("解锁失败");
            }

            @Override
            public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
                ToastUtils.toast(helpString.toString());
            }

            @Override
            public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
                ToastUtils.toast("解锁成功");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                    MainActivity.start(mView.getActivity());
                    mView.getActivity().finish();
                }
            }
        });
    }

    @Override
    public void onClick() {
        onFingerprintClick();
    }
}
