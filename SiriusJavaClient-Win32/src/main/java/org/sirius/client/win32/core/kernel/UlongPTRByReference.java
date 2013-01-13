/**
 * UlongPTRByReference.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sirius.client.win32.core.kernel;

public class UlongPTRByReference extends
		org.sirius.client.win32.core.kernel.ByReference implements
		java.io.Serializable {
	private org.sirius.client.win32.core.kernel.UlongPTR value;

	public UlongPTRByReference() {
	}

	public UlongPTRByReference(
			org.sirius.client.win32.core.kernel.Pointer pointer,
			org.sirius.client.win32.core.kernel.UlongPTR value) {
		super(pointer);
		this.value = value;
	}

	/**
	 * Gets the value value for this UlongPTRByReference.
	 * 
	 * @return value
	 */
	public org.sirius.client.win32.core.kernel.UlongPTR getValue() {
		return value;
	}

	/**
	 * Sets the value value for this UlongPTRByReference.
	 * 
	 * @param value
	 */
	public void setValue(org.sirius.client.win32.core.kernel.UlongPTR value) {
		this.value = value;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof UlongPTRByReference))
			return false;
		UlongPTRByReference other = (UlongPTRByReference) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = super.equals(obj)
				&& ((this.value == null && other.getValue() == null) || (this.value != null && this.value
						.equals(other.getValue())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = super.hashCode();
		if (getValue() != null) {
			_hashCode += getValue().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			UlongPTRByReference.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"http://core.win32.server.sirius.org/", "ulongPTRByReference"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("value");
		elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://core.win32.server.sirius.org/", "ulongPTR"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType,
				_xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType,
				_xmlType, typeDesc);
	}

}
