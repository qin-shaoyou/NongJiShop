package org.shaoyou.nongshop.task;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


import org.shaoyou.nongshop.activity.Search;
import org.shaoyou.nongshop.activity.Success;
import org.shaoyou.nongshop.tool.CanShu;

import org.shaoyou.nongshop.util.Search_WebServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.shaoyou.nongshop.model.Gson2.SearchGson;

/**
 * Created by Administrator on 15-9-8.
 */
public class Search_Tas extends AsyncTask<Void, Integer, List<SearchGson.ResultEntity>> {

    ////
//@TargetApi(Build.VERSION_CODES.CUPCAKE)
    private Context context;
    private CanShu canShu;
    private int pageIndex;

    public Search_Tas(Context context, CanShu canShu, int pageIndex) {
        this.context = context;
        this.canShu = canShu;
        this.pageIndex = pageIndex;
    }




    @Override
    protected List<SearchGson.ResultEntity> doInBackground(Void... voids) {





        List<SearchGson.ResultEntity> listMap = null;


        Intent intent = ((Activity) context).getIntent();
        canShu = (CanShu) intent.getSerializableExtra("user");

        canShu.setPageIndex(pageIndex);
        canShu.setPageSize(4);
        Log.d("AAA", "获取数据之前--------------------");

        listMap = Search_WebServiceUtil.getSearch(canShu);


        Log.d("TTT", listMap.get(0).getCROPNAME());


        Log.d("AAA", "获取数据之--------------------");
        return listMap;


//        String StrNongHuMingEditText = getIntentaa.getStringExtra("StrNongHuMingEditText");
//        String StrZhongLeiEditText = getIntentaa.getStringExtra("StrZhongLeiEditText");
//        String StrstartDateiEditText = getIntentaa.getStringExtra("StrstartDateiEditText");
//        String StrendDateEditText = getIntentaa.getStringExtra("StrendDateEditText");

//        Intent getIntentaa = ((Activity) context).getIntent();
//        int bbbb = getIntentaa.getIntExtra("xxoo", 0);
    }

    @Override
    protected void onPostExecute(List<SearchGson.ResultEntity> listMap) {
//        super.onPostExecute(listMap);
//        try {
//            Log.d("AAA", "获取执行前");
//
//            output.Huoqu(listMap);
//            Log.d("AAA", "获取执行中");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String topPan = listMap.get(0).getVMName();
//        String Jiaoyi = listMap.get(0).getOTDATE();
//        String ZHonle = listMap.get(0).getCROPNAME();
//        String Nonghu = listMap.get(0).getFARMERNAME();
//        String Dapeng = listMap.get(0).getGHNO();

//        Log.d("SSS", "异步线程里面的" + topPan + "*****" + Jiaoyi + "*****" + ZHonle + "*****" + Nonghu + Dapeng + "*****");

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}