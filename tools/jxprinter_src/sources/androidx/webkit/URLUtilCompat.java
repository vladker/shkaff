package androidx.webkit;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.alibaba.android.arouter.utils.Consts;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class URLUtilCompat {
    private static final Pattern DISPOSITION_PATTERN = Pattern.compile("\\s*(\\S+?) # Group 1: parameter name\n\\s*=\\s* # Match equals sign\n(?: # non-capturing group of options\n   '( (?: [^'\\\\] | \\\\. )* )' # Group 2: single-quoted\n | \"( (?: [^\"\\\\] | \\\\. )*  )\" # Group 3: double-quoted\n | ( [^'\"][^;\\s]* ) # Group 4: un-quoted parameter\n)\\s*;? # Optional end semicolon", 4);

    private URLUtilCompat() {
    }

    private static String encodePlusCharacters(String str, String str2) {
        Charset charsetForName = Charset.forName(str2);
        StringBuilder sb = new StringBuilder();
        for (byte b : charsetForName.encode("+").array()) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return str.replaceAll("\\+", sb.toString());
    }

    private static boolean extensionDifferentFromMimeType(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(46) + 1));
        return (mimeTypeFromExtension == null || mimeTypeFromExtension.equalsIgnoreCase(str2)) ? false : true;
    }

    public static String getFilenameFromContentDisposition(String str) {
        String strRemoveSlashEscapes;
        String[] strArrSplit = str.trim().split(";", 2);
        String extValueString = null;
        if (strArrSplit.length < 2 || "inline".equalsIgnoreCase(strArrSplit[0].trim())) {
            return null;
        }
        Matcher matcher = DISPOSITION_PATTERN.matcher(strArrSplit[1]);
        String str2 = null;
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (matcher.group(2) != null) {
                strRemoveSlashEscapes = removeSlashEscapes(matcher.group(2));
            } else {
                strRemoveSlashEscapes = matcher.group(3) != null ? removeSlashEscapes(matcher.group(3)) : matcher.group(4);
            }
            if (strGroup != null && strRemoveSlashEscapes != null) {
                if ("filename*".equalsIgnoreCase(strGroup)) {
                    extValueString = parseExtValueString(strRemoveSlashEscapes);
                } else if ("filename".equalsIgnoreCase(strGroup)) {
                    str2 = strRemoveSlashEscapes;
                }
            }
        }
        return extValueString != null ? extValueString : str2;
    }

    public static String guessFileName(String str, String str2, String str3) {
        String lastPathSegment;
        String filenameFromContentDisposition;
        if (str2 != null && (filenameFromContentDisposition = getFilenameFromContentDisposition(str2)) != null) {
            return replacePathSeparators(filenameFromContentDisposition);
        }
        Uri uri = Uri.parse(str);
        String strReplacePathSeparators = (uri == null || (lastPathSegment = uri.getLastPathSegment()) == null) ? "downloadfile" : replacePathSeparators(lastPathSegment);
        return (strReplacePathSeparators.indexOf(46) < 0 || extensionDifferentFromMimeType(strReplacePathSeparators, str3)) ? androidx.collection.a.n(strReplacePathSeparators, suggestExtensionFromMimeType(str3)) : strReplacePathSeparators;
    }

    private static String parseExtValueString(String str) {
        String[] strArrSplit = str.split("'", 3);
        if (strArrSplit.length < 3) {
            return null;
        }
        String str2 = strArrSplit[0];
        try {
            return URLDecoder.decode(encodePlusCharacters(strArrSplit[2], str2), str2);
        } catch (UnsupportedEncodingException | RuntimeException unused) {
            return null;
        }
    }

    private static String removeSlashEscapes(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\\\(.)", "$1");
    }

    private static String replacePathSeparators(String str) {
        return str.replaceAll(PackagingURIHelper.FORWARD_SLASH_STRING, "_");
    }

    private static String suggestExtensionFromMimeType(String str) {
        String extensionFromMimeType;
        if (str == null) {
            return "";
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        return (lowerCase.equals("application/octet-stream") || (extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(lowerCase)) == null) ? "" : Consts.DOT.concat(extensionFromMimeType);
    }
}
