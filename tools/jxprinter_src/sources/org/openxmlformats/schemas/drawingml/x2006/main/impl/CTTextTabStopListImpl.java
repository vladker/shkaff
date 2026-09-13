package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.b2;
import l5.d2;
import l5.g2;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextTabStopListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTextTabStopListImpl extends XmlComplexContentImpl implements CTTextTabStopList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "tab")};
    private static final long serialVersionUID = 1;

    public CTTextTabStopListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop addNewTab() {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop[] getTabArray() {
        return (CTTextTabStop[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTextTabStop[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public List<CTTextTabStop> getTabList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: l5.l2
                public final /* synthetic */ CTTextTabStopListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getTabArray(iIntValue);
                        default:
                            return this.b.insertNewTab(iIntValue);
                    }
                }
            }, new g2(this, 1), new Function(this) { // from class: l5.l2
                public final /* synthetic */ CTTextTabStopListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getTabArray(iIntValue);
                        default:
                            return this.b.insertNewTab(iIntValue);
                    }
                }
            }, new d2(this, 3), new b2(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop insertNewTab(int i5) {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStop = (CTTextTabStop) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void removeTab(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void setTabArray(CTTextTabStop[] cTTextTabStopArr) {
        check_orphaned();
        arraySetterHelper(cTTextTabStopArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public int sizeOfTabArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public CTTextTabStop getTabArray(int i5) {
        CTTextTabStop cTTextTabStop;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTextTabStop = (CTTextTabStop) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTTextTabStop == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTextTabStop;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList
    public void setTabArray(int i5, CTTextTabStop cTTextTabStop) {
        generatedSetterHelperImpl(cTTextTabStop, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
