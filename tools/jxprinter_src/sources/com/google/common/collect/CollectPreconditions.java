package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
final class CollectPreconditions {
    public static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            String strValueOf = String.valueOf(obj2);
            throw new NullPointerException(com.google.android.gms.auth.api.accounttransfer.a.i(strValueOf.length() + 24, "null key in entry: null=", strValueOf));
        }
        if (obj2 != null) {
            return;
        }
        String strValueOf2 = String.valueOf(obj);
        throw new NullPointerException(androidx.exifinterface.media.a.e(strValueOf2.length() + 26, "null value in entry: ", strValueOf2, "=null"));
    }

    @CanIgnoreReturnValue
    public static int checkNonnegative(int i5, String str) {
        if (i5 >= 0) {
            return i5;
        }
        StringBuilder sb = new StringBuilder(androidx.exifinterface.media.a.b(40, str));
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void checkPositive(int i5, String str) {
        if (i5 > 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(androidx.exifinterface.media.a.b(38, str));
        sb.append(str);
        sb.append(" must be positive but was: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void checkRemove(boolean z6) {
        Preconditions.checkState(z6, "no calls to next() since the last call to remove()");
    }

    @CanIgnoreReturnValue
    public static long checkNonnegative(long j6, String str) {
        if (j6 >= 0) {
            return j6;
        }
        StringBuilder sb = new StringBuilder(androidx.exifinterface.media.a.b(49, str));
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(j6);
        throw new IllegalArgumentException(sb.toString());
    }
}
