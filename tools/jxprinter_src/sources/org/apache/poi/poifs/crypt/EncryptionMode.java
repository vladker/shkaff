package org.apache.poi.poifs.crypt;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum EncryptionMode {
    binaryRC4(new androidx.emoji2.text.flatbuffer.a(24), 1, 1, 0),
    cryptoAPI(new androidx.emoji2.text.flatbuffer.a(25), 4, 2, 4),
    standard(new androidx.emoji2.text.flatbuffer.a(26), 4, 2, 36),
    agile(new androidx.emoji2.text.flatbuffer.a(27), 4, 4, 64),
    xor(new androidx.emoji2.text.flatbuffer.a(28), 0, 0, 0);

    public final Supplier<EncryptionInfoBuilder> builder;
    public final int encryptionFlags;
    public final int versionMajor;
    public final int versionMinor;

    EncryptionMode(Supplier supplier, int i5, int i6, int i7) {
        this.builder = supplier;
        this.versionMajor = i5;
        this.versionMinor = i6;
        this.encryptionFlags = i7;
    }
}
