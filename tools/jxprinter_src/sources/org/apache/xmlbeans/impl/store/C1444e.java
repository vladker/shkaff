package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1444e implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7417a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public /* synthetic */ C1444e(Cursor cursor, Object obj, int i5, int i6, int i7) {
        this.f7417a = i7;
        this.b = cursor;
        this.c = obj;
        this.d = i5;
        this.e = i6;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7417a) {
            case 0:
                return this.b.lambda$getTextValue$42((char[]) this.c, this.d, this.e);
            case 1:
                return this.b.lambda$getChars$45((char[]) this.c, this.d, this.e);
            default:
                return this.b.lambda$twoLocaleOp$0((Cursor) this.c, this.d, this.e);
        }
    }
}
