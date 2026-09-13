package L3;

import A3.E;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f446a = -1;
    public boolean b;
    public boolean c;
    public final /* synthetic */ BufferedInputStream d;

    public b(BufferedInputStream bufferedInputStream) {
        this.d = bufferedInputStream;
    }

    public final void b() throws IOException {
        if (this.b || this.c) {
            return;
        }
        int i5 = this.d.read();
        this.f446a = i5;
        this.b = true;
        this.c = i5 == -1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        b();
        return !this.c;
    }

    @Override // A3.E
    public final byte nextByte() throws IOException {
        b();
        if (this.c) {
            throw new NoSuchElementException("Input stream is over.");
        }
        byte b = (byte) this.f446a;
        this.b = false;
        return b;
    }
}
