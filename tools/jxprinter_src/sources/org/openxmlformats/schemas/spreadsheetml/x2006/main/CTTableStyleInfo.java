package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTableStyleInfo extends XmlObject {
    public static final DocumentFactory<CTTableStyleInfo> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableStyleInfo> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablestyleinfo499atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getName();

    boolean getShowColumnStripes();

    boolean getShowFirstColumn();

    boolean getShowLastColumn();

    boolean getShowRowStripes();

    boolean isSetName();

    boolean isSetShowColumnStripes();

    boolean isSetShowFirstColumn();

    boolean isSetShowLastColumn();

    boolean isSetShowRowStripes();

    void setName(String str);

    void setShowColumnStripes(boolean z6);

    void setShowFirstColumn(boolean z6);

    void setShowLastColumn(boolean z6);

    void setShowRowStripes(boolean z6);

    void unsetName();

    void unsetShowColumnStripes();

    void unsetShowFirstColumn();

    void unsetShowLastColumn();

    void unsetShowRowStripes();

    STXstring xgetName();

    XmlBoolean xgetShowColumnStripes();

    XmlBoolean xgetShowFirstColumn();

    XmlBoolean xgetShowLastColumn();

    XmlBoolean xgetShowRowStripes();

    void xsetName(STXstring sTXstring);

    void xsetShowColumnStripes(XmlBoolean xmlBoolean);

    void xsetShowFirstColumn(XmlBoolean xmlBoolean);

    void xsetShowLastColumn(XmlBoolean xmlBoolean);

    void xsetShowRowStripes(XmlBoolean xmlBoolean);
}
