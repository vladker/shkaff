package org.apache.commons.compress.archivers.examples;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Expander.ArchiveEntrySupplier, Expander.EntryWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SevenZFile f6695a;

    public /* synthetic */ b(SevenZFile sevenZFile) {
        this.f6695a = sevenZFile;
    }

    @Override // org.apache.commons.compress.archivers.examples.Expander.ArchiveEntrySupplier
    public ArchiveEntry getNextReadableEntry() {
        return this.f6695a.getNextEntry();
    }

    @Override // org.apache.commons.compress.archivers.examples.Expander.EntryWriter
    public void writeEntryDataTo(ArchiveEntry archiveEntry, OutputStream outputStream) throws IOException {
        Expander.lambda$expand$6(this.f6695a, archiveEntry, outputStream);
    }
}
