package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNumFmt extends XmlObject {
    public static final DocumentFactory<CTNumFmt> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumFmt> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumfmtc0f5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getFormatCode();

    boolean getSourceLinked();

    boolean isSetSourceLinked();

    void setFormatCode(String str);

    void setSourceLinked(boolean z6);

    void unsetSourceLinked();

    STXstring xgetFormatCode();

    XmlBoolean xgetSourceLinked();

    void xsetFormatCode(STXstring sTXstring);

    void xsetSourceLinked(XmlBoolean xmlBoolean);
}
