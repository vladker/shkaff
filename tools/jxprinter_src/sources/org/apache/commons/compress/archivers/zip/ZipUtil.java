package org.apache.commons.compress.archivers.zip;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = ZipLong.getBytes(8448);

    public static long adjustToLong(int i5) {
        return i5 < 0 ? ((long) i5) + 4294967296L : i5;
    }

    public static long bigToLong(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + bigInteger + "]");
    }

    public static boolean canHandleEntryData(ZipArchiveEntry zipArchiveEntry) {
        return supportsEncryptionOf(zipArchiveEntry) && supportsMethodOf(zipArchiveEntry);
    }

    public static void checkRequestedFeatures(ZipArchiveEntry zipArchiveEntry) throws UnsupportedZipFeatureException {
        if (!supportsEncryptionOf(zipArchiveEntry)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, zipArchiveEntry);
        }
        if (supportsMethodOf(zipArchiveEntry)) {
            return;
        }
        ZipMethod methodByCode = ZipMethod.getMethodByCode(zipArchiveEntry.getMethod());
        if (methodByCode != null) {
            throw new UnsupportedZipFeatureException(methodByCode, zipArchiveEntry);
        }
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, zipArchiveEntry);
    }

    public static byte[] copy(byte[] bArr) {
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    public static long dosToJavaTime(long j6) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j6 >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j6 >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j6 >> 16)) & 31);
        calendar.set(11, ((int) (j6 >> 11)) & 31);
        calendar.set(12, ((int) (j6 >> 5)) & 63);
        calendar.set(13, ((int) (j6 << 1)) & 62);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static Date fromDosTime(ZipLong zipLong) {
        return new Date(dosToJavaTime(zipLong.getValue()));
    }

    private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField abstractUnicodeExtraField, byte[] bArr) {
        if (abstractUnicodeExtraField == null) {
            return null;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        if (crc32.getValue() != abstractUnicodeExtraField.getNameCRC32()) {
            return null;
        }
        try {
            return ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(abstractUnicodeExtraField.getUnicodeName());
        } catch (IOException unused) {
            return null;
        }
    }

    public static BigInteger longToBig(long j6) {
        if (j6 < -2147483648L) {
            throw new IllegalArgumentException(androidx.exifinterface.media.a.k("Negative longs < -2^31 not permitted: [", j6, "]"));
        }
        if (j6 < 0 && j6 >= -2147483648L) {
            j6 = adjustToLong((int) j6);
        }
        return BigInteger.valueOf(j6);
    }

    public static byte[] reverse(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i5 = 0; i5 < bArr.length / 2; i5++) {
            byte b = bArr[i5];
            int i6 = length - i5;
            bArr[i5] = bArr[i6];
            bArr[i6] = b;
        }
        return bArr;
    }

    public static void setNameAndCommentFromExtraFields(ZipArchiveEntry zipArchiveEntry, byte[] bArr, byte[] bArr2) {
        ZipExtraField extraField = zipArchiveEntry.getExtraField(UnicodePathExtraField.UPATH_ID);
        String unicodeStringIfOriginalMatches = getUnicodeStringIfOriginalMatches(extraField instanceof UnicodePathExtraField ? (UnicodePathExtraField) extraField : null, bArr);
        if (unicodeStringIfOriginalMatches != null) {
            zipArchiveEntry.setName(unicodeStringIfOriginalMatches);
            zipArchiveEntry.setNameSource(ZipArchiveEntry.NameSource.UNICODE_EXTRA_FIELD);
        }
        if (bArr2 == null || bArr2.length <= 0) {
            return;
        }
        ZipExtraField extraField2 = zipArchiveEntry.getExtraField(UnicodeCommentExtraField.UCOM_ID);
        String unicodeStringIfOriginalMatches2 = getUnicodeStringIfOriginalMatches(extraField2 instanceof UnicodeCommentExtraField ? (UnicodeCommentExtraField) extraField2 : null, bArr2);
        if (unicodeStringIfOriginalMatches2 != null) {
            zipArchiveEntry.setComment(unicodeStringIfOriginalMatches2);
            zipArchiveEntry.setCommentSource(ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD);
        }
    }

    public static int signedByteToUnsignedInt(byte b) {
        return b >= 0 ? b : b + 256;
    }

    private static boolean supportsEncryptionOf(ZipArchiveEntry zipArchiveEntry) {
        return !zipArchiveEntry.getGeneralPurposeBit().usesEncryption();
    }

    private static boolean supportsMethodOf(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getMethod() == 0 || zipArchiveEntry.getMethod() == ZipMethod.UNSHRINKING.getCode() || zipArchiveEntry.getMethod() == ZipMethod.IMPLODING.getCode() || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || zipArchiveEntry.getMethod() == ZipMethod.BZIP2.getCode();
    }

    public static ZipLong toDosTime(Date date) {
        return new ZipLong(toDosTime(date.getTime()));
    }

    public static byte unsignedIntToSignedByte(int i5) {
        if (i5 > 255 || i5 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.i(i5, "Can only convert non-negative integers between [0,255] to byte: [", "]"));
        }
        return i5 < 128 ? (byte) i5 : (byte) (i5 + InputDeviceCompat.SOURCE_ANY);
    }

    public static void copy(byte[] bArr, byte[] bArr2, int i5) {
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, i5, bArr.length);
        }
    }

    public static byte[] toDosTime(long j6) {
        byte[] bArr = new byte[4];
        toDosTime(j6, bArr, 0);
        return bArr;
    }

    public static void toDosTime(long j6, byte[] bArr, int i5) {
        toDosTime(Calendar.getInstance(), j6, bArr, i5);
    }

    public static void toDosTime(Calendar calendar, long j6, byte[] bArr, int i5) {
        calendar.setTimeInMillis(j6);
        int i6 = calendar.get(1);
        if (i6 < 1980) {
            copy(DOS_TIME_MIN, bArr, i5);
        } else {
            ZipLong.putLong((calendar.get(13) >> 1) | ((i6 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5), bArr, i5);
        }
    }
}
