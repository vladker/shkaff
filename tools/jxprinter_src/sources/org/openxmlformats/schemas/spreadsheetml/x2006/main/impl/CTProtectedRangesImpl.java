package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRange;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTProtectedRangesImpl;
import r5.B;
import r5.C1551a0;
import r5.C1553b0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTProtectedRangesImpl extends XmlComplexContentImpl implements CTProtectedRanges {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "protectedRange")};
    private static final long serialVersionUID = 1;

    public CTProtectedRangesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange addNewProtectedRange() {
        CTProtectedRange cTProtectedRange;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRange = (CTProtectedRange) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTProtectedRange;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange[] getProtectedRangeArray() {
        return (CTProtectedRange[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTProtectedRange[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public List<CTProtectedRange> getProtectedRangeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.v0
                public final /* synthetic */ CTProtectedRangesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getProtectedRangeArray(iIntValue);
                        default:
                            return this.b.insertNewProtectedRange(iIntValue);
                    }
                }
            }, new B(this, 29), new Function(this) { // from class: r5.v0
                public final /* synthetic */ CTProtectedRangesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getProtectedRangeArray(iIntValue);
                        default:
                            return this.b.insertNewProtectedRange(iIntValue);
                    }
                }
            }, new C1551a0(this, 14), new C1553b0(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange insertNewProtectedRange(int i5) {
        CTProtectedRange cTProtectedRange;
        synchronized (monitor()) {
            check_orphaned();
            cTProtectedRange = (CTProtectedRange) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTProtectedRange;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public void removeProtectedRange(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public void setProtectedRangeArray(CTProtectedRange[] cTProtectedRangeArr) {
        check_orphaned();
        arraySetterHelper(cTProtectedRangeArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public int sizeOfProtectedRangeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public CTProtectedRange getProtectedRangeArray(int i5) {
        CTProtectedRange cTProtectedRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTProtectedRange = (CTProtectedRange) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTProtectedRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTProtectedRange;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRanges
    public void setProtectedRangeArray(int i5, CTProtectedRange cTProtectedRange) {
        generatedSetterHelperImpl(cTProtectedRange, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
