package androidx.collection;

import A3.AbstractC0157z;
import kotlin.jvm.internal.E;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        E.d(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int get(long j6) {
        return Long.numberOfTrailingZeros(j6) >> 3;
    }

    public static final long group(long[] metadata, int i5) {
        E.f(metadata, "metadata");
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        return (((-i7) >> 63) & (metadata[i6 + 1] << (64 - i7))) | (metadata[i6] >>> i7);
    }

    public static final int h1(int i5) {
        return i5 >>> 7;
    }

    public static final int h2(int i5) {
        return i5 & 127;
    }

    public static final boolean hasNext(long j6) {
        return j6 != 0;
    }

    public static final int hash(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return iHashCode ^ (iHashCode << 16);
    }

    public static final boolean isDeleted(long[] metadata, int i5) {
        E.f(metadata, "metadata");
        return ((metadata[i5 >> 3] >> ((i5 & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(long[] metadata, int i5) {
        E.f(metadata, "metadata");
        return ((metadata[i5 >> 3] >> ((i5 & 7) << 3)) & 255) == 128;
    }

    public static final boolean isFull(long j6) {
        return j6 < 128;
    }

    public static final int loadedCapacity(int i5) {
        if (i5 == 7) {
            return 6;
        }
        return i5 - (i5 / 8);
    }

    public static final int lowestBitSet(long j6) {
        return Long.numberOfTrailingZeros(j6) >> 3;
    }

    public static final long maskEmpty(long j6) {
        return j6 & ((~j6) << 6) & (-9187201950435737472L);
    }

    public static final long maskEmptyOrDeleted(long j6) {
        return j6 & ((~j6) << 7) & (-9187201950435737472L);
    }

    public static final long match(long j6, int i5) {
        long j7 = j6 ^ (((long) i5) * BitmaskLsb);
        return (~j7) & (j7 - BitmaskLsb) & (-9187201950435737472L);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static final long next(long j6) {
        return j6 & (j6 - 1);
    }

    public static final int nextCapacity(int i5) {
        if (i5 == 0) {
            return 6;
        }
        return (i5 * 2) + 1;
    }

    public static final int normalizeCapacity(int i5) {
        if (i5 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i5);
        }
        return 0;
    }

    public static final long readRawMetadata(long[] data, int i5) {
        E.f(data, "data");
        return (data[i5 >> 3] >> ((i5 & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i5) {
        if (i5 == 7) {
            return 8;
        }
        return AbstractC0157z.b(i5, 1, 7, i5);
    }

    public static final void writeRawMetadata(long[] data, int i5, long j6) {
        E.f(data, "data");
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        data[i6] = (j6 << i7) | (data[i6] & (~(255 << i7)));
    }

    public static final boolean isFull(long[] metadata, int i5) {
        E.f(metadata, "metadata");
        return ((metadata[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128;
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(C1938s... pairs) {
        E.f(pairs, "pairs");
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(pairs.length);
        mutableScatterMap.putAll(pairs);
        return mutableScatterMap;
    }

    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    public static /* synthetic */ void getSentinel$annotations() {
    }
}
