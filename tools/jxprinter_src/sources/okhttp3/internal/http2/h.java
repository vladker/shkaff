package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends p107s4.b {
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ s d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(s sVar, Object[] objArr, int i5, long j6) {
        super("OkHttp Window Update %s stream %d", objArr);
        this.d = sVar;
        this.b = i5;
        this.c = j6;
    }

    @Override // p107s4.b
    public final void a() {
        s sVar = this.d;
        try {
            sVar.f6639w.windowUpdate(this.b, this.c);
        } catch (IOException e) {
            sVar.failConnection(e);
        }
    }
}
