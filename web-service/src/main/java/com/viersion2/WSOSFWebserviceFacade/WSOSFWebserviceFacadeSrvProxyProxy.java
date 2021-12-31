package com.viersion2.WSOSFWebserviceFacade;

public class WSOSFWebserviceFacadeSrvProxyProxy implements WSOSFWebserviceFacadeSrvProxy {
  private String _endpoint = null;
  private WSOSFWebserviceFacadeSrvProxy wSOSFWebserviceFacadeSrvProxy = null;
  
  public WSOSFWebserviceFacadeSrvProxyProxy() {
    _initWSOSFWebserviceFacadeSrvProxyProxy();
  }
  
  public WSOSFWebserviceFacadeSrvProxyProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSOSFWebserviceFacadeSrvProxyProxy();
  }
  
  private void _initWSOSFWebserviceFacadeSrvProxyProxy() {
    try {
      wSOSFWebserviceFacadeSrvProxy = (new WSOSFWebserviceFacadeSrvProxyServiceLocator()).getWSOSFWebserviceFacade();
      if (wSOSFWebserviceFacadeSrvProxy != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSOSFWebserviceFacadeSrvProxy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSOSFWebserviceFacadeSrvProxy)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSOSFWebserviceFacadeSrvProxy != null)
      ((javax.xml.rpc.Stub)wSOSFWebserviceFacadeSrvProxy)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WSOSFWebserviceFacadeSrvProxy getWSOSFWebserviceFacadeSrvProxy() {
    if (wSOSFWebserviceFacadeSrvProxy == null)
      _initWSOSFWebserviceFacadeSrvProxyProxy();
    return wSOSFWebserviceFacadeSrvProxy;
  }
  
  public String proceedOSF(String serviceName, String param) throws java.rmi.RemoteException{
    if (wSOSFWebserviceFacadeSrvProxy == null)
      _initWSOSFWebserviceFacadeSrvProxyProxy();
    return wSOSFWebserviceFacadeSrvProxy.proceedOSF(serviceName, param);
  }
  
  
}