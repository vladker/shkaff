package okhttp3;

import A3.AbstractC0157z;
import A4.C0169l;
import A4.C0173p;
import A4.InterfaceC0171n;
import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractC1125a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class W implements Closeable {
    private Reader reader;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(Throwable th, InterfaceC0171n interfaceC0171n) throws Exception {
        boolean zIsTerminated;
        if (th != null) {
            try {
                AbstractC1125a.l(interfaceC0171n);
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                return;
            }
        }
        if (interfaceC0171n instanceof AutoCloseable) {
            interfaceC0171n.close();
            return;
        }
        if (!(interfaceC0171n instanceof ExecutorService)) {
            if (interfaceC0171n instanceof TypedArray) {
                ((TypedArray) interfaceC0171n).recycle();
                return;
            } else if (interfaceC0171n instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) interfaceC0171n).release();
                return;
            } else {
                if (!(interfaceC0171n instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) interfaceC0171n).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) interfaceC0171n;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z6 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z6) {
                    executorService.shutdownNow();
                    z6 = true;
                }
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
    }

    public static W create(B b, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (b != null) {
            Charset charset2 = b.charset();
            if (charset2 == null) {
                b = B.parse(b + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        C0169l c0169lWriteString = new C0169l().writeString(str, charset);
        return create(b, c0169lWriteString.size(), c0169lWriteString);
    }

    public final Reader b() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        InterfaceC0171n interfaceC0171nD = d();
        B bContentType = contentType();
        V v6 = new V(interfaceC0171nD, bContentType != null ? bContentType.charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8);
        this.reader = v6;
        return v6;
    }

    public final byte[] bytes() throws Exception {
        long jC = c();
        if (jC > 2147483647L) {
            throw new IOException(androidx.collection.a.j(jC, "Cannot buffer entire body for content length: "));
        }
        InterfaceC0171n interfaceC0171nD = d();
        try {
            byte[] byteArray = interfaceC0171nD.readByteArray();
            a(null, interfaceC0171nD);
            if (jC == -1 || jC == byteArray.length) {
                return byteArray;
            }
            throw new IOException(AbstractC0157z.l(") disagree", byteArray.length, androidx.collection.a.t("Content-Length (", jC, ") and stream length (")));
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (interfaceC0171nD != null) {
                    a(th, interfaceC0171nD);
                }
                throw th2;
            }
        }
    }

    public abstract long c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        p107s4.d.c(d());
    }

    public abstract B contentType();

    public abstract InterfaceC0171n d();

    public final String string() throws Exception {
        InterfaceC0171n interfaceC0171nD = d();
        try {
            B bContentType = contentType();
            String string = interfaceC0171nD.readString(p107s4.d.bomAwareCharset(interfaceC0171nD, bContentType != null ? bContentType.charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8));
            a(null, interfaceC0171nD);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (interfaceC0171nD != null) {
                    a(th, interfaceC0171nD);
                }
                throw th2;
            }
        }
    }

    public static W create(B b, byte[] bArr) {
        return create(b, bArr.length, new C0169l().write(bArr));
    }

    public static W create(B b, C0173p c0173p) {
        return create(b, c0173p.size(), new C0169l().write(c0173p));
    }

    public static W create(B b, long j6, InterfaceC0171n interfaceC0171n) {
        if (interfaceC0171n != null) {
            return new U(b, j6, interfaceC0171n);
        }
        throw new NullPointerException("source == null");
    }
}
