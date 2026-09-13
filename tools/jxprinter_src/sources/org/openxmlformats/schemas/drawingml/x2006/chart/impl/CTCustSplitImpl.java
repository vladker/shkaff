package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import H4.d;
import J4.b;
import J4.c;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTCustSplitImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTCustSplitImpl extends XmlComplexContentImpl implements CTCustSplit {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_CHART, "secondPiePt")};
    private static final long serialVersionUID = 1;

    public CTCustSplitImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt addNewSecondPiePt() {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt[] getSecondPiePtArray() {
        return (CTUnsignedInt[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTUnsignedInt[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public List<CTUnsignedInt> getSecondPiePtList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: k5.I
                public final /* synthetic */ CTCustSplitImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSecondPiePtArray(iIntValue);
                        default:
                            return this.b.insertNewSecondPiePt(iIntValue);
                    }
                }
            }, new b(this, 7), new Function(this) { // from class: k5.I
                public final /* synthetic */ CTCustSplitImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSecondPiePtArray(iIntValue);
                        default:
                            return this.b.insertNewSecondPiePt(iIntValue);
                    }
                }
            }, new c(this, 7), new d(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt insertNewSecondPiePt(int i5) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            cTUnsignedInt = (CTUnsignedInt) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public void removeSecondPiePt(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public void setSecondPiePtArray(CTUnsignedInt[] cTUnsignedIntArr) {
        check_orphaned();
        arraySetterHelper(cTUnsignedIntArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public int sizeOfSecondPiePtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public CTUnsignedInt getSecondPiePtArray(int i5) {
        CTUnsignedInt cTUnsignedInt;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTUnsignedInt = (CTUnsignedInt) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTUnsignedInt == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTCustSplit
    public void setSecondPiePtArray(int i5, CTUnsignedInt cTUnsignedInt) {
        generatedSetterHelperImpl(cTUnsignedInt, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
