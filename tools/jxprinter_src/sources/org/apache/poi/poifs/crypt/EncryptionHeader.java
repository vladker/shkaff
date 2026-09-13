package org.apache.poi.poifs.crypt;

import A3.AbstractC0157z;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EncryptionHeader implements GenericRecord, Duplicatable {
    private int blockSize;
    private ChainingMode chainingMode;
    private CipherAlgorithm cipherAlgorithm;
    private String cspName;
    private int flags;
    private HashAlgorithm hashAlgorithm;
    private int keyBits;
    private byte[] keySalt;
    private CipherProvider providerType;
    private int sizeExtra;

    public EncryptionHeader() {
    }

    @Override // org.apache.poi.common.Duplicatable
    public abstract EncryptionHeader copy();

    public int getBlockSize() {
        return this.blockSize;
    }

    public ChainingMode getChainingMode() {
        return this.chainingMode;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    public CipherProvider getCipherProvider() {
        return this.providerType;
    }

    public String getCspName() {
        return this.cspName;
    }

    public int getFlags() {
        return this.flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("flags", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("sizeExtra", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("cipherAlgorithm", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("hashAlgorithm", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("keyBits", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("blockSize", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("providerType", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put("chainingMode", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i13 = 8;
        linkedHashMap.put("keySalt", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        final int i14 = 9;
        linkedHashMap.put("cspName", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.c
            public final /* synthetic */ EncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return Integer.valueOf(this.b.getFlags());
                    case 1:
                        return Integer.valueOf(this.b.getSizeExtra());
                    case 2:
                        return this.b.getCipherAlgorithm();
                    case 3:
                        return this.b.getHashAlgorithm();
                    case 4:
                        return Integer.valueOf(this.b.getKeySize());
                    case 5:
                        return Integer.valueOf(this.b.getBlockSize());
                    case 6:
                        return this.b.getCipherProvider();
                    case 7:
                        return this.b.getChainingMode();
                    case 8:
                        return this.b.getKeySalt();
                    default:
                        return this.b.getCspName();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getKeySalt() {
        return this.keySalt;
    }

    public int getKeySize() {
        return this.keyBits;
    }

    public int getSizeExtra() {
        return this.sizeExtra;
    }

    public void setBlockSize(int i5) {
        this.blockSize = i5;
    }

    public void setChainingMode(ChainingMode chainingMode) {
        this.chainingMode = chainingMode;
    }

    public void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
        if (cipherAlgorithm.allowedKeySize.length == 1) {
            setKeySize(cipherAlgorithm.defaultKeySize);
        }
    }

    public void setCipherProvider(CipherProvider cipherProvider) {
        this.providerType = cipherProvider;
    }

    public void setCspName(String str) {
        this.cspName = str;
    }

    public void setFlags(int i5) {
        this.flags = i5;
    }

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public void setKeySalt(byte[] bArr) {
        this.keySalt = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setKeySize(int i5) {
        this.keyBits = i5;
        for (int i6 : getCipherAlgorithm().allowedKeySize) {
            if (i6 == i5) {
                return;
            }
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "KeySize ", " not allowed for cipher ");
        sbT.append(getCipherAlgorithm());
        throw new EncryptedDocumentException(sbT.toString());
    }

    public void setSizeExtra(int i5) {
        this.sizeExtra = i5;
    }

    public EncryptionHeader(EncryptionHeader encryptionHeader) {
        this.flags = encryptionHeader.flags;
        this.sizeExtra = encryptionHeader.sizeExtra;
        this.cipherAlgorithm = encryptionHeader.cipherAlgorithm;
        this.hashAlgorithm = encryptionHeader.hashAlgorithm;
        this.keyBits = encryptionHeader.keyBits;
        this.blockSize = encryptionHeader.blockSize;
        this.providerType = encryptionHeader.providerType;
        this.chainingMode = encryptionHeader.chainingMode;
        byte[] bArr = encryptionHeader.keySalt;
        this.keySalt = bArr == null ? null : (byte[]) bArr.clone();
        this.cspName = encryptionHeader.cspName;
    }
}
