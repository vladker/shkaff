package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFitText extends XmlObject {
    public static final DocumentFactory<CTFitText> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFitText> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfittexta474type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    BigInteger getId();

    Object getVal();

    boolean isSetId();

    void setId(BigInteger bigInteger);

    void setVal(Object obj);

    void unsetId();

    STDecimalNumber xgetId();

    STTwipsMeasure xgetVal();

    void xsetId(STDecimalNumber sTDecimalNumber);

    void xsetVal(STTwipsMeasure sTTwipsMeasure);
}
