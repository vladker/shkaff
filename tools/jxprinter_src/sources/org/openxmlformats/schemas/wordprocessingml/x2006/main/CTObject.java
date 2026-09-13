package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTObject extends XmlObject {
    public static final DocumentFactory<CTObject> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTObject> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctobject47c9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTControl addNewControl();

    CTDrawing addNewDrawing();

    CTRel addNewMovie();

    CTObjectEmbed addNewObjectEmbed();

    CTObjectLink addNewObjectLink();

    CTControl getControl();

    CTDrawing getDrawing();

    Object getDxaOrig();

    Object getDyaOrig();

    CTRel getMovie();

    CTObjectEmbed getObjectEmbed();

    CTObjectLink getObjectLink();

    boolean isSetControl();

    boolean isSetDrawing();

    boolean isSetDxaOrig();

    boolean isSetDyaOrig();

    boolean isSetMovie();

    boolean isSetObjectEmbed();

    boolean isSetObjectLink();

    void setControl(CTControl cTControl);

    void setDrawing(CTDrawing cTDrawing);

    void setDxaOrig(Object obj);

    void setDyaOrig(Object obj);

    void setMovie(CTRel cTRel);

    void setObjectEmbed(CTObjectEmbed cTObjectEmbed);

    void setObjectLink(CTObjectLink cTObjectLink);

    void unsetControl();

    void unsetDrawing();

    void unsetDxaOrig();

    void unsetDyaOrig();

    void unsetMovie();

    void unsetObjectEmbed();

    void unsetObjectLink();

    STTwipsMeasure xgetDxaOrig();

    STTwipsMeasure xgetDyaOrig();

    void xsetDxaOrig(STTwipsMeasure sTTwipsMeasure);

    void xsetDyaOrig(STTwipsMeasure sTTwipsMeasure);
}
