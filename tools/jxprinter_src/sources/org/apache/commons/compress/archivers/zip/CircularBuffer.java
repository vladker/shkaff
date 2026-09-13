package org.apache.commons.compress.archivers.zip;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class CircularBuffer {
    private final byte[] buffer;
    private int readIndex;
    private final int size;
    private int writeIndex;

    public CircularBuffer(int i5) {
        this.size = i5;
        this.buffer = new byte[i5];
    }

    public boolean available() {
        return this.readIndex != this.writeIndex;
    }

    public void copy(int i5, int i6) {
        int i7 = this.writeIndex - i5;
        int i8 = i6 + i7;
        while (i7 < i8) {
            byte[] bArr = this.buffer;
            int i9 = this.writeIndex;
            int i10 = this.size;
            bArr[i9] = bArr[(i7 + i10) % i10];
            this.writeIndex = (i9 + 1) % i10;
            i7++;
        }
    }

    public int get() {
        if (!available()) {
            return -1;
        }
        byte[] bArr = this.buffer;
        int i5 = this.readIndex;
        byte b = bArr[i5];
        this.readIndex = (i5 + 1) % this.size;
        return b & UnsignedBytes.MAX_VALUE;
    }

    public void put(int i5) {
        byte[] bArr = this.buffer;
        int i6 = this.writeIndex;
        bArr[i6] = (byte) i5;
        this.writeIndex = (i6 + 1) % this.size;
    }
}
