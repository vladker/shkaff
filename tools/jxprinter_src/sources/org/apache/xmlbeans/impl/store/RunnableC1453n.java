package org.apache.xmlbeans.impl.store;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC1453n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7435a;
    public final /* synthetic */ Cursor b;

    public /* synthetic */ RunnableC1453n(int i5, Cursor cursor) {
        this.f7435a = i5;
        this.b = cursor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7435a) {
            case 0:
                this.b._clearSelections();
                break;
            case 1:
                this.b._toStartDoc();
                break;
            case 2:
                this.b._toEndDoc();
                break;
            case 3:
                this.b._push();
                break;
            case 4:
                this.b._addToSelection();
                break;
            case 5:
                this.b._dump();
                break;
            default:
                this.b._dispose();
                break;
        }
    }
}
