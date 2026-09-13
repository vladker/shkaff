package androidx.core.util;

import android.annotation.SuppressLint;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(C1938s c1938s) {
        return new android.util.Pair<>(c1938s.f9134a, c1938s.b);
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(C1938s c1938s) {
        return new Pair<>(c1938s.f9134a, c1938s.b);
    }

    public static final <F, S> C1938s toKotlinPair(Pair<F, S> pair) {
        return new C1938s(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        return (S) pair.second;
    }

    public static final <F, S> C1938s toKotlinPair(android.util.Pair<F, S> pair) {
        return new C1938s(pair.first, pair.second);
    }
}
