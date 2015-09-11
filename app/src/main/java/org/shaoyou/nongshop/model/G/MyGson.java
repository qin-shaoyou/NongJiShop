package org.shaoyou.nongshop.model.G;

/**
 * Created by Administrator on 15-9-8.
 */
public class MyGson {


    /**
     * Message : null
     * IsSuccess : true
     * Result : {"UserID":1,"UserName":"admin","FullName":"超级管理员","DeptID":1,"DeptName":"寿光市","DeptCode":"370783","DeptType":"0","RoleID":1}
     */

    private Object Message;
    private boolean IsSuccess;
    private ResultEntity Result;

    public void setMessage(Object Message) {
        this.Message = Message;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public void setResult(ResultEntity Result) {
        this.Result = Result;
    }

    public Object getMessage() {
        return Message;
    }

    public boolean getIsSuccess() {
        return IsSuccess;
    }

    public ResultEntity getResult() {
        return Result;
    }

    public static class ResultEntity {
        /**
         * UserID : 1
         * UserName : admin
         * FullName : 超级管理员
         * DeptID : 1
         * DeptName : 寿光市
         * DeptCode : 370783
         * DeptType : 0
         * RoleID : 1
         */

        private int UserID;
        private String UserName;
        private String FullName;
        private int DeptID;
        private String DeptName;
        private String DeptCode;
        private String DeptType;
        private int RoleID;

        public void setUserID(int UserID) {
            this.UserID = UserID;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public void setFullName(String FullName) {
            this.FullName = FullName;
        }

        public void setDeptID(int DeptID) {
            this.DeptID = DeptID;
        }

        public void setDeptName(String DeptName) {
            this.DeptName = DeptName;
        }

        public void setDeptCode(String DeptCode) {
            this.DeptCode = DeptCode;
        }

        public void setDeptType(String DeptType) {
            this.DeptType = DeptType;
        }

        public void setRoleID(int RoleID) {
            this.RoleID = RoleID;
        }

        public int getUserID() {
            return UserID;
        }

        public String getUserName() {
            return UserName;
        }

        public String getFullName() {
            return FullName;
        }

        public int getDeptID() {
            return DeptID;
        }

        public String getDeptName() {
            return DeptName;
        }

        public String getDeptCode() {
            return DeptCode;
        }

        public String getDeptType() {
            return DeptType;
        }

        public int getRoleID() {
            return RoleID;
        }
    }
}
