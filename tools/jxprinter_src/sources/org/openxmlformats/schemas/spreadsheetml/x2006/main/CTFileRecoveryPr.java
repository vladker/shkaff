package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFileRecoveryPr extends XmlObject {
    public static final DocumentFactory<CTFileRecoveryPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFileRecoveryPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfilerecoveryprf05ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getAutoRecover();

    boolean getCrashSave();

    boolean getDataExtractLoad();

    boolean getRepairLoad();

    boolean isSetAutoRecover();

    boolean isSetCrashSave();

    boolean isSetDataExtractLoad();

    boolean isSetRepairLoad();

    void setAutoRecover(boolean z6);

    void setCrashSave(boolean z6);

    void setDataExtractLoad(boolean z6);

    void setRepairLoad(boolean z6);

    void unsetAutoRecover();

    void unsetCrashSave();

    void unsetDataExtractLoad();

    void unsetRepairLoad();

    XmlBoolean xgetAutoRecover();

    XmlBoolean xgetCrashSave();

    XmlBoolean xgetDataExtractLoad();

    XmlBoolean xgetRepairLoad();

    void xsetAutoRecover(XmlBoolean xmlBoolean);

    void xsetCrashSave(XmlBoolean xmlBoolean);

    void xsetDataExtractLoad(XmlBoolean xmlBoolean);

    void xsetRepairLoad(XmlBoolean xmlBoolean);
}
