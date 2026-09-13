package org.apache.commons.compress.utils;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FileNameUtils {
    public static String getBaseName(String str) {
        if (str == null) {
            return null;
        }
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 0 ? name : name.substring(0, iLastIndexOf);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 0 ? "" : name.substring(iLastIndexOf + 1);
    }
}
