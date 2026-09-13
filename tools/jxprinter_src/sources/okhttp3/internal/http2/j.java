package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends p107s4.b {
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ s e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(s sVar, Object[] objArr, int i5, EnumC1358b enumC1358b) {
        super("OkHttp %s stream %d", objArr);
        this.e = sVar;
        this.c = i5;
        this.d = enumC1358b;
    }

    @Override // p107s4.b
    public final void a() {
        switch (this.b) {
            case 0:
                this.e.f6626j.getClass();
                try {
                    this.e.f6639w.rstStream(this.c, EnumC1358b.CANCEL);
                    synchronized (this.e) {
                        try {
                            this.e.f6641y.remove(Integer.valueOf(this.c));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                    return;
                }
                break;
            case 1:
                this.e.f6626j.getClass();
                try {
                    this.e.f6639w.rstStream(this.c, EnumC1358b.CANCEL);
                    synchronized (this.e) {
                        try {
                            this.e.f6641y.remove(Integer.valueOf(this.c));
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (IOException unused2) {
                    return;
                }
                break;
            default:
                s sVar = this.e;
                try {
                    sVar.writeSynReset(this.c, (EnumC1358b) this.d);
                } catch (IOException e) {
                    sVar.failConnection(e);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(s sVar, Object[] objArr, int i5, List list) {
        super("OkHttp %s Push Request[%s]", objArr);
        this.e = sVar;
        this.c = i5;
        this.d = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(s sVar, Object[] objArr, int i5, List list, boolean z6) {
        super("OkHttp %s Push Headers[%s]", objArr);
        this.e = sVar;
        this.c = i5;
        this.d = list;
    }
}
