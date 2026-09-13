package B3;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f95a;
    public int b;
    public int c;
    private final m map;

    public j(m map) {
        E.f(map, "map");
        this.map = map;
        this.b = -1;
        this.c = map.d;
        c();
    }

    public final void b() {
        if (this.map.d != this.c) {
            throw new ConcurrentModificationException();
        }
    }

    public final void c() {
        while (true) {
            int i5 = this.f95a;
            m mVar = this.map;
            if (i5 >= mVar.b) {
                return;
            }
            int[] iArr = mVar.presenceArray;
            int i6 = this.f95a;
            if (iArr[i6] >= 0) {
                return;
            } else {
                this.f95a = i6 + 1;
            }
        }
    }

    public final m getMap$kotlin_stdlib() {
        return this.map;
    }

    public final boolean hasNext() {
        return this.f95a < this.map.b;
    }

    public final void remove() {
        b();
        if (this.b == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        this.map.h();
        this.map.o(this.b);
        this.b = -1;
        this.c = this.map.d;
    }
}
