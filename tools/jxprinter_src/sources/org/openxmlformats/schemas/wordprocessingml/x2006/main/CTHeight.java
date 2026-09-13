package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTHeight extends XmlObject {
    public static final DocumentFactory<CTHeight> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHeight> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctheighta2e1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STHeightRule.Enum getHRule();

    Object getVal();

    boolean isSetHRule();

    boolean isSetVal();

    void setHRule(STHeightRule.Enum r6);

    void setVal(Object obj);

    void unsetHRule();

    void unsetVal();

    STHeightRule xgetHRule();

    STTwipsMeasure xgetVal();

    void xsetHRule(STHeightRule sTHeightRule);

    void xsetVal(STTwipsMeasure sTTwipsMeasure);
}
