package W3;

import A3.AbstractC0134c;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: W3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0218b extends AbstractC0134c {
    private final O3.l keySelector;
    private final HashSet<Object> observed;
    private final Iterator<Object> source;

    public C0218b(Iterator<Object> source, O3.l keySelector) {
        kotlin.jvm.internal.E.f(source, "source");
        kotlin.jvm.internal.E.f(keySelector, "keySelector");
        this.source = source;
        this.keySelector = keySelector;
        this.observed = new HashSet<>();
    }

    @Override // A3.AbstractC0134c
    public final void b() {
        while (this.source.hasNext()) {
            Object next = this.source.next();
            if (this.observed.add(this.keySelector.invoke(next))) {
                c(next);
                return;
            }
        }
        this.f37a = 2;
    }
}
