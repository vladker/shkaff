package org.apache.poi.poifs.crypt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum ChainingMode {
    ecb("ECB", 1, null),
    cbc("CBC", 2, "ChainingModeCBC"),
    cfb("CFB8", 3, "ChainingModeCFB");

    public final int ecmaId;
    public final String jceId;
    public final String xmlId;

    ChainingMode(String str, int i5, String str2) {
        this.jceId = str;
        this.ecmaId = i5;
        this.xmlId = str2;
    }

    public static ChainingMode fromXmlId(String str) {
        for (ChainingMode chainingMode : values()) {
            String str2 = chainingMode.xmlId;
            if (str2 != null && str2.equals(str)) {
                return chainingMode;
            }
        }
        return null;
    }
}
