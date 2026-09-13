package org.apache.xmlbeans.impl.store;

import org.apache.xmlbeans.impl.soap.SOAPEnvelope;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class H implements DomImpl.WrapSoapEx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7391a;
    public final /* synthetic */ DomImpl.Dom b;
    public final /* synthetic */ SOAPEnvelope c;

    public /* synthetic */ H(DomImpl.Dom dom, SOAPEnvelope sOAPEnvelope, int i5) {
        this.f7391a = i5;
        this.b = dom;
        this.c = sOAPEnvelope;
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
    public final Object get() {
        switch (this.f7391a) {
            case 0:
                return DomImpl.lambda$_soapEnvelope_getBody$57(this.b, this.c);
            case 1:
                return DomImpl.lambda$_soapEnvelope_getHeader$58(this.b, this.c);
            case 2:
                return DomImpl.lambda$_soapEnvelope_addHeader$59(this.b, this.c);
            default:
                return DomImpl.lambda$_soapEnvelope_addBody$56(this.b, this.c);
        }
    }
}
