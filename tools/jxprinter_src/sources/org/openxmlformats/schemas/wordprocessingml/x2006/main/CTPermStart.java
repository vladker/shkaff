package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPermStart extends CTPerm {
    public static final DocumentFactory<CTPermStart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPermStart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpermstart0140type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    BigInteger getColFirst();

    BigInteger getColLast();

    String getEd();

    STEdGrp.Enum getEdGrp();

    boolean isSetColFirst();

    boolean isSetColLast();

    boolean isSetEd();

    boolean isSetEdGrp();

    void setColFirst(BigInteger bigInteger);

    void setColLast(BigInteger bigInteger);

    void setEd(String str);

    void setEdGrp(STEdGrp.Enum r6);

    void unsetColFirst();

    void unsetColLast();

    void unsetEd();

    void unsetEdGrp();

    STDecimalNumber xgetColFirst();

    STDecimalNumber xgetColLast();

    STString xgetEd();

    STEdGrp xgetEdGrp();

    void xsetColFirst(STDecimalNumber sTDecimalNumber);

    void xsetColLast(STDecimalNumber sTDecimalNumber);

    void xsetEd(STString sTString);

    void xsetEdGrp(STEdGrp sTEdGrp);
}
