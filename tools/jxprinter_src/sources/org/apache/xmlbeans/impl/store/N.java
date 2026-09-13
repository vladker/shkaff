package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.impl.soap.SOAPElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class N implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7397a;
    public final /* synthetic */ SOAPElement b;
    public final /* synthetic */ String c;

    public /* synthetic */ N(SOAPElement sOAPElement, String str, int i5) {
        this.f7397a = i5;
        this.b = sOAPElement;
        this.c = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7397a) {
            case 0:
                return DomImpl.lambda$_soapElement_removeNamespaceDeclaration$38(this.b, this.c, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$_soapElement_getNamespaceURI$53(this.b, this.c, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_soapElement_addTextNode$49(this.b, this.c, (DomImpl.Dom) obj);
        }
    }
}
