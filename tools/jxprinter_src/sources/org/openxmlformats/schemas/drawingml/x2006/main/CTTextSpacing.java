package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTextSpacing extends XmlObject {
    public static final DocumentFactory<CTTextSpacing> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTextSpacing> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttextspacingef87type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTextSpacingPercent addNewSpcPct();

    CTTextSpacingPoint addNewSpcPts();

    CTTextSpacingPercent getSpcPct();

    CTTextSpacingPoint getSpcPts();

    boolean isSetSpcPct();

    boolean isSetSpcPts();

    void setSpcPct(CTTextSpacingPercent cTTextSpacingPercent);

    void setSpcPts(CTTextSpacingPoint cTTextSpacingPoint);

    void unsetSpcPct();

    void unsetSpcPts();
}
