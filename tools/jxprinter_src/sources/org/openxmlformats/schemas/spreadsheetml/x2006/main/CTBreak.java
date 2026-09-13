package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTBreak extends XmlObject {
    public static final DocumentFactory<CTBreak> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBreak> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbreak815etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getId();

    boolean getMan();

    long getMax();

    long getMin();

    boolean getPt();

    boolean isSetId();

    boolean isSetMan();

    boolean isSetMax();

    boolean isSetMin();

    boolean isSetPt();

    void setId(long j6);

    void setMan(boolean z6);

    void setMax(long j6);

    void setMin(long j6);

    void setPt(boolean z6);

    void unsetId();

    void unsetMan();

    void unsetMax();

    void unsetMin();

    void unsetPt();

    XmlUnsignedInt xgetId();

    XmlBoolean xgetMan();

    XmlUnsignedInt xgetMax();

    XmlUnsignedInt xgetMin();

    XmlBoolean xgetPt();

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetMan(XmlBoolean xmlBoolean);

    void xsetMax(XmlUnsignedInt xmlUnsignedInt);

    void xsetMin(XmlUnsignedInt xmlUnsignedInt);

    void xsetPt(XmlBoolean xmlBoolean);
}
