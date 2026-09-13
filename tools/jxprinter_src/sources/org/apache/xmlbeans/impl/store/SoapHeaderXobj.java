package org.apache.xmlbeans.impl.store;

import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SoapHeaderXobj extends SoapElementXobj implements SOAPHeader {
    public SoapHeaderXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public SOAPHeaderElement addHeaderElement(Name name) {
        return DomImpl.soapHeader_addHeaderElement(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> examineAllHeaderElements() {
        return DomImpl.soapHeader_examineAllHeaderElements(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> examineHeaderElements(String str) {
        return DomImpl.soapHeader_examineHeaderElements(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> examineMustUnderstandHeaderElements(String str) {
        return DomImpl.soapHeader_examineMustUnderstandHeaderElements(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> extractAllHeaderElements() {
        return DomImpl.soapHeader_extractAllHeaderElements(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeader
    public Iterator<SOAPHeaderElement> extractHeaderElements(String str) {
        return DomImpl.soapHeader_extractHeaderElements(this, str);
    }

    @Override // org.apache.xmlbeans.impl.store.SoapElementXobj, org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new SoapHeaderXobj(locale, this._name);
    }
}
