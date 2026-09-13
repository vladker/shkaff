package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDocGrid extends XmlObject {
    public static final DocumentFactory<CTDocGrid> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDocGrid> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdocgride8b4type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    BigInteger getCharSpace();

    BigInteger getLinePitch();

    STDocGrid.Enum getType();

    boolean isSetCharSpace();

    boolean isSetLinePitch();

    boolean isSetType();

    void setCharSpace(BigInteger bigInteger);

    void setLinePitch(BigInteger bigInteger);

    void setType(STDocGrid.Enum r6);

    void unsetCharSpace();

    void unsetLinePitch();

    void unsetType();

    STDecimalNumber xgetCharSpace();

    STDecimalNumber xgetLinePitch();

    STDocGrid xgetType();

    void xsetCharSpace(STDecimalNumber sTDecimalNumber);

    void xsetLinePitch(STDecimalNumber sTDecimalNumber);

    void xsetType(STDocGrid sTDocGrid);
}
