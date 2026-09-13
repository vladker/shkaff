package p120v0;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8760a;
    public final boolean[] b;
    public boolean c;
    public final /* synthetic */ f d;

    public c(f fVar, d dVar) {
        this.d = fVar;
        this.f8760a = dVar;
        this.b = dVar.e ? null : new boolean[fVar.f8768g];
    }

    private InputStream newInputStream(int i5) {
        synchronized (this.d) {
            d dVar = this.f8760a;
            if (dVar.f8762f != this) {
                throw new IllegalStateException();
            }
            if (!dVar.e) {
                return null;
            }
            try {
                return new FileInputStream(this.f8760a.c[i5]);
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
    }

    public void abort() {
        this.d.completeEdit(this, false);
    }

    public void commit() {
        this.d.completeEdit(this, true);
        this.c = true;
    }

    public File getFile(int i5) {
        File file;
        synchronized (this.d) {
            try {
                d dVar = this.f8760a;
                if (dVar.f8762f != this) {
                    throw new IllegalStateException();
                }
                if (!dVar.e) {
                    this.b[i5] = true;
                }
                file = dVar.d[i5];
                this.d.f8766a.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public String getString(int i5) {
        InputStream inputStreamNewInputStream = newInputStream(i5);
        if (inputStreamNewInputStream != null) {
            return f.inputStreamToString(inputStreamNewInputStream);
        }
        return null;
    }

    public void set(int i5, String str) throws Throwable {
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(getFile(i5)), i.b);
            try {
                outputStreamWriter2.write(str);
                try {
                    outputStreamWriter2.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
                outputStreamWriter = outputStreamWriter2;
                Charset charset = i.f8778a;
                if (outputStreamWriter != null) {
                    try {
                        outputStreamWriter.close();
                    } catch (RuntimeException e6) {
                        throw e6;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
