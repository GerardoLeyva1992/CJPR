/**
 * RestaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package process;

public interface RestaService extends javax.xml.rpc.Service {
    public java.lang.String getRestaAddress();

    public process.Resta getResta() throws javax.xml.rpc.ServiceException;

    public process.Resta getResta(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
