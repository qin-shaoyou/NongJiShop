package org.shaoyou.nongshop.data;

import org.shaoyou.nongshop.model.Gson2.SearchGson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-9-10.
 */
public class EmpDataSource {
    List<SearchGson.ResultEntity> list;

    public List<SearchGson.ResultEntity> getDataSource() {
        list = new ArrayList<SearchGson.ResultEntity>();
        for (int i = 0; i < 100; i++) {

        }
        return list;
    }
}
