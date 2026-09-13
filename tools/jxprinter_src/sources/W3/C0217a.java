package W3;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: W3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0217a implements InterfaceC0233q {
    private final AtomicReference<InterfaceC0233q> sequenceRef;

    public C0217a(InterfaceC0233q sequence) {
        kotlin.jvm.internal.E.f(sequence, "sequence");
        this.sequenceRef = new AtomicReference<>(sequence);
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        InterfaceC0233q andSet = this.sequenceRef.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
