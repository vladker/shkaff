package org.apache.commons.compress.archivers.dump;

import java.util.Arrays;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class DumpArchiveUtil {
    private DumpArchiveUtil() {
    }

    public static int calculateChecksum(byte[] bArr) {
        int iConvert32 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            iConvert32 += convert32(bArr, i5 * 4);
        }
        return DumpArchiveConstants.CHECKSUM - (iConvert32 - convert32(bArr, 28));
    }

    public static final int convert16(byte[] bArr, int i5) {
        return (int) ByteUtils.fromLittleEndian(bArr, i5, 2);
    }

    public static final int convert32(byte[] bArr, int i5) {
        return (int) ByteUtils.fromLittleEndian(bArr, i5, 4);
    }

    public static final long convert64(byte[] bArr, int i5) {
        return ByteUtils.fromLittleEndian(bArr, i5, 8);
    }

    public static String decode(ZipEncoding zipEncoding, byte[] bArr, int i5, int i6) {
        return zipEncoding.decode(Arrays.copyOfRange(bArr, i5, i6 + i5));
    }

    public static final int getIno(byte[] bArr) {
        return convert32(bArr, 20);
    }

    public static final boolean verify(byte[] bArr) {
        return convert32(bArr, 24) == 60012 && convert32(bArr, 28) == calculateChecksum(bArr);
    }
}
