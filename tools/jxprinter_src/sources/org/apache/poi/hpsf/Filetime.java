package org.apache.poi.hpsf;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class Filetime {
    private static final BigInteger EPOCH_DIFF = BigInteger.valueOf(-11644473600000L);
    private static final BigInteger NANO_100 = BigInteger.valueOf(10000);
    private long fileTime;

    public Filetime() {
    }

    public static long dateToFileTime(java.util.Date date) {
        return BigInteger.valueOf(date.getTime()).subtract(EPOCH_DIFF).multiply(NANO_100).longValue();
    }

    public static java.util.Date filetimeToDate(long j6) {
        return new java.util.Date((j6 < 0 ? twoComplement(j6) : BigInteger.valueOf(j6)).divide(NANO_100).add(EPOCH_DIFF).longValue());
    }

    public static boolean isUndefined(java.util.Date date) {
        return date == null || dateToFileTime(date) == 0;
    }

    private static BigInteger twoComplement(long j6) {
        return new BigInteger(new byte[]{(byte) (j6 < 0 ? 0 : -1), (byte) ((j6 >> 56) & 255), (byte) ((j6 >> 48) & 255), (byte) ((j6 >> 40) & 255), (byte) ((j6 >> 32) & 255), (byte) ((j6 >> 24) & 255), (byte) ((j6 >> 16) & 255), (byte) ((j6 >> 8) & 255), (byte) (j6 & 255)});
    }

    public java.util.Date getJavaValue() {
        return filetimeToDate(this.fileTime);
    }

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this.fileTime = littleEndianByteArrayInputStream.readLong();
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[8];
        LittleEndian.putLong(bArr, 0, this.fileTime);
        return bArr;
    }

    public int write(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
        return 8;
    }

    public Filetime(java.util.Date date) {
        this.fileTime = dateToFileTime(date);
    }
}
