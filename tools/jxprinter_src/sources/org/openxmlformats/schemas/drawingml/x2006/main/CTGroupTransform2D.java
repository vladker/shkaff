package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTGroupTransform2D extends XmlObject {
    public static final DocumentFactory<CTGroupTransform2D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGroupTransform2D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgrouptransform2d411atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPositiveSize2D addNewChExt();

    CTPoint2D addNewChOff();

    CTPositiveSize2D addNewExt();

    CTPoint2D addNewOff();

    CTPositiveSize2D getChExt();

    CTPoint2D getChOff();

    CTPositiveSize2D getExt();

    boolean getFlipH();

    boolean getFlipV();

    CTPoint2D getOff();

    int getRot();

    boolean isSetChExt();

    boolean isSetChOff();

    boolean isSetExt();

    boolean isSetFlipH();

    boolean isSetFlipV();

    boolean isSetOff();

    boolean isSetRot();

    void setChExt(CTPositiveSize2D cTPositiveSize2D);

    void setChOff(CTPoint2D cTPoint2D);

    void setExt(CTPositiveSize2D cTPositiveSize2D);

    void setFlipH(boolean z6);

    void setFlipV(boolean z6);

    void setOff(CTPoint2D cTPoint2D);

    void setRot(int i5);

    void unsetChExt();

    void unsetChOff();

    void unsetExt();

    void unsetFlipH();

    void unsetFlipV();

    void unsetOff();

    void unsetRot();

    XmlBoolean xgetFlipH();

    XmlBoolean xgetFlipV();

    STAngle xgetRot();

    void xsetFlipH(XmlBoolean xmlBoolean);

    void xsetFlipV(XmlBoolean xmlBoolean);

    void xsetRot(STAngle sTAngle);
}
