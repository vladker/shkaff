package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ConnectsType;
import com.microsoft.schemas.office.visio.x2012.main.PageContentsType;
import com.microsoft.schemas.office.visio.x2012.main.ShapesType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PageContentsTypeImpl extends XmlComplexContentImpl implements PageContentsType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "Shapes"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "Connects")};
    private static final long serialVersionUID = 1;

    public PageContentsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ConnectsType addNewConnects() {
        ConnectsType connectsType;
        synchronized (monitor()) {
            check_orphaned();
            connectsType = (ConnectsType) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return connectsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ShapesType addNewShapes() {
        ShapesType shapesType;
        synchronized (monitor()) {
            check_orphaned();
            shapesType = (ShapesType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return shapesType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ConnectsType getConnects() {
        ConnectsType connectsType;
        synchronized (monitor()) {
            check_orphaned();
            connectsType = (ConnectsType) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (connectsType == null) {
                connectsType = null;
            }
        }
        return connectsType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public ShapesType getShapes() {
        ShapesType shapesType;
        synchronized (monitor()) {
            check_orphaned();
            shapesType = (ShapesType) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (shapesType == null) {
                shapesType = null;
            }
        }
        return shapesType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public boolean isSetConnects() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public boolean isSetShapes() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void setConnects(ConnectsType connectsType) {
        generatedSetterHelperImpl(connectsType, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void setShapes(ShapesType shapesType) {
        generatedSetterHelperImpl(shapesType, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void unsetConnects() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PageContentsType
    public void unsetShapes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
