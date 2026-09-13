package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPHeader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class X implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7405a;
    public final /* synthetic */ SOAPHeader b;

    public /* synthetic */ X(SOAPHeader sOAPHeader, int i5) {
        this.f7405a = i5;
        this.b = sOAPHeader;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7405a) {
            case 0:
                return DomImpl.lambda$soapHeader_extractAllHeaderElements$63(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$soapHeader_examineAllHeaderElements$62(this.b, (DomImpl.Dom) obj);
        }
    }
}
