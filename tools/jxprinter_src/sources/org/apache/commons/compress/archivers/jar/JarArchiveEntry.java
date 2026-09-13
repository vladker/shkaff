package org.apache.commons.compress.archivers.jar;

import java.security.cert.Certificate;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.zip.ZipEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class JarArchiveEntry extends ZipArchiveEntry {
    private final Certificate[] certificates;
    private final Attributes manifestAttributes;

    public JarArchiveEntry(ZipEntry zipEntry) {
        super(zipEntry);
        this.manifestAttributes = null;
        this.certificates = null;
    }

    @Deprecated
    public Certificate[] getCertificates() {
        Certificate[] certificateArr = this.certificates;
        if (certificateArr == null) {
            return null;
        }
        int length = certificateArr.length;
        Certificate[] certificateArr2 = new Certificate[length];
        System.arraycopy(certificateArr, 0, certificateArr2, 0, length);
        return certificateArr2;
    }

    @Deprecated
    public Attributes getManifestAttributes() {
        return this.manifestAttributes;
    }

    public JarArchiveEntry(String str) {
        super(str);
        this.manifestAttributes = null;
        this.certificates = null;
    }

    public JarArchiveEntry(ZipArchiveEntry zipArchiveEntry) {
        super(zipArchiveEntry);
        this.manifestAttributes = null;
        this.certificates = null;
    }

    public JarArchiveEntry(JarEntry jarEntry) {
        super(jarEntry);
        this.manifestAttributes = null;
        this.certificates = null;
    }
}
