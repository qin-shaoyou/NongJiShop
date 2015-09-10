package org.shaoyou.nongshop.Ctrl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.shaoyou.nongshop.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DevidePage extends Activity {
    private String EMP_PATH = "http://172.16.17.36:8080/JsonServiceDemo/servlet/EmpAction?pageNo=";
    private ListView listView;
    private MyAdapter adapter;
    private boolean is_divPage;// 是否进行分页操作
    private List<String> oneTotal = new ArrayList<String>();// 用来存放一页数据
    private List<String> total = new ArrayList<String>();//用来存放获取的所有数据
    private ProgressDialog dialog;
    private static int pageNo = 1;//设置pageNo的初始化值为1，即默认获取的是第一页的数据。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jieguo_layout);


        listView = (ListView) findViewById(R.id.listView);
        dialog = new ProgressDialog(DevidePage.this);
        dialog.setTitle("提示:");
        dialog.setMessage("正在加载信息...");

        adapter = new MyAdapter();
        /**
         * 用来获取数据...
         */
        new MyTask().execute(EMP_PATH + pageNo);

        listView.setOnScrollListener(new OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                /**
                 * 当分页操作is_divPage为true时、滑动停止时、且pageNo<=4（这里因为服务端有4页数据）时，加载更多数据。
                 */
                if (is_divPage && scrollState == OnScrollListener.SCROLL_STATE_IDLE && pageNo <= 4) {
                    Toast.makeText(DevidePage.this, "正在获取更多数据...", Toast.LENGTH_SHORT).show();
                    new MyTask().execute(EMP_PATH + pageNo);
                } else if (pageNo > 4) {
                    /**
                     * 如果pageNo>4则表示，服务端没有更多的数据可供加载了。
                     */
                    Toast.makeText(DevidePage.this, "没有更多数据啦...", Toast.LENGTH_SHORT).show();
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

    }

    /**
     * MyTask继承线程池AsyncTask用来网络数据请求、json解析、数据更新等操作。
     */
    class MyTask extends AsyncTask<String, Void, String> {
        /**
         * 数据请求前显示dialog。
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        /**
         * 在doInBackground方法中，做一些诸如网络请求等耗时操作。
         */
        @Override
        protected String doInBackground(String... params) {
            return RequestData();
        }

        /**
         * 在该方法中，主要进行一些数据的处理，更新。
         */
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                // 如果获取的result数据不为空，那么对其进行JSON解析。并显示在手机屏幕上。
                List<String> list = JSONAnalysis(result);
                total.addAll(list);
                adapter.bindData(total);
                /**
                 * 当pageNo等于1的时候才会setAdapter，以后不会再设置，直接notifyDataSetChanged，进行数据更新
                 * ，这样可避免每次加载更多数据的时候，都会重新回到第一页。
                 */
                if (pageNo == 1) {
                    listView.setAdapter(adapter);
                }
                adapter.notifyDataSetChanged();
                pageNo++;
            } else if (result == null) {
                Toast.makeText(DevidePage.this, "请求数据失败...", Toast.LENGTH_LONG)
                        .show();
            }
//			dialog.dismiss();
        }
    }

    /**
     * ListView的适配器
     */
    class MyAdapter extends BaseAdapter {
        List<String> list;

        /**
         * bindData用来传递数据给适配器。
         *
         * @param list
         */
        public void bindData(List<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = null;
            if (convertView == null) {
                textView = new TextView(DevidePage.this);
            } else {
                textView = (TextView) convertView;
            }
            textView.setTextSize(20);
            textView.setText(list.get(position));
            return textView;
        }

    }

    /**
     * 网络数据请求
     *
     * @return
     */
    public String RequestData() {

        StringBuilder builder = null;
        try {

            String Hhh;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * JSON解析
     *
     * @param result
     * @return
     */
    public List<String> JSONAnalysis(String result) {
        oneTotal.clear();//解析之前 先清理一下，以保证只存储该页的数据，避免重复。
        JSONArray array = null;
        try {
            array = new JSONArray(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            String str0 = array.getString(0);
            String str1 = array.getString(1);
            String str2 = array.getString(2);
            String str3 = array.getString(3);
            String str4 = array.getString(4);
            String str5 = array.getString(5);
            String str6 = array.getString(6);
            String str7 = array.getString(7);
            String str8 = array.getString(8);
            String str9 = array.getString(9);
            String str10 = array.getString(10);
            String str11 = array.getString(11);
            String str12 = array.getString(12);
            String str13 = array.getString(13);
            String str14 = array.getString(14);
            String str15 = array.getString(15);
            String str16 = array.getString(16);
            String str17 = array.getString(17);
            String str18 = array.getString(18);
            String str19 = array.getString(19);
            String str20 = array.getString(20);
            String str21 = array.getString(21);
            String str22 = array.getString(22);
            String str23 = array.getString(23);
            String str24 = array.getString(24);

            oneTotal.add(str0);
            oneTotal.add(str1);
            oneTotal.add(str2);
            oneTotal.add(str3);
            oneTotal.add(str4);
            oneTotal.add(str5);
            oneTotal.add(str6);
            oneTotal.add(str7);
            oneTotal.add(str8);
            oneTotal.add(str9);
            oneTotal.add(str10);
            oneTotal.add(str11);
            oneTotal.add(str12);
            oneTotal.add(str13);
            oneTotal.add(str14);
            oneTotal.add(str15);
            oneTotal.add(str16);
            oneTotal.add(str17);
            oneTotal.add(str18);
            oneTotal.add(str19);
            oneTotal.add(str20);
            oneTotal.add(str21);
            oneTotal.add(str22);
            oneTotal.add(str23);
            oneTotal.add(str24);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return oneTotal;//只返回该页的数据
    }
}
