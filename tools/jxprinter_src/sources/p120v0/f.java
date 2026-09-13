package p120v0;

import android.annotation.TargetApi;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f8766a;
    public final File b;
    public final File c;
    public final File d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f8767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8768g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BufferedWriter f8770i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8772k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8769h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f8771j = new LinkedHashMap(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f8773l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f8774m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f8775n = new a(this);

    public f(File file, int i5, int i6, long j6) {
        this.f8766a = file;
        this.e = i5;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.f8768g = i6;
        this.f8767f = j6;
    }

    @TargetApi(26)
    private static void closeWriter(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(c cVar, boolean z6) {
        d dVar = cVar.f8760a;
        if (dVar.f8762f != cVar) {
            throw new IllegalStateException();
        }
        if (z6 && !dVar.e) {
            for (int i5 = 0; i5 < this.f8768g; i5++) {
                if (!cVar.b[i5]) {
                    cVar.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i5);
                }
                if (!dVar.d[i5].exists()) {
                    cVar.abort();
                    return;
                }
            }
        }
        for (int i6 = 0; i6 < this.f8768g; i6++) {
            File file = dVar.d[i6];
            if (!z6) {
                deleteIfExists(file);
            } else if (file.exists()) {
                File file2 = dVar.c[i6];
                file.renameTo(file2);
                long j6 = dVar.b[i6];
                long length = file2.length();
                dVar.b[i6] = length;
                this.f8769h = (this.f8769h - j6) + length;
            }
        }
        this.f8772k++;
        dVar.f8762f = null;
        if (dVar.e || z6) {
            dVar.e = true;
            this.f8770i.append((CharSequence) "CLEAN");
            this.f8770i.append(Chars.SPACE);
            this.f8770i.append((CharSequence) dVar.f8761a);
            this.f8770i.append((CharSequence) dVar.getLengths());
            this.f8770i.append('\n');
            if (z6) {
                long j7 = this.f8773l;
                this.f8773l = 1 + j7;
                dVar.f8763g = j7;
            }
        } else {
            this.f8771j.remove(dVar.f8761a);
            this.f8770i.append((CharSequence) "REMOVE");
            this.f8770i.append(Chars.SPACE);
            this.f8770i.append((CharSequence) dVar.f8761a);
            this.f8770i.append('\n');
        }
        flushWriter(this.f8770i);
        if (this.f8769h > this.f8767f || a()) {
            this.f8774m.submit(this.f8775n);
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    private static void flushWriter(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String inputStreamToString(InputStream inputStream) {
        return i.readFully(new InputStreamReader(inputStream, i.b));
    }

    public static f open(File file, int i5, int i6, long j6) throws IOException {
        if (j6 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i6 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                renameTo(file2, file3, false);
            }
        }
        f fVar = new f(file, i5, i6, j6);
        if (fVar.b.exists()) {
            try {
                fVar.readJournal();
                fVar.processJournal();
                return fVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                fVar.delete();
            }
        }
        file.mkdirs();
        f fVar2 = new f(file, i5, i6, j6);
        fVar2.rebuildJournal();
        return fVar2;
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.c);
        Iterator it = this.f8771j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            c cVar = dVar.f8762f;
            int i5 = this.f8768g;
            int i6 = 0;
            if (cVar == null) {
                while (i6 < i5) {
                    this.f8769h += dVar.b[i6];
                    i6++;
                }
            } else {
                dVar.f8762f = null;
                while (i6 < i5) {
                    deleteIfExists(dVar.c[i6]);
                    deleteIfExists(dVar.d[i6]);
                    i6++;
                }
                it.remove();
            }
        }
    }

    private void readJournal() {
        File file = this.b;
        h hVar = new h(new FileInputStream(file), i.f8778a);
        try {
            String line = hVar.readLine();
            String line2 = hVar.readLine();
            String line3 = hVar.readLine();
            String line4 = hVar.readLine();
            String line5 = hVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(line) || !"1".equals(line2) || !Integer.toString(this.e).equals(line3) || !Integer.toString(this.f8768g).equals(line4) || !"".equals(line5)) {
                throw new IOException("unexpected journal header: [" + line + ", " + line2 + ", " + line4 + ", " + line5 + "]");
            }
            int i5 = 0;
            while (true) {
                try {
                    readJournalLine(hVar.readLine());
                    i5++;
                } catch (EOFException unused) {
                    this.f8772k = i5 - this.f8771j.size();
                    if (hVar.e == -1) {
                        rebuildJournal();
                    } else {
                        this.f8770i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), i.f8778a));
                    }
                    try {
                        hVar.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                hVar.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private void readJournalLine(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i5 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i5);
        LinkedHashMap linkedHashMap = this.f8771j;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i5);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i5, iIndexOf2);
        }
        d dVar = (d) linkedHashMap.get(strSubstring);
        if (dVar == null) {
            dVar = new d(this, strSubstring);
            linkedHashMap.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f8762f = null;
            dVar.setLengths(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f8762f = new c(this, dVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() {
        try {
            BufferedWriter bufferedWriter = this.f8770i;
            if (bufferedWriter != null) {
                closeWriter(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), i.f8778a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.e));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f8768g));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (d dVar : this.f8771j.values()) {
                    if (dVar.f8762f != null) {
                        bufferedWriter2.write("DIRTY " + dVar.f8761a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + dVar.f8761a + dVar.getLengths() + '\n');
                    }
                }
                closeWriter(bufferedWriter2);
                if (this.b.exists()) {
                    renameTo(this.b, this.d, true);
                }
                renameTo(this.c, this.b, false);
                this.d.delete();
                this.f8770i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), i.f8778a));
            } catch (Throwable th) {
                closeWriter(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void renameTo(File file, File file2, boolean z6) throws IOException {
        if (z6) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.f8769h > this.f8767f) {
            remove((String) ((Map.Entry) this.f8771j.entrySet().iterator().next()).getKey());
        }
    }

    public final boolean a() {
        int i5 = this.f8772k;
        return i5 >= 2000 && i5 >= this.f8771j.size();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f8770i == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f8771j.values());
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                c cVar = ((d) obj).f8762f;
                if (cVar != null) {
                    cVar.abort();
                }
            }
            trimToSize();
            closeWriter(this.f8770i);
            this.f8770i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void delete() throws IOException {
        close();
        i.deleteContents(this.f8766a);
    }

    public c edit(String str) {
        return edit(str, -1L);
    }

    public synchronized void flush() {
        if (this.f8770i == null) {
            throw new IllegalStateException("cache is closed");
        }
        trimToSize();
        flushWriter(this.f8770i);
    }

    public synchronized e get(String str) throws Throwable {
        Throwable th;
        try {
            try {
                if (this.f8770i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                d dVar = (d) this.f8771j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (!dVar.e) {
                    return null;
                }
                for (File file : dVar.c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                this.f8772k++;
                this.f8770i.append((CharSequence) "READ");
                this.f8770i.append(Chars.SPACE);
                this.f8770i.append((CharSequence) str);
                this.f8770i.append('\n');
                if (a()) {
                    this.f8774m.submit(this.f8775n);
                }
                return new e(this, str, dVar.f8763g, dVar.c);
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
        }
        throw th;
    }

    public synchronized boolean remove(String str) {
        try {
            if (this.f8770i == null) {
                throw new IllegalStateException("cache is closed");
            }
            d dVar = (d) this.f8771j.get(str);
            if (dVar != null && dVar.f8762f == null) {
                for (int i5 = 0; i5 < this.f8768g; i5++) {
                    File file = dVar.c[i5];
                    if (file.exists() && !file.delete()) {
                        throw new IOException("failed to delete " + file);
                    }
                    long j6 = this.f8769h;
                    long[] jArr = dVar.b;
                    this.f8769h = j6 - jArr[i5];
                    jArr[i5] = 0;
                }
                this.f8772k++;
                this.f8770i.append((CharSequence) "REMOVE");
                this.f8770i.append(Chars.SPACE);
                this.f8770i.append((CharSequence) str);
                this.f8770i.append('\n');
                this.f8771j.remove(str);
                if (a()) {
                    this.f8774m.submit(this.f8775n);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized c edit(String str, long j6) {
        if (this.f8770i == null) {
            throw new IllegalStateException("cache is closed");
        }
        d dVar = (d) this.f8771j.get(str);
        if (j6 != -1 && (dVar == null || dVar.f8763g != j6)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str);
            this.f8771j.put(str, dVar);
        } else if (dVar.f8762f != null) {
            return null;
        }
        c cVar = new c(this, dVar);
        dVar.f8762f = cVar;
        this.f8770i.append((CharSequence) "DIRTY");
        this.f8770i.append(Chars.SPACE);
        this.f8770i.append((CharSequence) str);
        this.f8770i.append('\n');
        flushWriter(this.f8770i);
        return cVar;
    }
}
