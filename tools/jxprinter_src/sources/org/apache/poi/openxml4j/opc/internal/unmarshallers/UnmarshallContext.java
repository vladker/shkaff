package org.apache.poi.openxml4j.opc.internal.unmarshallers;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnmarshallContext {
    private OPCPackage _package;
    private PackagePartName partName;
    private ZipArchiveEntry zipEntry;

    public UnmarshallContext(OPCPackage oPCPackage, PackagePartName packagePartName) {
        this._package = oPCPackage;
        this.partName = packagePartName;
    }

    public OPCPackage getPackage() {
        return this._package;
    }

    public PackagePartName getPartName() {
        return this.partName;
    }

    public ZipArchiveEntry getZipEntry() {
        return this.zipEntry;
    }

    public void setPackage(OPCPackage oPCPackage) {
        this._package = oPCPackage;
    }

    public void setPartName(PackagePartName packagePartName) {
        this.partName = packagePartName;
    }

    public void setZipEntry(ZipArchiveEntry zipArchiveEntry) {
        this.zipEntry = zipArchiveEntry;
    }
}
