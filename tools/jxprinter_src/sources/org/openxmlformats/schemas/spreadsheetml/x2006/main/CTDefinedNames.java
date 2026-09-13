package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDefinedNames extends XmlObject {
    public static final DocumentFactory<CTDefinedNames> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDefinedNames> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdefinednamesce48type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDefinedName addNewDefinedName();

    CTDefinedName getDefinedNameArray(int i5);

    CTDefinedName[] getDefinedNameArray();

    List<CTDefinedName> getDefinedNameList();

    CTDefinedName insertNewDefinedName(int i5);

    void removeDefinedName(int i5);

    void setDefinedNameArray(int i5, CTDefinedName cTDefinedName);

    void setDefinedNameArray(CTDefinedName[] cTDefinedNameArr);

    int sizeOfDefinedNameArray();
}
