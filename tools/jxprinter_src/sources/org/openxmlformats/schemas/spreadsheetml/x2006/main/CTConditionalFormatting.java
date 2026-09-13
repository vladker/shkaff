package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTConditionalFormatting extends XmlObject {
    public static final DocumentFactory<CTConditionalFormatting> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTConditionalFormatting> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctconditionalformatting0deatype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCfRule addNewCfRule();

    CTExtensionList addNewExtLst();

    CTCfRule getCfRuleArray(int i5);

    CTCfRule[] getCfRuleArray();

    List<CTCfRule> getCfRuleList();

    CTExtensionList getExtLst();

    boolean getPivot();

    List getSqref();

    CTCfRule insertNewCfRule(int i5);

    boolean isSetExtLst();

    boolean isSetPivot();

    boolean isSetSqref();

    void removeCfRule(int i5);

    void setCfRuleArray(int i5, CTCfRule cTCfRule);

    void setCfRuleArray(CTCfRule[] cTCfRuleArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setPivot(boolean z6);

    void setSqref(List list);

    int sizeOfCfRuleArray();

    void unsetExtLst();

    void unsetPivot();

    void unsetSqref();

    XmlBoolean xgetPivot();

    STSqref xgetSqref();

    void xsetPivot(XmlBoolean xmlBoolean);

    void xsetSqref(STSqref sTSqref);
}
