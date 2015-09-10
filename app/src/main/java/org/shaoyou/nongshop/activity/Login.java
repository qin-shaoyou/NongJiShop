package org.shaoyou.nongshop.activity;

import org.shaoyou.nongshop.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.widget.Toast;

import org.shaoyou.nongshop.task.Login_NongTask;
import org.shaoyou.nongshop.util.Login_WebServiceUtil;

public class Login extends Activity {

    private Button loginBtn;
    private EditText userEditTeXT;
    private EditText passworTexzt;
    private String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        loginBtn = (Button) findViewById(R.id.login);
        userEditTeXT = (EditText) findViewById(R.id.account);
        passworTexzt = (EditText) findViewById(R.id.password);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user = userEditTeXT.getText().toString().trim();
                pass = passworTexzt.getText().toString().trim();



                Login_NongTask nongTask = new Login_NongTask(Login.this, user, pass);
                nongTask.execute();




            }
        });
    }
}