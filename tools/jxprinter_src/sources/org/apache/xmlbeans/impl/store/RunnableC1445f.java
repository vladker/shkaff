package org.apache.xmlbeans.impl.store;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC1445f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7419a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ RunnableC1445f(Cursor cursor, String str, String str2, int i5) {
        this.f7419a = i5;
        this.b = cursor;
        this.c = str;
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7419a) {
            case 0:
                this.b.lambda$insertAttributeWithValue$66(this.c, this.d);
                break;
            case 1:
                this.b.lambda$insertNamespace$69(this.c, this.d);
                break;
            case 2:
                this.b.lambda$beginElement$59(this.c, this.d);
                break;
            case 3:
                this.b.lambda$insertElementWithText$61(this.c, this.d);
                break;
            case 4:
                this.b.lambda$insertElement$56(this.c, this.d);
                break;
            case 5:
                this.b.lambda$insertProcInst$71(this.c, this.d);
                break;
            default:
                this.b.lambda$insertAttribute$64(this.c, this.d);
                break;
        }
    }
}
