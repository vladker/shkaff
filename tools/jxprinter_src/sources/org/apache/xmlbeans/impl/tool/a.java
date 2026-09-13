package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7448a;

    public /* synthetic */ a(int i5) {
        this.f7448a = i5;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        switch (this.f7448a) {
            case 0:
                return CodeGenUtil.lambda$addAllJavaFiles$0(file);
            default:
                return XsbDumper.lambda$dump$0(file);
        }
    }
}
