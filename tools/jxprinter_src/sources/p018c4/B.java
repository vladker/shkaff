package p018c4;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B {
    public static final C Companion = new C();
    private static final D failed = new D();
    private final Object holder;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a extends D {
        public final Throwable cause;

        public a(Throwable th) {
            this.cause = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && E.a(this.cause, ((a) obj).cause);
        }

        public final int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // p018c4.D
        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    private /* synthetic */ B(Object obj) {
        this.holder = obj;
    }

    public static final /* synthetic */ B b(Object obj) {
        return new B(obj);
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m1003exceptionOrNullimpl(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.cause;
        }
        return null;
    }

    /* JADX INFO: renamed from: getOrNull-impl, reason: not valid java name */
    public static final Object m1004getOrNullimpl(Object obj) {
        if (obj instanceof D) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1005toStringimpl(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public final /* synthetic */ Object c() {
        return this.holder;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof B) && E.a(this.holder, ((B) obj).holder);
    }

    public final int hashCode() {
        Object obj = this.holder;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return m1005toStringimpl(this.holder);
    }

    public static /* synthetic */ void getHolder$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m1002constructorimpl(Object obj) {
        return obj;
    }
}
