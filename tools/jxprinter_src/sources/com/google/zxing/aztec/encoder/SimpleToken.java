package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class SimpleToken extends Token {
    private final short bitCount;
    private final short value;

    public SimpleToken(Token token, int i5, int i6) {
        super(token);
        this.value = (short) i5;
        this.bitCount = (short) i6;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public String toString() {
        short s6 = this.value;
        short s7 = this.bitCount;
        return "<" + Integer.toBinaryString((s6 & ((1 << s7) - 1)) | (1 << s7) | (1 << this.bitCount)).substring(1) + '>';
    }
}
