package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1457s implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7440a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ int c;

    public /* synthetic */ C1457s(Cursor cursor, int i5, int i6) {
        this.f7440a = i6;
        this.b = cursor;
        this.c = i5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7440a) {
            case 0:
                return this.b.lambda$toSelection$21(this.c);
            case 1:
                return this.b.lambda$toChild$34(this.c);
            case 2:
                return this.b.lambda$toNextChar$29(this.c);
            case 3:
                return this.b.lambda$removeChars$52(this.c);
            default:
                return this.b.lambda$toPrevChar$30(this.c);
        }
    }
}
