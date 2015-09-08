package org.shaoyou.nongshop.util;

import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.shaoyou.nongshop.activity.Login;
import org.xmlpull.v1.XmlPullParserException;

public class WebServiceUtil {

	// 定义webservice的命名空间
	public static final String SERVICE_NAMESPACE = "MobileAppWebService/";

	// 定义webservice提供服务的url
	public static final String SERVICE_URL = "http://172.19.3.60/ProductTrace/AppWebService.asmx";

	// 调用远程webservice获取用户名密码
	public static String getPassUser(String username,String password) {

		Log.d("AAA","最顶层");
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
			soapObject.addProperty("userName","admin");//第一个是
			soapObject.addProperty("userPwd","123456");//第一个是


			envelope.bodyOut = soapObject;
			// 设置与.NET提供的webservice保持较好的兼容性
			envelope.dotNet = true;

			// 调用webservice
			Log.d("AAA","ht.call前面");
		try {
			ht.call("MobileAppWebService/ValidateUserLogin", envelope);
			Log.d("AAA",  "ht.call下面 ");
			if (envelope.getResponse() != null) {
				// 获取服务器响应返回的SOAP消息
				SoapObject result = (SoapObject) envelope.bodyIn;
				String detail = (String) result.getProperty("ValidateUserLoginResult");
				// 解析服务器响应的SOAP消息
				Log.d("AAA",detail+" ");


				return detail;

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






	// 根据省份获取城市列表
	public static List<String> getCityListsByProvince(String province) {
		// 调用的方法
		String methodName = "getSupportCityString";
		// 创建httptransportSE传输对象
		HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);
		ht.debug = true;
		// 实例化SoapObject对象
		SoapObject soapObject = new SoapObject(SERVICE_NAMESPACE, methodName);
		// 添加一个请求参数
		soapObject.addProperty("theRegionCode", province);
		// 使用soap1.1协议创建envelop对象
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.bodyOut = soapObject;
		// 设置与.NET提供的webservice保持较好的兼容性
		envelope.dotNet = true;

		// 调用webservice
		try {
			ht.call(SERVICE_NAMESPACE + methodName, envelope);
			if (envelope.getResponse() != null) {
				// 获取服务器响应返回的SOAP消息
				SoapObject result = (SoapObject) envelope.bodyIn;
				SoapObject detail = (SoapObject) result.getProperty(methodName
						+ "Result");
				// 解析服务器响应的SOAP消息
				return null;
			}
		} catch (SoapFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}





	// 根据城市字符串获取相应天气情况
	public static SoapObject getWeatherByCity(String cityName) {
		String methodName = "getWeather";
		HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);
		ht.debug = true;
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		SoapObject soapObject = new SoapObject(SERVICE_NAMESPACE, methodName);
		soapObject.addProperty("theCityCode", cityName);
		envelope.bodyOut = soapObject;
		envelope.dotNet = true;

		try {
			ht.call(SERVICE_NAMESPACE + methodName, envelope);
			SoapObject result = (SoapObject) envelope.bodyIn;
			SoapObject detail = (SoapObject) result.getProperty(methodName
					+ "Result");
			return detail;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
