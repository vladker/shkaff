package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPageField extends XmlObject {
    public static final DocumentFactory<CTPageField> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPageField> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpagefield338atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    String getCap();

    CTExtensionList getExtLst();

    int getFld();

    int getHier();

    long getItem();

    String getName();

    boolean isSetCap();

    boolean isSetExtLst();

    boolean isSetHier();

    boolean isSetItem();

    boolean isSetName();

    void setCap(String str);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFld(int i5);

    void setHier(int i5);

    void setItem(long j6);

    void setName(String str);

    void unsetCap();

    void unsetExtLst();

    void unsetHier();

    void unsetItem();

    void unsetName();

    STXstring xgetCap();

    XmlInt xgetFld();

    XmlInt xgetHier();

    XmlUnsignedInt xgetItem();

    STXstring xgetName();

    void xsetCap(STXstring sTXstring);

    void xsetFld(XmlInt xmlInt);

    void xsetHier(XmlInt xmlInt);

    void xsetItem(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);
}
