package org.apache.xmlbeans.impl.store;

import java.io.Serializable;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b0 implements DomImpl.WrapSoapEx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7411a = 0;
    public final /* synthetic */ DomImpl.Dom b;
    public final /* synthetic */ String c;
    public final /* synthetic */ SOAPElement d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Serializable f7412f;

    public /* synthetic */ b0(DomImpl.Dom dom, SOAPBody sOAPBody, Name name, String str, java.util.Locale locale) {
        this.b = dom;
        this.d = sOAPBody;
        this.e = name;
        this.c = str;
        this.f7412f = locale;
    }

    @Override // org.apache.xmlbeans.impl.store.DomImpl.WrapSoapEx
    public final Object get() {
        switch (this.f7411a) {
            case 0:
                return DomImpl.lambda$soapBody_addFault$74(this.b, (SOAPBody) this.d, (Name) this.e, this.c, (java.util.Locale) this.f7412f);
            default:
                return DomImpl.lambda$_soapElement_addChildElement$47(this.b, this.d, this.c, (String) this.e, (String) this.f7412f);
        }
    }

    public /* synthetic */ b0(DomImpl.Dom dom, SOAPElement sOAPElement, String str, String str2, String str3) {
        this.b = dom;
        this.d = sOAPElement;
        this.c = str;
        this.e = str2;
        this.f7412f = str3;
    }
}
