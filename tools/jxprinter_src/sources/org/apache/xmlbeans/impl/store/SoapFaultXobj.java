package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPFault;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SoapFaultXobj extends SoapBodyElementXobj implements SOAPFault {
    public SoapFaultXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public Detail addDetail() {
        return DomImpl.soapFault_addDetail(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public Detail getDetail() {
        return DomImpl.soapFault_getDetail(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public String getFaultActor() {
        return DomImpl.soapFault_getFaultActor(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public String getFaultCode() {
        return DomImpl.soapFault_getFaultCode(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public Name getFaultCodeAsName() {
        return DomImpl.soapFault_getFaultCodeAsName(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public String getFaultString() {
        return DomImpl.soapFault_getFaultString(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public java.util.Locale getFaultStringLocale() {
        return DomImpl.soapFault_getFaultStringLocale(this);
    }

    @Override // org.apache.xmlbeans.impl.store.SoapBodyElementXobj, org.apache.xmlbeans.impl.store.SoapElementXobj, org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new SoapFaultXobj(locale, this._name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public void setFaultActor(String str) {
        DomImpl.soapFault_setFaultActor(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public void setFaultCode(Name name) {
        DomImpl.soapFault_setFaultCode(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public void setFaultString(String str) {
        DomImpl.soapFault_setFaultString(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public void setFaultCode(String str) {
        DomImpl.soapFault_setFaultCode(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPFault
    public void setFaultString(String str, java.util.Locale locale) {
        DomImpl.soapFault_setFaultString(this, str, locale);
    }
}
