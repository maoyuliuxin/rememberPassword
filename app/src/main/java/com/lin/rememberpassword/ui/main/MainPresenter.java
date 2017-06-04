package com.lin.rememberpassword.ui.main;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lin.rememberpassword.R;
import com.lin.rememberpassword.Utils.DipAddPxUtils;
import com.lin.rememberpassword.Utils.UtilsViewHolder;
import com.lin.rememberpassword.bean.PasswordBean;
import com.lin.rememberpassword.db.DbRememberPassWord;
import com.lin.rememberpassword.mvp.BasePresenterImpl;
import com.lin.rememberpassword.ui.add.AddActivity;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter, View.OnClickListener, AdapterView.OnItemClickListener {

    private MainAdapter mAdapter;

    @Override
    public void initData() {
        List<PasswordBean> passwordBeans = DbRememberPassWord.get().queryList();
        mAdapter = new MainAdapter(passwordBeans);
        mView.getList().setAdapter(mAdapter);
        mView.getList().setDividerHeight(DipAddPxUtils.dpToPx(mView.getContext(), 10));
        mView.getList().setOnItemClickListener(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onClick(int id) {
        switch (id) {
            case R.id.add:
                AddActivity.start(mView.getActivity());
                break;
            case R.id.select:
                break;
            case R.id.delete_selector:
                break;
            case R.id.delete_all:
                break;
        }
    }

    @Override
    public void update() {
        List<PasswordBean> passwordBeans = DbRememberPassWord.get().queryList();
        Log.e("shen", "passwordBeans=" + passwordBeans);
        mAdapter.setPasswordBeans(passwordBeans);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AddActivity.start(mView.getActivity(), mAdapter.getItemId(position));
    }

    private static class MainAdapter extends BaseAdapter {

        private List<PasswordBean> mPasswordBeans;

        public MainAdapter(List<PasswordBean> passwordBeans) {
            mPasswordBeans = passwordBeans;
        }

        public void setPasswordBeans(List<PasswordBean> passwordBeans) {
            mPasswordBeans = passwordBeans;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mPasswordBeans == null ? 0 : mPasswordBeans.size();
        }

        @Override
        public PasswordBean getItem(int position) {
            return mPasswordBeans.get(position);
        }

        @Override
        public long getItemId(int position) {
            return mPasswordBeans.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            PasswordBean passwordBean = mPasswordBeans.get(position);
            UtilsViewHolder holder = UtilsViewHolder.create(convertView, parent, R.layout.item_main);
            TextView type = holder.getTextView(R.id.tv_type);
            type.setText("账户类型: " + passwordBean.getTabName());
            holder.getTextView(R.id.tv_number).setText("账户账号: " + passwordBean.getNumber());
            holder.getTextView(R.id.tv_psw).setText("账户密码: " + passwordBean.getPassWord());
            return holder.convertView;
        }
    }
}
