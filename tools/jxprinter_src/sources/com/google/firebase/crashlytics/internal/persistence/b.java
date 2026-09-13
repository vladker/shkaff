package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.apache.xmlbeans.impl.tool.MavenPlugin;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3493a;
    public final /* synthetic */ Serializable b;

    public /* synthetic */ b(Serializable serializable, int i5) {
        this.f3493a = i5;
        this.b = serializable;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f3493a) {
            case 0:
                return FileStore.lambda$cleanupFileSystemDirs$0((String) this.b, file, str);
            default:
                return MavenPlugin.lambda$execute$0((Pattern) this.b, file, str);
        }
    }
}
