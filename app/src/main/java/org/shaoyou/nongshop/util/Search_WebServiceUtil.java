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

public class Search_WebServiceUtil {

    // 定义webservice的命名空间
    public static final String SERVICE_NAMESPACE = "MobileAppWebService/";

    // 定义webservice提供服务的url
    public static final String SERVICE_URL = "http://172.19.3.60/ProductTrace/AppWebService.asmx";

    private MyGson gsonResult;
    public static int UserIdString;

    // 调用远程webservice获取用户名密码
    public static String getSearch(String NongHuMing, String ZhongLei, String startDate, String endDate) {

        Log.d("AAA", "执行到最顶层");
        // 调用 的方法
        String methodName = "QueryReceiveGoods";

        // 创建HttpTransportSE传输对象
        HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

        ht.debug = true;
        // 使用SOAP1.1协议创建Envelop对象
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER10);
        // 实例化SoapObject对象
        SoapObject soapObject = new SoapObject(SERVICE_NAMESPACE,
                methodName);

        soapObject.addProperty("farmerName", NongHuMing);//农户名
        soapObject.addProperty("crops", ZhongLei);//农产品种类.
        soapObject.addProperty("startDate", startDate);//农产品种类.
        soapObject.addProperty("endDate", endDate);//农产品种类.

        envelope.bodyOut = soapObject;
        // 设置与.NET提供的webservice保持较好的兼容性
        envelope.dotNet = true;


        // 调用webservice
        try {
            ht.call(SERVICE_NAMESPACE + methodName, envelope);

            if (envelope.getResponse() != null) {

                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject) envelope.bodyIn;
                String detail = (String) result.getProperty("ValidateUserLoginResult").toString();
                // 解析服务器响应的SOAP消息


                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<MyGson>() {
                }.getType();
                MyGson jsonBean = gson.fromJson(detail, type);

                jsonBean.getResult();


                return null;


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
