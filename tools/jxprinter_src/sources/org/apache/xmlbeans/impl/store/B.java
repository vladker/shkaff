package org.apache.xmlbeans.impl.store;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class B implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7385a;
    public final /* synthetic */ String b;

    public /* synthetic */ B(String str, int i5) {
        this.f7385a = i5;
        this.b = str;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7385a) {
            case 0:
                return DomImpl.lambda$_attributes_removeNamedItem$24(this.b, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$_element_getElementsByTagName$19(this.b, (DomImpl.Dom) obj);
            case 2:
                return DomImpl.lambda$_document_createComment$5(this.b, (DomImpl.Dom) obj);
            case 3:
                return DomImpl.lambda$_document_getElementsByTagName$7(this.b, (DomImpl.Dom) obj);
            case 4:
                return DomImpl.lambda$_document_createElement$1(this.b, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_document_createAttribute$3(this.b, (DomImpl.Dom) obj);
        }
    }
}
