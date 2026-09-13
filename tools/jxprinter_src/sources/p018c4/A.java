package p018c4;

import O3.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A {
    public static final <E> InterfaceC0391v Channel(int i5, EnumC0368b enumC0368b, l lVar) {
        if (i5 == -2) {
            if (enumC0368b != EnumC0368b.f1135a) {
                return new s0(1, enumC0368b, lVar);
            }
            InterfaceC0391v.Factory.getClass();
            return new C0376f(C0390u.b, lVar);
        }
        if (i5 == -1) {
            if (enumC0368b == EnumC0368b.f1135a) {
                return new s0(1, EnumC0368b.b, lVar);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i5 == 0) {
            return enumC0368b == EnumC0368b.f1135a ? new C0376f(0, lVar) : new s0(1, enumC0368b, lVar);
        }
        if (i5 != Integer.MAX_VALUE) {
            return enumC0368b == EnumC0368b.f1135a ? new C0376f(i5, lVar) : new s0(i5, enumC0368b, lVar);
        }
        return new C0376f(Integer.MAX_VALUE, lVar);
    }

    public static /* synthetic */ InterfaceC0391v a(int i5, int i6, EnumC0368b enumC0368b) {
        if ((i6 & 2) != 0) {
            enumC0368b = EnumC0368b.f1135a;
        }
        return Channel(i5, enumC0368b, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOrElse-WpGqRn0, reason: not valid java name */
    public static final <T> T m998getOrElseWpGqRn0(Object obj, l lVar) {
        return obj instanceof D ? (T) lVar.invoke(B.m1003exceptionOrNullimpl(obj)) : obj;
    }

    /* JADX INFO: renamed from: onClosed-WpGqRn0, reason: not valid java name */
    public static final <T> Object m999onClosedWpGqRn0(Object obj, l lVar) {
        if (obj instanceof B.a) {
            lVar.invoke(B.m1003exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* JADX INFO: renamed from: onFailure-WpGqRn0, reason: not valid java name */
    public static final <T> Object m1000onFailureWpGqRn0(Object obj, l lVar) {
        if (obj instanceof D) {
            lVar.invoke(B.m1003exceptionOrNullimpl(obj));
        }
        return obj;
    }

    /* JADX INFO: renamed from: onSuccess-WpGqRn0, reason: not valid java name */
    public static final <T> Object m1001onSuccessWpGqRn0(Object obj, l lVar) {
        if (!(obj instanceof D)) {
            lVar.invoke(obj);
        }
        return obj;
    }
}
