package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        volatile long f3389p0;
        volatile long p1;

        /* JADX INFO: renamed from: p2, reason: collision with root package name */
        volatile long f3390p2;

        /* JADX INFO: renamed from: p3, reason: collision with root package name */
        volatile long f3391p3;

        /* JADX INFO: renamed from: p4, reason: collision with root package name */
        volatile long f3392p4;

        /* JADX INFO: renamed from: p5, reason: collision with root package name */
        volatile long f3393p5;
        volatile long p6;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        volatile long f3394q0;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        volatile long f3395q1;

        /* JADX INFO: renamed from: q2, reason: collision with root package name */
        volatile long f3396q2;

        /* JADX INFO: renamed from: q3, reason: collision with root package name */
        volatile long f3397q3;

        /* JADX INFO: renamed from: q4, reason: collision with root package name */
        volatile long f3398q4;

        /* JADX INFO: renamed from: q5, reason: collision with root package name */
        volatile long f3399q5;
        volatile long q6;
        volatile long value;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public Cell(long j6) {
            this.value = j6;
        }

        public final boolean cas(long j6, long j7) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j6, j7);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.cache.Striped64.1
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

    public final boolean casBase(long j6, long j7) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j6, j7);
    }

    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    public abstract long fn(long j6, long j7);

    public final void internalReset(long j6) {
        Cell[] cellArr = this.cells;
        this.base = j6;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j6;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    public final void retryUpdate(long j6, int[] iArr, boolean z6) {
        int iNextInt;
        int[] iArr2;
        boolean z7;
        int length;
        boolean z8;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            iNextInt = rng.nextInt();
            if (iNextInt == 0) {
                iNextInt = 1;
            }
            iArr2[0] = iNextInt;
        } else {
            iNextInt = iArr[0];
            iArr2 = iArr;
        }
        boolean z9 = false;
        int i5 = iNextInt;
        boolean z10 = z6;
        while (true) {
            Cell[] cellArr = this.cells;
            if (cellArr != null && (length = cellArr.length) > 0) {
                Cell cell = cellArr[(length - 1) & i5];
                if (cell == null) {
                    if (this.busy == 0) {
                        Cell cell2 = new Cell(j6);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                Cell[] cellArr2 = this.cells;
                                if (cellArr2 == null || (length2 = cellArr2.length) <= 0) {
                                    z8 = false;
                                } else {
                                    int i6 = (length2 - 1) & i5;
                                    if (cellArr2[i6] == null) {
                                        cellArr2[i6] = cell2;
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                }
                                this.busy = 0;
                                if (z8) {
                                    return;
                                }
                            } catch (Throwable th) {
                                this.busy = 0;
                                throw th;
                            }
                        }
                    }
                    z9 = false;
                    int i7 = i5 ^ (i5 << 13);
                    int i8 = i7 ^ (i7 >>> 17);
                    i5 = i8 ^ (i8 << 5);
                    iArr2[0] = i5;
                } else {
                    if (z10) {
                        long j7 = cell.value;
                        if (cell.cas(j7, fn(j7, j6))) {
                            return;
                        }
                        if (length >= NCPU || this.cells != cellArr) {
                            z9 = false;
                        } else if (!z9) {
                            z9 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == cellArr) {
                                    Cell[] cellArr3 = new Cell[length << 1];
                                    for (int i9 = 0; i9 < length; i9++) {
                                        cellArr3[i9] = cellArr[i9];
                                    }
                                    this.cells = cellArr3;
                                }
                                this.busy = 0;
                                z9 = false;
                            } catch (Throwable th2) {
                                this.busy = 0;
                                throw th2;
                            }
                        }
                    } else {
                        z10 = true;
                    }
                    int i10 = i5 ^ (i5 << 13);
                    int i11 = i10 ^ (i10 >>> 17);
                    i5 = i11 ^ (i11 << 5);
                    iArr2[0] = i5;
                }
            } else if (this.busy == 0 && this.cells == cellArr && casBusy()) {
                try {
                    if (this.cells == cellArr) {
                        Cell[] cellArr4 = new Cell[2];
                        cellArr4[i5 & 1] = new Cell(j6);
                        this.cells = cellArr4;
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    this.busy = 0;
                    if (z7) {
                        return;
                    }
                } catch (Throwable th3) {
                    this.busy = 0;
                    throw th3;
                }
            } else {
                long j8 = this.base;
                if (casBase(j8, fn(j8, j6))) {
                    return;
                }
            }
        }
    }
}
