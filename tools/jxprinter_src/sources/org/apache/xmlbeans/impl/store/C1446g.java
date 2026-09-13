package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1446g implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7421a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ String c;

    public /* synthetic */ C1446g(Cursor cursor, String str, int i5) {
        this.f7421a = i5;
        this.b = cursor;
        this.c = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7421a) {
            case 0:
                return this.b.lambda$execQuery$46(this.c);
            case 1:
                return this.b.lambda$namespaceForPrefix$26(this.c);
            case 2:
                return this.b.lambda$toChild$31(this.c);
            case 3:
                return this.b.lambda$toNextSibling$36(this.c);
            default:
                return this.b.lambda$prefixForNamespace$27(this.c);
        }
    }
}
