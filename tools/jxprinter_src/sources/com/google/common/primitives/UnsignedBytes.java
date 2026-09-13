package com.google.common.primitives;

import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = -128;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @VisibleForTesting
    public static class LexicographicalComparatorHolder {
        static final String UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName().concat("$UnsafeComparator");
        static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                for (int i5 = 0; i5 < iMin; i5++) {
                    int iCompare = UnsignedBytes.compare(bArr[i5], bArr2[i5]);
                    if (iCompare != 0) {
                        return iCompare;
                    }
                }
                return bArr.length - bArr2.length;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        @VisibleForTesting
        public enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;

            static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final Unsafe theUnsafe;

            static {
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                int iArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = iArrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || iArrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            private static Unsafe getUnsafe() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (PrivilegedActionException e) {
                        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                    }
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1
                        @Override // java.security.PrivilegedExceptionAction
                        public Unsafe run() throws IllegalAccessException {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] bArr, byte[] bArr2) {
                int iMin = Math.min(bArr.length, bArr2.length);
                int i5 = iMin & (-8);
                int i6 = 0;
                while (i6 < i5) {
                    Unsafe unsafe = theUnsafe;
                    int i7 = BYTE_ARRAY_BASE_OFFSET;
                    long j6 = i6;
                    long j7 = unsafe.getLong(bArr, ((long) i7) + j6);
                    long j8 = unsafe.getLong(bArr2, ((long) i7) + j6);
                    if (j7 != j8) {
                        if (BIG_ENDIAN) {
                            return UnsignedLongs.compare(j7, j8);
                        }
                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j7 ^ j8) & (-8);
                        return ((int) ((j7 >>> iNumberOfTrailingZeros) & 255)) - ((int) ((j8 >>> iNumberOfTrailingZeros) & 255));
                    }
                    i6 += 8;
                }
                while (i6 < iMin) {
                    int iCompare = UnsignedBytes.compare(bArr[i6], bArr2[i6]);
                    if (iCompare != 0) {
                        return iCompare;
                    }
                    i6++;
                }
                return bArr.length - bArr2.length;
            }
        }

        public static Comparator<byte[]> getBestComparator() {
            try {
                Object[] enumConstants = Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
    }

    private UnsignedBytes() {
    }

    @CanIgnoreReturnValue
    public static byte checkedCast(long j6) {
        Preconditions.checkArgument((j6 >> 8) == 0, "out of range: %s", j6);
        return (byte) j6;
    }

    public static int compare(byte b, byte b6) {
        return toInt(b) - toInt(b6);
    }

    private static byte flip(byte b) {
        return (byte) (b ^ MAX_POWER_OF_TWO);
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() + 3) * bArr.length);
        sb.append(toInt(bArr[0]));
        for (int i5 = 1; i5 < bArr.length; i5++) {
            sb.append(str);
            sb.append(toString(bArr[i5]));
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    public static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i5 = toInt(bArr[0]);
        for (int i6 = 1; i6 < bArr.length; i6++) {
            int i7 = toInt(bArr[i6]);
            if (i7 > i5) {
                i5 = i7;
            }
        }
        return (byte) i5;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        int i5 = toInt(bArr[0]);
        for (int i6 = 1; i6 < bArr.length; i6++) {
            int i7 = toInt(bArr[i6]);
            if (i7 < i5) {
                i5 = i7;
            }
        }
        return (byte) i5;
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str) {
        return parseUnsignedByte(str, 10);
    }

    public static byte saturatedCast(long j6) {
        if (j6 > toInt((byte) -1)) {
            return (byte) -1;
        }
        if (j6 < 0) {
            return (byte) 0;
        }
        return (byte) j6;
    }

    public static void sort(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static int toInt(byte b) {
        return b & MAX_VALUE;
    }

    @Beta
    public static String toString(byte b) {
        return toString(b, 10);
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str, int i5) {
        int i6 = Integer.parseInt((String) Preconditions.checkNotNull(str), i5);
        if ((i6 >> 8) == 0) {
            return (byte) i6;
        }
        throw new NumberFormatException(a.h(25, i6, "out of range: "));
    }

    @Beta
    public static String toString(byte b, int i5) {
        Preconditions.checkArgument(i5 >= 2 && i5 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i5);
        return Integer.toString(toInt(b), i5);
    }

    public static void sort(byte[] bArr, int i5, int i6) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i5, i6, bArr.length);
        for (int i7 = i5; i7 < i6; i7++) {
            bArr[i7] = flip(bArr[i7]);
        }
        Arrays.sort(bArr, i5, i6);
        while (i5 < i6) {
            bArr[i5] = flip(bArr[i5]);
            i5++;
        }
    }

    public static void sortDescending(byte[] bArr, int i5, int i6) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i5, i6, bArr.length);
        for (int i7 = i5; i7 < i6; i7++) {
            bArr[i7] = (byte) (bArr[i7] ^ Ascii.DEL);
        }
        Arrays.sort(bArr, i5, i6);
        while (i5 < i6) {
            bArr[i5] = (byte) (bArr[i5] ^ Ascii.DEL);
            i5++;
        }
    }
}
