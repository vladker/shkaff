package org.apache.xmlbeans.impl.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SniffedXmlReader extends BufferedReader {
    public static final int MAX_SNIFFED_CHARS = 192;
    private static Charset dummy1 = Charset.forName("UTF-8");
    private static Charset dummy2 = Charset.forName("UTF-16");
    private static Charset dummy3 = Charset.forName("UTF-16BE");
    private static Charset dummy4 = Charset.forName("UTF-16LE");
    private static Charset dummy5 = Charset.forName("ISO-8859-1");
    private static Charset dummy6 = Charset.forName("US-ASCII");
    private static Charset dummy7 = Charset.forName("Cp1252");
    private String _encoding;

    public SniffedXmlReader(Reader reader) {
        super(reader);
        this._encoding = sniffForXmlDecl();
    }

    private int readAsMuchAsPossible(char[] cArr, int i5, int i6) throws IOException {
        int i7 = 0;
        while (i7 < i6) {
            int i8 = read(cArr, i5 + i7, i6 - i7);
            if (i8 < 0) {
                break;
            }
            i7 += i8;
        }
        return i7;
    }

    private String sniffForXmlDecl() throws IOException {
        mark(192);
        try {
            char[] cArr = new char[192];
            return SniffedXmlInputStream.extractXmlDeclEncoding(cArr, 0, readAsMuchAsPossible(cArr, 0, 192));
        } finally {
            reset();
        }
    }

    public String getXmlEncoding() {
        return this._encoding;
    }
}
