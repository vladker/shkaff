package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTableParts extends XmlObject {
    public static final DocumentFactory<CTTableParts> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableParts> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablepartsf6bbtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTablePart addNewTablePart();

    long getCount();

    CTTablePart getTablePartArray(int i5);

    CTTablePart[] getTablePartArray();

    List<CTTablePart> getTablePartList();

    CTTablePart insertNewTablePart(int i5);

    boolean isSetCount();

    void removeTablePart(int i5);

    void setCount(long j6);

    void setTablePartArray(int i5, CTTablePart cTTablePart);

    void setTablePartArray(CTTablePart[] cTTablePartArr);

    int sizeOfTablePartArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
