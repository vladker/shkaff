package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTExternalDefinedNames extends XmlObject {
    public static final DocumentFactory<CTExternalDefinedNames> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalDefinedNames> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternaldefinednamesccf3type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExternalDefinedName addNewDefinedName();

    CTExternalDefinedName getDefinedNameArray(int i5);

    CTExternalDefinedName[] getDefinedNameArray();

    List<CTExternalDefinedName> getDefinedNameList();

    CTExternalDefinedName insertNewDefinedName(int i5);

    void removeDefinedName(int i5);

    void setDefinedNameArray(int i5, CTExternalDefinedName cTExternalDefinedName);

    void setDefinedNameArray(CTExternalDefinedName[] cTExternalDefinedNameArr);

    int sizeOfDefinedNameArray();
}
