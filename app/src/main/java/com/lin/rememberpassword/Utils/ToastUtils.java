package com.lin.rememberpassword.Utils;

import android.widget.Toast;

import com.lin.rememberpassword.MyApplication;

/**
 * Created by Administrator on 2017/6/4 0004.
 */

public class ToastUtils {
    public static void toast(String msg) {
        Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
