package com.appdev.standard.util.fileDownload;

import java.io.File;
import java.io.InputStream;
import kotlinx.serialization.json.internal.AbstractC1127c;
import p050j.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f2840a;
    public final File b;
    public final String c;
    public int d = 1;
    public InputStream e;

    public a(File file, String str) {
        this.c = str;
        this.f2840a = file;
        this.b = new File(file.getAbsolutePath() + ".tmp");
    }

    public final boolean a() {
        return n.a(this.d, 7);
    }

    public abstract void b(String str);

    public abstract void c(String str);

    public abstract void d(String str);

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ControlCallBack [url: ");
        sb.append(this.c);
        sb.append("\n  state: ");
        switch (this.d) {
            case 1:
                str = "CREATED";
                break;
            case 2:
                str = "DOWNLOADING";
                break;
            case 3:
                str = "PAUSING";
                break;
            case 4:
                str = "PAUSED";
                break;
            case 5:
                str = "DONE";
                break;
            case 6:
                str = "ERROR";
                break;
            case 7:
                str = "DELETING";
                break;
            default:
                str = AbstractC1127c.NULL;
                break;
        }
        sb.append(str);
        sb.append(", targetFile: ");
        sb.append(this.f2840a);
        sb.append("\ndownloadBytesPerMs: 1000]");
        return sb.toString();
    }
}
