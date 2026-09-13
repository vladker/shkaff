package org.jsoup.nodes;

import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f7482a = {',', ';'};
    public static final HashMap b = new HashMap();

    static {
        o oVar = o.xhtml;
        Pattern pattern = V4.c.f766a;
        new ThreadLocal();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private static void appendEncoded(Appendable appendable, o oVar, int i5) throws IOException {
        String str;
        int iBinarySearch = Arrays.binarySearch(oVar.c, i5);
        if (iBinarySearch >= 0) {
            String[] strArr = oVar.d;
            if (iBinarySearch < strArr.length - 1) {
                int i6 = iBinarySearch + 1;
                if (oVar.c[i6] == i5) {
                    str = strArr[i6];
                } else {
                    str = strArr[iBinarySearch];
                }
            } else {
                str = strArr[iBinarySearch];
            }
        } else {
            str = "";
        }
        if ("".equals(str)) {
            appendable.append("&#x").append(Integer.toHexString(i5)).append(';');
        } else {
            appendable.append('&').append(str).append(';');
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0046  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e5  */
    public static void escape(Appendable appendable, String str, h hVar, boolean z6, boolean z7, boolean z8) throws IOException {
        String str2;
        char c;
        o oVar = hVar.f7469a;
        CharsetEncoder charsetEncoderE = (CharsetEncoder) hVar.c.get();
        if (charsetEncoderE == null) {
            charsetEncoderE = hVar.e();
        }
        n nVar = hVar.coreCharset;
        int length = str.length();
        int iCharCount = 0;
        boolean z9 = false;
        boolean z10 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            boolean zCanEncode = true;
            if (z7) {
                if (!W4.b.e(iCodePointAt)) {
                    z10 = false;
                    z9 = true;
                    if (iCodePointAt < 65536) {
                        c = (char) iCodePointAt;
                        if (c != '\t') {
                            appendable.append(c);
                        } else {
                            appendable.append(c);
                        }
                    } else {
                        str2 = new String(Character.toChars(iCodePointAt));
                        if (charsetEncoderE.canEncode(str2)) {
                            appendable.append(str2);
                        } else {
                            appendEncoded(appendable, oVar, iCodePointAt);
                        }
                    }
                } else if ((!z8 || z9) && !z10) {
                    appendable.append(Chars.SPACE);
                    z10 = true;
                }
            } else if (iCodePointAt < 65536) {
                c = (char) iCodePointAt;
                if (c != '\t' || c == '\n' || c == '\r') {
                    appendable.append(c);
                } else if (c != '\"') {
                    if (c == '&') {
                        appendable.append("&amp;");
                    } else if (c != '<') {
                        if (c != '>') {
                            if (c != 160) {
                                if (c < ' ') {
                                    appendEncoded(appendable, oVar, iCodePointAt);
                                } else {
                                    int iOrdinal = nVar.ordinal();
                                    if (iOrdinal != 0) {
                                        if (iOrdinal != 1) {
                                            zCanEncode = charsetEncoderE.canEncode(c);
                                        }
                                    } else if (c >= 128) {
                                        zCanEncode = false;
                                    }
                                    if (zCanEncode) {
                                        appendable.append(c);
                                    } else {
                                        appendEncoded(appendable, oVar, iCodePointAt);
                                    }
                                }
                            } else if (oVar != o.xhtml) {
                                appendable.append("&nbsp;");
                            } else {
                                appendable.append("&#xa0;");
                            }
                        } else if (z6) {
                            appendable.append(c);
                        } else {
                            appendable.append("&gt;");
                        }
                    } else if (!z6 || oVar == o.xhtml || hVar.f7470f == g.b) {
                        appendable.append("&lt;");
                    } else {
                        appendable.append(c);
                    }
                } else if (z6) {
                    appendable.append("&quot;");
                } else {
                    appendable.append(c);
                }
            } else {
                str2 = new String(Character.toChars(iCodePointAt));
                if (charsetEncoderE.canEncode(str2)) {
                    appendable.append(str2);
                } else {
                    appendEncoded(appendable, oVar, iCodePointAt);
                }
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }
}
