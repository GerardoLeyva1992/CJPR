/**
 * RestaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package process;

public class RestaServiceLocator extends org.apache.axis.client.Service implements process.RestaService {

    public RestaServiceLocator() {
    }


    public RestaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RestaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Resta
    private java.lang.String Resta_address = "http://localhost:8080/servico/services/Resta";

    public java.lang.String getRestaAddress() {
        return Resta_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RestaWSDDServiceName = "Resta";

    public java.lang.String getRestaWSDDServiceName() {
        return RestaWSDDServiceName;
    }

    public void setRestaWSDDServiceName(java.lang.String name) {
        RestaWSDDServiceName = name;
    }

    public process.Resta getResta() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Resta_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getResta(endpoint);
    }

    public process.Resta getResta(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            process.RestaSoapBindingStub _stub = new process.RestaSoapBindingStub(portAddress, this);
            _stub.setPortName(getRestaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRestaEndpointAddress(java.lang.String address) {
        Resta_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (process.Resta.class.isAssignableFrom(serviceEndpointInterface)) {
                process.RestaSoapBindingStub _stub = new process.RestaSoapBindingStub(new java.net.URL(Resta_address), this);
                _stub.setPortName(getRestaWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Resta".equals(inputPortName)) {
            return getResta();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://process", "RestaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://process", "Resta"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Resta".equals(portName)) {
            setRestaEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
