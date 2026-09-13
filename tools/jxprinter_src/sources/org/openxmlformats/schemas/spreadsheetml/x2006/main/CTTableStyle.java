package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTableStyle extends XmlObject {
    public static final DocumentFactory<CTTableStyle> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableStyle> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablestylea24ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTableStyleElement addNewTableStyleElement();

    long getCount();

    String getName();

    boolean getPivot();

    boolean getTable();

    CTTableStyleElement getTableStyleElementArray(int i5);

    CTTableStyleElement[] getTableStyleElementArray();

    List<CTTableStyleElement> getTableStyleElementList();

    CTTableStyleElement insertNewTableStyleElement(int i5);

    boolean isSetCount();

    boolean isSetPivot();

    boolean isSetTable();

    void removeTableStyleElement(int i5);

    void setCount(long j6);

    void setName(String str);

    void setPivot(boolean z6);

    void setTable(boolean z6);

    void setTableStyleElementArray(int i5, CTTableStyleElement cTTableStyleElement);

    void setTableStyleElementArray(CTTableStyleElement[] cTTableStyleElementArr);

    int sizeOfTableStyleElementArray();

    void unsetCount();

    void unsetPivot();

    void unsetTable();

    XmlUnsignedInt xgetCount();

    XmlString xgetName();

    XmlBoolean xgetPivot();

    XmlBoolean xgetTable();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(XmlString xmlString);

    void xsetPivot(XmlBoolean xmlBoolean);

    void xsetTable(XmlBoolean xmlBoolean);
}
