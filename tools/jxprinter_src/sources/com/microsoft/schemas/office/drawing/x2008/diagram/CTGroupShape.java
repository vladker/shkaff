package com.microsoft.schemas.office.drawing.x2008.diagram;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTGroupShape extends XmlObject {
    public static final DocumentFactory<CTGroupShape> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGroupShape> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgroupshape48cbtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTGroupShape addNewGrpSp();

    CTGroupShapeProperties addNewGrpSpPr();

    CTGroupShapeNonVisual addNewNvGrpSpPr();

    CTShape addNewSp();

    CTOfficeArtExtensionList getExtLst();

    CTGroupShape getGrpSpArray(int i5);

    CTGroupShape[] getGrpSpArray();

    List<CTGroupShape> getGrpSpList();

    CTGroupShapeProperties getGrpSpPr();

    CTGroupShapeNonVisual getNvGrpSpPr();

    CTShape getSpArray(int i5);

    CTShape[] getSpArray();

    List<CTShape> getSpList();

    CTGroupShape insertNewGrpSp(int i5);

    CTShape insertNewSp(int i5);

    boolean isSetExtLst();

    void removeGrpSp(int i5);

    void removeSp(int i5);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGrpSpArray(int i5, CTGroupShape cTGroupShape);

    void setGrpSpArray(CTGroupShape[] cTGroupShapeArr);

    void setGrpSpPr(CTGroupShapeProperties cTGroupShapeProperties);

    void setNvGrpSpPr(CTGroupShapeNonVisual cTGroupShapeNonVisual);

    void setSpArray(int i5, CTShape cTShape);

    void setSpArray(CTShape[] cTShapeArr);

    int sizeOfGrpSpArray();

    int sizeOfSpArray();

    void unsetExtLst();
}
