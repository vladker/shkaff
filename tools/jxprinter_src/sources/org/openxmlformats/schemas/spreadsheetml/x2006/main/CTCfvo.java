package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCfvo extends XmlObject {
    public static final DocumentFactory<CTCfvo> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCfvo> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcfvo7ca5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    boolean getGte();

    STCfvoType.Enum getType();

    String getVal();

    boolean isSetExtLst();

    boolean isSetGte();

    boolean isSetVal();

    void setExtLst(CTExtensionList cTExtensionList);

    void setGte(boolean z6);

    void setType(STCfvoType.Enum r6);

    void setVal(String str);

    void unsetExtLst();

    void unsetGte();

    void unsetVal();

    XmlBoolean xgetGte();

    STCfvoType xgetType();

    STXstring xgetVal();

    void xsetGte(XmlBoolean xmlBoolean);

    void xsetType(STCfvoType sTCfvoType);

    void xsetVal(STXstring sTXstring);
}
