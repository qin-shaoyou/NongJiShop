package org.shaoyou.nongshop.task;

import android.os.AsyncTask;

import org.shaoyou.nongshop.activity.Success;

/**
 * Created by Administrator on 15-9-10.
 */
public class MyTask extends AsyncTask<String, String, String> {

    public Success activity;

    public MyTask(Success activity2) {
        this.activity = activity2;
    }


    @Override
    protected String doInBackground(String... strings) {


        return null;
    }
}
