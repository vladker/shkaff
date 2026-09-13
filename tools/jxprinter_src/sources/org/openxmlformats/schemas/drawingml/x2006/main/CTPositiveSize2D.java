package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPositiveSize2D extends XmlObject {
    public static final DocumentFactory<CTPositiveSize2D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPositiveSize2D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpositivesize2d0147type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getCx();

    long getCy();

    void setCx(long j6);

    void setCy(long j6);

    STPositiveCoordinate xgetCx();

    STPositiveCoordinate xgetCy();

    void xsetCx(STPositiveCoordinate sTPositiveCoordinate);

    void xsetCy(STPositiveCoordinate sTPositiveCoordinate);
}
