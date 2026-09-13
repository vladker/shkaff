package org.apache.commons.compress.archivers.sevenz;

import java.util.function.ToLongFunction;
import org.apache.commons.compress.archivers.tar.TarArchiveStructSparse;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.xmlbeans.SimpleValue;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements ToLongFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6699a;

    public /* synthetic */ a(int i5) {
        this.f6699a = i5;
    }

    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        switch (this.f6699a) {
            case 0:
                return ((Integer) obj).longValue();
            case 1:
                return ((TarArchiveStructSparse) obj).getOffset();
            case 2:
                return ((ZipArchiveEntry) obj).getDiskNumberStart();
            case 3:
                return ((ZipArchiveEntry) obj).getLocalHeaderOffset();
            case 4:
                return ((CTSlideIdListEntry) obj).getId();
            default:
                return ((SimpleValue) obj).getLongValue();
        }
    }
}
