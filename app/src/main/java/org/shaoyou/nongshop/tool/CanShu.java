package org.shaoyou.nongshop.tool;

import java.io.Serializable;

/**
 * Created by Administrator on 15-9-9.
 */
public class CanShu implements Serializable {
    private String username;//用户名

    private String password;//密码

    private int UserId;//User标识

    private String NongHuMing;//农户名

    private String ZhongLei;//产品种类

    private String startDate;//开始日期

    private String endDate;//结束日期

    private int pageSize;  //空间大小

    private int pageIndex; //wocao

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getNongHuMing() {
        return NongHuMing;
    }

    public void setNongHuMing(String nongHuMing) {
        NongHuMing = nongHuMing;
    }

    public String getZhongLei() {
        return ZhongLei;
    }

    public void setZhongLei(String zhongLei) {
        ZhongLei = zhongLei;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
