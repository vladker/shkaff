package M3;

import A3.v0;
import A3.w0;
import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final j INSTANCE = new j();
    private static final LinkOption[] nofollowLinkOption = {LinkOption.NOFOLLOW_LINKS};
    private static final LinkOption[] followLinkOption = new LinkOption[0];
    private static final Set<FileVisitOption> nofollowVisitOption = w0.emptySet();
    private static final Set<FileVisitOption> followVisitOption = v0.setOf(FileVisitOption.FOLLOW_LINKS);

    public final LinkOption[] toLinkOptions(boolean z6) {
        return z6 ? followLinkOption : nofollowLinkOption;
    }

    public final Set<FileVisitOption> toVisitOptions(boolean z6) {
        return z6 ? followVisitOption : nofollowVisitOption;
    }
}
