package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTAnchorClientData extends XmlObject {
    public static final DocumentFactory<CTAnchorClientData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAnchorClientData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctanchorclientdata02betype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getFLocksWithSheet();

    boolean getFPrintsWithSheet();

    boolean isSetFLocksWithSheet();

    boolean isSetFPrintsWithSheet();

    void setFLocksWithSheet(boolean z6);

    void setFPrintsWithSheet(boolean z6);

    void unsetFLocksWithSheet();

    void unsetFPrintsWithSheet();

    XmlBoolean xgetFLocksWithSheet();

    XmlBoolean xgetFPrintsWithSheet();

    void xsetFLocksWithSheet(XmlBoolean xmlBoolean);

    void xsetFPrintsWithSheet(XmlBoolean xmlBoolean);
}
