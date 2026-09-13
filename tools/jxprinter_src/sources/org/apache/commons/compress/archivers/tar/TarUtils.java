package org.apache.commons.compress.archivers.tar;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.IOUtils;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TarUtils {
    private static final int BYTE_MASK = 255;
    static final ZipEncoding DEFAULT_ENCODING = ZipEncodingHelper.getZipEncoding(null);
    static final ZipEncoding FALLBACK_ENCODING = new ZipEncoding() { // from class: org.apache.commons.compress.archivers.tar.TarUtils.1
        @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
        public boolean canEncode(String str) {
            return true;
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
        public String decode(byte[] bArr) {
            StringBuilder sb = new StringBuilder(bArr.length);
            for (byte b : bArr) {
                if (b == 0) {
                    break;
                }
                sb.append((char) (b & UnsignedBytes.MAX_VALUE));
            }
            return sb.toString();
        }

        @Override // org.apache.commons.compress.archivers.zip.ZipEncoding
        public ByteBuffer encode(String str) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i5 = 0; i5 < length; i5++) {
                bArr[i5] = (byte) str.charAt(i5);
            }
            return ByteBuffer.wrap(bArr);
        }
    };

    private TarUtils() {
    }

    public static long computeCheckSum(byte[] bArr) {
        long j6 = 0;
        for (byte b : bArr) {
            j6 += (long) (b & UnsignedBytes.MAX_VALUE);
        }
        return j6;
    }

    private static String exceptionMessage(byte[] bArr, int i5, int i6, int i7, byte b) {
        String strReplace = new String(bArr, i5, i6).replace(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, "{NUL}");
        StringBuilder sbT = AbstractC0157z.t(b, "Invalid byte ", " at offset ");
        sbT.append(i7 - i5);
        sbT.append(" in '");
        sbT.append(strReplace);
        return androidx.exifinterface.media.a.q(sbT, "' len=", i6);
    }

    private static void formatBigIntegerBinary(long j6, byte[] bArr, int i5, int i6, boolean z6) {
        byte[] byteArray = BigInteger.valueOf(j6).toByteArray();
        int length = byteArray.length;
        if (length > i6 - 1) {
            throw new IllegalArgumentException("Value " + j6 + " is too large for " + i6 + " byte field.");
        }
        int i7 = (i6 + i5) - length;
        System.arraycopy(byteArray, 0, bArr, i7, length);
        byte b = (byte) (z6 ? 255 : 0);
        while (true) {
            i5++;
            if (i5 >= i7) {
                return;
            } else {
                bArr[i5] = b;
            }
        }
    }

    public static int formatCheckSumOctalBytes(long j6, byte[] bArr, int i5, int i6) {
        int i7 = i6 - 2;
        formatUnsignedOctalString(j6, bArr, i5, i7);
        bArr[i7 + i5] = 0;
        bArr[(i6 - 1) + i5] = 32;
        return i5 + i6;
    }

    private static void formatLongBinary(long j6, byte[] bArr, int i5, int i6, boolean z6) {
        int i7 = (i6 - 1) * 8;
        long j7 = 1 << i7;
        long jAbs = Math.abs(j6);
        if (jAbs < 0 || jAbs >= j7) {
            throw new IllegalArgumentException("Value " + j6 + " is too large for " + i6 + " byte field.");
        }
        if (z6) {
            jAbs = ((jAbs ^ (j7 - 1)) + 1) | (255 << i7);
        }
        for (int i8 = (i6 + i5) - 1; i8 >= i5; i8--) {
            bArr[i8] = (byte) jAbs;
            jAbs >>= 8;
        }
    }

    public static int formatLongOctalBytes(long j6, byte[] bArr, int i5, int i6) {
        int i7 = i6 - 1;
        formatUnsignedOctalString(j6, bArr, i5, i7);
        bArr[i7 + i5] = 32;
        return i5 + i6;
    }

    public static int formatLongOctalOrBinaryBytes(long j6, byte[] bArr, int i5, int i6) {
        byte[] bArr2;
        int i7;
        int i8;
        long j7 = i6 == 8 ? TarConstants.MAXID : TarConstants.MAXSIZE;
        boolean z6 = j6 < 0;
        if (!z6 && j6 <= j7) {
            return formatLongOctalBytes(j6, bArr, i5, i6);
        }
        if (i6 < 9) {
            bArr2 = bArr;
            i7 = i5;
            i8 = i6;
            formatLongBinary(j6, bArr2, i7, i8, z6);
        } else {
            bArr2 = bArr;
            i7 = i5;
            i8 = i6;
            formatBigIntegerBinary(j6, bArr2, i7, i8, z6);
        }
        bArr2[i7] = (byte) (z6 ? 255 : 128);
        return i7 + i8;
    }

    public static int formatNameBytes(String str, byte[] bArr, int i5, int i6) {
        try {
            try {
                return formatNameBytes(str, bArr, i5, i6, DEFAULT_ENCODING);
            } catch (IOException unused) {
                return formatNameBytes(str, bArr, i5, i6, FALLBACK_ENCODING);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int formatOctalBytes(long j6, byte[] bArr, int i5, int i6) {
        int i7 = i6 - 2;
        formatUnsignedOctalString(j6, bArr, i5, i7);
        bArr[i7 + i5] = 32;
        bArr[(i6 - 1) + i5] = 0;
        return i5 + i6;
    }

    public static void formatUnsignedOctalString(long j6, byte[] bArr, int i5, int i6) {
        int i7;
        int i8 = i6 - 1;
        if (j6 == 0) {
            i7 = i6 - 2;
            bArr[i8 + i5] = TarConstants.LF_NORMAL;
        } else {
            long j7 = j6;
            while (i8 >= 0 && j7 != 0) {
                bArr[i5 + i8] = (byte) (((byte) (7 & j7)) + TarConstants.LF_NORMAL);
                j7 >>>= 3;
                i8--;
            }
            if (j7 != 0) {
                throw new IllegalArgumentException(j6 + "=" + Long.toOctalString(j6) + " will not fit in octal number buffer of length " + i6);
            }
            i7 = i8;
        }
        while (i7 >= 0) {
            bArr[i5 + i7] = TarConstants.LF_NORMAL;
            i7--;
        }
    }

    private static long parseBinaryBigInteger(byte[] bArr, int i5, int i6, boolean z6) {
        int i7 = i6 - 1;
        byte[] bArr2 = new byte[i7];
        System.arraycopy(bArr, i5 + 1, bArr2, 0, i7);
        BigInteger bigInteger = new BigInteger(bArr2);
        if (z6) {
            bigInteger = bigInteger.add(BigInteger.valueOf(-1L)).not();
        }
        if (bigInteger.bitLength() > 63) {
            throw new IllegalArgumentException(androidx.collection.a.m("At offset ", i5, i6, ", ", " byte binary number exceeds maximum signed long value"));
        }
        long jLongValue = bigInteger.longValue();
        return z6 ? -jLongValue : jLongValue;
    }

    private static long parseBinaryLong(byte[] bArr, int i5, int i6, boolean z6) {
        if (i6 >= 9) {
            throw new IllegalArgumentException(androidx.collection.a.m("At offset ", i5, i6, ", ", " byte binary number exceeds maximum signed long value"));
        }
        long jPow = 0;
        for (int i7 = 1; i7 < i6; i7++) {
            jPow = (jPow << 8) + ((long) (bArr[i5 + i7] & UnsignedBytes.MAX_VALUE));
        }
        if (z6) {
            jPow = (jPow - 1) ^ (((long) Math.pow(2.0d, ((double) (i6 - 1)) * 8.0d)) - 1);
        }
        return z6 ? -jPow : jPow;
    }

    public static boolean parseBoolean(byte[] bArr, int i5) {
        return bArr[i5] == 1;
    }

    public static List<TarArchiveStructSparse> parseFromPAX01SparseHeaders(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length % 2 == 1) {
            throw new IOException("Corrupted TAR archive. Bad format in GNU.sparse.map PAX Header");
        }
        for (int i5 = 0; i5 < strArrSplit.length; i5 += 2) {
            try {
                long j6 = Long.parseLong(strArrSplit[i5]);
                if (j6 < 0) {
                    throw new IOException("Corrupted TAR archive. Sparse struct offset contains negative value");
                }
                try {
                    long j7 = Long.parseLong(strArrSplit[i5 + 1]);
                    if (j7 < 0) {
                        throw new IOException("Corrupted TAR archive. Sparse struct numbytes contains negative value");
                    }
                    arrayList.add(new TarArchiveStructSparse(j6, j7));
                } catch (NumberFormatException unused) {
                    throw new IOException("Corrupted TAR archive. Sparse struct numbytes contains a non-numeric value");
                }
            } catch (NumberFormatException unused2) {
                throw new IOException("Corrupted TAR archive. Sparse struct offset contains a non-numeric value");
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String parseName(byte[] bArr, int i5, int i6) {
        try {
            try {
                return parseName(bArr, i5, i6, DEFAULT_ENCODING);
            } catch (IOException unused) {
                return parseName(bArr, i5, i6, FALLBACK_ENCODING);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long parseOctal(byte[] bArr, int i5, int i6) {
        int i7 = i5 + i6;
        if (i6 < 2) {
            throw new IllegalArgumentException(androidx.collection.a.i(i6, "Length ", " must be at least 2"));
        }
        long j6 = 0;
        if (bArr[i5] == 0) {
            return 0L;
        }
        int i8 = i5;
        while (i8 < i7 && bArr[i8] == 32) {
            i8++;
        }
        byte b = bArr[i7 - 1];
        while (i8 < i7 && (b == 0 || b == 32)) {
            b = bArr[i7 - 2];
            i7--;
        }
        while (i8 < i7) {
            byte b6 = bArr[i8];
            if (b6 < 48 || b6 > 55) {
                throw new IllegalArgumentException(exceptionMessage(bArr, i5, i6, i8, b6));
            }
            j6 = (j6 << 3) + ((long) (b6 - 48));
            i8++;
        }
        return j6;
    }

    public static long parseOctalOrBinary(byte[] bArr, int i5, int i6) {
        byte b = bArr[i5];
        if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
            return parseOctal(bArr, i5, i6);
        }
        boolean z6 = b == -1;
        return i6 < 9 ? parseBinaryLong(bArr, i5, i6, z6) : parseBinaryBigInteger(bArr, i5, i6, z6);
    }

    public static List<TarArchiveStructSparse> parsePAX01SparseHeaders(String str) {
        try {
            return parseFromPAX01SparseHeaders(str);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static List<TarArchiveStructSparse> parsePAX1XSparseHeaders(InputStream inputStream, int i5) throws IOException {
        ArrayList arrayList = new ArrayList();
        long[] lineOfNumberForPax1X = readLineOfNumberForPax1X(inputStream);
        long j6 = lineOfNumberForPax1X[0];
        if (j6 < 0) {
            throw new IOException("Corrupted TAR archive. Negative value in sparse headers block");
        }
        long j7 = lineOfNumberForPax1X[1];
        while (true) {
            long j8 = j6 - 1;
            if (j6 <= 0) {
                long j9 = i5;
                IOUtils.skip(inputStream, j9 - (j7 % j9));
                return arrayList;
            }
            long[] lineOfNumberForPax1X2 = readLineOfNumberForPax1X(inputStream);
            long j10 = lineOfNumberForPax1X2[0];
            if (j10 < 0) {
                throw new IOException("Corrupted TAR archive. Sparse header block offset contains negative value");
            }
            long j11 = j7 + lineOfNumberForPax1X2[1];
            long[] lineOfNumberForPax1X3 = readLineOfNumberForPax1X(inputStream);
            long j12 = lineOfNumberForPax1X3[0];
            if (j12 < 0) {
                throw new IOException("Corrupted TAR archive. Sparse header block numbytes contains negative value");
            }
            j7 = j11 + lineOfNumberForPax1X3[1];
            arrayList.add(new TarArchiveStructSparse(j10, j12));
            j6 = j8;
        }
    }

    @Deprecated
    public static Map<String, String> parsePaxHeaders(InputStream inputStream, List<TarArchiveStructSparse> list, Map<String, String> map) {
        return parsePaxHeaders(inputStream, list, map, -1L);
    }

    public static TarArchiveStructSparse parseSparse(byte[] bArr, int i5) {
        return new TarArchiveStructSparse(parseOctalOrBinary(bArr, i5, 12), parseOctalOrBinary(bArr, i5 + 12, 12));
    }

    private static long[] readLineOfNumberForPax1X(InputStream inputStream) throws IOException {
        long j6 = 0;
        long j7 = 0;
        while (true) {
            int i5 = inputStream.read();
            if (i5 == 10) {
                return new long[]{j7, j6 + 1};
            }
            j6++;
            if (i5 == -1) {
                throw new IOException("Unexpected EOF when reading parse information of 1.X PAX format");
            }
            if (i5 < 48 || i5 > 57) {
                throw new IOException("Corrupted TAR archive. Non-numeric value in sparse headers block");
            }
            j7 = (j7 * 10) + ((long) (i5 - 48));
        }
    }

    public static List<TarArchiveStructSparse> readSparseStructs(byte[] bArr, int i5, int i6) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < i6; i7++) {
            try {
                TarArchiveStructSparse sparse = parseSparse(bArr, (i7 * 24) + i5);
                if (sparse.getOffset() < 0) {
                    throw new IOException("Corrupted TAR archive, sparse entry with negative offset");
                }
                if (sparse.getNumbytes() < 0) {
                    throw new IOException("Corrupted TAR archive, sparse entry with negative numbytes");
                }
                arrayList.add(sparse);
            } catch (IllegalArgumentException e) {
                throw new IOException("Corrupted TAR archive, sparse entry is invalid", e);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean verifyCheckSum(byte[] bArr) {
        long octal = parseOctal(bArr, 148, 8);
        long j6 = 0;
        long j7 = 0;
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b = bArr[i5];
            if (148 <= i5 && i5 < 156) {
                b = 32;
            }
            j6 += (long) (b & UnsignedBytes.MAX_VALUE);
            j7 += (long) b;
        }
        return octal == j6 || octal == j7;
    }

    public static Map<String, String> parsePaxHeaders(InputStream inputStream, List<TarArchiveStructSparse> list, Map<String, String> map, long j6) throws IOException {
        int i5;
        int i6;
        int i7;
        long j7;
        HashMap map2 = new HashMap(map);
        int i8 = 0;
        int i9 = 0;
        Long lValueOf = null;
        while (true) {
            int i10 = i8;
            int i11 = i10;
            while (true) {
                i5 = inputStream.read();
                int i12 = -1;
                long j8 = 0;
                if (i5 != -1) {
                    i10++;
                    i9++;
                    if (i5 == 10) {
                        i6 = -1;
                        break;
                    }
                    if (i5 == 32) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            i7 = inputStream.read();
                            if (i7 != i12) {
                                i10++;
                                i9++;
                                if (i9 >= 0 && (j6 < j8 || i9 < j6)) {
                                    if (i7 == 61) {
                                        String string = byteArrayOutputStream.toString("UTF-8");
                                        int i13 = i11 - i10;
                                        if (i13 > 1) {
                                            if (j6 >= j8 && i13 > j6 - ((long) i9)) {
                                                throw new IOException(androidx.collection.a.i(i13, "Paxheader value size ", " exceeds size of header record"));
                                            }
                                            byte[] range = IOUtils.readRange(inputStream, i13);
                                            int length = range.length;
                                            if (length != i13) {
                                                throw new IOException(androidx.collection.a.h(i13, length, "Failed to read Paxheader. Expected ", " bytes, read "));
                                            }
                                            i9 += i13;
                                            int i14 = i13 - 1;
                                            if (range[i14] != 10) {
                                                throw new IOException("Failed to read Paxheader.Value should end with a newline");
                                            }
                                            String str = new String(range, i8, i14, StandardCharsets.UTF_8);
                                            map2.put(string, str);
                                            if (string.equals("GNU.sparse.offset")) {
                                                if (lValueOf != null) {
                                                    j7 = 0;
                                                    list.add(new TarArchiveStructSparse(lValueOf.longValue(), 0L));
                                                } else {
                                                    j7 = 0;
                                                }
                                                try {
                                                    lValueOf = Long.valueOf(str);
                                                    if (lValueOf.longValue() < j7) {
                                                        throw new IOException("Failed to read Paxheader.GNU.sparse.offset contains negative value");
                                                    }
                                                } catch (NumberFormatException unused) {
                                                    throw new IOException("Failed to read Paxheader.GNU.sparse.offset contains a non-numeric value");
                                                }
                                            }
                                            if (!string.equals("GNU.sparse.numbytes")) {
                                                break;
                                            }
                                            if (lValueOf == null) {
                                                throw new IOException("Failed to read Paxheader.GNU.sparse.offset is expected before GNU.sparse.numbytes shows up.");
                                            }
                                            try {
                                                long j9 = Long.parseLong(str);
                                                if (j9 < 0) {
                                                    throw new IOException("Failed to read Paxheader.GNU.sparse.numbytes contains negative value");
                                                }
                                                list.add(new TarArchiveStructSparse(lValueOf.longValue(), j9));
                                                lValueOf = null;
                                                break;
                                            } catch (NumberFormatException unused2) {
                                                throw new IOException("Failed to read Paxheader.GNU.sparse.numbytes contains a non-numeric value.");
                                            }
                                        }
                                        map2.remove(string);
                                    } else {
                                        byteArrayOutputStream.write((byte) i7);
                                        i8 = 0;
                                        i12 = -1;
                                        j8 = 0;
                                    }
                                }
                            }
                            break;
                        }
                        i5 = i7;
                    } else {
                        if (i5 < 48 || i5 > 57) {
                            throw new IOException("Failed to read Paxheader. Encountered a non-number while reading length");
                        }
                        i11 = (i11 * 10) + (i5 - 48);
                        i8 = 0;
                    }
                }
                i6 = -1;
                break;
            }
            if (i5 == i6) {
                if (lValueOf != null) {
                    list.add(new TarArchiveStructSparse(lValueOf.longValue(), 0L));
                }
                return map2;
            }
            i8 = 0;
        }
    }

    public static int formatNameBytes(String str, byte[] bArr, int i5, int i6, ZipEncoding zipEncoding) {
        int length = str.length();
        ByteBuffer byteBufferEncode = zipEncoding.encode(str);
        while (byteBufferEncode.limit() > i6 && length > 0) {
            length--;
            byteBufferEncode = zipEncoding.encode(str.substring(0, length));
        }
        int iLimit = byteBufferEncode.limit() - byteBufferEncode.position();
        System.arraycopy(byteBufferEncode.array(), byteBufferEncode.arrayOffset(), bArr, i5, iLimit);
        while (iLimit < i6) {
            bArr[i5 + iLimit] = 0;
            iLimit++;
        }
        return i5 + i6;
    }

    public static String parseName(byte[] bArr, int i5, int i6, ZipEncoding zipEncoding) {
        int i7 = 0;
        for (int i8 = i5; i7 < i6 && bArr[i8] != 0; i8++) {
            i7++;
        }
        if (i7 > 0) {
            byte[] bArr2 = new byte[i7];
            System.arraycopy(bArr, i5, bArr2, 0, i7);
            return zipEncoding.decode(bArr2);
        }
        return "";
    }
}
