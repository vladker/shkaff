package org.apache.poi.poifs.filesystem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.poi.poifs.storage.HeaderBlockConstants;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FileMagic {
    OLE2(HeaderBlockConstants._signature),
    OOXML(80, 75, 3, 4),
    XML(60, 63, 120, 109, 108),
    BIFF2(9, 0, 4, 0, 0, 0, 63, 0),
    BIFF3(9, 2, 6, 0, 0, 0, 63, 0),
    BIFF4(new byte[]{9, 4, 6, 0, 0, 0, 63, 0}, new byte[]{9, 4, 6, 0, 0, 0, 0, 1}),
    MSWRITE(new byte[]{TarConstants.LF_LINK, -66, 0, 0}, new byte[]{TarConstants.LF_SYMLINK, -66, 0, 0}),
    RTF("{\\rtf"),
    PDF("%PDF"),
    HTML("<!DOCTYP", "<html", "\n\r<html", "\r\n<html", "\r<html", "\n<html", "<HTML", "\r\n<HTML", "\n\r<HTML", "\r<HTML", "\n<HTML"),
    WORD2(219, 165, 45, 0),
    JPEG(new byte[]{-1, -40, -1, -37}, new byte[]{-1, -40, -1, -32, 63, 63, 74, 70, 73, 70, 0, 1}, new byte[]{-1, -40, -1, -18}, new byte[]{-1, -40, -1, -31, 63, 63, 69, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 105, 102, 0, 0}),
    GIF("GIF87a", "GIF89a"),
    PNG(137, 80, 78, 71, 13, 10, 26, 10),
    TIFF("II*\u0000", "MM\u0000*"),
    WMF(215, 205, 198, 154),
    EMF(1, 0, 0, 0, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 63, 32, 69, 77, 70),
    BMP(66, 77),
    UNKNOWN(new byte[0]);

    static final int MAX_PATTERN_LENGTH = 44;
    final byte[][] magic;

    FileMagic(long j6) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 1, 8);
        this.magic = bArr;
        LittleEndian.putLong(bArr[0], 0, j6);
    }

    private static boolean findMagic(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b = bArr[i5];
            int i7 = i6 + 1;
            if (bArr2[i6] != b && b != 63) {
                return false;
            }
            i5++;
            i6 = i7;
        }
        return true;
    }

    public static InputStream prepareToCheckMagic(InputStream inputStream) {
        return inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
    }

    public static FileMagic valueOf(byte[] bArr) {
        for (FileMagic fileMagic : values()) {
            for (byte[] bArr2 : fileMagic.magic) {
                if (bArr.length >= bArr2.length && findMagic(bArr2, bArr)) {
                    return fileMagic;
                }
            }
        }
        return UNKNOWN;
    }

    FileMagic(int... iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            bArr[i5] = (byte) (iArr[i5] & 255);
        }
        this.magic = new byte[][]{bArr};
    }

    public static FileMagic valueOf(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[44];
            int fully = IOUtils.readFully(fileInputStream, bArr, 0, 44);
            if (fully == -1) {
                FileMagic fileMagic = UNKNOWN;
                fileInputStream.close();
                return fileMagic;
            }
            FileMagic fileMagicValueOf = valueOf(Arrays.copyOf(bArr, fully));
            fileInputStream.close();
            return fileMagicValueOf;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    FileMagic(byte[]... bArr) {
        this.magic = bArr;
    }

    FileMagic(String... strArr) {
        this.magic = new byte[strArr.length][];
        int length = strArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            this.magic[i6] = strArr[i5].getBytes(LocaleUtil.CHARSET_1252);
            i5++;
            i6++;
        }
    }

    public static FileMagic valueOf(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return valueOf(IOUtils.peekFirstNBytes(inputStream, 44));
        }
        throw new IOException("getFileMagic() only operates on streams which support mark(int)");
    }
}
