package org.apache.xmlbeans.impl.store;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC1443d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7415a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ String c;

    public /* synthetic */ RunnableC1443d(Cursor cursor, String str, int i5) {
        this.f7415a = i5;
        this.b = cursor;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7415a) {
            case 0:
                this.b.lambda$beginElement$58(this.c);
                break;
            case 1:
                this.b.lambda$insertChars$53(this.c);
                break;
            case 2:
                this.b.lambda$insertComment$70(this.c);
                break;
            case 3:
                this.b.lambda$selectPath$19(this.c);
                break;
            case 4:
                this.b.lambda$setTextValue$43(this.c);
                break;
            case 5:
                this.b.lambda$insertElement$55(this.c);
                break;
            default:
                this.b.lambda$insertAttribute$63(this.c);
                break;
        }
    }
}
