package p028e4;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class F {
    public static final boolean a(Object obj) {
        return obj == AbstractC0647a.CLOSED;
    }

    /* JADX INFO: renamed from: getSegment-impl, reason: not valid java name */
    public static final E m1031getSegmentimpl(Object obj) {
        if (obj == AbstractC0647a.CLOSED) {
            throw new IllegalStateException("Does not contain segment");
        }
        E.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (E) obj;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <S extends E> Object m1030constructorimpl(Object obj) {
        return obj;
    }
}
