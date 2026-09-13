package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCacheField extends XmlObject {
    public static final DocumentFactory<CTCacheField> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCacheField> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcachefieldae21type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTFieldGroup addNewFieldGroup();

    CTX addNewMpMap();

    CTSharedItems addNewSharedItems();

    String getCaption();

    boolean getDatabaseField();

    CTExtensionList getExtLst();

    CTFieldGroup getFieldGroup();

    String getFormula();

    int getHierarchy();

    long getLevel();

    long getMappingCount();

    boolean getMemberPropertyField();

    CTX getMpMapArray(int i5);

    CTX[] getMpMapArray();

    List<CTX> getMpMapList();

    String getName();

    long getNumFmtId();

    String getPropertyName();

    boolean getServerField();

    CTSharedItems getSharedItems();

    int getSqlType();

    boolean getUniqueList();

    CTX insertNewMpMap(int i5);

    boolean isSetCaption();

    boolean isSetDatabaseField();

    boolean isSetExtLst();

    boolean isSetFieldGroup();

    boolean isSetFormula();

    boolean isSetHierarchy();

    boolean isSetLevel();

    boolean isSetMappingCount();

    boolean isSetMemberPropertyField();

    boolean isSetNumFmtId();

    boolean isSetPropertyName();

    boolean isSetServerField();

    boolean isSetSharedItems();

    boolean isSetSqlType();

    boolean isSetUniqueList();

    void removeMpMap(int i5);

    void setCaption(String str);

    void setDatabaseField(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFieldGroup(CTFieldGroup cTFieldGroup);

    void setFormula(String str);

    void setHierarchy(int i5);

    void setLevel(long j6);

    void setMappingCount(long j6);

    void setMemberPropertyField(boolean z6);

    void setMpMapArray(int i5, CTX ctx);

    void setMpMapArray(CTX[] ctxArr);

    void setName(String str);

    void setNumFmtId(long j6);

    void setPropertyName(String str);

    void setServerField(boolean z6);

    void setSharedItems(CTSharedItems cTSharedItems);

    void setSqlType(int i5);

    void setUniqueList(boolean z6);

    int sizeOfMpMapArray();

    void unsetCaption();

    void unsetDatabaseField();

    void unsetExtLst();

    void unsetFieldGroup();

    void unsetFormula();

    void unsetHierarchy();

    void unsetLevel();

    void unsetMappingCount();

    void unsetMemberPropertyField();

    void unsetNumFmtId();

    void unsetPropertyName();

    void unsetServerField();

    void unsetSharedItems();

    void unsetSqlType();

    void unsetUniqueList();

    STXstring xgetCaption();

    XmlBoolean xgetDatabaseField();

    STXstring xgetFormula();

    XmlInt xgetHierarchy();

    XmlUnsignedInt xgetLevel();

    XmlUnsignedInt xgetMappingCount();

    XmlBoolean xgetMemberPropertyField();

    STXstring xgetName();

    STNumFmtId xgetNumFmtId();

    STXstring xgetPropertyName();

    XmlBoolean xgetServerField();

    XmlInt xgetSqlType();

    XmlBoolean xgetUniqueList();

    void xsetCaption(STXstring sTXstring);

    void xsetDatabaseField(XmlBoolean xmlBoolean);

    void xsetFormula(STXstring sTXstring);

    void xsetHierarchy(XmlInt xmlInt);

    void xsetLevel(XmlUnsignedInt xmlUnsignedInt);

    void xsetMappingCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetMemberPropertyField(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);

    void xsetPropertyName(STXstring sTXstring);

    void xsetServerField(XmlBoolean xmlBoolean);

    void xsetSqlType(XmlInt xmlInt);

    void xsetUniqueList(XmlBoolean xmlBoolean);
}
