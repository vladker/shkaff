package okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends p107s4.b {
    public final /* synthetic */ int b = 2;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(s sVar) {
        super("OkHttp %s ping", sVar.d);
        this.c = sVar;
    }

    @Override // p107s4.b
    public final void a() {
        s sVar;
        boolean z6;
        switch (this.b) {
            case 0:
                ((s) this.c).g(false, 2, 0);
                return;
            case 1:
                synchronized (((s) this.c)) {
                    sVar = (s) this.c;
                    long j6 = sVar.f6628l;
                    long j7 = sVar.f6627k;
                    if (j6 < j7) {
                        z6 = true;
                    } else {
                        sVar.f6627k = j7 + 1;
                        z6 = false;
                    }
                    break;
                }
                if (z6) {
                    sVar.failConnection(null);
                    return;
                } else {
                    sVar.g(false, 1, 0);
                    return;
                }
            default:
                s sVar2 = ((r) this.c).c;
                sVar2.b.a(sVar2);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(s sVar, Object[] objArr) {
        super("OkHttp %s ping", objArr);
        this.c = sVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(r rVar, Object[] objArr) {
        super("OkHttp %s settings", objArr);
        this.c = rVar;
    }
}
