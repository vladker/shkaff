package org.apache.xmlbeans.impl.store;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class k0 implements Saver.SyncWrapFun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7430a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k0(Object obj, int i5) {
        this.f7430a = i5;
        this.b = obj;
    }

    @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
    public final int process() {
        switch (this.f7430a) {
            case 0:
                return ((Saver.InputStreamSaver) this.b).lambda$available$1();
            default:
                return ((Saver.TextSaver) this.b).read();
        }
    }
}
