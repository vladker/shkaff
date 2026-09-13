package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFunctionGroups extends XmlObject {
    public static final DocumentFactory<CTFunctionGroups> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFunctionGroups> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfunctiongroupsbfd5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFunctionGroup addNewFunctionGroup();

    long getBuiltInGroupCount();

    CTFunctionGroup getFunctionGroupArray(int i5);

    CTFunctionGroup[] getFunctionGroupArray();

    List<CTFunctionGroup> getFunctionGroupList();

    CTFunctionGroup insertNewFunctionGroup(int i5);

    boolean isSetBuiltInGroupCount();

    void removeFunctionGroup(int i5);

    void setBuiltInGroupCount(long j6);

    void setFunctionGroupArray(int i5, CTFunctionGroup cTFunctionGroup);

    void setFunctionGroupArray(CTFunctionGroup[] cTFunctionGroupArr);

    int sizeOfFunctionGroupArray();

    void unsetBuiltInGroupCount();

    XmlUnsignedInt xgetBuiltInGroupCount();

    void xsetBuiltInGroupCount(XmlUnsignedInt xmlUnsignedInt);
}
