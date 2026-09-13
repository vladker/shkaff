package org.apache.xmlbeans.impl.store;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC1448i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7425a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ RunnableC1448i(Cursor cursor, String str, String str2, String str3, int i5) {
        this.f7425a = i5;
        this.b = cursor;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7425a) {
            case 0:
                this.b.lambda$insertElementWithText$62(this.c, this.d, this.e);
                break;
            default:
                this.b.lambda$insertAttributeWithValue$67(this.c, this.d, this.e);
                break;
        }
    }
}
