package kotlin.jvm.internal;

import java.util.Iterator;

/* JADX INFO: renamed from: kotlin.jvm.internal.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1095i {
    public static final <T> Iterator<T> iterator(T[] array) {
        E.f(array, "array");
        return new C1094h(array);
    }
}
