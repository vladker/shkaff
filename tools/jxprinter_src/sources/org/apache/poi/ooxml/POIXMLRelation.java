package org.apache.poi.ooxml;

import java.io.InputStream;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class POIXMLRelation {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) POIXMLRelation.class);
    private final String _defaultName;
    private final String _relation;
    private final String _type;
    private final NoArgConstructor noArgConstructor;
    private final PackagePartConstructor packagePartConstructor;
    private final ParentPartConstructor parentPartConstructor;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Internal
    public interface NoArgConstructor {
        POIXMLDocumentPart init();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Internal
    public interface PackagePartConstructor {
        POIXMLDocumentPart init(PackagePart packagePart);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Internal
    public interface ParentPartConstructor {
        POIXMLDocumentPart init(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart);
    }

    public POIXMLRelation(String str, String str2, String str3, NoArgConstructor noArgConstructor, PackagePartConstructor packagePartConstructor, ParentPartConstructor parentPartConstructor) {
        this._type = str;
        this._relation = str2;
        this._defaultName = str3;
        this.noArgConstructor = noArgConstructor;
        this.packagePartConstructor = packagePartConstructor;
        this.parentPartConstructor = parentPartConstructor;
    }

    public String getContentType() {
        return this._type;
    }

    public InputStream getContents(PackagePart packagePart) {
        Iterator<PackageRelationship> it = packagePart.getRelationshipsByType(getRelation()).iterator();
        if (it.hasNext()) {
            return packagePart.getPackage().getPart(PackagingURIHelper.createPartName(it.next().getTargetURI())).getInputStream();
        }
        LOGGER.atWarn().log("No part {} found", getDefaultFileName());
        return null;
    }

    public String getDefaultFileName() {
        return this._defaultName;
    }

    public String getFileName(int i5) {
        return !this._defaultName.contains("#") ? getDefaultFileName() : this._defaultName.replace("#", Integer.toString(i5));
    }

    public Integer getFileNameIndex(POIXMLDocumentPart pOIXMLDocumentPart) {
        return Integer.valueOf(pOIXMLDocumentPart.getPackagePart().getPartName().getName().replaceAll(this._defaultName.replace("#", "(\\d+)"), "$1"));
    }

    public NoArgConstructor getNoArgConstructor() {
        return this.noArgConstructor;
    }

    public PackagePartConstructor getPackagePartConstructor() {
        return this.packagePartConstructor;
    }

    public ParentPartConstructor getParentPartConstructor() {
        return this.parentPartConstructor;
    }

    public String getRelation() {
        return this._relation;
    }

    public POIXMLRelation(String str, String str2, String str3) {
        this(str, str2, str3, null, null, null);
    }
}
