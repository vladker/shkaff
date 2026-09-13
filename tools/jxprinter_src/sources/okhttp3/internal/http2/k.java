package okhttp3.internal.http2;

import A4.C0169l;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends p107s4.b {
    public final /* synthetic */ int b;
    public final /* synthetic */ C0169l c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ s f6615f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(s sVar, Object[] objArr, int i5, C0169l c0169l, int i6, boolean z6) {
        super("OkHttp %s Push Data[%s]", objArr);
        this.f6615f = sVar;
        this.b = i5;
        this.c = c0169l;
        this.d = i6;
        this.e = z6;
    }

    @Override // p107s4.b
    public final void a() {
        try {
            boolean zOnData = this.f6615f.f6626j.onData(this.b, this.c, this.d, this.e);
            if (zOnData) {
                this.f6615f.f6639w.rstStream(this.b, EnumC1358b.CANCEL);
            }
            if (zOnData || this.e) {
                synchronized (this.f6615f) {
                    this.f6615f.f6641y.remove(Integer.valueOf(this.b));
                }
            }
        } catch (IOException unused) {
        }
    }
}
