package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.AttachedToolbarsType;
import com.microsoft.schemas.office.visio.x2012.main.CustomMenusFileType;
import com.microsoft.schemas.office.visio.x2012.main.CustomToolbarsFileType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.DynamicGridEnabledType;
import com.microsoft.schemas.office.visio.x2012.main.GlueSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectBkgndsType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectMastersType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectShapesType;
import com.microsoft.schemas.office.visio.x2012.main.ProtectStylesType;
import com.microsoft.schemas.office.visio.x2012.main.SnapAnglesType;
import com.microsoft.schemas.office.visio.x2012.main.SnapExtensionsType;
import com.microsoft.schemas.office.visio.x2012.main.SnapSettingsType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentSettingsTypeImpl extends XmlComplexContentImpl implements DocumentSettingsType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "GlueSettings"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "SnapSettings"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "SnapExtensions"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "SnapAngles"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "DynamicGridEnabled"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectStyles"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectShapes"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectMasters"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "ProtectBkgnds"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "CustomMenusFile"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "CustomToolbarsFile"), new QName("http://schemas.microsoft.com/office/visio/2012/main", "AttachedToolbars"), new QName("", "TopPage"), new QName("", "DefaultTextStyle"), new QName("", "DefaultLineStyle"), new QName("", "DefaultFillStyle"), new QName("", "DefaultGuideStyle")};
    private static final long serialVersionUID = 1;

    public DocumentSettingsTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public AttachedToolbarsType addNewAttachedToolbars() {
        AttachedToolbarsType attachedToolbarsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            attachedToolbarsTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return attachedToolbarsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomMenusFileType addNewCustomMenusFile() {
        CustomMenusFileType customMenusFileTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            customMenusFileTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return customMenusFileTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomToolbarsFileType addNewCustomToolbarsFile() {
        CustomToolbarsFileType customToolbarsFileTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            customToolbarsFileTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return customToolbarsFileTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public DynamicGridEnabledType addNewDynamicGridEnabled() {
        DynamicGridEnabledType dynamicGridEnabledTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            dynamicGridEnabledTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return dynamicGridEnabledTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public GlueSettingsType addNewGlueSettings() {
        GlueSettingsType glueSettingsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            glueSettingsTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return glueSettingsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectBkgndsType addNewProtectBkgnds() {
        ProtectBkgndsType protectBkgndsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectBkgndsTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return protectBkgndsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectMastersType addNewProtectMasters() {
        ProtectMastersType protectMastersTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectMastersTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return protectMastersTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectShapesType addNewProtectShapes() {
        ProtectShapesType protectShapesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectShapesTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return protectShapesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectStylesType addNewProtectStyles() {
        ProtectStylesType protectStylesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectStylesTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return protectStylesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapAnglesType addNewSnapAngles() {
        SnapAnglesType snapAnglesTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapAnglesTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return snapAnglesTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapExtensionsType addNewSnapExtensions() {
        SnapExtensionsType snapExtensionsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapExtensionsTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return snapExtensionsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapSettingsType addNewSnapSettings() {
        SnapSettingsType snapSettingsTypeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapSettingsTypeAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return snapSettingsTypeAdd_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public AttachedToolbarsType getAttachedToolbars() {
        AttachedToolbarsType attachedToolbarsTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            attachedToolbarsTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (attachedToolbarsTypeFind_element_user == null) {
                attachedToolbarsTypeFind_element_user = null;
            }
        }
        return attachedToolbarsTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomMenusFileType getCustomMenusFile() {
        CustomMenusFileType customMenusFileTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            customMenusFileTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (customMenusFileTypeFind_element_user == null) {
                customMenusFileTypeFind_element_user = null;
            }
        }
        return customMenusFileTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public CustomToolbarsFileType getCustomToolbarsFile() {
        CustomToolbarsFileType customToolbarsFileTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            customToolbarsFileTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (customToolbarsFileTypeFind_element_user == null) {
                customToolbarsFileTypeFind_element_user = null;
            }
        }
        return customToolbarsFileTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultFillStyle() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[15]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultGuideStyle() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[16]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultLineStyle() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[14]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getDefaultTextStyle() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[13]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public DynamicGridEnabledType getDynamicGridEnabled() {
        DynamicGridEnabledType dynamicGridEnabledTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            dynamicGridEnabledTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (dynamicGridEnabledTypeFind_element_user == null) {
                dynamicGridEnabledTypeFind_element_user = null;
            }
        }
        return dynamicGridEnabledTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public GlueSettingsType getGlueSettings() {
        GlueSettingsType glueSettingsTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            glueSettingsTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (glueSettingsTypeFind_element_user == null) {
                glueSettingsTypeFind_element_user = null;
            }
        }
        return glueSettingsTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectBkgndsType getProtectBkgnds() {
        ProtectBkgndsType protectBkgndsTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectBkgndsTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (protectBkgndsTypeFind_element_user == null) {
                protectBkgndsTypeFind_element_user = null;
            }
        }
        return protectBkgndsTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectMastersType getProtectMasters() {
        ProtectMastersType protectMastersTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectMastersTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (protectMastersTypeFind_element_user == null) {
                protectMastersTypeFind_element_user = null;
            }
        }
        return protectMastersTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectShapesType getProtectShapes() {
        ProtectShapesType protectShapesTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectShapesTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (protectShapesTypeFind_element_user == null) {
                protectShapesTypeFind_element_user = null;
            }
        }
        return protectShapesTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public ProtectStylesType getProtectStyles() {
        ProtectStylesType protectStylesTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            protectStylesTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (protectStylesTypeFind_element_user == null) {
                protectStylesTypeFind_element_user = null;
            }
        }
        return protectStylesTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapAnglesType getSnapAngles() {
        SnapAnglesType snapAnglesTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapAnglesTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (snapAnglesTypeFind_element_user == null) {
                snapAnglesTypeFind_element_user = null;
            }
        }
        return snapAnglesTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapExtensionsType getSnapExtensions() {
        SnapExtensionsType snapExtensionsTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapExtensionsTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (snapExtensionsTypeFind_element_user == null) {
                snapExtensionsTypeFind_element_user = null;
            }
        }
        return snapExtensionsTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public SnapSettingsType getSnapSettings() {
        SnapSettingsType snapSettingsTypeFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            snapSettingsTypeFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (snapSettingsTypeFind_element_user == null) {
                snapSettingsTypeFind_element_user = null;
            }
        }
        return snapSettingsTypeFind_element_user;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public long getTopPage() {
        long longValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[12]);
            longValue = simpleValue == null ? 0L : simpleValue.getLongValue();
        }
        return longValue;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetAttachedToolbars() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetCustomMenusFile() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetCustomToolbarsFile() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultFillStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[15]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultGuideStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[16]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultLineStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[14]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDefaultTextStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[13]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetDynamicGridEnabled() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetGlueSettings() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectBkgnds() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectMasters() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectShapes() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetProtectStyles() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetSnapAngles() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetSnapExtensions() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetSnapSettings() {
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

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public boolean isSetTopPage() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[12]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setAttachedToolbars(AttachedToolbarsType attachedToolbarsType) {
        generatedSetterHelperImpl(attachedToolbarsType, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setCustomMenusFile(CustomMenusFileType customMenusFileType) {
        generatedSetterHelperImpl(customMenusFileType, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setCustomToolbarsFile(CustomToolbarsFileType customToolbarsFileType) {
        generatedSetterHelperImpl(customToolbarsFileType, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultFillStyle(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[15]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[15]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultGuideStyle(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[16]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[16]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultLineStyle(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[14]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[14]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDefaultTextStyle(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[13]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[13]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setDynamicGridEnabled(DynamicGridEnabledType dynamicGridEnabledType) {
        generatedSetterHelperImpl(dynamicGridEnabledType, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setGlueSettings(GlueSettingsType glueSettingsType) {
        generatedSetterHelperImpl(glueSettingsType, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectBkgnds(ProtectBkgndsType protectBkgndsType) {
        generatedSetterHelperImpl(protectBkgndsType, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectMasters(ProtectMastersType protectMastersType) {
        generatedSetterHelperImpl(protectMastersType, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectShapes(ProtectShapesType protectShapesType) {
        generatedSetterHelperImpl(protectShapesType, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setProtectStyles(ProtectStylesType protectStylesType) {
        generatedSetterHelperImpl(protectStylesType, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setSnapAngles(SnapAnglesType snapAnglesType) {
        generatedSetterHelperImpl(snapAnglesType, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setSnapExtensions(SnapExtensionsType snapExtensionsType) {
        generatedSetterHelperImpl(snapExtensionsType, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setSnapSettings(SnapSettingsType snapSettingsType) {
        generatedSetterHelperImpl(snapSettingsType, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void setTopPage(long j6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[12]);
                }
                simpleValue.setLongValue(j6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetAttachedToolbars() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetCustomMenusFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetCustomToolbarsFile() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultFillStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[15]);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultGuideStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[16]);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultLineStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[14]);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDefaultTextStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[13]);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetDynamicGridEnabled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetGlueSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectBkgnds() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectMasters() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectShapes() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetProtectStyles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetSnapAngles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetSnapExtensions() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetSnapSettings() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void unsetTopPage() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[12]);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultFillStyle() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[15]);
        }
        return xmlUnsignedInt;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultGuideStyle() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[16]);
        }
        return xmlUnsignedInt;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultLineStyle() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[14]);
        }
        return xmlUnsignedInt;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetDefaultTextStyle() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[13]);
        }
        return xmlUnsignedInt;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public XmlUnsignedInt xgetTopPage() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(PROPERTY_QNAME[12]);
        }
        return xmlUnsignedInt;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultFillStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[15]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[15]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultGuideStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[16]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[16]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultLineStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[14]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[14]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetDefaultTextStyle(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[13]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[13]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType
    public void xsetTopPage(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qNameArr[12]);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qNameArr[12]);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
