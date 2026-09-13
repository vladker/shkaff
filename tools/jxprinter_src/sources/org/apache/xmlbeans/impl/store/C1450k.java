package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1450k implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7429a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ C1450k(Cursor cursor, String str, String str2, int i5) {
        this.f7429a = i5;
        this.b = cursor;
        this.c = str;
        this.d = str2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7429a) {
            case 0:
                return this.b.lambda$toChild$32(this.c, this.d);
            default:
                return this.b.lambda$toNextSibling$37(this.c, this.d);
        }
    }
}
