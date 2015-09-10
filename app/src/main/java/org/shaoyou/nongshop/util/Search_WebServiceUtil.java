package org.shaoyou.nongshop.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.shaoyou.nongshop.model.Gson2.SearchGson;
import org.shaoyou.nongshop.tool.CanShu;
import org.xmlpull.v1.XmlPullParserException;

public class Search_WebServiceUtil {

    // 定义webservice的命名空间
    public static final String SERVICE_NAMESPACE = "MobileAppWebService/";

    // 定义webservice提供服务的url
    public static final String SERVICE_URL = "http://172.19.3.60/ProductTrace/AppWebService.asmx";


    // 调用远程webservice获取用户名密码
    public static List<SearchGson.ResultEntity> getSearch(CanShu canShu) {

        List<SearchGson.ResultEntity> listaaa;
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
        if (canShu != null) {
            soapObject.addProperty("farmerName", canShu.getNongHuMing());//农户名
            soapObject.addProperty("crops", canShu.getZhongLei());//农产品种类.
            soapObject.addProperty("startDate", canShu.getStartDate());//农产品种类.
            soapObject.addProperty("endDate", canShu.getEndDate());//农产品种类.
        }
        soapObject.addProperty("userID", canShu.getUserId());//获取UserID
        soapObject.addProperty("pageSize", canShu.getPageSize());//
        soapObject.addProperty("pageIndex", canShu.getPageIndex());//


        envelope.bodyOut = soapObject;
        // 设置与.NET提供的webservice保持较好的兼容性
        envelope.dotNet = true;


        // 调用webservice
        try {
            ht.call(SERVICE_NAMESPACE + methodName, envelope);

            if (envelope.getResponse() != null) {

                // 获取服务器响应返回的SOAP消息
                SoapObject result = (SoapObject) envelope.bodyIn;
                String detail = (String) result.getProperty("QueryReceiveGoodsResult").toString();
                // 解析服务器响应的SOAP消息
                Log.d("AAA", "执行到Gson解析上面");

                Gson gson = new Gson();
                java.lang.reflect.Type type = new TypeToken<SearchGson>() {
                }.getType();

                SearchGson jsonBean01 = gson.fromJson(detail, type);
                listaaa = jsonBean01.getResult();
//                int aaa = Log.d("AAA", jsonBean01.toString());
//                Log.d("AAA", "这个hi才加的" + jsonBean01.getResult().get(1).getFARMERNAME());

                return listaaa;


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
