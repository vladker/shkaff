package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1458t implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7441a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ XmlOptions c;

    public /* synthetic */ C1458t(Cursor cursor, XmlOptions xmlOptions, int i5) {
        this.f7441a = i5;
        this.b = cursor;
        this.c = xmlOptions;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7441a) {
            case 0:
                return this.b.lambda$newReader$13(this.c);
            case 1:
                return this.b.lambda$newDomNode$14(this.c);
            case 2:
                return this.b.lambda$newInputStream$12(this.c);
            case 3:
                return this.b.lambda$xmlText$11(this.c);
            default:
                return this.b.lambda$newXMLStreamReader$6(this.c);
        }
    }
}
