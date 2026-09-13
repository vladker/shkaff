package p028e4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.E;
import p007a4.S;

/* JADX INFO: renamed from: e4.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class C0663q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f3943a = AtomicReferenceFieldUpdater.newUpdater(C0663q.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(C0663q.class, Object.class, "_prev$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C0663q.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final C0663q a() {
        C0663q c0663q;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = b;
            C0663q c0663q2 = (C0663q) atomicReferenceFieldUpdater2.get(this);
            c0663q = c0663q2;
            while (true) {
                C0663q c0663q3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f3943a;
                    obj = atomicReferenceFieldUpdater.get(c0663q);
                    if (obj == this) {
                        if (c0663q2 != c0663q) {
                            while (!atomicReferenceFieldUpdater2.compareAndSet(this, c0663q2, c0663q)) {
                                if (atomicReferenceFieldUpdater2.get(this) != c0663q2) {
                                    break;
                                }
                            }
                            break loop0;
                        }
                        break;
                    }
                    if (c()) {
                        return null;
                    }
                    if (!(obj instanceof B)) {
                        E.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                        c0663q3 = c0663q;
                        c0663q = (C0663q) obj;
                    } else {
                        if (c0663q3 != null) {
                            break;
                        }
                        c0663q = (C0663q) atomicReferenceFieldUpdater2.get(c0663q);
                    }
                }
                C0663q c0663q4 = ((B) obj).ref;
                while (!atomicReferenceFieldUpdater.compareAndSet(c0663q3, c0663q, c0663q4)) {
                    if (atomicReferenceFieldUpdater.get(c0663q3) != c0663q) {
                        break;
                    }
                }
                c0663q = c0663q3;
            }
        }
        return c0663q;
    }

    public final boolean addLast(C0663q c0663q, int i5) {
        C0663q prevNode;
        do {
            prevNode = getPrevNode();
            if (prevNode instanceof C0660n) {
                return (((C0660n) prevNode).forbiddenElementsBitmask & i5) == 0 && prevNode.addLast(c0663q, i5);
            }
        } while (!prevNode.addNext(c0663q, this));
        return true;
    }

    public final boolean addNext(C0663q c0663q, C0663q c0663q2) {
        b.set(c0663q, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3943a;
        atomicReferenceFieldUpdater.set(c0663q, c0663q2);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, c0663q2, c0663q)) {
            if (atomicReferenceFieldUpdater.get(this) != c0663q2) {
                return false;
            }
        }
        c0663q.b(c0663q2);
        return true;
    }

    public final boolean addOneIfEmpty(C0663q c0663q) {
        b.set(c0663q, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3943a;
        atomicReferenceFieldUpdater.set(c0663q, this);
        while (getNext() == this) {
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, this, c0663q)) {
                    c0663q.b(this);
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(this) == this);
        }
        return false;
    }

    public final void b(C0663q c0663q) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            C0663q c0663q2 = (C0663q) atomicReferenceFieldUpdater.get(c0663q);
            if (getNext() != c0663q) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(c0663q, c0663q2, this)) {
                    if (c()) {
                        c0663q.a();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(c0663q) == c0663q2);
        }
    }

    public boolean c() {
        return getNext() instanceof B;
    }

    public final Object getNext() {
        return f3943a.get(this);
    }

    public final C0663q getNextNode() {
        C0663q c0663q;
        Object next = getNext();
        B b6 = next instanceof B ? (B) next : null;
        if (b6 != null && (c0663q = b6.ref) != null) {
            return c0663q;
        }
        E.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (C0663q) next;
    }

    public final C0663q getPrevNode() {
        C0663q c0663qA = a();
        if (c0663qA != null) {
            return c0663qA;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        Object obj = atomicReferenceFieldUpdater.get(this);
        while (true) {
            C0663q c0663q = (C0663q) obj;
            if (!c0663q.c()) {
                return c0663q;
            }
            obj = atomicReferenceFieldUpdater.get(c0663q);
        }
    }

    public final C0663q removeOrNext() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            Object next = getNext();
            if (next instanceof B) {
                return ((B) next).ref;
            }
            if (next == this) {
                return (C0663q) next;
            }
            E.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            C0663q c0663q = (C0663q) next;
            c0663q.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = c;
            B b6 = (B) atomicReferenceFieldUpdater2.get(c0663q);
            if (b6 == null) {
                b6 = new B(c0663q);
                atomicReferenceFieldUpdater2.set(c0663q, b6);
            }
            do {
                atomicReferenceFieldUpdater = f3943a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, next, b6)) {
                    c0663q.a();
                    return null;
                }
            } while (atomicReferenceFieldUpdater.get(this) == next);
        }
    }

    public String toString() {
        return new C0662p(this, S.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + S.getHexAddress(this);
    }

    public final void validateNode$kotlinx_coroutines_core(C0663q c0663q, C0663q c0663q2) {
    }
}
