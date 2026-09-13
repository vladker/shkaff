package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTSlideSize extends XmlObject {
    public static final DocumentFactory<CTSlideSize> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSlideSize> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctslidesizeb0fdtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    int getCx();

    int getCy();

    STSlideSizeType.Enum getType();

    boolean isSetType();

    void setCx(int i5);

    void setCy(int i5);

    void setType(STSlideSizeType.Enum r6);

    void unsetType();

    STSlideSizeCoordinate xgetCx();

    STSlideSizeCoordinate xgetCy();

    STSlideSizeType xgetType();

    void xsetCx(STSlideSizeCoordinate sTSlideSizeCoordinate);

    void xsetCy(STSlideSizeCoordinate sTSlideSizeCoordinate);

    void xsetType(STSlideSizeType sTSlideSizeType);
}
