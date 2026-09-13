package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.Calendar;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPivotCacheDefinition extends XmlObject {
    public static final DocumentFactory<CTPivotCacheDefinition> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotCacheDefinition> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotcachedefinition575ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCacheFields addNewCacheFields();

    CTCacheHierarchies addNewCacheHierarchies();

    CTCacheSource addNewCacheSource();

    CTCalculatedItems addNewCalculatedItems();

    CTCalculatedMembers addNewCalculatedMembers();

    CTDimensions addNewDimensions();

    CTExtensionList addNewExtLst();

    CTPCDKPIs addNewKpis();

    CTMeasureDimensionMaps addNewMaps();

    CTMeasureGroups addNewMeasureGroups();

    CTTupleCache addNewTupleCache();

    boolean getBackgroundQuery();

    CTCacheFields getCacheFields();

    CTCacheHierarchies getCacheHierarchies();

    CTCacheSource getCacheSource();

    CTCalculatedItems getCalculatedItems();

    CTCalculatedMembers getCalculatedMembers();

    short getCreatedVersion();

    CTDimensions getDimensions();

    boolean getEnableRefresh();

    CTExtensionList getExtLst();

    String getId();

    boolean getInvalid();

    CTPCDKPIs getKpis();

    CTMeasureDimensionMaps getMaps();

    CTMeasureGroups getMeasureGroups();

    short getMinRefreshableVersion();

    long getMissingItemsLimit();

    boolean getOptimizeMemory();

    long getRecordCount();

    boolean getRefreshOnLoad();

    String getRefreshedBy();

    double getRefreshedDate();

    Calendar getRefreshedDateIso();

    short getRefreshedVersion();

    boolean getSaveData();

    boolean getSupportAdvancedDrill();

    boolean getSupportSubquery();

    CTTupleCache getTupleCache();

    boolean getTupleCache2();

    boolean getUpgradeOnRefresh();

    boolean isSetBackgroundQuery();

    boolean isSetCacheHierarchies();

    boolean isSetCalculatedItems();

    boolean isSetCalculatedMembers();

    boolean isSetCreatedVersion();

    boolean isSetDimensions();

    boolean isSetEnableRefresh();

    boolean isSetExtLst();

    boolean isSetId();

    boolean isSetInvalid();

    boolean isSetKpis();

    boolean isSetMaps();

    boolean isSetMeasureGroups();

    boolean isSetMinRefreshableVersion();

    boolean isSetMissingItemsLimit();

    boolean isSetOptimizeMemory();

    boolean isSetRecordCount();

    boolean isSetRefreshOnLoad();

    boolean isSetRefreshedBy();

    boolean isSetRefreshedDate();

    boolean isSetRefreshedDateIso();

    boolean isSetRefreshedVersion();

    boolean isSetSaveData();

    boolean isSetSupportAdvancedDrill();

    boolean isSetSupportSubquery();

    boolean isSetTupleCache();

    boolean isSetTupleCache2();

    boolean isSetUpgradeOnRefresh();

    void setBackgroundQuery(boolean z6);

    void setCacheFields(CTCacheFields cTCacheFields);

    void setCacheHierarchies(CTCacheHierarchies cTCacheHierarchies);

    void setCacheSource(CTCacheSource cTCacheSource);

    void setCalculatedItems(CTCalculatedItems cTCalculatedItems);

    void setCalculatedMembers(CTCalculatedMembers cTCalculatedMembers);

    void setCreatedVersion(short s6);

    void setDimensions(CTDimensions cTDimensions);

    void setEnableRefresh(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(String str);

    void setInvalid(boolean z6);

    void setKpis(CTPCDKPIs cTPCDKPIs);

    void setMaps(CTMeasureDimensionMaps cTMeasureDimensionMaps);

    void setMeasureGroups(CTMeasureGroups cTMeasureGroups);

    void setMinRefreshableVersion(short s6);

    void setMissingItemsLimit(long j6);

    void setOptimizeMemory(boolean z6);

    void setRecordCount(long j6);

    void setRefreshOnLoad(boolean z6);

    void setRefreshedBy(String str);

    void setRefreshedDate(double d);

    void setRefreshedDateIso(Calendar calendar);

    void setRefreshedVersion(short s6);

    void setSaveData(boolean z6);

    void setSupportAdvancedDrill(boolean z6);

    void setSupportSubquery(boolean z6);

    void setTupleCache(CTTupleCache cTTupleCache);

    void setTupleCache2(boolean z6);

    void setUpgradeOnRefresh(boolean z6);

    void unsetBackgroundQuery();

    void unsetCacheHierarchies();

    void unsetCalculatedItems();

    void unsetCalculatedMembers();

    void unsetCreatedVersion();

    void unsetDimensions();

    void unsetEnableRefresh();

    void unsetExtLst();

    void unsetId();

    void unsetInvalid();

    void unsetKpis();

    void unsetMaps();

    void unsetMeasureGroups();

    void unsetMinRefreshableVersion();

    void unsetMissingItemsLimit();

    void unsetOptimizeMemory();

    void unsetRecordCount();

    void unsetRefreshOnLoad();

    void unsetRefreshedBy();

    void unsetRefreshedDate();

    void unsetRefreshedDateIso();

    void unsetRefreshedVersion();

    void unsetSaveData();

    void unsetSupportAdvancedDrill();

    void unsetSupportSubquery();

    void unsetTupleCache();

    void unsetTupleCache2();

    void unsetUpgradeOnRefresh();

    XmlBoolean xgetBackgroundQuery();

    XmlUnsignedByte xgetCreatedVersion();

    XmlBoolean xgetEnableRefresh();

    STRelationshipId xgetId();

    XmlBoolean xgetInvalid();

    XmlUnsignedByte xgetMinRefreshableVersion();

    XmlUnsignedInt xgetMissingItemsLimit();

    XmlBoolean xgetOptimizeMemory();

    XmlUnsignedInt xgetRecordCount();

    XmlBoolean xgetRefreshOnLoad();

    STXstring xgetRefreshedBy();

    XmlDouble xgetRefreshedDate();

    XmlDateTime xgetRefreshedDateIso();

    XmlUnsignedByte xgetRefreshedVersion();

    XmlBoolean xgetSaveData();

    XmlBoolean xgetSupportAdvancedDrill();

    XmlBoolean xgetSupportSubquery();

    XmlBoolean xgetTupleCache2();

    XmlBoolean xgetUpgradeOnRefresh();

    void xsetBackgroundQuery(XmlBoolean xmlBoolean);

    void xsetCreatedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetEnableRefresh(XmlBoolean xmlBoolean);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetInvalid(XmlBoolean xmlBoolean);

    void xsetMinRefreshableVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetMissingItemsLimit(XmlUnsignedInt xmlUnsignedInt);

    void xsetOptimizeMemory(XmlBoolean xmlBoolean);

    void xsetRecordCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetRefreshOnLoad(XmlBoolean xmlBoolean);

    void xsetRefreshedBy(STXstring sTXstring);

    void xsetRefreshedDate(XmlDouble xmlDouble);

    void xsetRefreshedDateIso(XmlDateTime xmlDateTime);

    void xsetRefreshedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetSaveData(XmlBoolean xmlBoolean);

    void xsetSupportAdvancedDrill(XmlBoolean xmlBoolean);

    void xsetSupportSubquery(XmlBoolean xmlBoolean);

    void xsetTupleCache2(XmlBoolean xmlBoolean);

    void xsetUpgradeOnRefresh(XmlBoolean xmlBoolean);
}
