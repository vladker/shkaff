package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTableRow extends XmlObject {
    public static final DocumentFactory<CTTableRow> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableRow> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablerow4ac7type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTTableCell addNewTc();

    CTOfficeArtExtensionList getExtLst();

    Object getH();

    CTTableCell getTcArray(int i5);

    CTTableCell[] getTcArray();

    List<CTTableCell> getTcList();

    CTTableCell insertNewTc(int i5);

    boolean isSetExtLst();

    void removeTc(int i5);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setH(Object obj);

    void setTcArray(int i5, CTTableCell cTTableCell);

    void setTcArray(CTTableCell[] cTTableCellArr);

    int sizeOfTcArray();

    void unsetExtLst();

    STCoordinate xgetH();

    void xsetH(STCoordinate sTCoordinate);
}
