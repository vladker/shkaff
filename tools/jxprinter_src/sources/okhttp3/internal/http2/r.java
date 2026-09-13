package okhttp3.internal.http2;

import A4.InterfaceC0171n;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends p107s4.b implements v {
    public final w b;
    public final /* synthetic */ s c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, w wVar) {
        super("OkHttp %s", sVar.d);
        this.c = sVar;
        this.b = wVar;
    }

    @Override // p107s4.b
    public final void a() throws Throwable {
        EnumC1358b enumC1358b;
        s sVar = this.c;
        w wVar = this.b;
        EnumC1358b enumC1358b2 = EnumC1358b.INTERNAL_ERROR;
        IOException e = null;
        try {
            wVar.readConnectionPreface(this);
            while (wVar.nextFrame(false, this)) {
            }
            enumC1358b = EnumC1358b.NO_ERROR;
            try {
                try {
                    sVar.close(enumC1358b, EnumC1358b.CANCEL, null);
                } catch (IOException e6) {
                    e = e6;
                    EnumC1358b enumC1358b3 = EnumC1358b.PROTOCOL_ERROR;
                    sVar.close(enumC1358b3, enumC1358b3, e);
                }
            } catch (Throwable th) {
                th = th;
                sVar.close(enumC1358b, enumC1358b2, e);
                p107s4.d.c(wVar);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            enumC1358b = enumC1358b2;
        } catch (Throwable th2) {
            th = th2;
            enumC1358b = enumC1358b2;
            sVar.close(enumC1358b, enumC1358b2, e);
            p107s4.d.c(wVar);
            throw th;
        }
        p107s4.d.c(wVar);
    }

    @Override // okhttp3.internal.http2.v
    public void data(boolean z6, int i5, InterfaceC0171n interfaceC0171n, int i6) throws IOException {
        s sVar = this.c;
        if (i5 != 0 && (i5 & 1) == 0) {
            sVar.pushDataLater(i5, interfaceC0171n, i6, z6);
            return;
        }
        A aB = sVar.b(i5);
        if (aB == null) {
            sVar.h(i5, EnumC1358b.PROTOCOL_ERROR);
            long j6 = i6;
            sVar.f(j6);
            interfaceC0171n.skip(j6);
            return;
        }
        aB.receiveData(interfaceC0171n, i6);
        if (z6) {
            aB.e(p107s4.d.c, true);
        }
    }

    @Override // okhttp3.internal.http2.v
    public final void pushPromise(int i5, int i6, List list) {
        s sVar = this.c;
        synchronized (sVar) {
            try {
                if (sVar.f6641y.contains(Integer.valueOf(i6))) {
                    sVar.h(i6, EnumC1358b.PROTOCOL_ERROR);
                    return;
                }
                sVar.f6641y.add(Integer.valueOf(i6));
                try {
                    sVar.d(new j(sVar, new Object[]{sVar.d, Integer.valueOf(i6)}, i6, list));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
