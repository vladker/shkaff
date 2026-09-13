package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int i5) {
        this.longs = new AtomicLongArray(i5);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i5 = objectInputStream.readInt();
        ImmutableLongArray.Builder builder = ImmutableLongArray.builder();
        for (int i6 = 0; i6 < i5; i6++) {
            builder.add(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.build().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i5 = 0; i5 < length; i5++) {
            objectOutputStream.writeDouble(get(i5));
        }
    }

    @CanIgnoreReturnValue
    public double addAndGet(int i5, double d) {
        while (true) {
            long j6 = this.longs.get(i5);
            double dLongBitsToDouble = Double.longBitsToDouble(j6) + d;
            int i6 = i5;
            if (this.longs.compareAndSet(i6, j6, Double.doubleToRawLongBits(dLongBitsToDouble))) {
                return dLongBitsToDouble;
            }
            i5 = i6;
        }
    }

    public final boolean compareAndSet(int i5, double d, double d6) {
        return this.longs.compareAndSet(i5, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d6));
    }

    public final double get(int i5) {
        return Double.longBitsToDouble(this.longs.get(i5));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int i5, double d) {
        while (true) {
            long j6 = this.longs.get(i5);
            double dLongBitsToDouble = Double.longBitsToDouble(j6);
            int i6 = i5;
            if (this.longs.compareAndSet(i6, j6, Double.doubleToRawLongBits(dLongBitsToDouble + d))) {
                return dLongBitsToDouble;
            }
            i5 = i6;
        }
    }

    public final double getAndSet(int i5, double d) {
        return Double.longBitsToDouble(this.longs.getAndSet(i5, Double.doubleToRawLongBits(d)));
    }

    public final void lazySet(int i5, double d) {
        this.longs.lazySet(i5, Double.doubleToRawLongBits(d));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i5, double d) {
        this.longs.set(i5, Double.doubleToRawLongBits(d));
    }

    public String toString() {
        int length = length();
        int i5 = length - 1;
        if (i5 == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length * 19);
        sb.append('[');
        int i6 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i6)));
            if (i6 == i5) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            i6++;
        }
    }

    public final boolean weakCompareAndSet(int i5, double d, double d6) {
        return this.longs.weakCompareAndSet(i5, Double.doubleToRawLongBits(d), Double.doubleToRawLongBits(d6));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            jArr[i5] = Double.doubleToRawLongBits(dArr[i5]);
        }
        this.longs = new AtomicLongArray(jArr);
    }
}
