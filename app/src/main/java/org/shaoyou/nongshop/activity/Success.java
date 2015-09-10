package org.shaoyou.nongshop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.shaoyou.nongshop.R;
import org.shaoyou.nongshop.model.Gson2.SearchGson;
import org.shaoyou.nongshop.task.JieKou;
import org.shaoyou.nongshop.task.Search_Runnable;
import org.shaoyou.nongshop.tool.CanShu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-9-9.
 */
public class Success extends Activity implements JieKou {
    private CanShu canShu;
    List<SearchGson.ResultEntity> output;

    private List<SearchGson.ResultEntity> data = new ArrayList<SearchGson.ResultEntity>();

    @Override
    public void Huoqu(List<SearchGson.ResultEntity> output) {
        data = output;


        Log.d("WWWww", " 咩咩咩个哈哈" + output.get(0).getVMName());

        
        TextView topPan = (TextView) findViewById(R.id.topPanel);
        TextView Nonghu = (TextView) findViewById(R.id.NonghuXINGming);
        TextView Dapeng = (TextView) findViewById(R.id.DapengBinhao);
        TextView Jiaoyi = (TextView) findViewById(R.id.JiaoYijinE);
        TextView ZHonlei = (TextView) findViewById(R.id.NongchanpZhongLei);


        topPan.setText(data.get(0).getVMName());
        Nonghu.setText("农户姓名：" + data.get(0).getFARMERNAME());
        Dapeng.setText("大棚编号：" + data.get(0).getGHNO());
        Jiaoyi.setText("农产品种类：" + data.get(0).getCROPNAME());
        ZHonlei.setText("交易金额：" + data.get(0).getPRICE());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success_layout);


//        Search_Tas search_tas = new Search_Tas(this, canShu);
//
//        search_tas.execute();

        Search_Runnable wocao = new Search_Runnable(this, getCanShu());
        wocao.getData(this);


//        getData(this);
//        asyncTask.delegate = this;
//        Log.d("沃茨法克", asyncTask.delegate.toString());

    }

    private CanShu getCanShu() {

        CanShu canShull = new CanShu();
        Intent intent = getIntent();
        canShull = (CanShu) intent.getSerializableExtra("user");
        canShull.setPageIndex(1);
        canShull.setPageSize(1);
        return canShull;
    }



}
