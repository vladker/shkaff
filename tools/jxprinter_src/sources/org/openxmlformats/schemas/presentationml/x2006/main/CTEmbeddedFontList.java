package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTEmbeddedFontList extends XmlObject {
    public static final DocumentFactory<CTEmbeddedFontList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTEmbeddedFontList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctembeddedfontlist240etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTEmbeddedFontListEntry addNewEmbeddedFont();

    CTEmbeddedFontListEntry getEmbeddedFontArray(int i5);

    CTEmbeddedFontListEntry[] getEmbeddedFontArray();

    List<CTEmbeddedFontListEntry> getEmbeddedFontList();

    CTEmbeddedFontListEntry insertNewEmbeddedFont(int i5);

    void removeEmbeddedFont(int i5);

    void setEmbeddedFontArray(int i5, CTEmbeddedFontListEntry cTEmbeddedFontListEntry);

    void setEmbeddedFontArray(CTEmbeddedFontListEntry[] cTEmbeddedFontListEntryArr);

    int sizeOfEmbeddedFontArray();
}
