package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPercentage extends XmlObject {
    public static final DocumentFactory<CTPercentage> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPercentage> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpercentage4e75type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getVal();

    void setVal(Object obj);

    STPercentage xgetVal();

    void xsetVal(STPercentage sTPercentage);
}
