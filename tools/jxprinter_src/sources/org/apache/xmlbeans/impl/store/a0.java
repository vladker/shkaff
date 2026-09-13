package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPBody;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7409a;
    public final /* synthetic */ SOAPBody b;

    public /* synthetic */ a0(SOAPBody sOAPBody, int i5) {
        this.f7409a = i5;
        this.b = sOAPBody;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7409a) {
            case 0:
                return DomImpl.lambda$soapBody_hasFault$68(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$soapBody_getFault$70(this.b, (DomImpl.Dom) obj);
        }
    }
}
