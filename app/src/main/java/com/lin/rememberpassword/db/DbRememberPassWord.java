package com.lin.rememberpassword.db;

import android.text.TextUtils;

import com.lin.rememberpassword.MyApplication;
import com.lin.rememberpassword.Utils.ToastUtils;
import com.lin.rememberpassword.bean.PasswordBean;
import com.lin.rememberpassword.bean.PasswordBeanDao;

import java.util.List;

/**
 * Created by Administrator on 2017/6/4 0004.
 */

public class DbRememberPassWord {
    private static DbRememberPassWord sRememberPassWord;
    private final PasswordBeanDao mPasswordBeanDao;

    private DbRememberPassWord() {
        mPasswordBeanDao = MyApplication.getDaoSession().getPasswordBeanDao();
    }

    public static DbRememberPassWord get() {
        if (sRememberPassWord == null) {
            sRememberPassWord = new DbRememberPassWord();
        }
        return sRememberPassWord;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<PasswordBean> queryList() {
        List<PasswordBean> list = mPasswordBeanDao.loadAll();
        return list;
    }

    public PasswordBean getBeanById(Long id) {
        PasswordBean load = mPasswordBeanDao.load(id);
        return load;
    }

    public void insert(String tabName, String number, String passWord, String date, String tag1Name, String tag1,
                       String tag2Name, String tag2, String tag3Name, String tag3) {
        if (TextUtils.isEmpty(number) || TextUtils.isEmpty(passWord) || TextUtils.isEmpty(date)) {
            ToastUtils.toast("请输入必填项：账户与密码");
            return;
        }
        PasswordBean passwordBean = new PasswordBean();
        passwordBean.setTabName(tabName);
        passwordBean.setNumber(number);
        passwordBean.setPassWord(passWord);
        passwordBean.setDate(date);
        passwordBean.setTag1Name(tag1Name);
        passwordBean.setTag2Name(tag2Name);
        passwordBean.setTag3Name(tag3Name);
        passwordBean.setTag1(tag1);
        passwordBean.setTag2(tag2);
        passwordBean.setTag3(tag3);
        mPasswordBeanDao.insert(passwordBean);
    }

    public void delete(Long id) {
        mPasswordBeanDao.deleteByKey(id);
    }

    public void deleteAll() {
        mPasswordBeanDao.deleteAll();
    }

    public void update(Long id, String tabName, String number, String passWord, String date, String tag1Name, String tag1,
                       String tag2Name, String tag2, String tag3Name, String tag3) {
        PasswordBean load = mPasswordBeanDao.load(id);
        load.setTabName(tabName);
        load.setNumber(number);
        load.setPassWord(passWord);
        load.setDate(date);
        load.setTag1(tag1);
        load.setTag2(tag2);
        load.setTag3(tag3);
        load.setTag1Name(tag1Name);
        load.setTag2Name(tag2Name);
        load.setTag3Name(tag3Name);
        mPasswordBeanDao.update(load);
    }
}
