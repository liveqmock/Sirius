/**
 * ListViewSvcLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sirius.server.win32lib.controls.listview;

public class ListViewSvcLocator extends org.apache.axis.client.Service implements org.sirius.server.win32lib.controls.listview.ListViewSvc {

    public ListViewSvcLocator() {
    }


    public ListViewSvcLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ListViewSvcLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ListViewSvcPort
    private java.lang.String ListViewSvcPort_address = "http://localhost:8990/win32lib/listviewsvc";

    public java.lang.String getListViewSvcPortAddress() {
        return ListViewSvcPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ListViewSvcPortWSDDServiceName = "ListViewSvcPort";

    public java.lang.String getListViewSvcPortWSDDServiceName() {
        return ListViewSvcPortWSDDServiceName;
    }

    public void setListViewSvcPortWSDDServiceName(java.lang.String name) {
        ListViewSvcPortWSDDServiceName = name;
    }

    public org.sirius.server.win32lib.controls.listview.IListViewContract getListViewSvcPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ListViewSvcPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getListViewSvcPort(endpoint);
    }

    public org.sirius.server.win32lib.controls.listview.IListViewContract getListViewSvcPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sirius.server.win32lib.controls.listview.ListViewSvcPortStub _stub = new org.sirius.server.win32lib.controls.listview.ListViewSvcPortStub(portAddress, this);
            _stub.setPortName(getListViewSvcPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setListViewSvcPortEndpointAddress(java.lang.String address) {
        ListViewSvcPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sirius.server.win32lib.controls.listview.IListViewContract.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sirius.server.win32lib.controls.listview.ListViewSvcPortStub _stub = new org.sirius.server.win32lib.controls.listview.ListViewSvcPortStub(new java.net.URL(ListViewSvcPort_address), this);
                _stub.setPortName(getListViewSvcPortWSDDServiceName());
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
        if ("ListViewSvcPort".equals(inputPortName)) {
            return getListViewSvcPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://listview.controls.win32lib.server.sirius.org/", "ListViewSvc");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://listview.controls.win32lib.server.sirius.org/", "ListViewSvcPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ListViewSvcPort".equals(portName)) {
            setListViewSvcPortEndpointAddress(address);
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