package org.apache.xmlbeans;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SchemaLocalAttribute extends SchemaField, SchemaAnnotated {
    public static final int OPTIONAL = 2;
    public static final int PROHIBITED = 1;
    public static final int REQUIRED = 3;

    int getUse();
}
