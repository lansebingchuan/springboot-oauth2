package com.kdeascloud;

import com.client.WSContext;

public class EASLoginProxyProxy implements EASLoginProxy {
  private String _endpoint = null;
  private EASLoginProxy eASLoginProxy = null;
  
  public EASLoginProxyProxy() {
    _initEASLoginProxyProxy();
  }
  
  public EASLoginProxyProxy(String endpoint) {
    _endpoint = endpoint;
    _initEASLoginProxyProxy();
  }
  
  private void _initEASLoginProxyProxy() {
    try {
      eASLoginProxy = (new com.kdeascloud.EASLoginProxyServiceLocator()).getEASLogin();
      if (eASLoginProxy != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)eASLoginProxy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)eASLoginProxy)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (eASLoginProxy != null)
      ((javax.xml.rpc.Stub)eASLoginProxy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public EASLoginProxy getEASLoginProxy() {
    if (eASLoginProxy == null)
      _initEASLoginProxyProxy();
    return eASLoginProxy;
  }
  
  public WSContext loginByLtpaToken(String userName, String ltpaToken, String slnName, String dcName, String language, int dbType) throws java.rmi.RemoteException{
    if (eASLoginProxy == null)
      _initEASLoginProxyProxy();
    return eASLoginProxy.loginByLtpaToken(userName, ltpaToken, slnName, dcName, language, dbType);
  }
  
  public WSContext login(String userName, String password, String slnName, String dcName, String language, int dbType, String authPattern, int isEncodePwd) throws java.rmi.RemoteException{
    if (eASLoginProxy == null)
      _initEASLoginProxyProxy();
    return eASLoginProxy.login(userName, password, slnName, dcName, language, dbType, authPattern, isEncodePwd);
  }
  
  public WSContext login(String userName, String password, String slnName, String dcName, String language, int dbType) throws java.rmi.RemoteException{
    if (eASLoginProxy == null)
      _initEASLoginProxyProxy();
    return eASLoginProxy.login(userName, password, slnName, dcName, language, dbType);
  }
  
  public WSContext login(String userName, String password, String slnName, String dcName, String language, int dbType, String authPattern) throws java.rmi.RemoteException{
    if (eASLoginProxy == null)
      _initEASLoginProxyProxy();
    return eASLoginProxy.login(userName, password, slnName, dcName, language, dbType, authPattern);
  }
  
  public boolean logout(String userName, String slnName, String dcName, String language) throws java.rmi.RemoteException{
    if (eASLoginProxy == null)
      _initEASLoginProxyProxy();
    return eASLoginProxy.logout(userName, slnName, dcName, language);
  }
  
  
}