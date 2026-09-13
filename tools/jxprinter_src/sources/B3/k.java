package B3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends j implements Iterator, P3.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(m map) {
        super(map);
        E.f(map, "map");
    }

    @Override // java.util.Iterator
    public final Object next() {
        b();
        if (this.f95a >= getMap$kotlin_stdlib().b) {
            throw new NoSuchElementException();
        }
        int i5 = this.f95a;
        this.f95a = i5 + 1;
        this.b = i5;
        Object obj = getMap$kotlin_stdlib().keysArray[this.b];
        c();
        return obj;
    }
}
