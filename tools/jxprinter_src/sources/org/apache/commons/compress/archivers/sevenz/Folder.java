package org.apache.commons.compress.archivers.sevenz;

import A3.AbstractC0157z;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class Folder {
    static final Folder[] EMPTY_FOLDER_ARRAY = new Folder[0];
    BindPair[] bindPairs;
    Coder[] coders;
    long crc;
    boolean hasCrc;
    int numUnpackSubStreams;
    long[] packedStreams;
    long totalInputStreams;
    long totalOutputStreams;
    long[] unpackSizes;

    public int findBindPairForInStream(int i5) {
        if (this.bindPairs == null) {
            return -1;
        }
        int i6 = 0;
        while (true) {
            BindPair[] bindPairArr = this.bindPairs;
            if (i6 >= bindPairArr.length) {
                return -1;
            }
            if (bindPairArr[i6].inIndex == i5) {
                return i6;
            }
            i6++;
        }
    }

    public int findBindPairForOutStream(int i5) {
        if (this.bindPairs == null) {
            return -1;
        }
        int i6 = 0;
        while (true) {
            BindPair[] bindPairArr = this.bindPairs;
            if (i6 >= bindPairArr.length) {
                return -1;
            }
            if (bindPairArr[i6].outIndex == i5) {
                return i6;
            }
            i6++;
        }
    }

    public Iterable<Coder> getOrderedCoders() throws IOException {
        Coder[] coderArr;
        long[] jArr = this.packedStreams;
        if (jArr == null || (coderArr = this.coders) == null || jArr.length == 0 || coderArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = new LinkedList();
        int i5 = (int) this.packedStreams[0];
        while (i5 >= 0) {
            Coder[] coderArr2 = this.coders;
            if (i5 >= coderArr2.length) {
                break;
            }
            if (linkedList.contains(coderArr2[i5])) {
                throw new IOException("folder uses the same coder more than once in coder chain");
            }
            linkedList.addLast(this.coders[i5]);
            int iFindBindPairForOutStream = findBindPairForOutStream(i5);
            i5 = iFindBindPairForOutStream != -1 ? (int) this.bindPairs[iFindBindPairForOutStream].inIndex : -1;
        }
        return linkedList;
    }

    public long getUnpackSize() {
        long j6 = this.totalOutputStreams;
        if (j6 == 0) {
            return 0L;
        }
        for (int i5 = ((int) j6) - 1; i5 >= 0; i5--) {
            if (findBindPairForOutStream(i5) < 0) {
                return this.unpackSizes[i5];
            }
        }
        return 0L;
    }

    public long getUnpackSizeForCoder(Coder coder) {
        if (this.coders == null) {
            return 0L;
        }
        int i5 = 0;
        while (true) {
            Coder[] coderArr = this.coders;
            if (i5 >= coderArr.length) {
                return 0L;
            }
            if (coderArr[i5] == coder) {
                return this.unpackSizes[i5];
            }
            i5++;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Folder with ");
        sb.append(this.coders.length);
        sb.append(" coders, ");
        sb.append(this.totalInputStreams);
        sb.append(" input streams, ");
        sb.append(this.totalOutputStreams);
        sb.append(" output streams, ");
        sb.append(this.bindPairs.length);
        sb.append(" bind pairs, ");
        sb.append(this.packedStreams.length);
        sb.append(" packed streams, ");
        sb.append(this.unpackSizes.length);
        sb.append(" unpack sizes, ");
        if (this.hasCrc) {
            str = "with CRC " + this.crc;
        } else {
            str = "without CRC";
        }
        sb.append(str);
        sb.append(" and ");
        return AbstractC0157z.l(" unpack streams", this.numUnpackSubStreams, sb);
    }
}
