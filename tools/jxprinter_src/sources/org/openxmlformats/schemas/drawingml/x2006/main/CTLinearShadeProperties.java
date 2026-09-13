package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTLinearShadeProperties extends XmlObject {
    public static final DocumentFactory<CTLinearShadeProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLinearShadeProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlinearshadeproperties7f0ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    int getAng();

    boolean getScaled();

    boolean isSetAng();

    boolean isSetScaled();

    void setAng(int i5);

    void setScaled(boolean z6);

    void unsetAng();

    void unsetScaled();

    STPositiveFixedAngle xgetAng();

    XmlBoolean xgetScaled();

    void xsetAng(STPositiveFixedAngle sTPositiveFixedAngle);

    void xsetScaled(XmlBoolean xmlBoolean);
}
