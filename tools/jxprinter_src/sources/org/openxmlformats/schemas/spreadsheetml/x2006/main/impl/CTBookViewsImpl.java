package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTBookViewsImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTBookViewsImpl extends XmlComplexContentImpl implements CTBookViews {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "workbookView")};
    private static final long serialVersionUID = 1;

    public CTBookViewsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView addNewWorkbookView() {
        CTBookView cTBookView;
        synchronized (monitor()) {
            check_orphaned();
            cTBookView = (CTBookView) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTBookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView[] getWorkbookViewArray() {
        return (CTBookView[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTBookView[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public List<CTBookView> getWorkbookViewList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.e
                public final /* synthetic */ CTBookViewsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getWorkbookViewArray(iIntValue);
                        default:
                            return this.b.insertNewWorkbookView(iIntValue);
                    }
                }
            }, new g2(this, 18), new Function(this) { // from class: r5.e
                public final /* synthetic */ CTBookViewsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getWorkbookViewArray(iIntValue);
                        default:
                            return this.b.insertNewWorkbookView(iIntValue);
                    }
                }
            }, new d2(this, 28), new b2(this, 28));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView insertNewWorkbookView(int i5) {
        CTBookView cTBookView;
        synchronized (monitor()) {
            check_orphaned();
            cTBookView = (CTBookView) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTBookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public void removeWorkbookView(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public void setWorkbookViewArray(CTBookView[] cTBookViewArr) {
        check_orphaned();
        arraySetterHelper(cTBookViewArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public int sizeOfWorkbookViewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public CTBookView getWorkbookViewArray(int i5) {
        CTBookView cTBookView;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBookView = (CTBookView) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTBookView == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBookView;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews
    public void setWorkbookViewArray(int i5, CTBookView cTBookView) {
        generatedSetterHelperImpl(cTBookView, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
