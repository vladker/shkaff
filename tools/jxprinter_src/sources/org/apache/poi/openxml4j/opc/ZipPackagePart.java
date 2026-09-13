package org.apache.poi.openxml4j.opc;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.util.NotImplemented;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZipPackagePart extends PackagePart {
    private ZipArchiveEntry zipEntry;

    public ZipPackagePart(OPCPackage oPCPackage, ZipArchiveEntry zipArchiveEntry, PackagePartName packagePartName, String str) {
        this(oPCPackage, zipArchiveEntry, packagePartName, str, true);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public void close() {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public void flush() {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public InputStream getInputStreamImpl() {
        return ((ZipPackage) this._container).getZipArchive().getInputStream(this.zipEntry);
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public OutputStream getOutputStreamImpl() {
        return null;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public long getSize() {
        return this.zipEntry.getSize();
    }

    public ZipArchiveEntry getZipArchive() {
        return this.zipEntry;
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    @NotImplemented
    public boolean load(InputStream inputStream) {
        throw new InvalidOperationException("Method not implemented !");
    }

    @Override // org.apache.poi.openxml4j.opc.PackagePart
    public boolean save(OutputStream outputStream) {
        return new ZipPartMarshaller().marshall(this, outputStream);
    }

    public ZipPackagePart(OPCPackage oPCPackage, ZipArchiveEntry zipArchiveEntry, PackagePartName packagePartName, String str, boolean z6) {
        super(oPCPackage, packagePartName, new ContentType(str), z6);
        this.zipEntry = zipArchiveEntry;
    }
}
