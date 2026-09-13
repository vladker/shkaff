package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFootnotes extends XmlObject {
    public static final DocumentFactory<CTFootnotes> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFootnotes> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfootnotes691ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFtnEdn addNewFootnote();

    CTFtnEdn getFootnoteArray(int i5);

    CTFtnEdn[] getFootnoteArray();

    List<CTFtnEdn> getFootnoteList();

    CTFtnEdn insertNewFootnote(int i5);

    void removeFootnote(int i5);

    void setFootnoteArray(int i5, CTFtnEdn cTFtnEdn);

    void setFootnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfFootnoteArray();
}
