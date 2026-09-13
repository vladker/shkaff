package org.apache.commons.codec.net;

import A3.AbstractC0157z;
import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class RFC1522Codec {
    protected static final String POSTFIX = "?=";
    protected static final String PREFIX = "=?";
    protected static final char SEP = '?';

    public String decodeText(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(PREFIX) || !str.endsWith(POSTFIX)) {
            throw new DecoderException("RFC 1522 violation: malformed encoded content");
        }
        int length = str.length() - 2;
        int iIndexOf = str.indexOf(63, 2);
        if (iIndexOf == length) {
            throw new DecoderException("RFC 1522 violation: charset token not found");
        }
        String strSubstring = str.substring(2, iIndexOf);
        if (strSubstring.equals("")) {
            throw new DecoderException("RFC 1522 violation: charset not specified");
        }
        int i5 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(63, i5);
        if (iIndexOf2 == length) {
            throw new DecoderException("RFC 1522 violation: encoding token not found");
        }
        String strSubstring2 = str.substring(i5, iIndexOf2);
        if (!getEncoding().equalsIgnoreCase(strSubstring2)) {
            throw new DecoderException(AbstractC0157z.o("This codec cannot decode ", strSubstring2, " encoded content"));
        }
        int i6 = iIndexOf2 + 1;
        return new String(doDecoding(StringUtils.getBytesUsAscii(str.substring(i6, str.indexOf(63, i6)))), strSubstring);
    }

    public abstract byte[] doDecoding(byte[] bArr);

    public abstract byte[] doEncoding(byte[] bArr);

    public String encodeText(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return PREFIX + charset + SEP + getEncoding() + SEP + StringUtils.newStringUsAscii(doEncoding(str.getBytes(charset))) + POSTFIX;
    }

    public abstract String getEncoding();

    public String encodeText(String str, String str2) {
        if (str == null) {
            return null;
        }
        return encodeText(str, Charset.forName(str2));
    }
}
