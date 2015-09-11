package org.shaoyou.nongshop.KK;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


import org.shaoyou.nongshop.R;
import org.shaoyou.nongshop.model.Gson2.SearchGson;
import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 15-9-11.
 */
public class KKAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<SearchGson.ResultEntity> list;
    public static Boolean boolenpuanduan = true;

    public KKAdapter(Context context, List<SearchGson.ResultEntity> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    /**
     * 添加数据
     *
     * @param resultEntities
     */
    public void addData(List<SearchGson.ResultEntity> resultEntities) {
        list.addAll(resultEntities);
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new MyViewHolder();
            view = inflater.inflate(R.layout.item_result, null);

            viewHolder.vmname = (TextView) view.findViewById(R.id.vmname);
            viewHolder.farmername = (TextView) view.findViewById(R.id.farmername);
            viewHolder.hno = (TextView) view.findViewById(R.id.hno);
            viewHolder.crap = (TextView) view.findViewById(R.id.crap);
            viewHolder.otdata = (TextView) view.findViewById(R.id.otdata);
            viewHolder.acount = (TextView) view.findViewById(R.id.acount);


            view.setTag(viewHolder);
        } else {
            viewHolder = (MyViewHolder) view.getTag();
        }


        if (list.get(i).getVMName() == null || list.get(i).getFARMERNAME() == null ||
                list.get(i).getGHNO() == null || list.get(i).getCROPNAME() == null ||
                list.get(i).getOTDATE() == null) {

            Toast.makeText(inflater.getContext(), "没有可以显示的数据啦", Toast.LENGTH_SHORT).show();
            boolenpuanduan = false;

        } else {


            viewHolder.vmname.setText(list.get(i).getVMName().toString().trim());
            viewHolder.farmername.setText("\n" + "农户姓名    ：" + list.get(i).getFARMERNAME().toString().trim());
            viewHolder.hno.setText("大棚编号    ：" + list.get(i).getGHNO().toString().trim());
            viewHolder.crap.setText("农产品种类：" + list.get(i).getCROPNAME().toString().trim());

            viewHolder.acount.setText("交易金额    ：" + list.get(i).getAMOUNT() + "");
            viewHolder.otdata.setText("交易时间    ：" + list.get(i).getOTDATE().toString().trim() + "\n");
        }
        return view;
    }


}
