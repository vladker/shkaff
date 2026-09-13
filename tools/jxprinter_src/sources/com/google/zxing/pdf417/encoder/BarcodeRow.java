package com.google.zxing.pdf417.encoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    public BarcodeRow(int i5) {
        this.row = new byte[i5];
    }

    public void addBar(boolean z6, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = this.currentLocation;
            this.currentLocation = i7 + 1;
            set(i7, z6);
        }
    }

    public byte[] getScaledRow(int i5) {
        int length = this.row.length * i5;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = this.row[i6 / i5];
        }
        return bArr;
    }

    public void set(int i5, byte b) {
        this.row[i5] = b;
    }

    private void set(int i5, boolean z6) {
        this.row[i5] = z6 ? (byte) 1 : (byte) 0;
    }
}
