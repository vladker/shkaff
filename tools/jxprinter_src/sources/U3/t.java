package U3;

import A3.f0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f735a;
    public final long b;
    public boolean c;
    public long d;

    public t(long j6, long j7, long j8) {
        this.f735a = j8;
        this.b = j7;
        boolean z6 = false;
        if (j8 <= 0 ? j6 >= j7 : j6 <= j7) {
            z6 = true;
        }
        this.c = z6;
        this.d = z6 ? j6 : j7;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // A3.f0
    public final long nextLong() {
        long j6 = this.d;
        if (j6 != this.b) {
            this.d = this.f735a + j6;
            return j6;
        }
        if (!this.c) {
            throw new NoSuchElementException();
        }
        this.c = false;
        return j6;
    }
}
