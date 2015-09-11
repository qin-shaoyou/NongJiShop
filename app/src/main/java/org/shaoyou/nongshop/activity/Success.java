package org.shaoyou.nongshop.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.shaoyou.nongshop.Ctrl.DevidePage;
import org.shaoyou.nongshop.Ctrl.MyAdapter;
import org.shaoyou.nongshop.KK.KKAdapter;
import org.shaoyou.nongshop.R;
import org.shaoyou.nongshop.model.Gson2.SearchGson;
import org.shaoyou.nongshop.task.JieKou;
import org.shaoyou.nongshop.task.Search_Runnable;
import org.shaoyou.nongshop.task.Search_Tas;
import org.shaoyou.nongshop.tool.CanShu;
import org.shaoyou.nongshop.util.Search_WebServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 15-9-9.
 * implements JieKou
 */
public class Success extends Activity {
    private CanShu canShu;
    List<SearchGson.ResultEntity> output;
    private List<SearchGson.ResultEntity> data = new ArrayList<SearchGson.ResultEntity>();
    private ListView listView;
    private MyAdapter adapter;
    private KKAdapter kkAdapter;
    private boolean is_divPage;// 是否进行分页操作
    private List<SearchGson.ResultEntity> oneTotal = new ArrayList<SearchGson.ResultEntity>();// 用来存放一页数据
    private List<SearchGson.ResultEntity> total = new ArrayList<SearchGson.ResultEntity>();//用来存放获取的所有数据
    private ProgressDialog dialog;
    private static int pageNo = 1;//设置pageNo的初始化值为1，即默认获取的是第一页的数据。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jieguo_layout);

        listView = (ListView) findViewById(R.id.listView);
//        dialog = new ProgressDialog(Success.this);
//        dialog.setTitle("提示:");
//        dialog.setMessage("正在加载信息...");

        kkAdapter = new KKAdapter(this, getData(1));
        listView.setAdapter(kkAdapter);


        /**
         * 用来获取数据...
         */

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                /**
                 * 当分页操作is_divPage为true时、滑动停止时、且pageNo<=4（这里因为服务端有4页数据）时，加载更多数据。
                 */

                //
                if (is_divPage && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && KKAdapter.boolenpuanduan) {
                    Toast.makeText(Success.this, "正在获取更多数据...", Toast.LENGTH_SHORT).show();
//

                    kkAdapter.addData(getData(kkAdapter.getCount() + 1));

                    //刷新视图
                    kkAdapter.notifyDataSetChanged();

                    //
                } else {


                }

            }

            /**
             * 当：第一个可见的item（firstVisibleItem）+可见的item的个数（visibleItemCount）=所有的item总数的时候，
             * is_divPage变为TRUE，这个时候才会加载数据。
             */
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                is_divPage = (firstVisibleItem + visibleItemCount == totalItemCount);
            }
        });
    }      //onCreate结束


//上面写过了

    /**
     * 获取网络数据
     */
    private List<SearchGson.ResultEntity> getData(int pageIndex) {
        List<SearchGson.ResultEntity> list = null;
        try {
            list = new Search_Tas(this, canShu, pageIndex).execute().get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void InitData() {

//    total.add(getData(kkAdapter).get(0).getCROPNAME());

    }


}
















