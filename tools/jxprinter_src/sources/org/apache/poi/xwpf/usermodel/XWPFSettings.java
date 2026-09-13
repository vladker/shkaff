package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.RandomSingleton;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STAlgClass;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STAlgType;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STCryptProv;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTZoom;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDocProtect;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.SettingsDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFSettings extends POIXMLDocumentPart {
    private CTSettings ctSettings;

    /* JADX INFO: renamed from: org.apache.poi.xwpf.usermodel.XWPFSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm;

        static {
            int[] iArr = new int[HashAlgorithm.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm = iArr;
            try {
                iArr[HashAlgorithm.md2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.md4.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.md5.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha256.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha384.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[HashAlgorithm.sha512.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public XWPFSettings(PackagePart packagePart) {
        super(packagePart);
    }

    private void readFrom(InputStream inputStream) {
        try {
            this.ctSettings = SettingsDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSettings();
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to read data from input-stream", e);
        }
    }

    private CTDocProtect safeGetDocumentProtection() {
        if (this.ctSettings.getDocumentProtection() == null) {
            this.ctSettings.setDocumentProtection(CTDocProtect.Factory.newInstance());
        }
        return this.ctSettings.getDocumentProtection();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        if (this.ctSettings == null) {
            throw new IllegalStateException("Unable to write out settings that were never read in!");
        }
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTSettings.type.getName().getNamespaceURI(), "settings"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.ctSettings.save(outputStream, xmlOptions);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public boolean getEvenAndOddHeadings() {
        return this.ctSettings.isSetEvenAndOddHeaders();
    }

    public boolean getMirrorMargins() {
        return this.ctSettings.isSetMirrorMargins();
    }

    public long getZoomPercent() {
        CTZoom cTZoomAddNewZoom = !this.ctSettings.isSetZoom() ? this.ctSettings.addNewZoom() : this.ctSettings.getZoom();
        if (cTZoomAddNewZoom.getPercent() == null) {
            return 100L;
        }
        return POIXMLUnits.parsePercent(cTZoomAddNewZoom.xgetPercent()) / 1000;
    }

    public boolean isEnforcedWith() {
        CTDocProtect documentProtection = this.ctSettings.getDocumentProtection();
        return documentProtection != null && POIXMLUnits.parseOnOff(documentProtection.xgetEnforcement());
    }

    public boolean isTrackRevisions() {
        return this.ctSettings.isSetTrackRevisions();
    }

    public boolean isUpdateFields() {
        return this.ctSettings.isSetUpdateFields() && POIXMLUnits.parseOnOff(this.ctSettings.getUpdateFields().xgetVal());
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void removeEnforcement() {
        safeGetDocumentProtection().setEnforcement(STOnOff1.OFF);
    }

    public void setEnforcementEditValue(STDocProtect.Enum r6) {
        safeGetDocumentProtection().setEnforcement(STOnOff1.ON);
        safeGetDocumentProtection().setEdit(r6);
    }

    public void setEvenAndOddHeadings(boolean z6) {
        CTOnOff cTOnOffNewInstance = CTOnOff.Factory.newInstance();
        cTOnOffNewInstance.setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
        this.ctSettings.setEvenAndOddHeaders(cTOnOffNewInstance);
    }

    public void setMirrorMargins(boolean z6) {
        CTOnOff cTOnOffNewInstance = CTOnOff.Factory.newInstance();
        cTOnOffNewInstance.setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
        this.ctSettings.setMirrorMargins(cTOnOffNewInstance);
    }

    public void setTrackRevisions(boolean z6) {
        if (z6) {
            if (this.ctSettings.isSetTrackRevisions()) {
                return;
            }
            this.ctSettings.addNewTrackRevisions();
        } else if (this.ctSettings.isSetTrackRevisions()) {
            this.ctSettings.unsetTrackRevisions();
        }
    }

    public void setUpdateFields() {
        CTOnOff cTOnOffNewInstance = CTOnOff.Factory.newInstance();
        cTOnOffNewInstance.setVal(STOnOff1.ON);
        this.ctSettings.setUpdateFields(cTOnOffNewInstance);
    }

    public void setZoomPercent(long j6) {
        if (!this.ctSettings.isSetZoom()) {
            this.ctSettings.addNewZoom();
        }
        this.ctSettings.getZoom().setPercent(BigInteger.valueOf(j6));
    }

    public boolean validateProtectionPassword(String str) {
        HashAlgorithm hashAlgorithm;
        BigInteger cryptAlgorithmSid = safeGetDocumentProtection().getCryptAlgorithmSid();
        byte[] hash = safeGetDocumentProtection().getHash();
        byte[] salt = safeGetDocumentProtection().getSalt();
        BigInteger cryptSpinCount = safeGetDocumentProtection().getCryptSpinCount();
        if (cryptAlgorithmSid == null || hash == null || salt == null || cryptSpinCount == null) {
            return false;
        }
        int iIntValue = cryptAlgorithmSid.intValue();
        if (iIntValue == 1) {
            hashAlgorithm = HashAlgorithm.md2;
        } else if (iIntValue == 2) {
            hashAlgorithm = HashAlgorithm.md4;
        } else if (iIntValue == 3) {
            hashAlgorithm = HashAlgorithm.md5;
        } else if (iIntValue != 4) {
            switch (iIntValue) {
                case 12:
                    hashAlgorithm = HashAlgorithm.sha256;
                    break;
                case 13:
                    hashAlgorithm = HashAlgorithm.sha384;
                    break;
                case 14:
                    hashAlgorithm = HashAlgorithm.sha512;
                    break;
                default:
                    return false;
            }
        } else {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        return Arrays.equals(hash, CryptoFunctions.hashPassword(CryptoFunctions.xorHashPasswordReversed(str), hashAlgorithm, salt, cryptSpinCount.intValue(), false));
    }

    public XWPFSettings() {
        this.ctSettings = CTSettings.Factory.newInstance();
    }

    public boolean isEnforcedWith(STDocProtect.Enum r6) {
        CTDocProtect documentProtection = this.ctSettings.getDocumentProtection();
        return documentProtection != null && POIXMLUnits.parseOnOff(documentProtection.xgetEnforcement()) && documentProtection.getEdit().equals(r6);
    }

    public void setEnforcementEditValue(STDocProtect.Enum r6, String str, HashAlgorithm hashAlgorithm) {
        STCryptProv.Enum r7;
        int i5;
        safeGetDocumentProtection().setEnforcement(STOnOff1.ON);
        safeGetDocumentProtection().setEdit(r6);
        if (str == null) {
            if (safeGetDocumentProtection().isSetCryptProviderType()) {
                safeGetDocumentProtection().unsetCryptProviderType();
            }
            if (safeGetDocumentProtection().isSetCryptAlgorithmClass()) {
                safeGetDocumentProtection().unsetCryptAlgorithmClass();
            }
            if (safeGetDocumentProtection().isSetCryptAlgorithmType()) {
                safeGetDocumentProtection().unsetCryptAlgorithmType();
            }
            if (safeGetDocumentProtection().isSetCryptAlgorithmSid()) {
                safeGetDocumentProtection().unsetCryptAlgorithmSid();
            }
            if (safeGetDocumentProtection().isSetSalt()) {
                safeGetDocumentProtection().unsetSalt();
            }
            if (safeGetDocumentProtection().isSetCryptSpinCount()) {
                safeGetDocumentProtection().unsetCryptSpinCount();
            }
            if (safeGetDocumentProtection().isSetHash()) {
                safeGetDocumentProtection().unsetHash();
                return;
            }
            return;
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$HashAlgorithm[hashAlgorithm.ordinal()]) {
            case 1:
                r7 = STCryptProv.RSA_FULL;
                i5 = 1;
                break;
            case 2:
                r7 = STCryptProv.RSA_FULL;
                i5 = 2;
                break;
            case 3:
                r7 = STCryptProv.RSA_FULL;
                i5 = 3;
                break;
            case 4:
                r7 = STCryptProv.RSA_FULL;
                i5 = 4;
                break;
            case 5:
                r7 = STCryptProv.RSA_AES;
                i5 = 12;
                break;
            case 6:
                r7 = STCryptProv.RSA_AES;
                i5 = 13;
                break;
            case 7:
                r7 = STCryptProv.RSA_AES;
                i5 = 14;
                break;
            default:
                throw new EncryptedDocumentException("Hash algorithm '" + hashAlgorithm + "' is not supported for document write protection.");
        }
        byte[] bArrGenerateSeed = RandomSingleton.getInstance().generateSeed(16);
        byte[] bArrHashPassword = CryptoFunctions.hashPassword(CryptoFunctions.xorHashPasswordReversed(str), hashAlgorithm, bArrGenerateSeed, BZip2Constants.BASEBLOCKSIZE, false);
        safeGetDocumentProtection().setSalt(bArrGenerateSeed);
        safeGetDocumentProtection().setHash(bArrHashPassword);
        safeGetDocumentProtection().setCryptSpinCount(BigInteger.valueOf(BZip2Constants.BASEBLOCKSIZE));
        safeGetDocumentProtection().setCryptAlgorithmType(STAlgType.TYPE_ANY);
        safeGetDocumentProtection().setCryptAlgorithmClass(STAlgClass.HASH);
        safeGetDocumentProtection().setCryptProviderType(r7);
        safeGetDocumentProtection().setCryptAlgorithmSid(BigInteger.valueOf(i5));
    }
}
