package com.lin.rememberpassword.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Administrator on 2017/6/4 0004.
 */

public class DialogUtil {

    public  static void setItemDialog(Context context, String[] items, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(items, onClickListener);
        builder.show();
    }
}
