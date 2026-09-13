package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPPart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class D implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7387a;
    public final /* synthetic */ SOAPPart b;

    public /* synthetic */ D(SOAPPart sOAPPart, int i5) {
        this.f7387a = i5;
        this.b = sOAPPart;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7387a) {
            case 0:
                return DomImpl.lambda$_soapPart_getContent$97(this.b, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$_soapPart_getEnvelope$96(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_soapPart_getAllMimeHeaders$95(this.b, (DomImpl.Dom) obj);
        }
    }
}
