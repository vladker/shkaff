package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType;
import com.microsoft.schemas.office.visio.x2012.main.impl.StyleSheetsTypeImpl;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import p105s2.i;
import p105s2.j;
import r5.B0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class StyleSheetsTypeImpl extends XmlComplexContentImpl implements StyleSheetsType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "StyleSheet")};
    private static final long serialVersionUID = 1;

    public StyleSheetsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public StyleSheetType addNewStyleSheet() {
        StyleSheetType styleSheetType;
        synchronized (monitor()) {
            check_orphaned();
            styleSheetType = (StyleSheetType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return styleSheetType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public StyleSheetType[] getStyleSheetArray() {
        return (StyleSheetType[]) getXmlObjectArray(PROPERTY_QNAME[0], new StyleSheetType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public List<StyleSheetType> getStyleSheetList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: s2.x
                public final /* synthetic */ StyleSheetsTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getStyleSheetArray(iIntValue);
                        default:
                            return this.b.insertNewStyleSheet(iIntValue);
                    }
                }
            }, new B0(this, 18), new Function(this) { // from class: s2.x
                public final /* synthetic */ StyleSheetsTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getStyleSheetArray(iIntValue);
                        default:
                            return this.b.insertNewStyleSheet(iIntValue);
                    }
                }
            }, new i(this, 2), new j(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public StyleSheetType insertNewStyleSheet(int i5) {
        StyleSheetType styleSheetType;
        synchronized (monitor()) {
            check_orphaned();
            styleSheetType = (StyleSheetType) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return styleSheetType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public void removeStyleSheet(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public void setStyleSheetArray(StyleSheetType[] styleSheetTypeArr) {
        check_orphaned();
        arraySetterHelper(styleSheetTypeArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public int sizeOfStyleSheetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public StyleSheetType getStyleSheetArray(int i5) {
        StyleSheetType styleSheetType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                styleSheetType = (StyleSheetType) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (styleSheetType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return styleSheetType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType
    public void setStyleSheetArray(int i5, StyleSheetType styleSheetType) {
        generatedSetterHelperImpl(styleSheetType, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
