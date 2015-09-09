package org.shaoyou.nongshop.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;

import org.shaoyou.nongshop.activity.Login;
import org.shaoyou.nongshop.util.Login_WebServiceUtil;
import org.shaoyou.nongshop.util.Search_WebServiceUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-9-8.
 */
public class Search_Tas extends AsyncTask<Void, Integer, String> {


    private Button loginBtn;

    private Login login_activity;
    private List<String> cities;
    private Map<String, String> result;
    private String NongHuMing;
    private String ZhongLei;
    private String startDate;
    private String endDate;
    private String Result;
    private Context context;

    public static int Puanduan = 1;

    public Search_Tas(Context context, String NongHuMing, String ZhongLei, String startDate, String endDate) {
        this.context = context;
        this.NongHuMing = NongHuMing;
        this.ZhongLei = ZhongLei;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //执行么么哒
    @Override
    protected String doInBackground(Void... voids) {
        Result = Search_WebServiceUtil.getSearch(NongHuMing, ZhongLei, startDate, endDate);

        return Result;
    }

    //用来返回值处理 么
    @Override
    protected void onPostExecute(String result) {


        Toast.makeText(context, Result, 1).show();

    }
}
