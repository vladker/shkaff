package org.apache.poi.ooxml;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class POIXMLFactory {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) POIXMLFactory.class);

    public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        PackageRelationship packageRelationship = getPackageRelationship(pOIXMLDocumentPart, packagePart);
        String relationshipType = packageRelationship.getRelationshipType();
        POIXMLRelation descriptor = getDescriptor(relationshipType);
        if (descriptor != null) {
            try {
                if (!POIXMLDocument.PACK_OBJECT_REL_TYPE.equals(relationshipType)) {
                    POIXMLRelation.ParentPartConstructor parentPartConstructor = descriptor.getParentPartConstructor();
                    if (parentPartConstructor != null) {
                        return parentPartConstructor.init(pOIXMLDocumentPart, packagePart);
                    }
                    POIXMLRelation.PackagePartConstructor packagePartConstructor = descriptor.getPackagePartConstructor();
                    if (packagePartConstructor != null) {
                        return packagePartConstructor.init(packagePart);
                    }
                }
            } catch (IOException e) {
                e = e;
                throw new POIXMLException(e.getMessage(), e);
            } catch (XmlException e6) {
                e = e6;
                throw new POIXMLException(e.getMessage(), e);
            }
        }
        LOGGER.atDebug().log("using default POIXMLDocumentPart for {}", packageRelationship.getRelationshipType());
        return new POIXMLDocumentPart(pOIXMLDocumentPart, packagePart);
    }

    public abstract POIXMLRelation getDescriptor(String str);

    public PackageRelationship getPackageRelationship(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        try {
            String name = packagePart.getPartName().getName();
            for (PackageRelationship packageRelationship : pOIXMLDocumentPart.getPackagePart().getRelationships()) {
                if (packageRelationship.getTargetURI().toASCIIString().equalsIgnoreCase(name)) {
                    return packageRelationship;
                }
            }
            throw new POIXMLException("package part isn't a child of the parent document.");
        } catch (InvalidFormatException e) {
            throw new POIXMLException("error while determining package relations", e);
        }
    }

    public POIXMLDocumentPart newDocumentPart(POIXMLRelation pOIXMLRelation) {
        if (pOIXMLRelation == null || pOIXMLRelation.getNoArgConstructor() == null) {
            throw new POIXMLException("can't initialize POIXMLDocumentPart");
        }
        return pOIXMLRelation.getNoArgConstructor().init();
    }
}
