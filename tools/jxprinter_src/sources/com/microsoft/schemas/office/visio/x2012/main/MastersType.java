package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface MastersType extends XmlObject {
    public static final DocumentFactory<MastersType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<MastersType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "masterstypeaebatype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    MasterType addNewMaster();

    MasterShortcutType addNewMasterShortcut();

    MasterType getMasterArray(int i5);

    MasterType[] getMasterArray();

    List<MasterType> getMasterList();

    MasterShortcutType getMasterShortcutArray(int i5);

    MasterShortcutType[] getMasterShortcutArray();

    List<MasterShortcutType> getMasterShortcutList();

    MasterType insertNewMaster(int i5);

    MasterShortcutType insertNewMasterShortcut(int i5);

    void removeMaster(int i5);

    void removeMasterShortcut(int i5);

    void setMasterArray(int i5, MasterType masterType);

    void setMasterArray(MasterType[] masterTypeArr);

    void setMasterShortcutArray(int i5, MasterShortcutType masterShortcutType);

    void setMasterShortcutArray(MasterShortcutType[] masterShortcutTypeArr);

    int sizeOfMasterArray();

    int sizeOfMasterShortcutArray();
}
