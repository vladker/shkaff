package org.apache.poi.openxml4j.opc;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PackageRelationship {
    public static final String ID_ATTRIBUTE_NAME = "Id";
    public static final String RELATIONSHIPS_TAG_NAME = "Relationships";
    public static final String RELATIONSHIP_TAG_NAME = "Relationship";
    public static final String TARGET_ATTRIBUTE_NAME = "Target";
    public static final String TARGET_MODE_ATTRIBUTE_NAME = "TargetMode";
    public static final String TYPE_ATTRIBUTE_NAME = "Type";
    private static URI containerRelationshipPart;
    private final OPCPackage container;
    private final String id;
    private final String relationshipType;
    private final PackagePart source;
    private final TargetMode targetMode;
    private final URI targetUri;

    static {
        try {
            containerRelationshipPart = new URI("/_rels/.rels");
        } catch (URISyntaxException unused) {
        }
    }

    public PackageRelationship(OPCPackage oPCPackage, PackagePart packagePart, URI uri, TargetMode targetMode, String str, String str2) {
        if (oPCPackage == null) {
            throw new IllegalArgumentException("pkg");
        }
        if (uri == null) {
            throw new IllegalArgumentException("targetUri");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("id");
        }
        this.container = oPCPackage;
        this.source = packagePart;
        this.targetUri = uri;
        this.targetMode = targetMode;
        this.relationshipType = str;
        this.id = str2;
    }

    public static URI getContainerPartRelationship() {
        return containerRelationshipPart;
    }

    public boolean equals(Object obj) {
        PackagePart packagePart;
        if (!(obj instanceof PackageRelationship)) {
            return false;
        }
        PackageRelationship packageRelationship = (PackageRelationship) obj;
        return this.id.equals(packageRelationship.id) && this.relationshipType.equals(packageRelationship.relationshipType) && ((packagePart = packageRelationship.source) == null || packagePart.equals(this.source)) && this.targetMode == packageRelationship.targetMode && this.targetUri.equals(packageRelationship.targetUri);
    }

    public String getId() {
        return this.id;
    }

    public OPCPackage getPackage() {
        return this.container;
    }

    public String getRelationshipType() {
        return this.relationshipType;
    }

    public PackagePart getSource() {
        return this.source;
    }

    public URI getSourceURI() {
        PackagePart packagePart = this.source;
        return packagePart == null ? PackagingURIHelper.PACKAGE_ROOT_URI : packagePart._partName.getURI();
    }

    public TargetMode getTargetMode() {
        return this.targetMode;
    }

    public URI getTargetURI() {
        if (this.targetMode == TargetMode.EXTERNAL) {
            return this.targetUri;
        }
        return !this.targetUri.toASCIIString().startsWith(PackagingURIHelper.FORWARD_SLASH_STRING) ? PackagingURIHelper.resolvePartUri(getSourceURI(), this.targetUri) : this.targetUri;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.relationshipType, this.source, this.targetMode, this.targetUri);
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("id=");
        sb.append(this.id);
        sb.append(" - container=");
        sb.append(this.container);
        sb.append(" - relationshipType=");
        sb.append(this.relationshipType);
        if (this.source == null) {
            str = " - source=null";
        } else {
            str = " - source=" + getSourceURI().toASCIIString();
        }
        sb.append(str);
        sb.append(" - target=");
        sb.append(getTargetURI().toASCIIString());
        if (this.targetMode == null) {
            str2 = ",targetMode=null";
        } else {
            str2 = ",targetMode=" + this.targetMode;
        }
        sb.append(str2);
        return sb.toString();
    }
}
