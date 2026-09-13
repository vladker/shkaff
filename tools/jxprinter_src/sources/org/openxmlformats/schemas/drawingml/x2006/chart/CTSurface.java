package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTSurface extends XmlObject {
    public static final DocumentFactory<CTSurface> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSurface> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsurface5a19type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTPictureOptions addNewPictureOptions();

    CTShapeProperties addNewSpPr();

    CTThickness addNewThickness();

    CTExtensionList getExtLst();

    CTPictureOptions getPictureOptions();

    CTShapeProperties getSpPr();

    CTThickness getThickness();

    boolean isSetExtLst();

    boolean isSetPictureOptions();

    boolean isSetSpPr();

    boolean isSetThickness();

    void setExtLst(CTExtensionList cTExtensionList);

    void setPictureOptions(CTPictureOptions cTPictureOptions);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setThickness(CTThickness cTThickness);

    void unsetExtLst();

    void unsetPictureOptions();

    void unsetSpPr();

    void unsetThickness();
}
