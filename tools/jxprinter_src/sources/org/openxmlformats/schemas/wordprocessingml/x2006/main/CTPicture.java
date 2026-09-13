package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPicture extends XmlObject {
    public static final DocumentFactory<CTPicture> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPicture> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpicture1054type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTControl addNewControl();

    CTRel addNewMovie();

    CTControl getControl();

    CTRel getMovie();

    boolean isSetControl();

    boolean isSetMovie();

    void setControl(CTControl cTControl);

    void setMovie(CTRel cTRel);

    void unsetControl();

    void unsetMovie();
}
