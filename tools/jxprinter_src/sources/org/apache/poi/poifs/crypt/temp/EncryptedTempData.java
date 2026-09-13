package org.apache.poi.poifs.crypt.temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.g;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.util.RandomSingleton;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EncryptedTempData {
    private static final String PADDING = "PKCS5Padding";
    private final byte[] ivBytes;
    private CountingOutputStream outputStream;
    private final SecretKeySpec skeySpec;
    private final File tempFile;
    private static final Logger LOG = LogManager.getLogger((Class<?>) EncryptedTempData.class);
    private static final CipherAlgorithm cipherAlgorithm = CipherAlgorithm.aes128;

    public EncryptedTempData() {
        byte[] bArr = new byte[16];
        this.ivBytes = bArr;
        byte[] bArr2 = new byte[16];
        RandomSingleton.getInstance().nextBytes(bArr);
        RandomSingleton.getInstance().nextBytes(bArr2);
        this.skeySpec = new SecretKeySpec(bArr2, cipherAlgorithm.jceId);
        this.tempFile = TempFile.createTempFile("poi-temp-data", ".tmp");
    }

    public void dispose() {
        if (this.tempFile.delete()) {
            return;
        }
        LogBuilder logBuilderAtWarn = LOG.atWarn();
        File file = this.tempFile;
        file.getClass();
        logBuilderAtWarn.log("{} can't be removed (or was already removed).", new g(file, 2));
    }

    public long getByteCount() {
        CountingOutputStream countingOutputStream = this.outputStream;
        if (countingOutputStream == null) {
            return 0L;
        }
        return countingOutputStream.getByteCount();
    }

    public InputStream getInputStream() {
        return new CipherInputStream(new FileInputStream(this.tempFile), CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 2, PADDING));
    }

    public OutputStream getOutputStream() {
        CountingOutputStream countingOutputStream = new CountingOutputStream(new CipherOutputStream(new FileOutputStream(this.tempFile), CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 1, PADDING)));
        this.outputStream = countingOutputStream;
        return countingOutputStream;
    }
}
