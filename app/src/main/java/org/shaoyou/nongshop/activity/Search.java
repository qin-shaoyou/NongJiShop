package org.shaoyou.nongshop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.shaoyou.nongshop.R;
import org.shaoyou.nongshop.task.Search_Tas;
import org.shaoyou.nongshop.util.Login_WebServiceUtil;

/**
 * Created by Administrator on 15-9-8.
 */
public class Search extends Activity {

    private String NongHuMing;
    private String ZhongLei;
    private String startDate;
    private String endDate;

    private EditText NongHuMingEditText;
    private EditText ZhongLeiEditText;
    private EditText startDateiEditText;
    private EditText endDateEditText;

    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serach_layout);

        NongHuMingEditText = (EditText) findViewById(R.id.NongHuMing);
        ZhongLeiEditText = (EditText) findViewById(R.id.ZhongLei);
        startDateiEditText = (EditText) findViewById(R.id.startDate);
        endDateEditText = (EditText) findViewById(R.id.endDate);

        searchButton = (Button) findViewById(R.id.search_);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Search_Tas search_tas = new Search_Tas(Search.this, NongHuMing, ZhongLei, startDate, endDate);

                search_tas.execute();
            }

        });

    }
}
