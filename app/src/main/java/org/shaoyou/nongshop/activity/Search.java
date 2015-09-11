package org.shaoyou.nongshop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.shaoyou.nongshop.R;
import org.shaoyou.nongshop.model.G.CanShu;

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


        searchButton = (Button) findViewById(R.id.search_);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NongHuMingEditText = (EditText) findViewById(R.id.NongHuMing);
                ZhongLeiEditText = (EditText) findViewById(R.id.ZhongLei);
                startDateiEditText = (EditText) findViewById(R.id.startDate);
                endDateEditText = (EditText) findViewById(R.id.endDate);

                CanShu canShu = new CanShu();

                String StrNongHuMingEditText = NongHuMingEditText.getText().toString();
                String StrZhongLeiEditText = ZhongLeiEditText.getText().toString();
                String StrstartDateiEditText = startDateiEditText.getText().toString();
                String StrendDateEditText = endDateEditText.getText().toString();


                Intent getIntent = getIntent();
                int Userid = getIntent.getIntExtra("JieshouSHuju", 0);
                String abbb = "" + Userid;
                Log.d("AAA UserID是", abbb);


                canShu.setUserId(Userid);

                Intent sendTo3intent = new Intent();
                sendTo3intent.setClass(Search.this, Success.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", canShu);
                sendTo3intent.putExtras(bundle);

                sendTo3intent.putExtra("xxoo", Userid);
                sendTo3intent.putExtra("StrNongHuMingEditText", StrNongHuMingEditText);
                sendTo3intent.putExtra("StrZhongLeiEditText", StrZhongLeiEditText);
                sendTo3intent.putExtra("StrstartDateiEditText", StrstartDateiEditText);
                sendTo3intent.putExtra("StrendDateEditText", StrendDateEditText);


                startActivity(sendTo3intent);


//                Search_Tas search_tas = new Search_Tas(Search.this, canShu);
//
//                search_tas.execute();
            }

        });

    }


}
