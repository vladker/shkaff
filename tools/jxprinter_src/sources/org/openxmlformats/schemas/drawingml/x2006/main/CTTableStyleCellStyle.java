package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTableStyleCellStyle extends XmlObject {
    public static final DocumentFactory<CTTableStyleCellStyle> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableStyleCellStyle> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablestylecellstyle1fddtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCell3D addNewCell3D();

    CTFillProperties addNewFill();

    CTStyleMatrixReference addNewFillRef();

    CTTableCellBorderStyle addNewTcBdr();

    CTCell3D getCell3D();

    CTFillProperties getFill();

    CTStyleMatrixReference getFillRef();

    CTTableCellBorderStyle getTcBdr();

    boolean isSetCell3D();

    boolean isSetFill();

    boolean isSetFillRef();

    boolean isSetTcBdr();

    void setCell3D(CTCell3D cTCell3D);

    void setFill(CTFillProperties cTFillProperties);

    void setFillRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setTcBdr(CTTableCellBorderStyle cTTableCellBorderStyle);

    void unsetCell3D();

    void unsetFill();

    void unsetFillRef();

    void unsetTcBdr();
}
