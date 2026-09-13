package com.microsoft.schemas.office.x2006.digsig.impl;

import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.STPositiveInteger;
import com.microsoft.schemas.office.x2006.digsig.STSignatureComments;
import com.microsoft.schemas.office.x2006.digsig.STSignatureProviderUrl;
import com.microsoft.schemas.office.x2006.digsig.STSignatureText;
import com.microsoft.schemas.office.x2006.digsig.STSignatureType;
import com.microsoft.schemas.office.x2006.digsig.STUniqueIdentifierWithBraces;
import com.microsoft.schemas.office.x2006.digsig.STVersion;
import javax.xml.namespace.QName;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CTSignatureInfoV1Impl extends XmlComplexContentImpl implements CTSignatureInfoV1 {
    private static final QName[] PROPERTY_QNAME = {new QName(SignatureFacet.MS_DIGSIG_NS, "SetupID"), new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureText"), new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureImage"), new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureComments"), new QName(SignatureFacet.MS_DIGSIG_NS, "WindowsVersion"), new QName(SignatureFacet.MS_DIGSIG_NS, "OfficeVersion"), new QName(SignatureFacet.MS_DIGSIG_NS, "ApplicationVersion"), new QName(SignatureFacet.MS_DIGSIG_NS, "Monitors"), new QName(SignatureFacet.MS_DIGSIG_NS, "HorizontalResolution"), new QName(SignatureFacet.MS_DIGSIG_NS, "VerticalResolution"), new QName(SignatureFacet.MS_DIGSIG_NS, "ColorDepth"), new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureProviderId"), new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureProviderUrl"), new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureProviderDetails"), new QName(SignatureFacet.MS_DIGSIG_NS, "SignatureType"), new QName(SignatureFacet.MS_DIGSIG_NS, "DelegateSuggestedSigner"), new QName(SignatureFacet.MS_DIGSIG_NS, "DelegateSuggestedSigner2"), new QName(SignatureFacet.MS_DIGSIG_NS, "DelegateSuggestedSignerEmail"), new QName(SignatureFacet.MS_DIGSIG_NS, "ManifestHashAlgorithm")};
    private static final long serialVersionUID = 1;

    public CTSignatureInfoV1Impl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getApplicationVersion() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getColorDepth() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getDelegateSuggestedSigner() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getDelegateSuggestedSigner2() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[16], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getDelegateSuggestedSignerEmail() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[17], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getHorizontalResolution() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getManifestHashAlgorithm() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[18], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getMonitors() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getOfficeVersion() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSetupID() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureComments() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public byte[] getSignatureImage() {
        byte[] byteArrayValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            byteArrayValue = simpleValue == null ? null : simpleValue.getByteArrayValue();
        }
        return byteArrayValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getSignatureProviderDetails() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureProviderId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureProviderUrl() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getSignatureText() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getSignatureType() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public int getVerticalResolution() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            intValue = 0;
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (simpleValue != null) {
                intValue = simpleValue.getIntValue();
            }
        }
        return intValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public String getWindowsVersion() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetDelegateSuggestedSigner() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetDelegateSuggestedSigner2() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[16]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetDelegateSuggestedSignerEmail() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[17]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public boolean isSetManifestHashAlgorithm() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[18]) != 0;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setApplicationVersion(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[6], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[6]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setColorDepth(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[10], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[10]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setDelegateSuggestedSigner(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[15], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[15]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setDelegateSuggestedSigner2(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[16], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[16]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setDelegateSuggestedSignerEmail(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[17], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[17]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setHorizontalResolution(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[8], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[8]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setManifestHashAlgorithm(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[18], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[18]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setMonitors(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[7], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[7]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setOfficeVersion(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[5], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[5]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSetupID(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[0], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[0]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureComments(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[3], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[3]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureImage(byte[] bArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[2], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[2]);
                }
                simpleValue.setByteArrayValue(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureProviderDetails(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[13], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[13]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureProviderId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[11], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[11]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureProviderUrl(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[12], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[12]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureText(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[1], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[1]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setSignatureType(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[14], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[14]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setVerticalResolution(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[9], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[9]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void setWindowsVersion(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qNameArr[4], 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qNameArr[4]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetDelegateSuggestedSigner() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetDelegateSuggestedSigner2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetDelegateSuggestedSignerEmail() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void unsetManifestHashAlgorithm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], 0);
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STVersion xgetApplicationVersion() {
        STVersion sTVersionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVersionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], 0);
        }
        return sTVersionFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetColorDepth() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlString xgetDelegateSuggestedSigner() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[15], 0);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlString xgetDelegateSuggestedSigner2() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[16], 0);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlString xgetDelegateSuggestedSignerEmail() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_element_user(PROPERTY_QNAME[17], 0);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetHorizontalResolution() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlAnyURI xgetManifestHashAlgorithm() {
        XmlAnyURI xmlAnyURI;
        synchronized (monitor()) {
            check_orphaned();
            xmlAnyURI = (XmlAnyURI) get_store().find_element_user(PROPERTY_QNAME[18], 0);
        }
        return xmlAnyURI;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetMonitors() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(PROPERTY_QNAME[7], 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STVersion xgetOfficeVersion() {
        STVersion sTVersionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVersionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], 0);
        }
        return sTVersionFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STUniqueIdentifierWithBraces xgetSetupID() {
        STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces;
        synchronized (monitor()) {
            check_orphaned();
            sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces) get_store().find_element_user(PROPERTY_QNAME[0], 0);
        }
        return sTUniqueIdentifierWithBraces;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureComments xgetSignatureComments() {
        STSignatureComments sTSignatureComments;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureComments = (STSignatureComments) get_store().find_element_user(PROPERTY_QNAME[3], 0);
        }
        return sTSignatureComments;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlBase64Binary xgetSignatureImage() {
        XmlBase64Binary xmlBase64Binary;
        synchronized (monitor()) {
            check_orphaned();
            xmlBase64Binary = (XmlBase64Binary) get_store().find_element_user(PROPERTY_QNAME[2], 0);
        }
        return xmlBase64Binary;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public XmlInt xgetSignatureProviderDetails() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_element_user(PROPERTY_QNAME[13], 0);
        }
        return xmlInt;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STUniqueIdentifierWithBraces xgetSignatureProviderId() {
        STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces;
        synchronized (monitor()) {
            check_orphaned();
            sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces) get_store().find_element_user(PROPERTY_QNAME[11], 0);
        }
        return sTUniqueIdentifierWithBraces;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureProviderUrl xgetSignatureProviderUrl() {
        STSignatureProviderUrl sTSignatureProviderUrlFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureProviderUrlFind_element_user = get_store().find_element_user(PROPERTY_QNAME[12], 0);
        }
        return sTSignatureProviderUrlFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureText xgetSignatureText() {
        STSignatureText sTSignatureTextFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureTextFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], 0);
        }
        return sTSignatureTextFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STSignatureType xgetSignatureType() {
        STSignatureType sTSignatureType;
        synchronized (monitor()) {
            check_orphaned();
            sTSignatureType = (STSignatureType) get_store().find_element_user(PROPERTY_QNAME[14], 0);
        }
        return sTSignatureType;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STPositiveInteger xgetVerticalResolution() {
        STPositiveInteger sTPositiveIntegerFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveIntegerFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], 0);
        }
        return sTPositiveIntegerFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public STVersion xgetWindowsVersion() {
        STVersion sTVersionFind_element_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVersionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], 0);
        }
        return sTVersionFind_element_user;
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetApplicationVersion(STVersion sTVersion) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STVersion sTVersionFind_element_user = typeStore.find_element_user(qNameArr[6], 0);
                if (sTVersionFind_element_user == null) {
                    sTVersionFind_element_user = (STVersion) get_store().add_element_user(qNameArr[6]);
                }
                sTVersionFind_element_user.set(sTVersion);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetColorDepth(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qNameArr[10], 0);
                if (sTPositiveIntegerFind_element_user == null) {
                    sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qNameArr[10]);
                }
                sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetDelegateSuggestedSigner(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qNameArr[15], 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qNameArr[15]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetDelegateSuggestedSigner2(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qNameArr[16], 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qNameArr[16]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetDelegateSuggestedSignerEmail(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_element_user(qNameArr[17], 0);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_element_user(qNameArr[17]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetHorizontalResolution(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qNameArr[8], 0);
                if (sTPositiveIntegerFind_element_user == null) {
                    sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qNameArr[8]);
                }
                sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetManifestHashAlgorithm(XmlAnyURI xmlAnyURI) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_element_user(qNameArr[18], 0);
                if (xmlAnyURI2 == null) {
                    xmlAnyURI2 = (XmlAnyURI) get_store().add_element_user(qNameArr[18]);
                }
                xmlAnyURI2.set(xmlAnyURI);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetMonitors(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qNameArr[7], 0);
                if (sTPositiveIntegerFind_element_user == null) {
                    sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qNameArr[7]);
                }
                sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetOfficeVersion(STVersion sTVersion) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STVersion sTVersionFind_element_user = typeStore.find_element_user(qNameArr[5], 0);
                if (sTVersionFind_element_user == null) {
                    sTVersionFind_element_user = (STVersion) get_store().add_element_user(qNameArr[5]);
                }
                sTVersionFind_element_user.set(sTVersion);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSetupID(STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces2 = (STUniqueIdentifierWithBraces) typeStore.find_element_user(qNameArr[0], 0);
                if (sTUniqueIdentifierWithBraces2 == null) {
                    sTUniqueIdentifierWithBraces2 = (STUniqueIdentifierWithBraces) get_store().add_element_user(qNameArr[0]);
                }
                sTUniqueIdentifierWithBraces2.set(sTUniqueIdentifierWithBraces);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureComments(STSignatureComments sTSignatureComments) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STSignatureComments sTSignatureComments2 = (STSignatureComments) typeStore.find_element_user(qNameArr[3], 0);
                if (sTSignatureComments2 == null) {
                    sTSignatureComments2 = (STSignatureComments) get_store().add_element_user(qNameArr[3]);
                }
                sTSignatureComments2.set(sTSignatureComments);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureImage(XmlBase64Binary xmlBase64Binary) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBase64Binary xmlBase64Binary2 = (XmlBase64Binary) typeStore.find_element_user(qNameArr[2], 0);
                if (xmlBase64Binary2 == null) {
                    xmlBase64Binary2 = (XmlBase64Binary) get_store().add_element_user(qNameArr[2]);
                }
                xmlBase64Binary2.set(xmlBase64Binary);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureProviderDetails(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_element_user(qNameArr[13], 0);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_element_user(qNameArr[13]);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureProviderId(STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces2 = (STUniqueIdentifierWithBraces) typeStore.find_element_user(qNameArr[11], 0);
                if (sTUniqueIdentifierWithBraces2 == null) {
                    sTUniqueIdentifierWithBraces2 = (STUniqueIdentifierWithBraces) get_store().add_element_user(qNameArr[11]);
                }
                sTUniqueIdentifierWithBraces2.set(sTUniqueIdentifierWithBraces);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureProviderUrl(STSignatureProviderUrl sTSignatureProviderUrl) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STSignatureProviderUrl sTSignatureProviderUrlFind_element_user = typeStore.find_element_user(qNameArr[12], 0);
                if (sTSignatureProviderUrlFind_element_user == null) {
                    sTSignatureProviderUrlFind_element_user = (STSignatureProviderUrl) get_store().add_element_user(qNameArr[12]);
                }
                sTSignatureProviderUrlFind_element_user.set(sTSignatureProviderUrl);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureText(STSignatureText sTSignatureText) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STSignatureText sTSignatureTextFind_element_user = typeStore.find_element_user(qNameArr[1], 0);
                if (sTSignatureTextFind_element_user == null) {
                    sTSignatureTextFind_element_user = (STSignatureText) get_store().add_element_user(qNameArr[1]);
                }
                sTSignatureTextFind_element_user.set(sTSignatureText);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetSignatureType(STSignatureType sTSignatureType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STSignatureType sTSignatureType2 = (STSignatureType) typeStore.find_element_user(qNameArr[14], 0);
                if (sTSignatureType2 == null) {
                    sTSignatureType2 = (STSignatureType) get_store().add_element_user(qNameArr[14]);
                }
                sTSignatureType2.set(sTSignatureType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetVerticalResolution(STPositiveInteger sTPositiveInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPositiveInteger sTPositiveIntegerFind_element_user = typeStore.find_element_user(qNameArr[9], 0);
                if (sTPositiveIntegerFind_element_user == null) {
                    sTPositiveIntegerFind_element_user = (STPositiveInteger) get_store().add_element_user(qNameArr[9]);
                }
                sTPositiveIntegerFind_element_user.set(sTPositiveInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1
    public void xsetWindowsVersion(STVersion sTVersion) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STVersion sTVersionFind_element_user = typeStore.find_element_user(qNameArr[4], 0);
                if (sTVersionFind_element_user == null) {
                    sTVersionFind_element_user = (STVersion) get_store().add_element_user(qNameArr[4]);
                }
                sTVersionFind_element_user.set(sTVersion);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
