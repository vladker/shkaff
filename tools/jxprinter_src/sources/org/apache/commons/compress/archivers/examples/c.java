package org.apache.commons.compress.archivers.examples;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarFile;
import org.apache.commons.compress.archivers.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Expander.ArchiveEntrySupplier, Expander.EntryWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6696a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f6696a = i5;
        this.b = obj;
    }

    @Override // org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier
    public ArchiveEntry getNextReadableEntry() {
        return Expander.lambda$expand$2((Iterator) this.b);
    }

    @Override // org.apache.commons.compress.archivers.examples.Expander.EntryWriter
    public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
        switch (this.f6696a) {
            case 1:
                Expander.lambda$expand$3((TarFile) this.b, archiveEntry, outputStream);
                break;
            default:
                Expander.lambda$expand$5((ZipFile) this.b, archiveEntry, outputStream);
                break;
        }
    }
}
