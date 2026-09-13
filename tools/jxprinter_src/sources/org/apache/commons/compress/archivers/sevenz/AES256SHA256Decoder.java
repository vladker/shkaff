package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.compress.PasswordRequiredException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class AES256SHA256Decoder extends CoderBase {
    public AES256SHA256Decoder() {
        super(new Class[0]);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    public InputStream decode(final String str, final InputStream inputStream, long j6, final Coder coder, final byte[] bArr, int i5) {
        return new InputStream() { // from class: org.apache.commons.compress.archivers.sevenz.AES256SHA256Decoder.1
            private CipherInputStream cipherInputStream;
            private boolean isInitialized;

            private CipherInputStream init() throws IOException {
                byte[] bArrDigest;
                if (this.isInitialized) {
                    return this.cipherInputStream;
                }
                byte[] bArr2 = coder.properties;
                if (bArr2 == null) {
                    throw new IOException("Missing AES256 properties in " + str);
                }
                if (bArr2.length < 2) {
                    throw new IOException("AES256 properties too short in " + str);
                }
                int i6 = bArr2[0];
                int i7 = i6 & 255;
                int i8 = i6 & 63;
                int i9 = bArr2[1];
                int i10 = ((i7 >> 6) & 1) + (i9 & 15);
                int i11 = ((i7 >> 7) & 1) + ((i9 & 255) >> 4);
                int i12 = i11 + 2;
                if (i12 + i10 > bArr2.length) {
                    throw new IOException("Salt size + IV size too long in " + str);
                }
                byte[] bArr3 = new byte[i11];
                System.arraycopy(bArr2, 2, bArr3, 0, i11);
                byte[] bArr4 = new byte[16];
                System.arraycopy(coder.properties, i12, bArr4, 0, i10);
                if (bArr == null) {
                    throw new PasswordRequiredException(str);
                }
                if (i8 == 63) {
                    bArrDigest = new byte[32];
                    System.arraycopy(bArr3, 0, bArrDigest, 0, i11);
                    byte[] bArr5 = bArr;
                    System.arraycopy(bArr5, 0, bArrDigest, i11, Math.min(bArr5.length, 32 - i11));
                } else {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                        byte[] bArr6 = new byte[8];
                        for (long j7 = 0; j7 < (1 << i8); j7++) {
                            messageDigest.update(bArr3);
                            messageDigest.update(bArr);
                            messageDigest.update(bArr6);
                            for (int i13 = 0; i13 < 8; i13++) {
                                byte b = (byte) (bArr6[i13] + 1);
                                bArr6[i13] = b;
                                if (b != 0) {
                                    break;
                                }
                            }
                        }
                        bArrDigest = messageDigest.digest();
                    } catch (NoSuchAlgorithmException e) {
                        throw new IOException("SHA-256 is unsupported by your Java implementation", e);
                    }
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDigest, "AES");
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(2, secretKeySpec, new IvParameterSpec(bArr4));
                    CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
                    this.cipherInputStream = cipherInputStream;
                    this.isInitialized = true;
                    return cipherInputStream;
                } catch (GeneralSecurityException e6) {
                    throw new IOException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)", e6);
                }
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                CipherInputStream cipherInputStream = this.cipherInputStream;
                if (cipherInputStream != null) {
                    cipherInputStream.close();
                }
            }

            @Override // java.io.InputStream
            public int read() {
                return init().read();
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr2, int i6, int i7) {
                return init().read(bArr2, i6, i7);
            }
        };
    }
}
