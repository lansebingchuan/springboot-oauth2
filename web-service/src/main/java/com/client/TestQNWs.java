package com.client;


import com.kdeascloud.EASLoginProxy;
import com.kdeascloud.EASLoginProxyProxy;

import java.rmi.RemoteException;

public class TestQNWs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EASLoginProxy login=new EASLoginProxyProxy();
		try {
			WSContext context=login.login("", "", "", "", "", 0);
			System.out.println("session-id: " + context.getSessionId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
