package org.shaoyou.nongshop.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;

import org.shaoyou.nongshop.activity.Login;
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
    private String Result;
    private Context context;

    public static int Puanduan = 1;

    public Login_NongTask(Context context, String username, String password) {
        this.context = context;
        this.Username = username;
        this.Password = password;
    }

    //执行么么哒
    @Override
    protected String doInBackground(Void... voids) {
        Result = Login_WebServiceUtil.getPassUser(Username, Password);

        return Result;
    }

    //用来返回值处理 么
    @Override
    protected void onPostExecute(String result) {


        if (Result.equals("1")) {

            Toast.makeText(context, "IsSuccess:true 登录成功", 1).show();


        } else {
            Toast.makeText(context, "0.0失败了", 1).show();
            Puanduan = 2;
        }
    }


}
