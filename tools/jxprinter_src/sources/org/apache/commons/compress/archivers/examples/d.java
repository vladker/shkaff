package org.apache.commons.compress.archivers.examples;

import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Expander.ArchiveEntrySupplier, Expander.EntryWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArchiveInputStream f6697a;

    public /* synthetic */ d(ArchiveInputStream archiveInputStream) {
        this.f6697a = archiveInputStream;
    }

    @Override // org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier
    public ArchiveEntry getNextReadableEntry() {
        return Expander.lambda$expand$0(this.f6697a);
    }

    @Override // org.apache.commons.compress.archivers.examples.Expander.EntryWriter
    public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) {
        IOUtils.copy(this.f6697a, outputStream);
    }
}
