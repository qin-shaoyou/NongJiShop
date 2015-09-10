package org.shaoyou.nongshop.task;

import android.content.Context;

import org.shaoyou.nongshop.model.Gson2.SearchGson;
import org.shaoyou.nongshop.tool.CanShu;
import org.shaoyou.nongshop.util.Search_WebServiceUtil;

import java.util.List;

/**
 * Created by Administrator on 15-9-10.
 */
public class Search_Runnable {
    private CanShu canShu;
    private Context context;
    private List<SearchGson.ResultEntity> data;

    public Search_Runnable(Context context, CanShu canShu) {
        this.canShu = canShu;
        this.context = context;
    }


    public void getData(final JieKou callBack) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    data = Search_WebServiceUtil.getSearch(canShu);
                    callBack.Huoqu(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
