package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTGapAmount extends XmlObject {
    public static final DocumentFactory<CTGapAmount> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGapAmount> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgapamountdd98type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getVal();

    boolean isSetVal();

    void setVal(Object obj);

    void unsetVal();

    STGapAmount xgetVal();

    void xsetVal(STGapAmount sTGapAmount);
}
