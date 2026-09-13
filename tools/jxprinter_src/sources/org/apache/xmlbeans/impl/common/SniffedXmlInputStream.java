package org.apache.xmlbeans.impl.common;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SniffedXmlInputStream extends BufferedInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_SNIFFED_BYTES = 192;
    private String _encoding;
    private static Charset dummy1 = Charset.forName("UTF-8");
    private static Charset dummy2 = Charset.forName("UTF-16");
    private static Charset dummy3 = Charset.forName("UTF-16BE");
    private static Charset dummy4 = Charset.forName("UTF-16LE");
    private static Charset dummy5 = Charset.forName("ISO-8859-1");
    private static Charset dummy6 = Charset.forName("US-ASCII");
    private static Charset dummy7 = Charset.forName("Cp1252");
    private static char[] WHITESPACE = {Chars.SPACE, Chars.CR, '\t', '\n'};
    private static char[] NOTNAME = {Chars.EQ, Chars.SPACE, Chars.CR, '\t', '\n', '?', '>', '<', Chars.QUOTE, Chars.DQUOTE};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ScannedAttribute {
        public String name;
        public String value;

        private ScannedAttribute() {
        }
    }

    public SniffedXmlInputStream(InputStream inputStream) throws IOException {
        String strSniffForXmlDecl;
        super(inputStream);
        String strSniffFourBytes = sniffFourBytes();
        this._encoding = strSniffFourBytes;
        if (strSniffFourBytes != null && strSniffFourBytes.equals("IBM037") && (strSniffForXmlDecl = sniffForXmlDecl(this._encoding)) != null) {
            this._encoding = strSniffForXmlDecl;
        }
        if (this._encoding == null) {
            this._encoding = sniffForXmlDecl("UTF-8");
        }
        if (this._encoding == null) {
            this._encoding = "UTF-8";
        }
    }

    public static String extractXmlDeclEncoding(char[] cArr, int i5, int i6) {
        int i7 = i6 + i5;
        int iFirstIndexOf = firstIndexOf("<?xml", cArr, i5, i7);
        if (iFirstIndexOf >= 0) {
            int iScanAttribute = iFirstIndexOf + 5;
            ScannedAttribute scannedAttribute = new ScannedAttribute();
            while (iScanAttribute < i7) {
                iScanAttribute = scanAttribute(cArr, iScanAttribute, i7, scannedAttribute);
                if (iScanAttribute < 0) {
                    return null;
                }
                if (scannedAttribute.name.equals("encoding")) {
                    return scannedAttribute.value;
                }
            }
        }
        return null;
    }

    private static int firstIndexOf(String str, char[] cArr, int i5, int i6) {
        char[] charArray = str.toCharArray();
        char c = charArray[0];
        int length = i6 - charArray.length;
        while (i5 < length) {
            if (cArr[i5] == c) {
                for (int i7 = 1; i7 < charArray.length; i7++) {
                    if (cArr[i5 + i7] == charArray[i7]) {
                    }
                }
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private static int nextMatchingByte(char[] cArr, char[] cArr2, int i5, int i6) {
        while (i5 < i6) {
            char c = cArr2[i5];
            for (char c6 : cArr) {
                if (c == c6) {
                    return i5;
                }
            }
            i5++;
        }
        return -1;
    }

    private static int nextNonmatchingByte(char[] cArr, char[] cArr2, int i5, int i6) {
        while (i5 < i6) {
            char c = cArr2[i5];
            for (char c6 : cArr) {
                if (c == c6) {
                    i5++;
                }
            }
            return i5;
        }
        return -1;
    }

    private int readAsMuchAsPossible(byte[] bArr, int i5, int i6) throws IOException {
        int i7 = 0;
        while (i7 < i6) {
            int i8 = read(bArr, i5 + i7, i6 - i7);
            if (i8 < 0) {
                break;
            }
            i7 += i8;
        }
        return i7;
    }

    private static int scanAttribute(char[] cArr, int i5, int i6, ScannedAttribute scannedAttribute) {
        int iNextMatchingByte;
        int iNextNonmatchingByte;
        int i7;
        int iNextMatchingByte2;
        int iNextNonmatchingByte2 = nextNonmatchingByte(WHITESPACE, cArr, i5, i6);
        if (iNextNonmatchingByte2 < 0 || (iNextMatchingByte = nextMatchingByte(NOTNAME, cArr, iNextNonmatchingByte2, i6)) < 0 || (iNextNonmatchingByte = nextNonmatchingByte(WHITESPACE, cArr, iNextMatchingByte, i6)) < 0 || cArr[iNextNonmatchingByte] != '=') {
            return -1;
        }
        int iNextNonmatchingByte3 = nextNonmatchingByte(WHITESPACE, cArr, iNextNonmatchingByte + 1, i6);
        char c = cArr[iNextNonmatchingByte3];
        if ((c != '\'' && c != '\"') || (iNextMatchingByte2 = nextMatchingByte(c, cArr, (i7 = iNextNonmatchingByte3 + 1), i6)) < 0) {
            return -1;
        }
        scannedAttribute.name = new String(cArr, iNextNonmatchingByte2, iNextMatchingByte - iNextNonmatchingByte2);
        scannedAttribute.value = new String(cArr, i7, (iNextMatchingByte2 - iNextNonmatchingByte3) - 1);
        return iNextMatchingByte2 + 1;
    }

    private String sniffForXmlDecl(String str) throws IOException {
        mark(192);
        try {
            byte[] bArr = new byte[192];
            int asMuchAsPossible = readAsMuchAsPossible(bArr, 0, 192);
            InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(bArr, 0, asMuchAsPossible), Charset.forName(str));
            char[] cArr = new char[asMuchAsPossible];
            int i5 = 0;
            while (i5 < asMuchAsPossible) {
                int i6 = inputStreamReader.read(cArr, i5, asMuchAsPossible - i5);
                if (i6 < 0) {
                    break;
                }
                i5 += i6;
            }
            return extractXmlDeclEncoding(cArr, 0, i5);
        } finally {
            reset();
        }
    }

    private String sniffFourBytes() throws IOException {
        mark(4);
        try {
            byte[] bArr = new byte[4];
            if (readAsMuchAsPossible(bArr, 0, 4) < 4) {
                reset();
                return null;
            }
            long j6 = ((bArr[0] << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[3] & UnsignedBytes.MAX_VALUE);
            if (j6 == 65279) {
                reset();
                return "UCS-4";
            }
            if (j6 == -131072) {
                reset();
                return "UCS-4";
            }
            if (j6 == 60) {
                reset();
                return "UCS-4BE";
            }
            if (j6 == 1006632960) {
                reset();
                return "UCS-4LE";
            }
            if (j6 == 3932223) {
                reset();
                return "UTF-16BE";
            }
            if (j6 == 1006649088) {
                reset();
                return "UTF-16LE";
            }
            if (j6 == 1010792557) {
                reset();
                return null;
            }
            if (j6 == 1282385812) {
                reset();
                return "IBM037";
            }
            long j7 = (-65536) & j6;
            if (j7 == -16842752) {
                reset();
                return "UTF-16";
            }
            if (j7 == -131072) {
                reset();
                return "UTF-16";
            }
            if ((j6 & (-256)) == -272908544) {
                reset();
                return "UTF-8";
            }
            reset();
            return null;
        } catch (Throwable th) {
            reset();
            throw th;
        }
    }

    public String getXmlEncoding() {
        return this._encoding;
    }

    private static int nextMatchingByte(char c, char[] cArr, int i5, int i6) {
        while (i5 < i6) {
            if (cArr[i5] == c) {
                return i5;
            }
            i5++;
        }
        return -1;
    }
}
