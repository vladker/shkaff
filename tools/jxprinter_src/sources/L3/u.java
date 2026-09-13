package L3;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements Iterator, P3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f454a;
    public boolean b;
    public final /* synthetic */ v c;

    public u(v vVar) {
        this.c = vVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        if (this.f454a == null && !this.b) {
            String line = this.c.reader.readLine();
            this.f454a = line;
            if (line == null) {
                this.b = true;
            }
        }
        return this.f454a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f454a;
        this.f454a = null;
        E.c(str);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
