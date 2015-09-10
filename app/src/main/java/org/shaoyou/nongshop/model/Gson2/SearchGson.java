package org.shaoyou.nongshop.model.Gson2;

import java.util.List;

/**
 * Created by Administrator on 15-9-9.
 */
public class SearchGson {

    /**
     * Message : null
     * IsSuccess : true
     * Result : [{"ORDERNO":1,"VMName":"寿光市亮腾果菜专业合作社","FARMERNAME":"刘百强","GHNO":"37078311120300082","CROPNAME":"西瓜","WEIGHT":12345.68,"PRICE":7.23,"AMOUNT":89259.25,"OTDATE":"2015-09-08 17:36:31"},{"ORDERNO":2,"VMName":"寿光市亮腾果菜专业合作社","FARMERNAME":"刘百强","GHNO":"37078311120300082","CROPNAME":"西瓜","WEIGHT":3690.12,"PRICE":1.23,"AMOUNT":4555.45,"OTDATE":"2015-09-08 17:34:46"},{"ORDERNO":3,"VMName":"寿光市亮腾果菜专业合作社","FARMERNAME":"刘百强","GHNO":"37078311120300082","CROPNAME":"西瓜","WEIGHT":4563,"PRICE":1.37,"AMOUNT":6249.94,"OTDATE":"2015-09-08 17:31:59"},{"ORDERNO":4,"VMName":"寿光市亮腾果菜专业合作社","FARMERNAME":"刘百强","GHNO":"37078311120300082","CROPNAME":"西瓜","WEIGHT":43679,"PRICE":1.57,"AMOUNT":68479.94,"OTDATE":"2015-09-08 17:27:21"},{"ORDERNO":5,"VMName":"寿光市亮腾果菜专业合作社","FARMERNAME":"刘百强","GHNO":"37078311120300082","CROPNAME":"西瓜","WEIGHT":4697,"PRICE":4.12,"AMOUNT":19368.55,"OTDATE":"2015-09-08 17:24:35"}]
     */

    private Object Message;
    private boolean IsSuccess;
    private List<ResultEntity> Result;

    public void setMessage(Object Message) {
        this.Message = Message;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public void setResult(List<ResultEntity> Result) {
        this.Result = Result;
    }

    public Object getMessage() {
        return Message;
    }

    public boolean getIsSuccess() {
        return IsSuccess;
    }

    public List<ResultEntity> getResult() {
        return Result;
    }

    public static class ResultEntity {
        /**
         * ORDERNO : 1
         * VMName : 寿光市亮腾果菜专业合作社
         * FARMERNAME : 刘百强
         * GHNO : 37078311120300082
         * CROPNAME : 西瓜
         * WEIGHT : 12345.68
         * PRICE : 7.23
         * AMOUNT : 89259.25
         * OTDATE : 2015-09-08 17:36:31
         */

        private int ORDERNO;
        private String VMName;
        private String FARMERNAME;
        private String GHNO;
        private String CROPNAME;
        private double WEIGHT;
        private double PRICE;
        private double AMOUNT;
        private String OTDATE;

        public void setORDERNO(int ORDERNO) {
            this.ORDERNO = ORDERNO;
        }

        public void setVMName(String VMName) {
            this.VMName = VMName;
        }

        public void setFARMERNAME(String FARMERNAME) {
            this.FARMERNAME = FARMERNAME;
        }

        public void setGHNO(String GHNO) {
            this.GHNO = GHNO;
        }

        public void setCROPNAME(String CROPNAME) {
            this.CROPNAME = CROPNAME;
        }

        public void setWEIGHT(double WEIGHT) {
            this.WEIGHT = WEIGHT;
        }

        public void setPRICE(double PRICE) {
            this.PRICE = PRICE;
        }

        public void setAMOUNT(double AMOUNT) {
            this.AMOUNT = AMOUNT;
        }

        public void setOTDATE(String OTDATE) {
            this.OTDATE = OTDATE;
        }

        public int getORDERNO() {
            return ORDERNO;
        }

        public String getVMName() {
            return VMName;
        }

        public String getFARMERNAME() {
            return FARMERNAME;
        }

        public String getGHNO() {
            return GHNO;
        }

        public String getCROPNAME() {
            return CROPNAME;
        }

        public double getWEIGHT() {
            return WEIGHT;
        }

        public double getPRICE() {
            return PRICE;
        }

        public double getAMOUNT() {
            return AMOUNT;
        }

        public String getOTDATE() {
            return OTDATE;
        }
    }
}
