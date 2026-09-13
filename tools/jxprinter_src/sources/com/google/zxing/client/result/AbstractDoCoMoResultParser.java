package com.google.zxing.client.result;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    public static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z6) {
        return ResultParser.matchPrefixedField(str, str2, ';', z6);
    }

    public static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z6) {
        return ResultParser.matchSinglePrefixedField(str, str2, ';', z6);
    }
}
