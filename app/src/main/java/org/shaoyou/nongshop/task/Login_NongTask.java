package org.shaoyou.nongshop.task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;

import org.shaoyou.nongshop.activity.Login;
import org.shaoyou.nongshop.activity.Search;
import org.shaoyou.nongshop.model.G.MyGson;
import org.shaoyou.nongshop.util.Login_WebServiceUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-9-8.
 */
public class Login_NongTask extends AsyncTask<Void, Integer, String> {

    private Button loginBtn;

    private Login login_activity;
    private List<String> cities;
    private Map<String, String> result;
    private String Username;
    private String Password;
    private MyGson Result;
    private Context context;

    public Login_NongTask(Context context, String username, String password) {
        this.context = context;
        this.Username = username;
        this.Password = password;
    }

    //执行么么哒
    @Override
    protected String doInBackground(Void... voids) {
        Result = Login_WebServiceUtil.getPassUser(Username, Password);

        return null;
    }

    //用来返回值处理 么
    @Override
    protected void onPostExecute(String result) {


        if (Result.getIsSuccess()) {

            Toast.makeText(context, "IsSuccess:true 登录成功", 0).show();
            Intent intent = new Intent(context, Search.class);
            intent.putExtra("JieshouSHuju", Result.getResult().getUserID());

            context.startActivity(intent);


        } else {
            Toast.makeText(context, "0.0失败了", 1).show();

        }


    }


}
