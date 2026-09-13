package org.apache.commons.codec.digest;

import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XXHash32 implements Checksum {
    private static final int BUF_SIZE = 16;
    private static final int PRIME1 = -1640531535;
    private static final int PRIME2 = -2048144777;
    private static final int PRIME3 = -1028477379;
    private static final int PRIME4 = 668265263;
    private static final int PRIME5 = 374761393;
    private static final int ROTATE_BITS = 13;
    private final byte[] buffer;
    private final byte[] oneByte;
    private int pos;
    private final int seed;
    private final int[] state;
    private boolean stateUpdated;
    private int totalLen;

    public XXHash32() {
        this(0);
    }

    private static int getInt(byte[] bArr, int i5) {
        return ((bArr[i5 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i5] & UnsignedBytes.MAX_VALUE) | ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    private void initializeState() {
        int[] iArr = this.state;
        int i5 = this.seed;
        iArr[0] = 606290984 + i5;
        iArr[1] = PRIME2 + i5;
        iArr[2] = i5;
        iArr[3] = i5 - PRIME1;
    }

    private void process(byte[] bArr, int i5) {
        int[] iArr = this.state;
        int i6 = iArr[0];
        int i7 = iArr[1];
        int i8 = iArr[2];
        int i9 = iArr[3];
        int iRotateLeft = Integer.rotateLeft((getInt(bArr, i5) * PRIME2) + i6, 13) * PRIME1;
        int iRotateLeft2 = Integer.rotateLeft((getInt(bArr, i5 + 4) * PRIME2) + i7, 13) * PRIME1;
        int iRotateLeft3 = Integer.rotateLeft((getInt(bArr, i5 + 8) * PRIME2) + i8, 13) * PRIME1;
        int iRotateLeft4 = Integer.rotateLeft((getInt(bArr, i5 + 12) * PRIME2) + i9, 13) * PRIME1;
        int[] iArr2 = this.state;
        iArr2[0] = iRotateLeft;
        iArr2[1] = iRotateLeft2;
        iArr2[2] = iRotateLeft3;
        iArr2[3] = iRotateLeft4;
        this.stateUpdated = true;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        int iRotateLeft;
        int i5 = 0;
        if (this.stateUpdated) {
            iRotateLeft = Integer.rotateLeft(this.state[3], 18) + Integer.rotateLeft(this.state[2], 12) + Integer.rotateLeft(this.state[1], 7) + Integer.rotateLeft(this.state[0], 1);
        } else {
            iRotateLeft = this.state[2] + PRIME5;
        }
        int iRotateLeft2 = iRotateLeft + this.totalLen;
        int i6 = this.pos - 4;
        while (i5 <= i6) {
            iRotateLeft2 = Integer.rotateLeft((getInt(this.buffer, i5) * PRIME3) + iRotateLeft2, 17) * PRIME4;
            i5 += 4;
        }
        while (i5 < this.pos) {
            iRotateLeft2 = PRIME1 * Integer.rotateLeft(((this.buffer[i5] & UnsignedBytes.MAX_VALUE) * PRIME5) + iRotateLeft2, 11);
            i5++;
        }
        int i7 = ((iRotateLeft2 >>> 15) ^ iRotateLeft2) * PRIME2;
        int i8 = (i7 ^ (i7 >>> 13)) * PRIME3;
        return ((long) (i8 ^ (i8 >>> 16))) & KeyboardMap.kValueMask;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        initializeState();
        this.totalLen = 0;
        this.pos = 0;
        this.stateUpdated = false;
    }

    @Override // java.util.zip.Checksum
    public void update(int i5) {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i5 & 255);
        update(bArr, 0, 1);
    }

    public XXHash32(int i5) {
        this.oneByte = new byte[1];
        this.state = new int[4];
        this.buffer = new byte[16];
        this.seed = i5;
        initializeState();
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i5, int i6) {
        if (i6 <= 0) {
            return;
        }
        this.totalLen += i6;
        int i7 = i5 + i6;
        int i8 = this.pos;
        if ((i8 + i6) - 16 < 0) {
            System.arraycopy(bArr, i5, this.buffer, i8, i6);
            this.pos += i6;
            return;
        }
        if (i8 > 0) {
            int i9 = 16 - i8;
            System.arraycopy(bArr, i5, this.buffer, i8, i9);
            process(this.buffer, 0);
            i5 += i9;
        }
        int i10 = i7 - 16;
        while (i5 <= i10) {
            process(bArr, i5);
            i5 += 16;
        }
        if (i5 < i7) {
            int i11 = i7 - i5;
            this.pos = i11;
            System.arraycopy(bArr, i5, this.buffer, 0, i11);
            return;
        }
        this.pos = 0;
    }
}
