package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTFirstSliceAng extends XmlObject {
    public static final DocumentFactory<CTFirstSliceAng> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFirstSliceAng> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfirstsliceang0ceetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    int getVal();

    boolean isSetVal();

    void setVal(int i5);

    void unsetVal();

    STFirstSliceAng xgetVal();

    void xsetVal(STFirstSliceAng sTFirstSliceAng);
}
