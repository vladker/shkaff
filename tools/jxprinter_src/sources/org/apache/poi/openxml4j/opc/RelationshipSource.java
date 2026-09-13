package org.apache.poi.openxml4j.opc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface RelationshipSource {
    PackageRelationship addExternalRelationship(String str, String str2);

    PackageRelationship addExternalRelationship(String str, String str2, String str3);

    PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str);

    PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str, String str2);

    void clearRelationships();

    PackageRelationship getRelationship(String str);

    PackageRelationshipCollection getRelationships();

    PackageRelationshipCollection getRelationshipsByType(String str);

    boolean hasRelationships();

    boolean isRelationshipExists(PackageRelationship packageRelationship);

    void removeRelationship(String str);
}
