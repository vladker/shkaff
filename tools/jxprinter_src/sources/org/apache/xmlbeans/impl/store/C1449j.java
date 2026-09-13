package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1449j implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7427a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ Cursor c;

    public /* synthetic */ C1449j(Cursor cursor, Cursor cursor2, int i5) {
        this.f7427a = i5;
        this.b = cursor;
        this.c = cursor2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7427a) {
            case 0:
                return this.b.lambda$toCursor$1(this.c);
            case 1:
                return this.b.lambda$isLeftOf$3(this.c);
            case 2:
                return this.b.lambda$isRightOf$5(this.c);
            case 3:
                return this.b.lambda$isAtSamePositionAs$4(this.c);
            default:
                return this.b.lambda$comparePosition$2(this.c);
        }
    }
}
