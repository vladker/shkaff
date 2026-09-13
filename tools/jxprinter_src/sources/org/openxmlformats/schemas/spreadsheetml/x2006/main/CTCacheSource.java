package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCacheSource extends XmlObject {
    public static final DocumentFactory<CTCacheSource> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCacheSource> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcachesource00dctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTConsolidation addNewConsolidation();

    CTExtensionList addNewExtLst();

    CTWorksheetSource addNewWorksheetSource();

    long getConnectionId();

    CTConsolidation getConsolidation();

    CTExtensionList getExtLst();

    STSourceType.Enum getType();

    CTWorksheetSource getWorksheetSource();

    boolean isSetConnectionId();

    boolean isSetConsolidation();

    boolean isSetExtLst();

    boolean isSetWorksheetSource();

    void setConnectionId(long j6);

    void setConsolidation(CTConsolidation cTConsolidation);

    void setExtLst(CTExtensionList cTExtensionList);

    void setType(STSourceType.Enum r6);

    void setWorksheetSource(CTWorksheetSource cTWorksheetSource);

    void unsetConnectionId();

    void unsetConsolidation();

    void unsetExtLst();

    void unsetWorksheetSource();

    XmlUnsignedInt xgetConnectionId();

    STSourceType xgetType();

    void xsetConnectionId(XmlUnsignedInt xmlUnsignedInt);

    void xsetType(STSourceType sTSourceType);
}
