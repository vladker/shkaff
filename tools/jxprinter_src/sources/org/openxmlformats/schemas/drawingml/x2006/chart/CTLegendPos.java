package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTLegendPos extends XmlObject {
    public static final DocumentFactory<CTLegendPos> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLegendPos> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlegendpos053ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STLegendPos.Enum getVal();

    boolean isSetVal();

    void setVal(STLegendPos.Enum r6);

    void unsetVal();

    STLegendPos xgetVal();

    void xsetVal(STLegendPos sTLegendPos);
}
