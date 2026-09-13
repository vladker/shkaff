package org.apache.commons.compress.compressors;

import androidx.collection.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileNameUtil {
    private final Map<String, String> compressSuffix = new HashMap();
    private final String defaultExtension;
    private final int longestCompressedSuffix;
    private final int longestUncompressedSuffix;
    private final int shortestCompressedSuffix;
    private final int shortestUncompressedSuffix;
    private final Map<String, String> uncompressSuffix;

    public FileNameUtil(Map<String, String> map, String str) {
        this.uncompressSuffix = Collections.unmodifiableMap(map);
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MIN_VALUE;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            int length = entry.getKey().length();
            i5 = length > i5 ? length : i5;
            i6 = length < i6 ? length : i6;
            String value = entry.getValue();
            int length2 = value.length();
            if (length2 > 0) {
                if (!this.compressSuffix.containsKey(value)) {
                    this.compressSuffix.put(value, entry.getKey());
                }
                i8 = length2 > i8 ? length2 : i8;
                if (length2 < i7) {
                    i7 = length2;
                }
            }
        }
        this.longestCompressedSuffix = i5;
        this.longestUncompressedSuffix = i8;
        this.shortestCompressedSuffix = i6;
        this.shortestUncompressedSuffix = i7;
        this.defaultExtension = str;
    }

    public String getCompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        for (int i5 = this.shortestUncompressedSuffix; i5 <= this.longestUncompressedSuffix && i5 < length; i5++) {
            int i6 = length - i5;
            String str2 = this.compressSuffix.get(lowerCase.substring(i6));
            if (str2 != null) {
                return str.substring(0, i6) + str2;
            }
        }
        StringBuilder sbR = a.r(str);
        sbR.append(this.defaultExtension);
        return sbR.toString();
    }

    public String getUncompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        for (int i5 = this.shortestCompressedSuffix; i5 <= this.longestCompressedSuffix && i5 < length; i5++) {
            int i6 = length - i5;
            String str2 = this.uncompressSuffix.get(lowerCase.substring(i6));
            if (str2 != null) {
                return str.substring(0, i6) + str2;
            }
        }
        return str;
    }

    public boolean isCompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        for (int i5 = this.shortestCompressedSuffix; i5 <= this.longestCompressedSuffix && i5 < length; i5++) {
            if (this.uncompressSuffix.containsKey(lowerCase.substring(length - i5))) {
                return true;
            }
        }
        return false;
    }
}
