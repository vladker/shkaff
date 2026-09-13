package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1442c implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7413a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C1442c(Cursor cursor, Object obj, int i5) {
        this.f7413a = i5;
        this.b = cursor;
        this.c = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7413a) {
            case 0:
                return this.b.lambda$getBookmark$49(this.c);
            case 1:
                return this.b.lambda$toNextBookmark$23(this.c);
            default:
                return this.b.lambda$toPrevBookmark$24(this.c);
        }
    }
}
