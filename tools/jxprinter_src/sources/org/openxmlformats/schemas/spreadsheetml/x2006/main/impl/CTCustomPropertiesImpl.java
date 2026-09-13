package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCustomPropertiesImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTCustomPropertiesImpl extends XmlComplexContentImpl implements CTCustomProperties {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "customPr")};
    private static final long serialVersionUID = 1;

    public CTCustomPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty addNewCustomPr() {
        CTCustomProperty cTCustomProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomProperty = (CTCustomProperty) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTCustomProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty[] getCustomPrArray() {
        return (CTCustomProperty[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTCustomProperty[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public List<CTCustomProperty> getCustomPrList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.A
                public final /* synthetic */ CTCustomPropertiesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCustomPrArray(iIntValue);
                        default:
                            return this.b.insertNewCustomPr(iIntValue);
                    }
                }
            }, new B(this, 0), new Function(this) { // from class: r5.A
                public final /* synthetic */ CTCustomPropertiesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCustomPrArray(iIntValue);
                        default:
                            return this.b.insertNewCustomPr(iIntValue);
                    }
                }
            }, new C1566i(this, 12), new C1568j(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty insertNewCustomPr(int i5) {
        CTCustomProperty cTCustomProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomProperty = (CTCustomProperty) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTCustomProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public void removeCustomPr(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public void setCustomPrArray(CTCustomProperty[] cTCustomPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTCustomPropertyArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public int sizeOfCustomPrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public CTCustomProperty getCustomPrArray(int i5) {
        CTCustomProperty cTCustomProperty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCustomProperty = (CTCustomProperty) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTCustomProperty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCustomProperty;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperties
    public void setCustomPrArray(int i5, CTCustomProperty cTCustomProperty) {
        generatedSetterHelperImpl(cTCustomProperty, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
