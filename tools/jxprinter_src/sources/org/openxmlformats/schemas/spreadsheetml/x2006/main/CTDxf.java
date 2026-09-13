package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDxf extends XmlObject {
    public static final DocumentFactory<CTDxf> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDxf> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdxfa3b1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCellAlignment addNewAlignment();

    CTBorder addNewBorder();

    CTExtensionList addNewExtLst();

    CTFill addNewFill();

    CTFont addNewFont();

    CTNumFmt addNewNumFmt();

    CTCellProtection addNewProtection();

    CTCellAlignment getAlignment();

    CTBorder getBorder();

    CTExtensionList getExtLst();

    CTFill getFill();

    CTFont getFont();

    CTNumFmt getNumFmt();

    CTCellProtection getProtection();

    boolean isSetAlignment();

    boolean isSetBorder();

    boolean isSetExtLst();

    boolean isSetFill();

    boolean isSetFont();

    boolean isSetNumFmt();

    boolean isSetProtection();

    void setAlignment(CTCellAlignment cTCellAlignment);

    void setBorder(CTBorder cTBorder);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFill(CTFill cTFill);

    void setFont(CTFont cTFont);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setProtection(CTCellProtection cTCellProtection);

    void unsetAlignment();

    void unsetBorder();

    void unsetExtLst();

    void unsetFill();

    void unsetFont();

    void unsetNumFmt();

    void unsetProtection();
}
