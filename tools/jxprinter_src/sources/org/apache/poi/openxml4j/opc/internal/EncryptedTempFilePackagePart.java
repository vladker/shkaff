package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.poifs.crypt.temp.EncryptedTempData;
import org.apache.poi.util.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EncryptedTempFilePackagePart extends PackagePart {
    private static final Logger LOG = LogManager.getLogger((Class<?>) EncryptedTempFilePackagePart.class);
    private EncryptedTempData tempFile;

    public EncryptedTempFilePackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str) {
        this(oPCPackage, packagePartName, str, true);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void clear() {
        try {
            OutputStream outputStreamImpl = getOutputStreamImpl();
            try {
                outputStreamImpl.write(new byte[0]);
                outputStreamImpl.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStreamImpl != null) {
                        try {
                            outputStreamImpl.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            LOG.atWarn().log("Failed to clear data in temp file", e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void close() {
        this.tempFile.dispose();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        return this.tempFile.getInputStream();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        return this.tempFile.getOutputStream();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        return this.tempFile.getByteCount();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean load(InputStream inputStream) throws InvalidFormatException {
        try {
            OutputStream outputStreamImpl = getOutputStreamImpl();
            try {
                IOUtils.copy(inputStream, outputStreamImpl);
                if (outputStreamImpl == null) {
                    return true;
                }
                outputStreamImpl.close();
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStreamImpl != null) {
                        try {
                            outputStreamImpl.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new InvalidFormatException(e.getMessage(), e);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) {
        return new ZipPartMarshaller().marshall(this, outputStream);
    }

    public EncryptedTempFilePackagePart(OPCPackage oPCPackage, PackagePartName packagePartName, String str, boolean z6) {
        super(oPCPackage, packagePartName, new ContentType(str), z6);
        this.tempFile = new EncryptedTempData();
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public void flush() {
    }
}
