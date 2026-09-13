package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class BinaryShiftToken extends Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    public BinaryShiftToken(Token token, int i5, int i6) {
        super(token);
        this.binaryShiftStart = (short) i5;
        this.binaryShiftByteCount = (short) i6;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        int i5 = 0;
        while (true) {
            short s6 = this.binaryShiftByteCount;
            if (i5 >= s6) {
                return;
            }
            if (i5 == 0 || (i5 == 31 && s6 <= 62)) {
                bitArray.appendBits(31, 5);
                short s7 = this.binaryShiftByteCount;
                if (s7 > 62) {
                    bitArray.appendBits(s7 - 31, 16);
                } else if (i5 == 0) {
                    bitArray.appendBits(Math.min((int) s7, 31), 5);
                } else {
                    bitArray.appendBits(s7 - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + i5], 8);
            i5++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.binaryShiftStart);
        sb.append("::");
        sb.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        sb.append('>');
        return sb.toString();
    }
}
