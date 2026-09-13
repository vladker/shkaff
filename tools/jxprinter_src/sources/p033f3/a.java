package p033f3;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AtomicReferenceArray implements c {
    private static final long serialVersionUID = 2746389416410565408L;

    public final boolean a(int i5, c cVar) {
        c cVar2;
        do {
            cVar2 = (c) get(i5);
            if (cVar2 == d.f3969a) {
                cVar.dispose();
                return false;
            }
        } while (!compareAndSet(i5, cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.dispose();
        return true;
    }

    @Override // p011b3.c
    public final void dispose() {
        c cVar;
        Object obj = get(0);
        d dVar = d.f3969a;
        if (obj != dVar) {
            int length = length();
            for (int i5 = 0; i5 < length; i5++) {
                if (((c) get(i5)) != dVar && (cVar = (c) getAndSet(i5, dVar)) != dVar && cVar != null) {
                    cVar.dispose();
                }
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get(0) == d.f3969a;
    }
}
