package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {

    /* JADX INFO: renamed from: C1, reason: collision with root package name */
    private static final int f3386C1 = -862048943;

    /* JADX INFO: renamed from: C2, reason: collision with root package name */
    private static final int f3387C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j6, boolean z6, String str) {
        super(str);
        this.table = cArr;
        this.filter = j6;
        this.containsZero = z6;
    }

    private boolean checkFilter(int i5) {
        return 1 == ((this.filter >> i5) & 1);
    }

    @VisibleForTesting
    public static int chooseTableSize(int i5) {
        if (i5 == 1) {
            return 2;
        }
        int iHighestOneBit = Integer.highestOneBit(i5 - 1) << 1;
        while (((double) iHighestOneBit) * DESIRED_LOAD_FACTOR < i5) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static CharMatcher from(BitSet bitSet, String str) {
        int i5;
        int iCardinality = bitSet.cardinality();
        boolean z6 = bitSet.get(0);
        int iChooseTableSize = chooseTableSize(iCardinality);
        char[] cArr = new char[iChooseTableSize];
        int i6 = iChooseTableSize - 1;
        int iNextSetBit = bitSet.nextSetBit(0);
        long j6 = 0;
        while (iNextSetBit != -1) {
            long j7 = (1 << iNextSetBit) | j6;
            int iSmear = smear(iNextSetBit);
            while (true) {
                i5 = iSmear & i6;
                if (cArr[i5] == 0) {
                    break;
                }
                iSmear = i5 + 1;
            }
            cArr[i5] = (char) iNextSetBit;
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
            j6 = j7;
        }
        return new SmallCharMatcher(cArr, j6, z6, str);
    }

    public static int smear(int i5) {
        return Integer.rotateLeft(i5 * (-862048943), 15) * f3387C2;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c) {
        if (c == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c)) {
            return false;
        }
        int length = this.table.length - 1;
        int iSmear = smear(c) & length;
        int i5 = iSmear;
        do {
            char c6 = this.table[i5];
            if (c6 == 0) {
                return false;
            }
            if (c6 == c) {
                return true;
            }
            i5 = (i5 + 1) & length;
        } while (i5 != iSmear);
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c : this.table) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }
}
