package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTAltChunk extends XmlObject {
    public static final DocumentFactory<CTAltChunk> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAltChunk> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctaltchunk5c24type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAltChunkPr addNewAltChunkPr();

    CTAltChunkPr getAltChunkPr();

    String getId();

    boolean isSetAltChunkPr();

    boolean isSetId();

    void setAltChunkPr(CTAltChunkPr cTAltChunkPr);

    void setId(String str);

    void unsetAltChunkPr();

    void unsetId();

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
