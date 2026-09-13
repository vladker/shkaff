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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTGradientStopListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTGradientStopListImpl extends XmlComplexContentImpl implements CTGradientStopList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "gs")};
    private static final long serialVersionUID = 1;

    public CTGradientStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop addNewGs() {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop[] getGsArray() {
        return (CTGradientStop[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTGradientStop[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public List<CTGradientStop> getGsList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: l5.w0
                public final /* synthetic */ CTGradientStopListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getGsArray(iIntValue);
                        default:
                            return this.b.insertNewGs(iIntValue);
                    }
                }
            }, new b(this, 21), new Function(this) { // from class: l5.w0
                public final /* synthetic */ CTGradientStopListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getGsArray(iIntValue);
                        default:
                            return this.b.insertNewGs(iIntValue);
                    }
                }
            }, new c(this, 23), new d(this, 24));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop insertNewGs(int i5) {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientStop = (CTGradientStop) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void removeGs(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void setGsArray(CTGradientStop[] cTGradientStopArr) {
        check_orphaned();
        arraySetterHelper(cTGradientStopArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public int sizeOfGsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public CTGradientStop getGsArray(int i5) {
        CTGradientStop cTGradientStop;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTGradientStop = (CTGradientStop) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTGradientStop == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTGradientStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStopList
    public void setGsArray(int i5, CTGradientStop cTGradientStop) {
        generatedSetterHelperImpl(cTGradientStop, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
