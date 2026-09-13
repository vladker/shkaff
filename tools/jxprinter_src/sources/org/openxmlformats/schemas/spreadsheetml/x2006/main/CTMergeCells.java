package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTMergeCells extends XmlObject {
    public static final DocumentFactory<CTMergeCells> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMergeCells> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmergecells1242type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTMergeCell addNewMergeCell();

    long getCount();

    CTMergeCell getMergeCellArray(int i5);

    CTMergeCell[] getMergeCellArray();

    List<CTMergeCell> getMergeCellList();

    CTMergeCell insertNewMergeCell(int i5);

    boolean isSetCount();

    void removeMergeCell(int i5);

    void setCount(long j6);

    void setMergeCellArray(int i5, CTMergeCell cTMergeCell);

    void setMergeCellArray(CTMergeCell[] cTMergeCellArr);

    int sizeOfMergeCellArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
