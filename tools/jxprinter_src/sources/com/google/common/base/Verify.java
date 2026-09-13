package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Verify {
    private Verify() {
    }

    public static void verify(boolean z6) {
        if (!z6) {
            throw new VerifyException();
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(T t6) {
        return (T) verifyNotNull(t6, "expected a non-null reference", new Object[0]);
    }

    public static void verify(boolean z6, String str, Object... objArr) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(T t6, String str, Object... objArr) {
        if (t6 != null) {
            return t6;
        }
        throw new VerifyException(Strings.lenientFormat(str, objArr));
    }

    public static void verify(boolean z6, String str, char c) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    public static void verify(boolean z6, String str, int i5) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i5)));
        }
    }

    public static void verify(boolean z6, String str, long j6) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z6, String str, Object obj) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z6, String str, char c, char c6) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c6)));
        }
    }

    public static void verify(boolean z6, String str, int i5, char c) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i5), Character.valueOf(c)));
        }
    }

    public static void verify(boolean z6, String str, long j6, char c) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), Character.valueOf(c)));
        }
    }

    public static void verify(boolean z6, String str, Object obj, char c) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    public static void verify(boolean z6, String str, char c, int i5) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i5)));
        }
    }

    public static void verify(boolean z6, String str, int i5, int i6) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i5), Integer.valueOf(i6)));
        }
    }

    public static void verify(boolean z6, String str, long j6, int i5) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), Integer.valueOf(i5)));
        }
    }

    public static void verify(boolean z6, String str, Object obj, int i5) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Integer.valueOf(i5)));
        }
    }

    public static void verify(boolean z6, String str, char c, long j6) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z6, String str, int i5, long j6) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i5), Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z6, String str, long j6, long j7) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), Long.valueOf(j7)));
        }
    }

    public static void verify(boolean z6, String str, Object obj, long j6) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Long.valueOf(j6)));
        }
    }

    public static void verify(boolean z6, String str, char c, Object obj) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    public static void verify(boolean z6, String str, int i5, Object obj) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i5), obj));
        }
    }

    public static void verify(boolean z6, String str, long j6, Object obj) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j6), obj));
        }
    }

    public static void verify(boolean z6, String str, Object obj, Object obj2) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z6, String str, Object obj, Object obj2, Object obj3) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z6, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z6) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
