package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTBookmark extends CTBookmarkRange {
    public static final DocumentFactory<CTBookmark> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBookmark> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbookmarkd672type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getName();

    void setName(String str);

    STString xgetName();

    void xsetName(STString sTString);
}
