package task;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.shaoyou.nongshop.activity.Login;
import org.shaoyou.nongshop.util.WebServiceUtil;

import java.util.List;

/**
 * Created by Administrator on 15-9-8.
 */
public class NongTask extends AsyncTask<Void, Integer, String> {

    private Button loginBtn;

    private Login login_activity;
    private List<String> cities;
    private String result,Username,Password;
    private Context context;

    public NongTask(Context context,String username,String password) {
        this.context = context;
        this.Username=username;
        this.Password=password;
    }

    //执行么么哒
    @Override
    protected String doInBackground(Void... voids) {
        result = WebServiceUtil.getPassUser(Username,Password);
        return null;
    }

    //用来刷新UI
    @Override
    protected void onPostExecute(String result) {

        Toast.makeText(context,result, 0).show();

    }


    /**
     @Override protected List<String> doInBackground(String... params) {

     Username =
     cities = WebServiceUtil.getCityListsByProvince(sp_province
     .getSelectedItem().toString());
     return null;
     }


     **/
}
