package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPageMar extends XmlObject {
    public static final DocumentFactory<CTPageMar> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPageMar> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpagemar92a3type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getBottom();

    Object getFooter();

    Object getGutter();

    Object getHeader();

    Object getLeft();

    Object getRight();

    Object getTop();

    void setBottom(Object obj);

    void setFooter(Object obj);

    void setGutter(Object obj);

    void setHeader(Object obj);

    void setLeft(Object obj);

    void setRight(Object obj);

    void setTop(Object obj);

    STSignedTwipsMeasure xgetBottom();

    STTwipsMeasure xgetFooter();

    STTwipsMeasure xgetGutter();

    STTwipsMeasure xgetHeader();

    STTwipsMeasure xgetLeft();

    STTwipsMeasure xgetRight();

    STSignedTwipsMeasure xgetTop();

    void xsetBottom(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetFooter(STTwipsMeasure sTTwipsMeasure);

    void xsetGutter(STTwipsMeasure sTTwipsMeasure);

    void xsetHeader(STTwipsMeasure sTTwipsMeasure);

    void xsetLeft(STTwipsMeasure sTTwipsMeasure);

    void xsetRight(STTwipsMeasure sTTwipsMeasure);

    void xsetTop(STSignedTwipsMeasure sTSignedTwipsMeasure);
}
