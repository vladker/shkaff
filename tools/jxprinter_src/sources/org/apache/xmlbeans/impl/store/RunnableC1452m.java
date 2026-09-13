package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC1452m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7433a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ QName c;

    public /* synthetic */ RunnableC1452m(Cursor cursor, QName qName, int i5) {
        this.f7433a = i5;
        this.b = cursor;
        this.c = qName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7433a) {
            case 0:
                this.b.lambda$insertAttribute$65(this.c);
                break;
            case 1:
                this.b.lambda$setName$25(this.c);
                break;
            case 2:
                this.b.lambda$insertElement$54(this.c);
                break;
            default:
                this.b.lambda$beginElement$57(this.c);
                break;
        }
    }
}
