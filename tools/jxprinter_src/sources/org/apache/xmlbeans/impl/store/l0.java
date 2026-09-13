package org.apache.xmlbeans.impl.store;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class l0 implements Saver.SyncWrapFun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7432a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Closeable d;
    public final /* synthetic */ Object e;

    public /* synthetic */ l0(Closeable closeable, Object obj, int i5, int i6, int i7) {
        this.f7432a = i7;
        this.d = closeable;
        this.e = obj;
        this.b = i5;
        this.c = i6;
    }

    @Override // org.apache.xmlbeans.impl.store.Saver.SyncWrapFun
    public final int process() {
        switch (this.f7432a) {
            case 0:
                return ((Saver.InputStreamSaver) this.d).lambda$read$0((byte[]) this.e, this.b, this.c);
            default:
                return ((Saver.TextReader) this.d).lambda$read$1((char[]) this.e, this.b, this.c);
        }
    }
}
