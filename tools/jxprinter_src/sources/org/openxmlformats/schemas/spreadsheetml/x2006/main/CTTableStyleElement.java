package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTableStyleElement extends XmlObject {
    public static final DocumentFactory<CTTableStyleElement> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableStyleElement> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablestyleelementa658type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getDxfId();

    long getSize();

    STTableStyleType.Enum getType();

    boolean isSetDxfId();

    boolean isSetSize();

    void setDxfId(long j6);

    void setSize(long j6);

    void setType(STTableStyleType.Enum r6);

    void unsetDxfId();

    void unsetSize();

    STDxfId xgetDxfId();

    XmlUnsignedInt xgetSize();

    STTableStyleType xgetType();

    void xsetDxfId(STDxfId sTDxfId);

    void xsetSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetType(STTableStyleType sTTableStyleType);
}
