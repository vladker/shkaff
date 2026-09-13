package org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.b2;
import l5.d2;
import l5.g2;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.CTPropertiesImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTPropertiesImpl extends XmlComplexContentImpl implements CTProperties {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/custom-properties", "property")};
    private static final long serialVersionUID = 1;

    public CTPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty addNewProperty() {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty[] getPropertyArray() {
        return (CTProperty[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTProperty[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public List<CTProperty> getPropertyList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: n5.a
                public final /* synthetic */ CTPropertiesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getPropertyArray(iIntValue);
                        default:
                            return this.b.insertNewProperty(iIntValue);
                    }
                }
            }, new g2(this, 2), new Function(this) { // from class: n5.a
                public final /* synthetic */ CTPropertiesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getPropertyArray(iIntValue);
                        default:
                            return this.b.insertNewProperty(iIntValue);
                    }
                }
            }, new d2(this, 4), new b2(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty insertNewProperty(int i5) {
        CTProperty cTProperty;
        synchronized (monitor()) {
            check_orphaned();
            cTProperty = (CTProperty) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void removeProperty(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void setPropertyArray(CTProperty[] cTPropertyArr) {
        check_orphaned();
        arraySetterHelper(cTPropertyArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public int sizeOfPropertyArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public CTProperty getPropertyArray(int i5) {
        CTProperty cTProperty;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTProperty = (CTProperty) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTProperty == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTProperty;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties
    public void setPropertyArray(int i5, CTProperty cTProperty) {
        generatedSetterHelperImpl(cTProperty, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
