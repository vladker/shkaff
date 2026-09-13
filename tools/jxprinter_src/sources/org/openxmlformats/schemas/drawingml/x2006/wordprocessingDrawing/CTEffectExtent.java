package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTEffectExtent extends XmlObject {
    public static final DocumentFactory<CTEffectExtent> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTEffectExtent> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cteffectextent9724type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getB();

    Object getL();

    Object getR();

    Object getT();

    void setB(Object obj);

    void setL(Object obj);

    void setR(Object obj);

    void setT(Object obj);

    STCoordinate xgetB();

    STCoordinate xgetL();

    STCoordinate xgetR();

    STCoordinate xgetT();

    void xsetB(STCoordinate sTCoordinate);

    void xsetL(STCoordinate sTCoordinate);

    void xsetR(STCoordinate sTCoordinate);

    void xsetT(STCoordinate sTCoordinate);
}
