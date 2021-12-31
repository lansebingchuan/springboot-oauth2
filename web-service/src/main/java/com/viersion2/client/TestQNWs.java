package com.viersion2.client;


import com.client.WSContext;
import com.kdeascloud.EASLoginProxy;
import com.kdeascloud.EASLoginProxyProxy;
import com.viersion2.WSOSFWebserviceFacade.WSOSFWebserviceFacadeSrvProxy;
import com.viersion2.WSOSFWebserviceFacade.WSOSFWebserviceFacadeSrvProxyServiceLocator;

public class TestQNWs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EASLoginProxy login=new EASLoginProxyProxy();
		
		try {
			WSOSFWebserviceFacadeSrvProxy osfservice=new WSOSFWebserviceFacadeSrvProxyServiceLocator().getWSOSFWebserviceFacade();
			WSContext context=login.login("user", "cqqn", "eas", "cqqn_prod", "l2", 0);
			String param="{'records':[{'EquNo':'CJDE211060489','CardId':'500238199208083511','RecDate':'2021-12-24','RecTime':'14:10:18'}]}";
			System.out.println(context.getSessionId());
			((org.apache.axis.client.Stub)osfservice).setHeader("http://login.webservice.bos.kingdee.com","SessionId",context.getSessionId());
			String result=osfservice.proceedOSF("transmitPunchCardRecord", param);
			System.out.println("resulit:"+result);
//			
///			HttpClient hc = new HttpClient();
//			String url="https://cqqn.kdeascloud.com/shr/shrosf.jsp?serviceName=transmitPunchCardRecord&param={'records':[{'EquNo':'CJDE211060489','CardId':'500238199208083511','RecDate':'2021-12-24','RecTime':'14:10:18'}]}";
//	        Integer res = hc.doGet(url);
//	        if (res == 200) {
//	        	
//	        }else {
//	        }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
