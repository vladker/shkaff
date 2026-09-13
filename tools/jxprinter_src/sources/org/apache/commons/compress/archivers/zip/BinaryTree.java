package org.apache.commons.compress.archivers.zip;

import A3.AbstractC0157z;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BinaryTree {
    private static final int NODE = -2;
    private static final int UNDEFINED = -1;
    private final int[] tree;

    public BinaryTree(int i5) {
        if (i5 < 0 || i5 > 30) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "depth must be bigger than 0 and not bigger than 30 but is "));
        }
        int[] iArr = new int[(int) ((1 << (i5 + 1)) - 1)];
        this.tree = iArr;
        Arrays.fill(iArr, -1);
    }

    public static BinaryTree decode(InputStream inputStream, int i5) throws IOException {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "totalNumberOfValues must be bigger than 0, is "));
        }
        int i6 = inputStream.read() + 1;
        if (i6 == 0) {
            throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
        }
        byte[] range = IOUtils.readRange(inputStream, i6);
        if (range.length != i6) {
            throw new EOFException();
        }
        int[] iArr = new int[i5];
        int i7 = 0;
        int iMax = 0;
        for (byte b : range) {
            int i8 = ((b & 240) >> 4) + 1;
            if (i7 + i8 > i5) {
                throw new IOException("Number of values exceeds given total number of values");
            }
            int i9 = (b & 15) + 1;
            int i10 = 0;
            while (i10 < i8) {
                iArr[i7] = i9;
                i10++;
                i7++;
            }
            iMax = Math.max(iMax, i9);
        }
        int[] iArr2 = new int[i5];
        for (int i11 = 0; i11 < i5; i11++) {
            iArr2[i11] = i11;
        }
        int[] iArr3 = new int[i5];
        int i12 = 0;
        for (int i13 = 0; i13 < i5; i13++) {
            for (int i14 = 0; i14 < i5; i14++) {
                if (iArr[i14] == i13) {
                    iArr3[i12] = i13;
                    iArr2[i12] = i14;
                    i12++;
                }
            }
        }
        int[] iArr4 = new int[i5];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i5 - 1; i18 >= 0; i18--) {
            i15 += i16;
            int i19 = iArr3[i18];
            if (i19 != i17) {
                i16 = 1 << (16 - i19);
                i17 = i19;
            }
            iArr4[iArr2[i18]] = i15;
        }
        BinaryTree binaryTree = new BinaryTree(iMax);
        for (int i20 = 0; i20 < i5; i20++) {
            int i21 = iArr[i20];
            if (i21 > 0) {
                binaryTree.addLeaf(0, Integer.reverse(iArr4[i20] << 16), i21, i20);
            }
        }
        return binaryTree;
    }

    public void addLeaf(int i5, int i6, int i7, int i8) {
        if (i7 != 0) {
            this.tree[i5] = -2;
            addLeaf((i5 * 2) + 1 + (i6 & 1), i6 >>> 1, i7 - 1, i8);
            return;
        }
        int[] iArr = this.tree;
        if (iArr[i5] == -1) {
            iArr[i5] = i8;
        } else {
            throw new IllegalArgumentException(AbstractC0157z.l(")", this.tree[i5], AbstractC0157z.t(i5, "Tree value at index ", " has already been assigned (")));
        }
    }

    public int read(BitStream bitStream) throws IOException {
        int i5 = 0;
        while (true) {
            int iNextBit = bitStream.nextBit();
            if (iNextBit == -1) {
                return -1;
            }
            int i6 = (i5 * 2) + 1 + iNextBit;
            int i7 = this.tree[i6];
            if (i7 != -2) {
                if (i7 != -1) {
                    return i7;
                }
                throw new IOException(androidx.collection.a.m("The child ", iNextBit, i5, " of node at index ", " is not defined"));
            }
            i5 = i6;
        }
    }
}
