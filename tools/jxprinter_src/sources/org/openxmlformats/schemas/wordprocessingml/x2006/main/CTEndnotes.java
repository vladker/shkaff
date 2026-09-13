package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTEndnotes extends XmlObject {
    public static final DocumentFactory<CTEndnotes> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTEndnotes> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctendnotescee2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFtnEdn addNewEndnote();

    CTFtnEdn getEndnoteArray(int i5);

    CTFtnEdn[] getEndnoteArray();

    List<CTFtnEdn> getEndnoteList();

    CTFtnEdn insertNewEndnote(int i5);

    void removeEndnote(int i5);

    void setEndnoteArray(int i5, CTFtnEdn cTFtnEdn);

    void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfEndnoteArray();
}
