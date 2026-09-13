package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTOleObjects extends XmlObject {
    public static final DocumentFactory<CTOleObjects> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOleObjects> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctoleobjects1455type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOleObject addNewOleObject();

    CTOleObject getOleObjectArray(int i5);

    CTOleObject[] getOleObjectArray();

    List<CTOleObject> getOleObjectList();

    CTOleObject insertNewOleObject(int i5);

    void removeOleObject(int i5);

    void setOleObjectArray(int i5, CTOleObject cTOleObject);

    void setOleObjectArray(CTOleObject[] cTOleObjectArr);

    int sizeOfOleObjectArray();
}
