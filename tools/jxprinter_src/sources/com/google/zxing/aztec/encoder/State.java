package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i5, int i6, int i7) {
        this.token = token;
        this.mode = i5;
        this.binaryShiftByteCount = i6;
        this.bitCount = i7;
    }

    public State addBinaryShiftChar(int i5) {
        int i6;
        Token tokenAdd = this.token;
        int i7 = this.mode;
        int i8 = this.bitCount;
        if (i7 == 4 || i7 == 2) {
            int i9 = HighLevelEncoder.LATCH_TABLE[i7][0];
            int i10 = 65535 & i9;
            int i11 = i9 >> 16;
            tokenAdd = tokenAdd.add(i10, i11);
            i8 += i11;
            i7 = 0;
        }
        int i12 = this.binaryShiftByteCount;
        if (i12 == 0 || i12 == 31) {
            i6 = 18;
        } else {
            i6 = i12 == 62 ? 9 : 8;
        }
        State state = new State(tokenAdd, i7, i12 + 1, i8 + i6);
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i5 + 1) : state;
    }

    public State endBinaryShift(int i5) {
        int i6 = this.binaryShiftByteCount;
        return i6 == 0 ? this : new State(this.token.addBinaryShift(i5 - i6, i6), this.mode, 0, this.bitCount);
    }

    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    public int getBitCount() {
        return this.bitCount;
    }

    public int getMode() {
        return this.mode;
    }

    public Token getToken() {
        return this.token;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        int i5;
        int i6 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i7 = state.binaryShiftByteCount;
        if (i7 > 0 && ((i5 = this.binaryShiftByteCount) == 0 || i5 > i7)) {
            i6 += 10;
        }
        return i6 <= state.bitCount;
    }

    public State latchAndAppend(int i5, int i6) {
        int i7 = this.bitCount;
        Token tokenAdd = this.token;
        int i8 = this.mode;
        if (i5 != i8) {
            int i9 = HighLevelEncoder.LATCH_TABLE[i8][i5];
            int i10 = 65535 & i9;
            int i11 = i9 >> 16;
            tokenAdd = tokenAdd.add(i10, i11);
            i7 += i11;
        }
        int i12 = i5 == 2 ? 4 : 5;
        return new State(tokenAdd.add(i6, i12), i5, 0, i7 + i12);
    }

    public State shiftAndAppend(int i5, int i6) {
        Token token = this.token;
        int i7 = this.mode;
        int i8 = i7 == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[i7][i5], i8).add(i6, 5), this.mode, 0, this.bitCount + i8 + 5);
    }

    public BitArray toBitArray(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (Token previous = endBinaryShift(bArr.length).token; previous != null; previous = previous.getPrevious()) {
            linkedList.addFirst(previous);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Token) it.next()).appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}
