package p147z3;

import java.io.Serializable;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements Serializable {
    public static final C1939t Companion = new C1939t();
    private final Object value;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements Serializable {
        public final Throwable exception;

        public a(Throwable exception) {
            E.f(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && E.a(this.exception, ((a) obj).exception);
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    private /* synthetic */ u(Object obj) {
        this.value = obj;
    }

    public static final /* synthetic */ u a(Object obj) {
        return new u(obj);
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m1362exceptionOrNullimpl(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).exception;
        }
        return null;
    }

    /* JADX INFO: renamed from: getOrNull-impl, reason: not valid java name */
    private static final Object m1363getOrNullimpl(Object obj) {
        if (obj instanceof a) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1364toStringimpl(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public final /* synthetic */ Object b() {
        return this.value;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u) && E.a(this.value, ((u) obj).value);
    }

    public final int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return m1364toStringimpl(this.value);
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m1361constructorimpl(Object obj) {
        return obj;
    }
}
