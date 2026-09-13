package org.apache.poi.util;

import A3.AbstractC0157z;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CodePageUtil {
    public static final int CP_037 = 37;
    public static final int CP_EUC_JP = 51932;
    public static final int CP_EUC_KR = 51949;
    public static final int CP_GB18030 = 54936;
    public static final int CP_GB2312 = 52936;
    public static final int CP_GBK = 936;
    public static final int CP_ISO_2022_JP1 = 50220;
    public static final int CP_ISO_2022_JP2 = 50221;
    public static final int CP_ISO_2022_JP3 = 50222;
    public static final int CP_ISO_2022_KR = 50225;
    public static final int CP_ISO_8859_1 = 28591;
    public static final int CP_ISO_8859_2 = 28592;
    public static final int CP_ISO_8859_3 = 28593;
    public static final int CP_ISO_8859_4 = 28594;
    public static final int CP_ISO_8859_5 = 28595;
    public static final int CP_ISO_8859_6 = 28596;
    public static final int CP_ISO_8859_7 = 28597;
    public static final int CP_ISO_8859_8 = 28598;
    public static final int CP_ISO_8859_9 = 28599;
    public static final int CP_JOHAB = 1361;
    public static final int CP_KOI8_R = 20866;
    public static final int CP_MAC_ARABIC = 10004;
    public static final int CP_MAC_CENTRAL_EUROPE = 10029;
    public static final int CP_MAC_CHINESE_SIMPLE = 10008;
    public static final int CP_MAC_CHINESE_TRADITIONAL = 10002;
    public static final int CP_MAC_CROATIAN = 10082;
    public static final int CP_MAC_CYRILLIC = 10007;
    public static final int CP_MAC_GREEK = 10006;
    public static final int CP_MAC_HEBREW = 10005;
    public static final int CP_MAC_ICELAND = 10079;
    public static final int CP_MAC_JAPAN = 10001;
    public static final int CP_MAC_KOREAN = 10003;
    public static final int CP_MAC_ROMAN = 10000;
    public static final int CP_MAC_ROMANIA = 10010;
    public static final int CP_MAC_ROMAN_BIFF23 = 32768;
    public static final int CP_MAC_THAI = 10021;
    public static final int CP_MAC_TURKISH = 10081;
    public static final int CP_MAC_UKRAINE = 10017;
    public static final int CP_MS949 = 949;
    public static final int CP_SJIS = 932;
    public static final int CP_UNICODE = 1200;
    public static final int CP_US_ACSII = 20127;
    public static final int CP_US_ASCII2 = 65000;
    public static final int CP_UTF16 = 1200;
    public static final int CP_UTF16_BE = 1201;
    public static final int CP_UTF8 = 65001;
    public static final int CP_WINDOWS_1250 = 1250;
    public static final int CP_WINDOWS_1251 = 1251;
    public static final int CP_WINDOWS_1252 = 1252;
    public static final int CP_WINDOWS_1252_BIFF23 = 32769;
    public static final int CP_WINDOWS_1253 = 1253;
    public static final int CP_WINDOWS_1254 = 1254;
    public static final int CP_WINDOWS_1255 = 1255;
    public static final int CP_WINDOWS_1256 = 1256;
    public static final int CP_WINDOWS_1257 = 1257;
    public static final int CP_WINDOWS_1258 = 1258;

    public static String codepageToEncoding(int i5) {
        return codepageToEncoding(i5, false);
    }

    public static byte[] getBytesInCodePage(String str, int i5) {
        return str.getBytes(codepageToEncoding(i5));
    }

    public static String getStringFromCodePage(byte[] bArr, int i5) {
        return getStringFromCodePage(bArr, 0, bArr.length, i5);
    }

    public static String codepageToEncoding(int i5, boolean z6) throws UnsupportedEncodingException {
        if (i5 <= 0) {
            throw new UnsupportedEncodingException(AbstractC0157z.k(i5, "Codepage number may not be "));
        }
        if (i5 == 1200) {
            return "UTF-16LE";
        }
        if (i5 == 1201) {
            return "UTF-16BE";
        }
        if (i5 == 10081) {
            return "MacTurkish";
        }
        if (i5 == 10082) {
            return "MacCroatian";
        }
        switch (i5) {
            case 37:
                return "cp037";
            case CP_SJIS /* 932 */:
                return StringUtils.SHIFT_JIS;
            case CP_GBK /* 936 */:
                return "GBK";
            case CP_MS949 /* 949 */:
                return "ms949";
            case CP_JOHAB /* 1361 */:
                return "johab";
            case CP_MAC_ROMANIA /* 10010 */:
                return "MacRomania";
            case CP_MAC_UKRAINE /* 10017 */:
                return "MacUkraine";
            case CP_MAC_THAI /* 10021 */:
                return "MacThai";
            case CP_MAC_CENTRAL_EUROPE /* 10029 */:
                return "MacCentralEurope";
            case CP_MAC_ICELAND /* 10079 */:
                return "MacIceland";
            case CP_US_ACSII /* 20127 */:
                return "US-ASCII";
            case CP_KOI8_R /* 20866 */:
                return "KOI8-R";
            case CP_ISO_2022_KR /* 50225 */:
                return "ISO-2022-KR";
            case CP_EUC_JP /* 51932 */:
                return "EUC-JP";
            case CP_EUC_KR /* 51949 */:
                return "EUC-KR";
            case CP_GB2312 /* 52936 */:
                return StringUtils.GB2312;
            case CP_GB18030 /* 54936 */:
                return "GB18030";
            default:
                switch (i5) {
                    case CP_WINDOWS_1250 /* 1250 */:
                        return z6 ? "Cp1250" : "windows-1250";
                    case CP_WINDOWS_1251 /* 1251 */:
                        return z6 ? "Cp1251" : "windows-1251";
                    case 1252:
                        break;
                    case CP_WINDOWS_1253 /* 1253 */:
                        return z6 ? "Cp1253" : "windows-1253";
                    case CP_WINDOWS_1254 /* 1254 */:
                        return z6 ? "Cp1254" : "windows-1254";
                    case CP_WINDOWS_1255 /* 1255 */:
                        return z6 ? "Cp1255" : "windows-1255";
                    case CP_WINDOWS_1256 /* 1256 */:
                        return z6 ? "Cp1255" : "windows-1256";
                    case CP_WINDOWS_1257 /* 1257 */:
                        return z6 ? "Cp1257" : "windows-1257";
                    case CP_WINDOWS_1258 /* 1258 */:
                        return z6 ? "Cp1258" : "windows-1258";
                    default:
                        switch (i5) {
                            case 10000:
                                return "MacRoman";
                            case 10001:
                                return StringUtils.SHIFT_JIS;
                            case 10002:
                                return "Big5";
                            case 10003:
                                return "EUC-KR";
                            case 10004:
                                return "MacArabic";
                            case 10005:
                                return "MacHebrew";
                            case 10006:
                                return "MacGreek";
                            case CP_MAC_CYRILLIC /* 10007 */:
                                return "MacCyrillic";
                            case CP_MAC_CHINESE_SIMPLE /* 10008 */:
                                return "EUC_CN";
                            default:
                                switch (i5) {
                                    case CP_ISO_8859_1 /* 28591 */:
                                        return z6 ? "ISO8859_1" : "ISO-8859-1";
                                    case CP_ISO_8859_2 /* 28592 */:
                                        return z6 ? "ISO8859_2" : "ISO-8859-2";
                                    case CP_ISO_8859_3 /* 28593 */:
                                        return z6 ? "ISO8859_3" : "ISO-8859-3";
                                    case CP_ISO_8859_4 /* 28594 */:
                                        return z6 ? "ISO8859_4" : "ISO-8859-4";
                                    case CP_ISO_8859_5 /* 28595 */:
                                        return z6 ? "ISO8859_5" : "ISO-8859-5";
                                    case CP_ISO_8859_6 /* 28596 */:
                                        return z6 ? "ISO8859_6" : "ISO-8859-6";
                                    case CP_ISO_8859_7 /* 28597 */:
                                        return z6 ? "ISO8859_7" : "ISO-8859-7";
                                    case CP_ISO_8859_8 /* 28598 */:
                                        return z6 ? "ISO8859_8" : "ISO-8859-8";
                                    case CP_ISO_8859_9 /* 28599 */:
                                        return z6 ? "ISO8859_9" : "ISO-8859-9";
                                    default:
                                        switch (i5) {
                                            case 32768:
                                                return "MacRoman";
                                            case CP_WINDOWS_1252_BIFF23 /* 32769 */:
                                                break;
                                            default:
                                                switch (i5) {
                                                    case CP_ISO_2022_JP1 /* 50220 */:
                                                    case CP_ISO_2022_JP2 /* 50221 */:
                                                    case CP_ISO_2022_JP3 /* 50222 */:
                                                        return "ISO-2022-JP";
                                                    default:
                                                        switch (i5) {
                                                            case CP_US_ASCII2 /* 65000 */:
                                                                return "US-ASCII";
                                                            case CP_UTF8 /* 65001 */:
                                                                return "UTF-8";
                                                            default:
                                                                return AbstractC0157z.k(i5, "cp");
                                                        }
                                                }
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                return z6 ? "Cp1252" : "windows-1252";
        }
    }

    public static String getStringFromCodePage(byte[] bArr, int i5, int i6, int i7) {
        return new String(bArr, i5, i6, codepageToEncoding(i7));
    }
}
