package process;

public class RestaProxy implements process.Resta {
  private String _endpoint = null;
  private process.Resta resta = null;
  
  public RestaProxy() {
    _initRestaProxy();
  }
  
  public RestaProxy(String endpoint) {
    _endpoint = endpoint;
    _initRestaProxy();
  }
  
  private void _initRestaProxy() {
    try {
      resta = (new process.RestaServiceLocator()).getResta();
      if (resta != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)resta)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)resta)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (resta != null)
      ((javax.xml.rpc.Stub)resta)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public process.Resta getResta() {
    if (resta == null)
      _initRestaProxy();
    return resta;
  }
  
  public int opeResta(int x, int y) throws java.rmi.RemoteException{
    if (resta == null)
      _initRestaProxy();
    return resta.opeResta(x, y);
  }
  
  
}