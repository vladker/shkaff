package com.appdev.standard.util.fileDownload;

import A4.AbstractC0182z;
import A4.C0169l;
import A4.InterfaceC0171n;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends AbstractC0182z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2847a;
    public final /* synthetic */ k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, InterfaceC0171n interfaceC0171n) {
        super(interfaceC0171n);
        this.b = kVar;
        this.f2847a = 0L;
    }

    @Override // A4.AbstractC0182z, A4.h0
    public long read(C0169l c0169l, long j6) {
        long j7 = super.read(c0169l, j6);
        long j8 = this.f2847a + (j7 != -1 ? j7 : 0L);
        this.f2847a = j8;
        k kVar = this.b;
        S4.h hVar = kVar.b;
        String str = kVar.d;
        long jC = kVar.f2848a.c();
        boolean z6 = j7 == -1;
        Iterator it = ((g) hVar.b).b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onProgress(str, j8, jC, z6);
        }
        return j7;
    }
}
