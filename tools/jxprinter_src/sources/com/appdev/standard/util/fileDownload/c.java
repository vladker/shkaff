package com.appdev.standard.util.fileDownload;

import io.reactivex.I;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f2842a;
    public final /* synthetic */ String b;
    public final /* synthetic */ g c;

    public c(g gVar, a aVar, String str) {
        this.c = gVar;
        this.f2842a = aVar;
        this.b = str;
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f2842a.d = 6;
        Iterator it = this.c.b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onError(this.b, th);
        }
    }

    @Override // io.reactivex.I
    public final /* bridge */ /* synthetic */ void onNext(Object obj) {
    }

    @Override // io.reactivex.I
    public final void onComplete() {
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
    }
}
