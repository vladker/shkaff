package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNumVal extends XmlObject {
    public static final DocumentFactory<CTNumVal> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumVal> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumval2fe1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getFormatCode();

    long getIdx();

    String getV();

    boolean isSetFormatCode();

    void setFormatCode(String str);

    void setIdx(long j6);

    void setV(String str);

    void unsetFormatCode();

    STXstring xgetFormatCode();

    XmlUnsignedInt xgetIdx();

    STXstring xgetV();

    void xsetFormatCode(STXstring sTXstring);

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetV(STXstring sTXstring);
}
