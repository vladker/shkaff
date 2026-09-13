package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTNumFmt extends XmlObject {
    public static final DocumentFactory<CTNumFmt> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumFmt> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumfmt00e1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getFormat();

    STNumberFormat.Enum getVal();

    boolean isSetFormat();

    void setFormat(String str);

    void setVal(STNumberFormat.Enum r6);

    void unsetFormat();

    STString xgetFormat();

    STNumberFormat xgetVal();

    void xsetFormat(STString sTString);

    void xsetVal(STNumberFormat sTNumberFormat);
}
