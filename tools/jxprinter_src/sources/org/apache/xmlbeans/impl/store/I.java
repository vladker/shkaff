package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPHeader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class I implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7392a;
    public final /* synthetic */ SOAPHeader b;
    public final /* synthetic */ String c;

    public /* synthetic */ I(SOAPHeader sOAPHeader, String str, int i5) {
        this.f7392a = i5;
        this.b = sOAPHeader;
        this.c = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7392a) {
            case 0:
                return DomImpl.lambda$soapHeader_extractHeaderElements$66(this.b, this.c, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$soapHeader_examineHeaderElements$64(this.b, this.c, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$soapHeader_examineMustUnderstandHeaderElements$65(this.b, this.c, (DomImpl.Dom) obj);
        }
    }
}
