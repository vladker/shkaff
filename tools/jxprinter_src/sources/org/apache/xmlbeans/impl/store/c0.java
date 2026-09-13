package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPPart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7414a;
    public final /* synthetic */ SOAPPart b;
    public final /* synthetic */ String[] c;

    public /* synthetic */ c0(SOAPPart sOAPPart, String[] strArr, int i5) {
        this.f7414a = i5;
        this.b = sOAPPart;
        this.c = strArr;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7414a) {
            case 0:
                return DomImpl.lambda$_soapPart_getNonMatchingMimeHeaders$103(this.b, this.c, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_soapPart_getMatchingMimeHeaders$102(this.b, this.c, (DomImpl.Dom) obj);
        }
    }
}
