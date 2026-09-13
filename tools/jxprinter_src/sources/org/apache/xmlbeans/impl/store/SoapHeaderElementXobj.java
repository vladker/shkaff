package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SoapHeaderElementXobj extends SoapElementXobj implements SOAPHeaderElement {
    public SoapHeaderElementXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
    public String getActor() {
        return DomImpl.soapHeaderElement_getActor(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
    public boolean getMustUnderstand() {
        return DomImpl.soapHeaderElement_getMustUnderstand(this);
    }

    @Override // org.apache.xmlbeans.impl.store.SoapElementXobj, org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new SoapHeaderElementXobj(locale, this._name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
    public void setActor(String str) {
        DomImpl.soapHeaderElement_setActor(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPHeaderElement
    public void setMustUnderstand(boolean z6) {
        DomImpl.soapHeaderElement_setMustUnderstand(this, z6);
    }
}
