package A3;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class s0 extends AbstractC0139g {
    private final List<Object> delegate;

    public s0(List<Object> delegate) {
        kotlin.jvm.internal.E.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        return this.delegate.size();
    }

    @Override // java.util.List
    public final Object get(int i5) {
        return this.delegate.get(P.d(i5, this));
    }

    @Override // A3.AbstractC0139g, A3.AbstractC0132b, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return listIterator(0);
    }

    @Override // A3.AbstractC0139g, java.util.List
    public ListIterator<Object> listIterator() {
        return listIterator(0);
    }

    @Override // A3.AbstractC0139g, java.util.List
    public ListIterator<Object> listIterator(int i5) {
        return new q0(this, i5);
    }
}
