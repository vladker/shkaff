package org.apache.poi.ddf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherPropertyMetaData {
    public static final byte TYPE_ARRAY = 5;
    public static final byte TYPE_BOOLEAN = 1;
    public static final byte TYPE_RGB = 2;
    public static final byte TYPE_SHAPEPATH = 3;
    public static final byte TYPE_SIMPLE = 4;
    public static final byte TYPE_UNKNOWN = 0;
    private String description;
    private byte type;

    public EscherPropertyMetaData(String str) {
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }

    public byte getType() {
        return this.type;
    }

    public EscherPropertyMetaData(String str, byte b) {
        this.description = str;
        this.type = b;
    }
}
