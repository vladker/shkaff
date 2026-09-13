package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EncryptionInfo implements GenericRecord {
    public static final String ENCRYPTION_INFO_ENTRY = "EncryptionInfo";
    private Decryptor decryptor;
    private final int encryptionFlags;
    private final EncryptionMode encryptionMode;
    private Encryptor encryptor;
    private EncryptionHeader header;
    private EncryptionVerifier verifier;
    private final int versionMajor;
    private final int versionMinor;
    public static final BitField flagCryptoAPI = BitFieldFactory.getInstance(4);
    public static final BitField flagDocProps = BitFieldFactory.getInstance(8);
    public static final BitField flagExternal = BitFieldFactory.getInstance(16);
    public static final BitField flagAES = BitFieldFactory.getInstance(32);
    private static final int[] FLAGS_MASKS = {4, 8, 16, 32};
    private static final String[] FLAGS_NAMES = {"CRYPTO_API", "DOC_PROPS", "EXTERNAL", "AES"};

    public EncryptionInfo(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem.getRoot());
    }

    private static EncryptionInfoBuilder getBuilder(EncryptionMode encryptionMode) {
        return encryptionMode.builder.get();
    }

    public EncryptionInfo copy() {
        return new EncryptionInfo(this);
    }

    public Decryptor getDecryptor() {
        return this.decryptor;
    }

    public int getEncryptionFlags() {
        return this.encryptionFlags;
    }

    public EncryptionMode getEncryptionMode() {
        return this.encryptionMode;
    }

    public Encryptor getEncryptor() {
        return this.encryptor;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("encryptionMode", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("versionMajor", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("versionMinor", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("encryptionFlags", GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        }, FLAGS_MASKS, FLAGS_NAMES));
        final int i9 = 4;
        linkedHashMap.put("header", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("verifier", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("decryptor", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put("encryptor", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.d
            public final /* synthetic */ EncryptionInfo b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.getEncryptionMode();
                    case 1:
                        return Integer.valueOf(this.b.getVersionMajor());
                    case 2:
                        return Integer.valueOf(this.b.getVersionMinor());
                    case 3:
                        return Integer.valueOf(this.b.getEncryptionFlags());
                    case 4:
                        return this.b.getHeader();
                    case 5:
                        return this.b.getVerifier();
                    case 6:
                        return this.b.getDecryptor();
                    default:
                        return this.b.getEncryptor();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public EncryptionHeader getHeader() {
        return this.header;
    }

    public EncryptionVerifier getVerifier() {
        return this.verifier;
    }

    public int getVersionMajor() {
        return this.versionMajor;
    }

    public int getVersionMinor() {
        return this.versionMinor;
    }

    public boolean isDocPropsEncrypted() {
        return !flagDocProps.isSet(getEncryptionFlags());
    }

    public void setDecryptor(Decryptor decryptor) {
        this.decryptor = decryptor;
    }

    public void setEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    public void setHeader(EncryptionHeader encryptionHeader) {
        this.header = encryptionHeader;
    }

    public void setVerifier(EncryptionVerifier encryptionVerifier) {
        this.verifier = encryptionVerifier;
    }

    public EncryptionInfo(DirectoryNode directoryNode) {
        this(directoryNode.createDocumentInputStream(ENCRYPTION_INFO_ENTRY), null);
    }

    public EncryptionInfo(LittleEndianInput littleEndianInput, EncryptionMode encryptionMode) throws IOException {
        EncryptionMode encryptionMode2 = EncryptionMode.xor;
        if (encryptionMode == encryptionMode2) {
            this.versionMajor = encryptionMode2.versionMajor;
            this.versionMinor = encryptionMode2.versionMinor;
        } else {
            this.versionMajor = littleEndianInput.readUShort();
            this.versionMinor = littleEndianInput.readUShort();
        }
        int i5 = this.versionMajor;
        if (i5 == encryptionMode2.versionMajor && this.versionMinor == encryptionMode2.versionMinor) {
            this.encryptionMode = encryptionMode2;
            this.encryptionFlags = -1;
        } else {
            EncryptionMode encryptionMode3 = EncryptionMode.binaryRC4;
            if (i5 == encryptionMode3.versionMajor && this.versionMinor == encryptionMode3.versionMinor) {
                this.encryptionMode = encryptionMode3;
                this.encryptionFlags = -1;
            } else if (2 <= i5 && i5 <= 4 && this.versionMinor == 2) {
                int i6 = littleEndianInput.readInt();
                this.encryptionFlags = i6;
                EncryptionMode encryptionMode4 = EncryptionMode.cryptoAPI;
                if (encryptionMode != encryptionMode4 && flagAES.isSet(i6)) {
                    encryptionMode4 = EncryptionMode.standard;
                }
                this.encryptionMode = encryptionMode4;
            } else {
                EncryptionMode encryptionMode5 = EncryptionMode.agile;
                if (i5 == encryptionMode5.versionMajor && this.versionMinor == encryptionMode5.versionMinor) {
                    this.encryptionMode = encryptionMode5;
                    this.encryptionFlags = littleEndianInput.readInt();
                } else {
                    int i7 = littleEndianInput.readInt();
                    this.encryptionFlags = i7;
                    throw new EncryptedDocumentException("Unknown encryption: version major: " + this.versionMajor + " / version minor: " + this.versionMinor + " / fCrypto: " + flagCryptoAPI.isSet(i7) + " / fExternal: " + flagExternal.isSet(i7) + " / fDocProps: " + flagDocProps.isSet(i7) + " / fAES: " + flagAES.isSet(i7));
                }
            }
        }
        try {
            getBuilder(this.encryptionMode).initialize(this, littleEndianInput);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    public EncryptionInfo(EncryptionMode encryptionMode) {
        this(encryptionMode, null, null, -1, -1, null);
    }

    public EncryptionInfo(EncryptionMode encryptionMode, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        this.encryptionMode = encryptionMode;
        this.versionMajor = encryptionMode.versionMajor;
        this.versionMinor = encryptionMode.versionMinor;
        this.encryptionFlags = encryptionMode.encryptionFlags;
        try {
            getBuilder(encryptionMode).initialize(this, cipherAlgorithm, hashAlgorithm, i5, i6, chainingMode);
        } catch (Exception e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public EncryptionInfo(EncryptionInfo encryptionInfo) {
        this.encryptionMode = encryptionInfo.encryptionMode;
        this.versionMajor = encryptionInfo.versionMajor;
        this.versionMinor = encryptionInfo.versionMinor;
        this.encryptionFlags = encryptionInfo.encryptionFlags;
        EncryptionHeader encryptionHeader = encryptionInfo.header;
        this.header = encryptionHeader == null ? null : encryptionHeader.copy();
        EncryptionVerifier encryptionVerifier = encryptionInfo.verifier;
        this.verifier = encryptionVerifier != null ? encryptionVerifier.copy() : null;
        Decryptor decryptor = encryptionInfo.decryptor;
        if (decryptor != null) {
            Decryptor decryptorCopy = decryptor.copy();
            this.decryptor = decryptorCopy;
            decryptorCopy.setEncryptionInfo(this);
        }
        Encryptor encryptor = encryptionInfo.encryptor;
        if (encryptor != null) {
            Encryptor encryptorCopy = encryptor.copy();
            this.encryptor = encryptorCopy;
            encryptorCopy.setEncryptionInfo(this);
        }
    }
}
