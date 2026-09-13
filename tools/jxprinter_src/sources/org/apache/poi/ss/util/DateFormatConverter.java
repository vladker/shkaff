package org.apache.poi.ss.util;

import androidx.exifinterface.media.ExifInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.util.LocaleID;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DateFormatConverter {
    private static final Logger LOG = LogManager.getLogger((Class<?>) DateFormatConverter.class);
    private static Map<String, String> tokenConversions = prepareTokenConversions();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DateFormatTokenizer {
        String format;
        int pos;

        public DateFormatTokenizer(String str) {
            this.format = str;
        }

        public static String[] tokenize(String str) {
            ArrayList arrayList = new ArrayList();
            DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(str);
            while (true) {
                String nextToken = dateFormatTokenizer.getNextToken();
                if (nextToken == null) {
                    return (String[]) arrayList.toArray(new String[0]);
                }
                arrayList.add(nextToken);
            }
        }

        public String getNextToken() {
            if (this.pos >= this.format.length()) {
                return null;
            }
            int i5 = this.pos;
            char cCharAt = this.format.charAt(i5);
            this.pos++;
            if (cCharAt == '\'') {
                while (this.pos < this.format.length() && this.format.charAt(this.pos) != '\'') {
                    this.pos++;
                }
                if (this.pos < this.format.length()) {
                    this.pos++;
                }
            } else {
                while (this.pos < this.format.length() && this.format.charAt(this.pos) == cCharAt) {
                    this.pos++;
                }
            }
            return this.format.substring(i5, this.pos);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(this.format);
            while (true) {
                String nextToken = dateFormatTokenizer.getNextToken();
                if (nextToken == null) {
                    return sb.toString();
                }
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                androidx.collection.a.x(sb, "[", nextToken, "]");
            }
        }
    }

    private DateFormatConverter() {
    }

    public static String convert(Locale locale, DateFormat dateFormat) {
        return convert(locale, ((SimpleDateFormat) dateFormat).toPattern());
    }

    public static String getJavaDatePattern(int i5, Locale locale) {
        DateFormat dateInstance = DateFormat.getDateInstance(i5, locale);
        if (dateInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateInstance).toPattern();
        }
        if (i5 == 0) {
            return "dddd, MMMM d, yyyy";
        }
        if (i5 != 1) {
            return i5 != 3 ? "MMM d, yyyy" : "d/MM/yy";
        }
        return "MMMM d, yyyy";
    }

    public static String getJavaDateTimePattern(int i5, Locale locale) {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(i5, i5, locale);
        if (dateTimeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateTimeInstance).toPattern();
        }
        if (i5 == 0) {
            return "dddd, MMMM d, yyyy h:mm:ss a";
        }
        if (i5 != 1) {
            return i5 != 3 ? "MMM d, yyyy h:mm:ss a" : "M/d/yy h:mm a";
        }
        return "MMMM d, yyyy h:mm:ss a";
    }

    public static String getJavaTimePattern(int i5, Locale locale) {
        DateFormat timeInstance = DateFormat.getTimeInstance(i5, locale);
        if (timeInstance instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) timeInstance).toPattern();
        }
        return i5 != 3 ? "h:mm:ss a" : "h:mm a";
    }

    public static String getPrefixForLocale(Locale locale) {
        String languageTag = locale.toLanguageTag();
        if (Locale.ROOT.equals(locale) || "".equals(languageTag)) {
            return "";
        }
        LocaleID localeIDLookupByLanguageTag = LocaleID.lookupByLanguageTag(languageTag);
        if (localeIDLookupByLanguageTag == null) {
            String strReplace = languageTag.indexOf(95) > -1 ? languageTag.replace(NameUtil.USCORE, '-') : languageTag;
            int length = languageTag.length();
            while (localeIDLookupByLanguageTag == null) {
                length = strReplace.lastIndexOf(45, length - 1);
                if (length <= 0) {
                    break;
                }
                localeIDLookupByLanguageTag = LocaleID.lookupByLanguageTag(languageTag.substring(0, length));
            }
        }
        if (localeIDLookupByLanguageTag != null) {
            return String.format(Locale.ROOT, "[$-%04X]", Integer.valueOf(localeIDLookupByLanguageTag.getLcid()));
        }
        LOG.atError().log("Unable to find prefix for Locale '{}' or its parent locales.", languageTag);
        return "";
    }

    private static Map<String, String> prepareTokenConversions() {
        HashMap map = new HashMap();
        map.put("EEEE", "dddd");
        map.put("EEE", "ddd");
        map.put("EE", "ddd");
        map.put(ExifInterface.LONGITUDE_EAST, "d");
        map.put("Z", "");
        map.put(CompressorStreamFactory.f6702Z, "");
        map.put("a", "am/pm");
        map.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "AM/PM");
        map.put("K", "H");
        map.put("KK", "HH");
        map.put("k", "h");
        map.put("kk", "hh");
        map.put(ExifInterface.LATITUDE_SOUTH, "0");
        map.put("SS", TarConstants.VERSION_POSIX);
        map.put("SSS", "000");
        map.put("y", "yyyy");
        return map;
    }

    public static String convert(Locale locale, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefixForLocale(locale));
        DateFormatTokenizer dateFormatTokenizer = new DateFormatTokenizer(str);
        while (true) {
            String nextToken = dateFormatTokenizer.getNextToken();
            if (nextToken != null) {
                if (nextToken.startsWith("'")) {
                    sb.append(nextToken.replace(Chars.QUOTE, Chars.DQUOTE));
                } else if (!Character.isLetter(nextToken.charAt(0))) {
                    sb.append(nextToken);
                } else {
                    String str2 = tokenConversions.get(nextToken);
                    if (str2 != null) {
                        nextToken = str2;
                    }
                    sb.append(nextToken);
                }
            } else {
                sb.append(";@");
                return sb.toString().trim();
            }
        }
    }
}
