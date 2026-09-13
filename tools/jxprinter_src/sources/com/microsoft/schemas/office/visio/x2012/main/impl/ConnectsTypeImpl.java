package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ConnectType;
import com.microsoft.schemas.office.visio.x2012.main.ConnectsType;
import com.microsoft.schemas.office.visio.x2012.main.impl.ConnectsTypeImpl;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import r5.B0;
import r5.C1551a0;
import r5.C1553b0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ConnectsTypeImpl extends XmlComplexContentImpl implements ConnectsType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "Connect")};
    private static final long serialVersionUID = 1;

    public ConnectsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType addNewConnect() {
        ConnectType connectType;
        synchronized (monitor()) {
            check_orphaned();
            connectType = (ConnectType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return connectType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType[] getConnectArray() {
        return (ConnectType[]) getXmlObjectArray(PROPERTY_QNAME[0], new ConnectType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public List<ConnectType> getConnectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: s2.c
                public final /* synthetic */ ConnectsTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getConnectArray(iIntValue);
                        default:
                            return this.b.insertNewConnect(iIntValue);
                    }
                }
            }, new B0(this, 14), new Function(this) { // from class: s2.c
                public final /* synthetic */ ConnectsTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getConnectArray(iIntValue);
                        default:
                            return this.b.insertNewConnect(iIntValue);
                    }
                }
            }, new C1551a0(this, 29), new C1553b0(this, 29));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType insertNewConnect(int i5) {
        ConnectType connectType;
        synchronized (monitor()) {
            check_orphaned();
            connectType = (ConnectType) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return connectType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public void removeConnect(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public void setConnectArray(ConnectType[] connectTypeArr) {
        check_orphaned();
        arraySetterHelper(connectTypeArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public int sizeOfConnectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public ConnectType getConnectArray(int i5) {
        ConnectType connectType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                connectType = (ConnectType) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (connectType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return connectType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.ConnectsType
    public void setConnectArray(int i5, ConnectType connectType) {
        generatedSetterHelperImpl(connectType, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
