package org.apache.xmlbeans.impl.store;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SoapPartDocXobj extends DocumentXobj {
    SoapPartDom _soapPartDom;

    public SoapPartDocXobj(Locale locale) {
        super(locale);
        this._soapPartDom = new SoapPartDom(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.apache.xmlbeans.impl.store.Xobj
    public DomImpl.Dom getDom() {
        return this._soapPartDom;
    }

    @Override // org.apache.xmlbeans.impl.store.DocumentXobj, org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new SoapPartDocXobj(locale);
    }
}
