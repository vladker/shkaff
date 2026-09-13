package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTHyperlinks extends XmlObject {
    public static final DocumentFactory<CTHyperlinks> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHyperlinks> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cthyperlinks6416type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTHyperlink addNewHyperlink();

    CTHyperlink getHyperlinkArray(int i5);

    CTHyperlink[] getHyperlinkArray();

    List<CTHyperlink> getHyperlinkList();

    CTHyperlink insertNewHyperlink(int i5);

    void removeHyperlink(int i5);

    void setHyperlinkArray(int i5, CTHyperlink cTHyperlink);

    void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr);

    int sizeOfHyperlinkArray();
}
