package org.apache.xmlbeans.impl.store;

import java.util.function.Function;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1464z implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7447a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ C1464z(String str, String str2, int i5) {
        this.f7447a = i5;
        this.b = str;
        this.c = str2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7447a) {
            case 0:
                return DomImpl.lambda$_element_getElementsByTagNameNS$20(this.b, this.c, (DomImpl.Dom) obj);
            case 1:
                return DomImpl.lambda$_document_getElementsByTagNameNS$8(this.b, this.c, (DomImpl.Dom) obj);
            case 2:
                return DomImpl.lambda$_document_createAttributeNS$4(this.b, this.c, (DomImpl.Dom) obj);
            case 3:
                return DomImpl.lambda$_attributes_removeNamedItemNS$25(this.b, this.c, (DomImpl.Dom) obj);
            case 4:
                return DomImpl.lambda$_document_createElementNS$2(this.b, this.c, (DomImpl.Dom) obj);
            case 5:
                return DomImpl.lambda$_attributes_getNamedItemNS$23(this.b, this.c, (DomImpl.Dom) obj);
            default:
                return DomImpl.lambda$_document_createProcessingInstruction$6(this.b, this.c, (DomImpl.Dom) obj);
        }
    }
}
