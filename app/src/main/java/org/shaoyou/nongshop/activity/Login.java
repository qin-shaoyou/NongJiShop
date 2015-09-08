package org.shaoyou.nongshop.activity;

import org.ksoap2.serialization.SoapObject;
import org.shaoyou.nongshop.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;

import task.NongTask;

public class Login extends Activity {

    private Button loginBtn;
    private EditText userEditTeXT;
    private EditText passworTexzt;
    private String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginBtn = (Button) findViewById(R.id.login);
        userEditTeXT = (EditText) findViewById(R.id.account);
        passworTexzt = (EditText) findViewById(R.id.password);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("AAA",  "sdsfsdfsdf");
                user = userEditTeXT.getText().toString().trim();
                pass = passworTexzt.getText().toString().trim();
                new NongTask(Login.this,user,pass ).execute();
            }
        });
    }
}