package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.SOAPElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class P implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7398a;
    public final /* synthetic */ SOAPElement b;
    public final /* synthetic */ Name c;

    public /* synthetic */ P(SOAPElement sOAPElement, Name name, int i5) {
        this.f7398a = i5;
        this.b = sOAPElement;
        this.c = name;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7398a) {
            case 0:
                return DomImpl.lambda$_soapElement_getChildElements$51(this.b, this.c, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$_soapElement_getAttributeValue$50(this.b, this.c, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_soapElement_removeAttribute$55(this.b, this.c, (DomImpl.Dom) obj);
        }
    }
}
