package p007a4;

import A3.AbstractC0157z;
import kotlin.jvm.internal.E;
import p028e4.AbstractC0661o;
import p028e4.C0663q;

/* JADX INFO: renamed from: a4.c1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0268c1 extends AbstractC0661o implements B0 {
    public final String getString(String str) {
        StringBuilder sbY = AbstractC0157z.y("List{", str, "}[");
        Object next = getNext();
        E.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        boolean z6 = true;
        for (C0663q nextNode = (C0663q) next; !E.a(nextNode, this); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof O0) {
                if (z6) {
                    z6 = false;
                } else {
                    sbY.append(", ");
                }
                sbY.append(nextNode);
            }
        }
        sbY.append("]");
        String string = sbY.toString();
        E.e(string, "toString(...)");
        return string;
    }

    @Override // p007a4.B0
    public final boolean isActive() {
        return true;
    }

    @Override // p028e4.C0663q
    public String toString() {
        return super.toString();
    }

    @Override // p007a4.B0
    public C0268c1 getList() {
        return this;
    }
}
