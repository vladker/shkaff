package org.apache.poi.poifs.crypt;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.Duplicatable;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EncryptionVerifier implements GenericRecord, Duplicatable {
    private ChainingMode chainingMode;
    private CipherAlgorithm cipherAlgorithm;
    private byte[] encryptedKey;
    private byte[] encryptedVerifier;
    private byte[] encryptedVerifierHash;
    private HashAlgorithm hashAlgorithm;
    private byte[] salt;
    private int spinCount;

    public EncryptionVerifier() {
    }

    @Override // org.apache.poi.common.Duplicatable
    public abstract EncryptionVerifier copy();

    public ChainingMode getChainingMode() {
        return this.chainingMode;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    public byte[] getEncryptedKey() {
        return this.encryptedKey;
    }

    public byte[] getEncryptedVerifier() {
        return this.encryptedVerifier;
    }

    public byte[] getEncryptedVerifierHash() {
        return this.encryptedVerifierHash;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i5 = 0;
        linkedHashMap.put("salt", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        final int i6 = 1;
        linkedHashMap.put("encryptedVerifier", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        final int i7 = 2;
        linkedHashMap.put("encryptedVerifierHash", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        final int i8 = 3;
        linkedHashMap.put("encryptedKey", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        final int i9 = 4;
        linkedHashMap.put("spinCount", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        final int i10 = 5;
        linkedHashMap.put("cipherAlgorithm", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        final int i11 = 6;
        linkedHashMap.put("chainingMode", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        final int i12 = 7;
        linkedHashMap.put("hashAlgorithm", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.e
            public final /* synthetic */ EncryptionVerifier b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.getSalt();
                    case 1:
                        return this.b.getEncryptedVerifier();
                    case 2:
                        return this.b.getEncryptedVerifierHash();
                    case 3:
                        return this.b.getEncryptedKey();
                    case 4:
                        return Integer.valueOf(this.b.getSpinCount());
                    case 5:
                        return this.b.getCipherAlgorithm();
                    case 6:
                        return this.b.getChainingMode();
                    default:
                        return this.b.getHashAlgorithm();
                }
            }
        });
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public int getSpinCount() {
        return this.spinCount;
    }

    public void setChainingMode(ChainingMode chainingMode) {
        this.chainingMode = chainingMode;
    }

    public void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
    }

    public void setEncryptedKey(byte[] bArr) {
        this.encryptedKey = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setEncryptedVerifier(byte[] bArr) {
        this.encryptedVerifier = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setEncryptedVerifierHash(byte[] bArr) {
        this.encryptedVerifierHash = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public void setSalt(byte[] bArr) {
        this.salt = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setSpinCount(int i5) {
        this.spinCount = i5;
    }

    public EncryptionVerifier(EncryptionVerifier encryptionVerifier) {
        byte[] bArr = encryptionVerifier.salt;
        this.salt = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = encryptionVerifier.encryptedVerifier;
        this.encryptedVerifier = bArr2 == null ? null : (byte[]) bArr2.clone();
        byte[] bArr3 = encryptionVerifier.encryptedVerifierHash;
        this.encryptedVerifierHash = bArr3 == null ? null : (byte[]) bArr3.clone();
        byte[] bArr4 = encryptionVerifier.encryptedKey;
        this.encryptedKey = bArr4 != null ? (byte[]) bArr4.clone() : null;
        this.spinCount = encryptionVerifier.spinCount;
        this.cipherAlgorithm = encryptionVerifier.cipherAlgorithm;
        this.chainingMode = encryptionVerifier.chainingMode;
        this.hashAlgorithm = encryptionVerifier.hashAlgorithm;
    }
}
