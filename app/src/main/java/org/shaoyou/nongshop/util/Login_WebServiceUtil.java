package org.shaoyou.nongshop.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.shaoyou.nongshop.model.Gson2.MyGson;
import org.xmlpull.v1.XmlPullParserException;

public class Login_WebServiceUtil {

    // 定义webservice的命名空间
    public static final String SERVICE_NAMESPACE = "MobileAppWebService/";

    // 定义webservice提供服务的url
    public static final String SERVICE_URL = "http://172.19.3.60/ProductTrace/AppWebService.asmx";

    private MyGson gsonResult;
    public static int UserIdString;

    // 调用远程webservice获取用户名密码
    public static String getPassUser(String username, String password) {

        Log.d("AAA", "执行到最顶层");
        // 调用 的方法
        String methodName = "ValidateUserLogin";

        // 创建HttpTransportSE传输对象
        HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

        ht.debug = true;
        // 使用SOAP1.1协议创建Envelop对象
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER10);
        // 实例化SoapObject对象
        SoapObject soapObject = new SoapObject(SERVICE_NAMESPACE,
                methodName);

        soapObject.addProperty("userName", username);//第一个是
        soapObject.addProperty("userPwd", password);//第一个是


        envelope.bodyOut = soapObject;
        // 设置与.NET提供的webservice保持较好的兼容性
        envelope.dotNet = true;

        // 调用webservice
        Log.d("AAA", "ht.call前面");
        try {
            ht.call(SERVICE_NAMESPACE + methodName, envelope);
            Log.d("AAA", "ht.call下面 ");
            if (envelope.getResponse() != null) {
                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject) envelope.bodyIn;
                String detail = (String) result.getProperty("QueryReceiveGoodsResult").toString();
                // 解析服务器响应的SOAP消息
                Log.d("AAA", detail + " ");


                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<MyGson>() {
                }.getType();
                MyGson jsonBean = gson.fromJson(detail, type);

                UserIdString = jsonBean.getResult().getUserID();

                String panduan;
                String JieGuo;


                if (jsonBean.getIsSuccess()) {

                    JieGuo = "成功:getIsSuccess:true";
                    panduan
                            = "1";

                } else {
                    JieGuo = "失败:getIsSuccess:false";
                    panduan = "0";

                }

                return panduan;


            }
        } catch (SoapFault e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (XmlPullParserException e) {

            e.printStackTrace();
        }
        return null;
    }


}
