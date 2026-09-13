package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPictureLocking extends XmlObject {
    public static final DocumentFactory<CTPictureLocking> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPictureLocking> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpicturelockinga414type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getNoAdjustHandles();

    boolean getNoChangeArrowheads();

    boolean getNoChangeAspect();

    boolean getNoChangeShapeType();

    boolean getNoCrop();

    boolean getNoEditPoints();

    boolean getNoGrp();

    boolean getNoMove();

    boolean getNoResize();

    boolean getNoRot();

    boolean getNoSelect();

    boolean isSetExtLst();

    boolean isSetNoAdjustHandles();

    boolean isSetNoChangeArrowheads();

    boolean isSetNoChangeAspect();

    boolean isSetNoChangeShapeType();

    boolean isSetNoCrop();

    boolean isSetNoEditPoints();

    boolean isSetNoGrp();

    boolean isSetNoMove();

    boolean isSetNoResize();

    boolean isSetNoRot();

    boolean isSetNoSelect();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setNoAdjustHandles(boolean z6);

    void setNoChangeArrowheads(boolean z6);

    void setNoChangeAspect(boolean z6);

    void setNoChangeShapeType(boolean z6);

    void setNoCrop(boolean z6);

    void setNoEditPoints(boolean z6);

    void setNoGrp(boolean z6);

    void setNoMove(boolean z6);

    void setNoResize(boolean z6);

    void setNoRot(boolean z6);

    void setNoSelect(boolean z6);

    void unsetExtLst();

    void unsetNoAdjustHandles();

    void unsetNoChangeArrowheads();

    void unsetNoChangeAspect();

    void unsetNoChangeShapeType();

    void unsetNoCrop();

    void unsetNoEditPoints();

    void unsetNoGrp();

    void unsetNoMove();

    void unsetNoResize();

    void unsetNoRot();

    void unsetNoSelect();

    XmlBoolean xgetNoAdjustHandles();

    XmlBoolean xgetNoChangeArrowheads();

    XmlBoolean xgetNoChangeAspect();

    XmlBoolean xgetNoChangeShapeType();

    XmlBoolean xgetNoCrop();

    XmlBoolean xgetNoEditPoints();

    XmlBoolean xgetNoGrp();

    XmlBoolean xgetNoMove();

    XmlBoolean xgetNoResize();

    XmlBoolean xgetNoRot();

    XmlBoolean xgetNoSelect();

    void xsetNoAdjustHandles(XmlBoolean xmlBoolean);

    void xsetNoChangeArrowheads(XmlBoolean xmlBoolean);

    void xsetNoChangeAspect(XmlBoolean xmlBoolean);

    void xsetNoChangeShapeType(XmlBoolean xmlBoolean);

    void xsetNoCrop(XmlBoolean xmlBoolean);

    void xsetNoEditPoints(XmlBoolean xmlBoolean);

    void xsetNoGrp(XmlBoolean xmlBoolean);

    void xsetNoMove(XmlBoolean xmlBoolean);

    void xsetNoResize(XmlBoolean xmlBoolean);

    void xsetNoRot(XmlBoolean xmlBoolean);

    void xsetNoSelect(XmlBoolean xmlBoolean);
}
