package p028e4;

import O3.l;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: e4.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0661o extends C0663q {
    @Override // p028e4.C0663q
    public final boolean c() {
        return false;
    }

    public final void forEach(l lVar) {
        Object next = getNext();
        E.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        for (C0663q nextNode = (C0663q) next; !E.a(nextNode, this); nextNode = nextNode.getNextNode()) {
            lVar.invoke(nextNode);
        }
    }

    public final Void remove() {
        throw new IllegalStateException("head cannot be removed");
    }
}
