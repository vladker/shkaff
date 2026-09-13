package org.apache.poi.xssf.binary;

import androidx.exifinterface.media.a;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.nio.charset.StandardCharsets;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFBUtils {
    public static int castToInt(long j6) {
        if (j6 >= 2147483647L || j6 <= -2147483648L) {
            throw new POIXMLException(a.k("val (", j6, ") can't be cast to int"));
        }
        return (int) j6;
    }

    public static short castToShort(int i5) {
        if (i5 >= 32767 || i5 <= -32768) {
            throw new POIXMLException(androidx.collection.a.i(i5, "val (", ") can't be cast to short"));
        }
        return (short) i5;
    }

    public static int get24BitInt(byte[] bArr, int i5) {
        return ((bArr[i5 + 2] & UnsignedBytes.MAX_VALUE) << 16) + ((bArr[i5 + 1] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[i5] & UnsignedBytes.MAX_VALUE);
    }

    public static int readXLNullableWideString(byte[] bArr, int i5, StringBuilder sb) {
        long uInt = LittleEndian.getUInt(bArr, i5);
        if (uInt < 0) {
            throw new XSSFBParseException("too few chars to read");
        }
        if (uInt == KeyboardMap.kValueMask) {
            return 0;
        }
        if (uInt > KeyboardMap.kValueMask) {
            throw new XSSFBParseException("too many chars to read");
        }
        int i6 = ((int) uInt) * 2;
        int i7 = i5 + 4;
        if (i7 + i6 <= bArr.length) {
            sb.append(new String(bArr, i7, i6, StandardCharsets.UTF_16LE));
            return i6 + 4;
        }
        StringBuilder sbS = androidx.collection.a.s("trying to read beyond data length: offset=", i7, i6, ", numBytes=", ", data.length=");
        sbS.append(bArr.length);
        throw new XSSFBParseException(sbS.toString());
    }

    public static int readXLWideString(byte[] bArr, int i5, StringBuilder sb) {
        long uInt = LittleEndian.getUInt(bArr, i5);
        if (uInt < 0) {
            throw new XSSFBParseException("too few chars to read");
        }
        if (uInt > KeyboardMap.kValueMask) {
            throw new XSSFBParseException("too many chars to read");
        }
        int i6 = ((int) uInt) * 2;
        int i7 = i5 + 4;
        if (i7 + i6 > bArr.length) {
            throw new XSSFBParseException("trying to read beyond data length");
        }
        sb.append(new String(bArr, i7, i6, StandardCharsets.UTF_16LE));
        return i6 + 4;
    }
}
