package okhttp3;

import A4.InterfaceC0171n;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class V extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0171n f6548a;
    public final Charset b;
    public boolean c;
    private Reader delegate;

    public V(InterfaceC0171n interfaceC0171n, Charset charset) {
        this.f6548a = interfaceC0171n;
        this.b = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c = true;
        Reader reader = this.delegate;
        if (reader != null) {
            reader.close();
        } else {
            this.f6548a.close();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i5, int i6) throws IOException {
        if (this.c) {
            throw new IOException("Stream closed");
        }
        Reader reader = this.delegate;
        if (reader == null) {
            Charset charset = this.b;
            InterfaceC0171n interfaceC0171n = this.f6548a;
            InputStreamReader inputStreamReader = new InputStreamReader(interfaceC0171n.inputStream(), p107s4.d.bomAwareCharset(interfaceC0171n, charset));
            this.delegate = inputStreamReader;
            reader = inputStreamReader;
        }
        return reader.read(cArr, i5, i6);
    }
}
