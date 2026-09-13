package org.apache.poi.poifs.crypt;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'aes128' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CipherAlgorithm {
    private static final /* synthetic */ CipherAlgorithm[] $VALUES;
    public static final CipherAlgorithm aes128;
    public static final CipherAlgorithm aes192;
    public static final CipherAlgorithm aes256;
    public static final CipherAlgorithm des;
    public static final CipherAlgorithm des3;
    public static final CipherAlgorithm des3_112;
    public static final CipherAlgorithm rc2;
    public static final CipherAlgorithm rc4;
    public static final CipherAlgorithm rsa;
    public final int[] allowedKeySize;
    public final int blockSize;
    public final int defaultKeySize;
    public final int ecmaId;
    public final int encryptedVerifierHashLength;
    public final String jceId;
    public final boolean needsBouncyCastle;
    public final CipherProvider provider;
    public final String xmlId;

    static {
        CipherAlgorithm cipherAlgorithm = new CipherAlgorithm("rc4", 0, CipherProvider.rc4, "RC4", 26625, 64, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, -1, 20, "RC4", false);
        rc4 = cipherAlgorithm;
        CipherProvider cipherProvider = CipherProvider.aes;
        CipherAlgorithm cipherAlgorithm2 = new CipherAlgorithm("aes128", 1, cipherProvider, "AES", 26126, 128, new int[]{128}, 16, 32, "AES", false);
        aes128 = cipherAlgorithm2;
        CipherAlgorithm cipherAlgorithm3 = new CipherAlgorithm("aes192", 2, cipherProvider, "AES", 26127, 192, new int[]{192}, 16, 32, "AES", false);
        aes192 = cipherAlgorithm3;
        CipherAlgorithm cipherAlgorithm4 = new CipherAlgorithm("aes256", 3, cipherProvider, "AES", 26128, 256, new int[]{256}, 16, 32, "AES", false);
        aes256 = cipherAlgorithm4;
        CipherAlgorithm cipherAlgorithm5 = new CipherAlgorithm("rc2", 4, null, "RC2", -1, 128, new int[]{40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128}, 8, 20, "RC2", false);
        rc2 = cipherAlgorithm5;
        CipherAlgorithm cipherAlgorithm6 = new CipherAlgorithm("des", 5, null, "DES", -1, 64, new int[]{64}, 8, 32, "DES", false);
        des = cipherAlgorithm6;
        CipherAlgorithm cipherAlgorithm7 = new CipherAlgorithm("des3", 6, null, "DESede", -1, 192, new int[]{192}, 8, 32, "3DES", false);
        des3 = cipherAlgorithm7;
        CipherAlgorithm cipherAlgorithm8 = new CipherAlgorithm("des3_112", 7, null, "DESede", -1, 128, new int[]{128}, 8, 32, "3DES_112", true);
        des3_112 = cipherAlgorithm8;
        CipherAlgorithm cipherAlgorithm9 = new CipherAlgorithm("rsa", 8, null, "RSA", -1, 1024, new int[]{1024, 2048, 3072, 4096}, -1, -1, "", false);
        rsa = cipherAlgorithm9;
        $VALUES = new CipherAlgorithm[]{cipherAlgorithm, cipherAlgorithm2, cipherAlgorithm3, cipherAlgorithm4, cipherAlgorithm5, cipherAlgorithm6, cipherAlgorithm7, cipherAlgorithm8, cipherAlgorithm9};
    }

    private CipherAlgorithm(String str, int i5, CipherProvider cipherProvider, String str2, int i6, int i7, int[] iArr, int i8, int i9, String str3, boolean z6) {
        super(str, i5);
        this.provider = cipherProvider;
        this.jceId = str2;
        this.ecmaId = i6;
        this.defaultKeySize = i7;
        this.allowedKeySize = (int[]) iArr.clone();
        this.blockSize = i8;
        this.encryptedVerifierHashLength = i9;
        this.xmlId = str3;
        this.needsBouncyCastle = z6;
    }

    public static CipherAlgorithm fromEcmaId(int i5) {
        for (CipherAlgorithm cipherAlgorithm : values()) {
            if (cipherAlgorithm.ecmaId == i5) {
                return cipherAlgorithm;
            }
        }
        throw new EncryptedDocumentException(androidx.collection.a.i(i5, "cipher algorithm ", " not found"));
    }

    public static CipherAlgorithm fromXmlId(String str, int i5) {
        for (CipherAlgorithm cipherAlgorithm : values()) {
            if (cipherAlgorithm.xmlId.equals(str)) {
                for (int i6 : cipherAlgorithm.allowedKeySize) {
                    if (i6 == i5) {
                        return cipherAlgorithm;
                    }
                }
            }
        }
        throw new EncryptedDocumentException("cipher algorithm " + str + PackagingURIHelper.FORWARD_SLASH_STRING + i5 + " not found");
    }

    public static CipherAlgorithm valueOf(String str) {
        return (CipherAlgorithm) Enum.valueOf(CipherAlgorithm.class, str);
    }

    public static CipherAlgorithm[] values() {
        return (CipherAlgorithm[]) $VALUES.clone();
    }
}
