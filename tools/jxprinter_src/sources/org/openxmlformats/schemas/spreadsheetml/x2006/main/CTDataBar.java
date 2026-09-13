package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDataBar extends XmlObject {
    public static final DocumentFactory<CTDataBar> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDataBar> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdatabar4128type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCfvo addNewCfvo();

    CTColor addNewColor();

    CTCfvo getCfvoArray(int i5);

    CTCfvo[] getCfvoArray();

    List<CTCfvo> getCfvoList();

    CTColor getColor();

    long getMaxLength();

    long getMinLength();

    boolean getShowValue();

    CTCfvo insertNewCfvo(int i5);

    boolean isSetMaxLength();

    boolean isSetMinLength();

    boolean isSetShowValue();

    void removeCfvo(int i5);

    void setCfvoArray(int i5, CTCfvo cTCfvo);

    void setCfvoArray(CTCfvo[] cTCfvoArr);

    void setColor(CTColor cTColor);

    void setMaxLength(long j6);

    void setMinLength(long j6);

    void setShowValue(boolean z6);

    int sizeOfCfvoArray();

    void unsetMaxLength();

    void unsetMinLength();

    void unsetShowValue();

    XmlUnsignedInt xgetMaxLength();

    XmlUnsignedInt xgetMinLength();

    XmlBoolean xgetShowValue();

    void xsetMaxLength(XmlUnsignedInt xmlUnsignedInt);

    void xsetMinLength(XmlUnsignedInt xmlUnsignedInt);

    void xsetShowValue(XmlBoolean xmlBoolean);
}
