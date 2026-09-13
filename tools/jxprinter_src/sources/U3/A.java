package U3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A {
    public static final void checkStepIsPositive(boolean z6, Number step) {
        kotlin.jvm.internal.E.f(step, "step");
        if (z6) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    private static final <T, R extends InterfaceC0213j & Iterable<? extends T>> boolean contains(R r6, T t6) {
        kotlin.jvm.internal.E.f(r6, "<this>");
        return t6 != null && r6.contains((Comparable) t6);
    }

    public static final <T extends Comparable<? super T>> InterfaceC0213j rangeTo(T t6, T that) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(that, "that");
        return new C0215l(t6, that);
    }

    public static final <T extends Comparable<? super T>> z rangeUntil(T t6, T that) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(that, "that");
        return new C0214k(t6, that);
    }

    private static final <T, R extends z & Iterable<? extends T>> boolean contains(R r6, T t6) {
        kotlin.jvm.internal.E.f(r6, "<this>");
        return t6 != null && r6.contains((Comparable) t6);
    }

    public static final InterfaceC0211h rangeTo(double d, double d6) {
        return new C0209f(d, d6);
    }

    public static final z rangeUntil(double d, double d6) {
        return new w(d, d6);
    }

    public static final InterfaceC0211h rangeTo(float f6, float f7) {
        return new C0210g(f6, f7);
    }

    public static final z rangeUntil(float f6, float f7) {
        return new x(f6, f7);
    }
}
