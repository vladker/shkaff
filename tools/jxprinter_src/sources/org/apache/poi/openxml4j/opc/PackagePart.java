package org.apache.poi.openxml4j.opc;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.internal.ContentType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PackagePart implements RelationshipSource, Comparable<PackagePart> {
    protected OPCPackage _container;
    protected ContentType _contentType;
    private boolean _isDeleted;
    private final boolean _isRelationshipPart;
    protected PackagePartName _partName;
    private PackageRelationshipCollection _relationships;

    public PackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, ContentType contentType) {
        this(oPCPackage, packagePartName, contentType, true);
    }

    private PackageRelationshipCollection getRelationshipsCore(String str) {
        this._container.throwExceptionIfWriteOnly();
        if (this._relationships == null) {
            throwExceptionIfRelationship();
            this._relationships = new PackageRelationshipCollection(this);
        }
        return new PackageRelationshipCollection(this._relationships, str);
    }

    private void throwExceptionIfRelationship() {
        if (this._isRelationshipPart) {
            throw new InvalidOperationException("Can do this operation on a relationship part !");
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addExternalRelationship(String str, String str2) {
        return addExternalRelationship(str, str2, null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str) {
        return addRelationship(packagePartName, targetMode, str, (String) null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public void clearRelationships() {
        PackageRelationshipCollection packageRelationshipCollection = this._relationships;
        if (packageRelationshipCollection != null) {
            packageRelationshipCollection.clear();
        }
    }

    public abstract void close();

    public PackageRelationship findExistingRelation(PackagePart packagePart) {
        return this._relationships.findExistingInternalRelation(packagePart);
    }

    public abstract void flush();

    public String getContentType() {
        return this._contentType.toString();
    }

    public ContentType getContentTypeDetails() {
        return this._contentType;
    }

    public InputStream getInputStream() {
        InputStream inputStreamImpl = getInputStreamImpl();
        if (inputStreamImpl != null) {
            return inputStreamImpl;
        }
        throw new IOException("Can't obtain the input stream from " + this._partName.getName());
    }

    public abstract InputStream getInputStreamImpl();

    public OutputStream getOutputStream() {
        if (!(this instanceof ZipPackagePart)) {
            return getOutputStreamImpl();
        }
        this._container.removePart(this._partName);
        PackagePart packagePartCreatePart = this._container.createPart(this._partName, this._contentType.toString(), false);
        if (packagePartCreatePart == null) {
            throw new InvalidOperationException("Can't create a temporary part !");
        }
        packagePartCreatePart._relationships = this._relationships;
        return packagePartCreatePart.getOutputStreamImpl();
    }

    public abstract OutputStream getOutputStreamImpl();

    public OPCPackage getPackage() {
        return this._container;
    }

    public PackagePartName getPartName() {
        return this._partName;
    }

    public PackagePart getRelatedPart(PackageRelationship packageRelationship) {
        if (!isRelationshipExists(packageRelationship)) {
            throw new IllegalArgumentException("Relationship " + packageRelationship + " doesn't start with this part " + this._partName);
        }
        URI targetURI = packageRelationship.getTargetURI();
        if (targetURI.getFragment() != null) {
            String string = targetURI.toString();
            try {
                targetURI = new URI(string.substring(0, string.indexOf(35)));
            } catch (URISyntaxException unused) {
                throw new InvalidFormatException("Invalid target URI: " + targetURI);
            }
        }
        PackagePart part = this._container.getPart(PackagingURIHelper.createPartName(targetURI));
        if (part != null) {
            return part;
        }
        throw new IllegalArgumentException("No part found for relationship " + packageRelationship);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship getRelationship(String str) {
        return this._relationships.getRelationshipByID(str);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationshipCollection getRelationships() {
        return getRelationshipsCore(null);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationshipCollection getRelationshipsByType(String str) {
        this._container.throwExceptionIfWriteOnly();
        return getRelationshipsCore(str);
    }

    public long getSize() {
        return -1L;
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public boolean hasRelationships() {
        PackageRelationshipCollection packageRelationshipCollection;
        return (this._isRelationshipPart || (packageRelationshipCollection = this._relationships) == null || packageRelationshipCollection.isEmpty()) ? false : true;
    }

    public boolean isDeleted() {
        return this._isDeleted;
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public boolean isRelationshipExists(PackageRelationship packageRelationship) {
        return (packageRelationship == null || this._relationships.getRelationshipByID(packageRelationship.getId()) == null) ? false : true;
    }

    public boolean isRelationshipPart() {
        return this._isRelationshipPart;
    }

    public abstract boolean load(InputStream inputStream);

    public void loadRelationships() {
        if (this._relationships != null || this._isRelationshipPart) {
            return;
        }
        throwExceptionIfRelationship();
        this._relationships = new PackageRelationshipCollection(this);
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public void removeRelationship(String str) {
        this._container.throwExceptionIfReadOnly();
        PackageRelationshipCollection packageRelationshipCollection = this._relationships;
        if (packageRelationshipCollection != null) {
            packageRelationshipCollection.removeRelationship(str);
        }
    }

    public abstract boolean save(OutputStream outputStream);

    public void setContentType(String str) {
        OPCPackage oPCPackage = this._container;
        if (oPCPackage == null) {
            this._contentType = new ContentType(str);
            return;
        }
        oPCPackage.unregisterPartAndContentType(this._partName);
        this._contentType = new ContentType(str);
        this._container.registerPartAndContentType(this);
    }

    public void setDeleted(boolean z6) {
        this._isDeleted = z6;
    }

    public String toString() {
        return "Name: " + this._partName + " - Content Type: " + this._contentType;
    }

    public PackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, ContentType contentType, boolean z6) {
        this._partName = packagePartName;
        this._contentType = contentType;
        this._container = oPCPackage;
        this._isRelationshipPart = packagePartName.isRelationshipPartURI();
        if (z6) {
            loadRelationships();
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addExternalRelationship(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException(AbstractC0157z.n("target is null for type ", str2));
        }
        if (str2 == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this._relationships == null) {
            this._relationships = new PackageRelationshipCollection();
        }
        try {
            return this._relationships.addRelationship(new URI(str), TargetMode.EXTERNAL, str2, str3);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid target - " + e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.RelationshipSource
    public PackageRelationship addRelationship(PackagePartName packagePartName, TargetMode targetMode, String str, String str2) {
        this._container.throwExceptionIfReadOnly();
        if (packagePartName == null) {
            throw new IllegalArgumentException("targetPartName");
        }
        if (targetMode == null) {
            throw new IllegalArgumentException("targetMode");
        }
        if (str == null) {
            throw new IllegalArgumentException("relationshipType");
        }
        if (this._isRelationshipPart || packagePartName.isRelationshipPartURI()) {
            throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        if (this._relationships == null) {
            this._relationships = new PackageRelationshipCollection();
        }
        return this._relationships.addRelationship(packagePartName.getURI(), targetMode, str, str2);
    }

    @Override // java.lang.Comparable
    public int compareTo(PackagePart packagePart) {
        if (packagePart == null) {
            return -1;
        }
        return PackagePartName.compare(this._partName, packagePart._partName);
    }

    public PackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str) {
        this(oPCPackage, packagePartName, new ContentType(str));
    }

    public PackageRelationship addRelationship(URI uri, TargetMode targetMode, String str) {
        return addRelationship(uri, targetMode, str, (String) null);
    }

    public PackageRelationship addRelationship(URI uri, TargetMode targetMode, String str, String str2) {
        this._container.throwExceptionIfReadOnly();
        if (uri == null) {
            throw new IllegalArgumentException("targetPartName");
        }
        if (targetMode == null) {
            throw new IllegalArgumentException("targetMode");
        }
        if (str != null) {
            if (!this._isRelationshipPart && !PackagingURIHelper.isRelationshipPartURI(uri)) {
                if (this._relationships == null) {
                    this._relationships = new PackageRelationshipCollection();
                }
                return this._relationships.addRelationship(uri, targetMode, str, str2);
            }
            throw new InvalidOperationException("Rule M1.25: The Relationships part shall not have relationships to any other part.");
        }
        throw new IllegalArgumentException("relationshipType");
    }

    public void clear() {
    }
}
