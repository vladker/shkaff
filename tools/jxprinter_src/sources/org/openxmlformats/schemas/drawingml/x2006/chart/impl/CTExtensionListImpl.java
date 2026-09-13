package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import H4.d;
import J4.c;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtension;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTExtensionListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTExtensionListImpl extends XmlComplexContentImpl implements CTExtensionList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_CHART, "ext")};
    private static final long serialVersionUID = 1;

    public CTExtensionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension addNewExt() {
        CTExtension cTExtensionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExtensionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension[] getExtArray() {
        return getXmlObjectArray(PROPERTY_QNAME[0], (XmlObject[]) new CTExtension[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public List<CTExtension> getExtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: k5.M
                public final /* synthetic */ CTExtensionListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getExtArray(iIntValue);
                        default:
                            return this.b.insertNewExt(iIntValue);
                    }
                }
            }, new BiConsumer() { // from class: k5.N
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5621a.setExtArray(((Integer) obj).intValue(), (CTExtension) obj2);
                }
            }, new Function(this) { // from class: k5.M
                public final /* synthetic */ CTExtensionListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getExtArray(iIntValue);
                        default:
                            return this.b.insertNewExt(iIntValue);
                    }
                }
            }, new c(this, 10), new d(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension insertNewExt(int i5) {
        CTExtension cTExtensionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTExtensionInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public void removeExt(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public void setExtArray(CTExtension[] cTExtensionArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTExtensionArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public int sizeOfExtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public CTExtension getExtArray(int i5) {
        CTExtension cTExtensionFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTExtensionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTExtensionFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTExtensionFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTExtensionList
    public void setExtArray(int i5, CTExtension cTExtension) {
        generatedSetterHelperImpl(cTExtension, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
