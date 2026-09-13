package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPageSetUpPr extends XmlObject {
    public static final DocumentFactory<CTPageSetUpPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPageSetUpPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpagesetuppr24cftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getAutoPageBreaks();

    boolean getFitToPage();

    boolean isSetAutoPageBreaks();

    boolean isSetFitToPage();

    void setAutoPageBreaks(boolean z6);

    void setFitToPage(boolean z6);

    void unsetAutoPageBreaks();

    void unsetFitToPage();

    XmlBoolean xgetAutoPageBreaks();

    XmlBoolean xgetFitToPage();

    void xsetAutoPageBreaks(XmlBoolean xmlBoolean);

    void xsetFitToPage(XmlBoolean xmlBoolean);
}
