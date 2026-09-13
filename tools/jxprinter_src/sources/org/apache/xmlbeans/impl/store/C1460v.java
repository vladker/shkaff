package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;
import javax.xml.namespace.QName;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1460v implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7443a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ QName c;

    public /* synthetic */ C1460v(Cursor cursor, QName qName, int i5) {
        this.f7443a = i5;
        this.b = cursor;
        this.c = qName;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7443a) {
            case 0:
                return this.b.lambda$toNextSibling$38(this.c);
            case 1:
                return this.b.lambda$toChild$33(this.c);
            case 2:
                return this.b.lambda$getAttributeText$39(this.c);
            default:
                return this.b.lambda$removeAttribute$41(this.c);
        }
    }
}
