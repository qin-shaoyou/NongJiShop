package org.shaoyou.nongshop;

/**
 * Created by Administrator on 15-9-8.
 */
public class ReadMe {

/**

    1.创建HttpTransportSE传输对象：HttpTransportSE ht = new HttpTransportSE(SERVICE_URL); SERVICE_URL是webservice提供服务的url
    2.使用SOAP1.1协议创建Envelop对象：SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
 设置SOAP协议的版本号，根据服务端WebService的版本号设置。
  3.实例化SoapObject对象：SoapObject soapObject = new SoapObject(SERVICE_NAMESPACE, methodName);
 第一个参数表示WebService的命名空间，可以从WSDL文档中找到WebService的命名空间。第二个参数表示要调用的WebService方法名。
    4.设置调用方法的参数值，如果没有参数，可以省略：例如soapObject.addProperty("theCityCode", cityName);
    5.记得设置bodyout属性 envelope.bodyOut = soapObject;
    6.调用webservice：ht.call(SERVICE_NAMESPACE+methodName, envelope);
    7.获取服务器响应返回的SOAP消息：
    SoapObject result = (SoapObject) envelope.bodyIn;
    SoapObject detail = (SoapObject) result.getProperty(methodName+"Result");








    **/


}
