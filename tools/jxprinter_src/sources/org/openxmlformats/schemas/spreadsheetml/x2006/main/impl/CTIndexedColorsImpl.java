package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTIndexedColorsImpl;
import r5.B;
import r5.C1551a0;
import r5.C1553b0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTIndexedColorsImpl extends XmlComplexContentImpl implements CTIndexedColors {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "rgbColor")};
    private static final long serialVersionUID = 1;

    public CTIndexedColorsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor addNewRgbColor() {
        CTRgbColor cTRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTRgbColor = (CTRgbColor) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTRgbColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor[] getRgbColorArray() {
        return (CTRgbColor[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTRgbColor[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public List<CTRgbColor> getRgbColorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.e0
                public final /* synthetic */ CTIndexedColorsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getRgbColorArray(iIntValue);
                        default:
                            return this.b.insertNewRgbColor(iIntValue);
                    }
                }
            }, new B(this, 20), new Function(this) { // from class: r5.e0
                public final /* synthetic */ CTIndexedColorsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getRgbColorArray(iIntValue);
                        default:
                            return this.b.insertNewRgbColor(iIntValue);
                    }
                }
            }, new C1551a0(this, 3), new C1553b0(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor insertNewRgbColor(int i5) {
        CTRgbColor cTRgbColor;
        synchronized (monitor()) {
            check_orphaned();
            cTRgbColor = (CTRgbColor) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTRgbColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public void removeRgbColor(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public void setRgbColorArray(CTRgbColor[] cTRgbColorArr) {
        check_orphaned();
        arraySetterHelper(cTRgbColorArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public int sizeOfRgbColorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public CTRgbColor getRgbColorArray(int i5) {
        CTRgbColor cTRgbColor;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRgbColor = (CTRgbColor) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTRgbColor == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRgbColor;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIndexedColors
    public void setRgbColorArray(int i5, CTRgbColor cTRgbColor) {
        generatedSetterHelperImpl(cTRgbColor, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
