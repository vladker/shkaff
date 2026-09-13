package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SoapBodyXobj extends SoapElementXobj implements SOAPBody {
    public SoapBodyXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPBody
    public SOAPBodyElement addBodyElement(Name name) {
        return DomImpl.soapBody_addBodyElement(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPBody
    public SOAPBodyElement addDocument(Document document) {
        return DomImpl.soapBody_addDocument(this, document);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPBody
    public SOAPFault addFault() {
        return DomImpl.soapBody_addFault(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPBody
    public SOAPFault getFault() {
        return DomImpl.soapBody_getFault(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPBody
    public boolean hasFault() {
        return DomImpl.soapBody_hasFault(this);
    }

    @Override // org.apache.xmlbeans.impl.store.SoapElementXobj, org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new SoapBodyXobj(locale, this._name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPBody
    public SOAPFault addFault(Name name, String str) {
        return DomImpl.soapBody_addFault(this, name, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPBody
    public SOAPFault addFault(Name name, String str, java.util.Locale locale) {
        return DomImpl.soapBody_addFault(this, name, str, locale);
    }
}
