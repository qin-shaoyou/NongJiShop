package org.shaoyou.nongshop.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import org.shaoyou.nongshop.R;
import org.shaoyou.nongshop.model.Gson2.SearchGson;
import org.shaoyou.nongshop.task.JieKou;
import org.shaoyou.nongshop.task.Search_Runnable;
import org.shaoyou.nongshop.task.Search_Tas;
import org.shaoyou.nongshop.tool.CanShu;

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
    private boolean is_divPage;// 是否进行分页操作
    private List<String> oneTotal = new ArrayList<String>();// 用来存放一页数据
    private List<String> total = new ArrayList<String>();//用来存放获取的所有数据
    private ProgressDialog dialog;
    private static int pageNo = 1;//设置pageNo的初始化值为1，即默认获取的是第一页的数据。

    /**
     * @Override public void Huoqu(List<SearchGson.ResultEntity> output) {
     * /**
     * data = output;
     * <p/>
     * <p/>
     * Log.d("WWWww", " 咩咩咩个哈哈" + output.get(0).getVMName());
     * <p/>
     * <p/>
     * TextView topPan = (TextView) findViewById(R.id.topPanel);
     * TextView Nonghu = (TextView) findViewById(R.id.NonghuXINGming);
     * TextView Dapeng = (TextView) findViewById(R.id.DapengBinhao);
     * TextView Jiaoyi = (TextView) findViewById(R.id.JiaoYijinE);
     * TextView ZHonlei = (TextView) findViewById(R.id.NongchanpZhongLei);
     * <p/>
     * <p/>
     * topPan.setText(data.get(0).getVMName());
     * Nonghu.setText("农户姓名：" + data.get(0).getFARMERNAME());
     * Dapeng.setText("大棚编号：" + data.get(0).getGHNO());
     * Jiaoyi.setText("农产品种类：" + data.get(0).getCROPNAME());
     * ZHonlei.setText("交易金额：" + data.get(0).getPRICE());
     * <p/>
     * }
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success_layout);

        listView = (ListView) findViewById(R.id.listView);
        dialog = new ProgressDialog(Success.this);
        dialog.setTitle("提示:");
        dialog.setMessage("正在加载信息...");

        adapter = new MyAdapter();


        Search_Tas search_tas = new Search_Tas(this, canShu);
        try {
            Log.d("AAA", "执行之前，还没执行");

            data = search_tas.execute().get();
            Log.d("AAA", data.get(0).getVMName() + "执行之后 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /**
         * 用来获取数据...
         */

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                /**
                 * 当分页操作is_divPage为true时、滑动停止时、且pageNo<=4（这里因为服务端有4页数据）时，加载更多数据。
                 */
                if (is_divPage && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && pageNo <= 4) {
                    Toast.makeText(Success.this, "正在获取更多数据...", Toast.LENGTH_SHORT).show();
//                    new MyTask().execute(EMP_PATH+pageNo);
                } else if (pageNo > 4) {
                    /**
                     * 如果pageNo>4则表示，服务端没有更多的数据可供加载了。
                     */
                    Toast.makeText(Success.this, "没有更多数据啦...", Toast.LENGTH_SHORT).show();
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

//        Search_Runnable wocao = new Search_Runnable(this, getCanShu());
//        wocao.getData(this);


        //onCreate结束

    }
    /**
     * MyTask继承线程池AsyncTask用来网络数据请求、json解析、数据更新等操作。
     */




}
















