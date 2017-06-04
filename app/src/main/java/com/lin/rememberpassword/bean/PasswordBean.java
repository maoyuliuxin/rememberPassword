package com.lin.rememberpassword.bean;

import android.support.annotation.Nullable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by Administrator on 2017/6/4 0004.
 */

@Entity
public class PasswordBean {

    @Id(autoincrement = true)
    private Long id;
    @Property
    private String tabName;
    @NotNull
    private String number;
    @NotNull
    private String passWord;
    @NotNull
    private String date;
    @Property
    private String tag1Name;
    @Property
    private String tag1;
    @Property
    private String tag2Name;
    @Property
    private String tag2;
    @Property
    private String tag3Name;
    @Property
    private String tag3;

    @Transient
    private boolean isShowDelete;

    @Generated(hash = 1542250000)
    public PasswordBean() {
    }

    @Generated(hash = 1432181262)
    public PasswordBean(Long id, String tabName, @NotNull String number, @NotNull String passWord, @NotNull String date, String tag1Name, String tag1, String tag2Name, String tag2,
            String tag3Name, String tag3) {
        this.id = id;
        this.tabName = tabName;
        this.number = number;
        this.passWord = passWord;
        this.date = date;
        this.tag1Name = tag1Name;
        this.tag1 = tag1;
        this.tag2Name = tag2Name;
        this.tag2 = tag2;
        this.tag3Name = tag3Name;
        this.tag3 = tag3;
    }

    public boolean isShowDelete() {
        return isShowDelete;
    }

    public void setShowDelete(boolean showDelete) {
        isShowDelete = showDelete;
    }

    @Nullable
    public String getDate() {
        return date;
    }

    public void setDate(@Nullable String date) {
        this.date = date;
    }

    public String getTag1Name() {
        return tag1Name;
    }

    public void setTag1Name(String tag1Name) {
        this.tag1Name = tag1Name;
    }

    public String getTag2Name() {
        return tag2Name;
    }

    public void setTag2Name(String tag2Name) {
        this.tag2Name = tag2Name;
    }

    public String getTag3Name() {
        return tag3Name;
    }

    public void setTag3Name(String tag3Name) {
        this.tag3Name = tag3Name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Nullable
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(@Nullable String passWord) {
        this.passWord = passWord;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }


    @Override
    public String toString() {
        return "PasswordBean{" +
                "id=" + id +
                ", tabName='" + tabName + '\'' +
                ", number='" + number + '\'' +
                ", passWord='" + passWord + '\'' +
                ", date='" + date + '\'' +
                ", tag1Name='" + tag1Name + '\'' +
                ", tag1='" + tag1 + '\'' +
                ", tag2Name='" + tag2Name + '\'' +
                ", tag2='" + tag2 + '\'' +
                ", tag3Name='" + tag3Name + '\'' +
                ", tag3='" + tag3 + '\'' +
                '}';
    }
}
