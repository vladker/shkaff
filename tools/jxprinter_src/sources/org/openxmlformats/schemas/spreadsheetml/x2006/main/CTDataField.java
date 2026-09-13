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
public interface CTDataField extends XmlObject {
    public static final DocumentFactory<CTDataField> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDataField> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdatafield6f0ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    int getBaseField();

    long getBaseItem();

    CTExtensionList getExtLst();

    long getFld();

    String getName();

    long getNumFmtId();

    STShowDataAs$Enum getShowDataAs();

    STDataConsolidateFunction.Enum getSubtotal();

    boolean isSetBaseField();

    boolean isSetBaseItem();

    boolean isSetExtLst();

    boolean isSetName();

    boolean isSetNumFmtId();

    boolean isSetShowDataAs();

    boolean isSetSubtotal();

    void setBaseField(int i5);

    void setBaseItem(long j6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFld(long j6);

    void setName(String str);

    void setNumFmtId(long j6);

    void setShowDataAs(STShowDataAs$Enum sTShowDataAs$Enum);

    void setSubtotal(STDataConsolidateFunction.Enum r6);

    void unsetBaseField();

    void unsetBaseItem();

    void unsetExtLst();

    void unsetName();

    void unsetNumFmtId();

    void unsetShowDataAs();

    void unsetSubtotal();

    XmlInt xgetBaseField();

    XmlUnsignedInt xgetBaseItem();

    XmlUnsignedInt xgetFld();

    STXstring xgetName();

    STNumFmtId xgetNumFmtId();

    STShowDataAs xgetShowDataAs();

    STDataConsolidateFunction xgetSubtotal();

    void xsetBaseField(XmlInt xmlInt);

    void xsetBaseItem(XmlUnsignedInt xmlUnsignedInt);

    void xsetFld(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STXstring sTXstring);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);

    void xsetShowDataAs(STShowDataAs sTShowDataAs);

    void xsetSubtotal(STDataConsolidateFunction sTDataConsolidateFunction);
}
