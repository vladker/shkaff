package com.google.common.base;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int i5, int i6, String str) {
        if (i5 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(a.h(26, i6, "negative size: "));
    }

    private static String badPositionIndex(int i5, int i6, String str) {
        if (i5 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(a.h(26, i6, "negative size: "));
    }

    private static String badPositionIndexes(int i5, int i6, int i7) {
        if (i5 < 0 || i5 > i7) {
            return badPositionIndex(i5, i7, "start index");
        }
        return (i6 < 0 || i6 > i7) ? badPositionIndex(i6, i7, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5));
    }

    public static void checkArgument(boolean z6) {
        if (!z6) {
            throw new IllegalArgumentException();
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i5, int i6) {
        return checkElementIndex(i5, i6, FirebaseAnalytics.Param.INDEX);
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6) {
        t6.getClass();
        return t6;
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i5, int i6) {
        return checkPositionIndex(i5, i6, FirebaseAnalytics.Param.INDEX);
    }

    public static void checkPositionIndexes(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i5, i6, i7));
        }
    }

    public static void checkState(boolean z6) {
        if (!z6) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i5, int i6, String str) {
        if (i5 < 0 || i5 >= i6) {
            throw new IndexOutOfBoundsException(badElementIndex(i5, i6, str));
        }
        return i5;
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, Object obj) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i5, int i6, String str) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(badPositionIndex(i5, i6, str));
        }
        return i5;
    }

    public static void checkState(boolean z6, Object obj) {
        if (!z6) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z6, String str, Object... objArr) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object... objArr) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static void checkState(boolean z6, String str, Object... objArr) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z6, String str, char c) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, char c) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c)));
    }

    public static void checkState(boolean z6, String str, char c) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z6, String str, int i5) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i5)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, int i5) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i5)));
    }

    public static void checkState(boolean z6, String str, int i5) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i5)));
        }
    }

    public static void checkArgument(boolean z6, String str, long j6) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, long j6) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6)));
    }

    public static void checkState(boolean z6, String str, long j6) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z6, String str, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object obj) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static void checkState(boolean z6, String str, Object obj) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z6, String str, char c, char c6) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c6)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, char c, char c6) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c6)));
    }

    public static void checkState(boolean z6, String str, char c, char c6) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c6)));
        }
    }

    public static void checkArgument(boolean z6, String str, char c, int i5) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i5)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, char c, int i5) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i5)));
    }

    public static void checkState(boolean z6, String str, char c, int i5) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i5)));
        }
    }

    public static void checkArgument(boolean z6, String str, char c, long j6) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, char c, long j6) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j6)));
    }

    public static void checkState(boolean z6, String str, char c, long j6) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z6, String str, char c, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, char c, Object obj) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), obj));
    }

    public static void checkState(boolean z6, String str, char c, Object obj) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    public static void checkArgument(boolean z6, String str, int i5, char c) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i5), Character.valueOf(c)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, int i5, char c) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i5), Character.valueOf(c)));
    }

    public static void checkState(boolean z6, String str, int i5, char c) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i5), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z6, String str, int i5, int i6) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i5), Integer.valueOf(i6)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, int i5, int i6) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i5), Integer.valueOf(i6)));
    }

    public static void checkState(boolean z6, String str, int i5, int i6) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i5), Integer.valueOf(i6)));
        }
    }

    public static void checkArgument(boolean z6, String str, int i5, long j6) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i5), Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, int i5, long j6) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i5), Long.valueOf(j6)));
    }

    public static void checkState(boolean z6, String str, int i5, long j6) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i5), Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z6, String str, int i5, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i5), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, int i5, Object obj) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i5), obj));
    }

    public static void checkState(boolean z6, String str, int i5, Object obj) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i5), obj));
        }
    }

    public static void checkArgument(boolean z6, String str, long j6, char c) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, long j6, char c) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c)));
    }

    public static void checkState(boolean z6, String str, long j6, char c) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z6, String str, long j6, int i5) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i5)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, long j6, int i5) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i5)));
    }

    public static void checkState(boolean z6, String str, long j6, int i5) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i5)));
        }
    }

    public static void checkArgument(boolean z6, String str, long j6, long j7) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, long j6, long j7) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
    }

    public static void checkState(boolean z6, String str, long j6, long j7) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
        }
    }

    public static void checkArgument(boolean z6, String str, long j6, Object obj) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, long j6, Object obj) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
    }

    public static void checkState(boolean z6, String str, long j6, Object obj) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
        }
    }

    public static void checkArgument(boolean z6, String str, Object obj, char c) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object obj, char c) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
    }

    public static void checkState(boolean z6, String str, Object obj, char c) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z6, String str, Object obj, int i5) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i5)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object obj, int i5) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i5)));
    }

    public static void checkState(boolean z6, String str, Object obj, int i5) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i5)));
        }
    }

    public static void checkArgument(boolean z6, String str, Object obj, long j6) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object obj, long j6) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
    }

    public static void checkState(boolean z6, String str, Object obj, long j6) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
        }
    }

    public static void checkArgument(boolean z6, String str, Object obj, Object obj2) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object obj, Object obj2) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static void checkState(boolean z6, String str, Object obj, Object obj2) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z6, String str, Object obj, Object obj2, Object obj3) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object obj, Object obj2, Object obj3) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static void checkState(boolean z6, String str, Object obj, Object obj2, Object obj3) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z6, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z6) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t6, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (t6 != null) {
            return t6;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static void checkState(boolean z6, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z6) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
