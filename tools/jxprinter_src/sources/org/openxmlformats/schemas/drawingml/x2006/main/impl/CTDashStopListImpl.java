package org.openxmlformats.schemas.drawingml.x2006.main.impl;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTDashStopListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTDashStopListImpl extends XmlComplexContentImpl implements CTDashStopList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "ds")};
    private static final long serialVersionUID = 1;

    public CTDashStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop addNewDs() {
        CTDashStop cTDashStop;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStop = (CTDashStop) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTDashStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop[] getDsArray() {
        return (CTDashStop[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTDashStop[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public List<CTDashStop> getDsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: l5.D
                public final /* synthetic */ CTDashStopListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getDsArray(iIntValue);
                        default:
                            return this.b.insertNewDs(iIntValue);
                    }
                }
            }, new b(this, 18), new Function(this) { // from class: l5.D
                public final /* synthetic */ CTDashStopListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getDsArray(iIntValue);
                        default:
                            return this.b.insertNewDs(iIntValue);
                    }
                }
            }, new c(this, 19), new d(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop insertNewDs(int i5) {
        CTDashStop cTDashStop;
        synchronized (monitor()) {
            check_orphaned();
            cTDashStop = (CTDashStop) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTDashStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public void removeDs(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public void setDsArray(CTDashStop[] cTDashStopArr) {
        check_orphaned();
        arraySetterHelper(cTDashStopArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public int sizeOfDsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public CTDashStop getDsArray(int i5) {
        CTDashStop cTDashStop;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDashStop = (CTDashStop) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTDashStop == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDashStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTDashStopList
    public void setDsArray(int i5, CTDashStop cTDashStop) {
        generatedSetterHelperImpl(cTDashStop, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
