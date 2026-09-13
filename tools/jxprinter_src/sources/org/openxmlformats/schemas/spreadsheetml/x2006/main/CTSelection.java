package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSelection extends XmlObject {
    public static final DocumentFactory<CTSelection> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSelection> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctselectionca2btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getActiveCell();

    long getActiveCellId();

    STPane.Enum getPane();

    List getSqref();

    boolean isSetActiveCell();

    boolean isSetActiveCellId();

    boolean isSetPane();

    boolean isSetSqref();

    void setActiveCell(String str);

    void setActiveCellId(long j6);

    void setPane(STPane.Enum r6);

    void setSqref(List list);

    void unsetActiveCell();

    void unsetActiveCellId();

    void unsetPane();

    void unsetSqref();

    STCellRef xgetActiveCell();

    XmlUnsignedInt xgetActiveCellId();

    STPane xgetPane();

    STSqref xgetSqref();

    void xsetActiveCell(STCellRef sTCellRef);

    void xsetActiveCellId(XmlUnsignedInt xmlUnsignedInt);

    void xsetPane(STPane sTPane);

    void xsetSqref(STSqref sTSqref);
}
