package androidx.profileinstaller;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j6) {
        this.mValue = j6;
    }

    public static FileSectionType fromValue(long j6) {
        FileSectionType[] fileSectionTypeArrValues = values();
        for (int i5 = 0; i5 < fileSectionTypeArrValues.length; i5++) {
            if (fileSectionTypeArrValues[i5].getValue() == j6) {
                return fileSectionTypeArrValues[i5];
            }
        }
        throw new IllegalArgumentException(androidx.collection.a.j(j6, "Unsupported FileSection Type "));
    }

    public long getValue() {
        return this.mValue;
    }
}
