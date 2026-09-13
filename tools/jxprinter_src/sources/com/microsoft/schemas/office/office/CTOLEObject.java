package com.microsoft.schemas.office.office;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTOLEObject extends XmlObject {
    public static final DocumentFactory<CTOLEObject> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOLEObject> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctoleobjecte5c0type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STOLEDrawAspect.Enum getDrawAspect();

    String getFieldCodes();

    String getId();

    String getLinkType();

    STTrueFalseBlank.Enum getLockedField();

    String getObjectID();

    String getProgID();

    String getShapeID();

    STOLEType.Enum getType();

    STOLEUpdateMode$Enum getUpdateMode();

    boolean isSetDrawAspect();

    boolean isSetFieldCodes();

    boolean isSetId();

    boolean isSetLinkType();

    boolean isSetLockedField();

    boolean isSetObjectID();

    boolean isSetProgID();

    boolean isSetShapeID();

    boolean isSetType();

    boolean isSetUpdateMode();

    void setDrawAspect(STOLEDrawAspect.Enum r6);

    void setFieldCodes(String str);

    void setId(String str);

    void setLinkType(String str);

    void setLockedField(STTrueFalseBlank.Enum r6);

    void setObjectID(String str);

    void setProgID(String str);

    void setShapeID(String str);

    void setType(STOLEType.Enum r6);

    void setUpdateMode(STOLEUpdateMode$Enum sTOLEUpdateMode$Enum);

    void unsetDrawAspect();

    void unsetFieldCodes();

    void unsetId();

    void unsetLinkType();

    void unsetLockedField();

    void unsetObjectID();

    void unsetProgID();

    void unsetShapeID();

    void unsetType();

    void unsetUpdateMode();

    STOLEDrawAspect xgetDrawAspect();

    XmlString xgetFieldCodes();

    STRelationshipId xgetId();

    STOLELinkType xgetLinkType();

    STTrueFalseBlank xgetLockedField();

    XmlString xgetObjectID();

    XmlString xgetProgID();

    XmlString xgetShapeID();

    STOLEType xgetType();

    STOLEUpdateMode xgetUpdateMode();

    void xsetDrawAspect(STOLEDrawAspect sTOLEDrawAspect);

    void xsetFieldCodes(XmlString xmlString);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetLinkType(STOLELinkType sTOLELinkType);

    void xsetLockedField(STTrueFalseBlank sTTrueFalseBlank);

    void xsetObjectID(XmlString xmlString);

    void xsetProgID(XmlString xmlString);

    void xsetShapeID(XmlString xmlString);

    void xsetType(STOLEType sTOLEType);

    void xsetUpdateMode(STOLEUpdateMode sTOLEUpdateMode);
}
