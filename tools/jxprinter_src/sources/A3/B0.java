package A3;

import W3.InterfaceC0233q;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class B0 {
    public static final void a(int i5, int i6) {
        if (i5 <= 0 || i6 <= 0) {
            throw new IllegalArgumentException((i5 != i6 ? androidx.collection.a.m("Both size ", i5, i6, " and step ", " must be greater than zero.") : androidx.collection.a.i(i5, "size ", " must be greater than zero.")).toString());
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int i5, int i6, boolean z6, boolean z7) {
        kotlin.jvm.internal.E.f(iterator, "iterator");
        return !iterator.hasNext() ? V.INSTANCE : W3.t.iterator(new z0(i5, i6, iterator, z7, z6, null));
    }

    public static final <T> InterfaceC0233q windowedSequence(InterfaceC0233q interfaceC0233q, int i5, int i6, boolean z6, boolean z7) {
        kotlin.jvm.internal.E.f(interfaceC0233q, "<this>");
        a(i5, i6);
        return new A0(interfaceC0233q, i5, i6, z6, z7);
    }
}
