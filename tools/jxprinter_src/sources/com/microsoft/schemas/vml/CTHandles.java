package com.microsoft.schemas.vml;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTHandles extends XmlObject {
    public static final DocumentFactory<CTHandles> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHandles> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cthandles5c1ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTH addNewH();

    CTH getHArray(int i5);

    CTH[] getHArray();

    List<CTH> getHList();

    CTH insertNewH(int i5);

    void removeH(int i5);

    void setHArray(int i5, CTH cth);

    void setHArray(CTH[] cthArr);

    int sizeOfHArray();
}
