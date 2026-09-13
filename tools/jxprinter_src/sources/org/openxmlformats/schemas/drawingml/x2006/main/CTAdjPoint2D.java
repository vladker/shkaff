package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTAdjPoint2D extends XmlObject {
    public static final DocumentFactory<CTAdjPoint2D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAdjPoint2D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctadjpoint2d1656type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getX();

    Object getY();

    void setX(Object obj);

    void setY(Object obj);

    STAdjCoordinate xgetX();

    STAdjCoordinate xgetY();

    void xsetX(STAdjCoordinate sTAdjCoordinate);

    void xsetY(STAdjCoordinate sTAdjCoordinate);
}
