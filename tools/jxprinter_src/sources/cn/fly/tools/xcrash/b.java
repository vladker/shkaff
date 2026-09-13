package cn.fly.tools.xcrash;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b f2010l = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2011a = "placeholder";
    private String b = ".clean.xcrash";
    private String c = ".dirty.xcrash";
    private String d = null;
    private int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2012f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2013g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2014h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2015i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2016j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AtomicInteger f2017k = new AtomicInteger();

    private b() {
    }

    public static b a() {
        return f2010l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (e.a(this.d)) {
            File file = new File(this.d);
            try {
                b(file);
            } catch (Exception e) {
                XCrash.getLogger().a("NCRASH", "FileManager doMaintainTombstone failed", e);
            }
            try {
                c(file);
            } catch (Exception e6) {
                XCrash.getLogger().a("NCRASH", "FileManager doMaintainPlaceholder failed", e6);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00aa A[Catch: Exception -> 0x00ad, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ad, blocks: (B:36:0x00aa, B:30:0x0097), top: B:47:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private boolean d(File file) throws Throwable {
        File file2;
        FileOutputStream fileOutputStream = null;
        boolean zRenameTo = false;
        try {
            try {
                try {
                    byte[] bArr = new byte[1024];
                    Arrays.fill(bArr, (byte) 0);
                    long j6 = this.f2015i;
                    long length = file.length();
                    if (length > this.f2015i * 1024) {
                        j6 = length / 1024;
                        if (length % 1024 != 0) {
                            j6++;
                        }
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file.getAbsoluteFile(), false);
                    int i5 = 0;
                    while (i5 < j6) {
                        i5++;
                        if (i5 == j6) {
                            try {
                                try {
                                    if (length % 1024 != 0) {
                                        fileOutputStream2.write(bArr, 0, (int) (length % 1024));
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e) {
                                e = e;
                                file2 = file;
                                fileOutputStream = fileOutputStream2;
                                XCrash.getLogger().a("NCRASH", "FileManager cleanTheDirtyFile failed", e);
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (!zRenameTo) {
                                    try {
                                        file2.delete();
                                    } catch (Exception unused2) {
                                    }
                                }
                                return zRenameTo;
                            }
                        }
                        fileOutputStream2.write(bArr);
                    }
                    fileOutputStream2.flush();
                    file2 = file;
                    try {
                        zRenameTo = file2.renameTo(new File(String.format(Locale.US, "%s/%s_%020d%s", this.d, this.f2011a, Long.valueOf((new Date().getTime() * 1000) + ((long) d())), this.b)));
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = fileOutputStream2;
                        XCrash.getLogger().a("NCRASH", "FileManager cleanTheDirtyFile failed", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (!zRenameTo) {
                            file2.delete();
                        }
                        return zRenameTo;
                    }
                } catch (Exception unused3) {
                }
            } catch (Exception e7) {
                e = e7;
                file2 = file;
            }
            if (!zRenameTo) {
                file2.delete();
            }
            return zRenameTo;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void b() {
        int i5;
        if (this.d == null || (i5 = this.f2016j) < 0) {
            return;
        }
        try {
            if (i5 == 0) {
                new Thread(new Runnable() { // from class: cn.fly.tools.xcrash.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.c();
                    }
                }, "xcrash_file_mgr").start();
            } else {
                new Timer("xcrash_file_mgr").schedule(new TimerTask() { // from class: cn.fly.tools.xcrash.b.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b.this.c();
                    }
                }, this.f2016j);
            }
        } catch (Exception e) {
            XCrash.getLogger().a("NCRASH", "FileManager maintain start failed", e);
        }
    }

    public void a(String str, int i5, int i6, int i7, int i8, int i9) {
        File[] fileArrListFiles;
        this.d = str;
        this.e = i5;
        this.f2012f = i6;
        this.f2014h = i7;
        this.f2015i = i8;
        this.f2016j = i9;
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                for (File file2 : fileArrListFiles) {
                    if (file2.isFile()) {
                        String name = file2.getName();
                        if (!name.startsWith("tombstone_")) {
                            if (name.startsWith(this.f2011a + "_")) {
                                if (name.endsWith(this.b)) {
                                    i13++;
                                } else if (name.endsWith(this.c)) {
                                    i14++;
                                }
                            }
                        } else if (name.endsWith(".java.xcrash")) {
                            i10++;
                        } else if (name.endsWith(".native.xcrash")) {
                            i11++;
                        } else if (!name.endsWith(".anr.xcrash") && name.endsWith(".trace.xcrash")) {
                            i12++;
                        }
                    }
                }
                int i15 = this.e;
                if (i10 <= i15 && i11 <= this.f2012f && i12 <= this.f2013g && i13 == this.f2014h && i14 == 0) {
                    this.f2016j = -1;
                    return;
                }
                if (i10 <= i15 + 10) {
                    int i16 = this.f2012f;
                    if (i11 <= i16 + 10) {
                        int i17 = this.f2013g;
                        if (i12 <= i17 + 10) {
                            int i18 = this.f2014h;
                            if (i13 <= i18 + 10 && i14 <= 10) {
                                if (i10 > i15 || i11 > i16 || i12 > i17 || i13 > i18 || i14 > 0) {
                                    this.f2016j = 0;
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                c();
                this.f2016j = -1;
            }
        } catch (Exception e) {
            XCrash.getLogger().a("NCRASH", "FileManager init failed", e);
        }
    }

    private void b(File file) {
        a(file, ".native.xcrash", this.f2012f);
        a(file, ".java.xcrash", this.e);
        a(file, ".trace.xcrash", this.f2013g);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0080 A[EDGE_INSN: B:49:0x0080->B:28:0x0080 BREAK  A[LOOP:0: B:9:0x0021->B:50:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:? A[LOOP:0: B:9:0x0021->B:50:?, LOOP_END, SYNTHETIC] */
    private void c(File file) {
        File[] fileArrListFiles;
        int i5;
        File[] fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: cn.fly.tools.xcrash.b.6
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append(b.this.f2011a);
                sb.append("_");
                return str.startsWith(sb.toString()) && str.endsWith(b.this.b);
            }
        });
        if (fileArrListFiles2 == null || (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: cn.fly.tools.xcrash.b.7
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append(b.this.f2011a);
                sb.append("_");
                return str.startsWith(sb.toString()) && str.endsWith(b.this.c);
            }
        })) == null) {
            return;
        }
        int length = fileArrListFiles2.length;
        int length2 = fileArrListFiles.length;
        int i6 = 0;
        while (length < this.f2014h) {
            if (length2 > 0) {
                if (d(fileArrListFiles[length2 - 1])) {
                    length++;
                }
                length2--;
            } else {
                try {
                    i5 = i6;
                    try {
                        File file2 = new File(String.format(Locale.US, "%s/%s_%020d%s", this.d, this.f2011a, Long.valueOf((new Date().getTime() * 1000) + ((long) d())), this.c));
                        if (file2.createNewFile() && d(file2)) {
                            length++;
                        }
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i5 = i6;
                }
                i6 = i5 + 1;
                if (i6 > this.f2014h * 2) {
                    break;
                }
            }
            i5 = i6;
            i6 = i5 + 1;
            if (i6 > this.f2014h * 2) {
                break;
                break;
            }
        }
        if (i6 > 0) {
            fileArrListFiles2 = file.listFiles(new FilenameFilter() { // from class: cn.fly.tools.xcrash.b.8
                @Override // java.io.FilenameFilter
                public boolean accept(File file3, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(b.this.f2011a);
                    sb.append("_");
                    return str.startsWith(sb.toString()) && str.endsWith(b.this.b);
                }
            });
            fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: cn.fly.tools.xcrash.b.9
                @Override // java.io.FilenameFilter
                public boolean accept(File file3, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(b.this.f2011a);
                    sb.append("_");
                    return str.startsWith(sb.toString()) && str.endsWith(b.this.c);
                }
            });
        }
        if (fileArrListFiles2 != null && fileArrListFiles2.length > this.f2014h) {
            for (int i7 = 0; i7 < fileArrListFiles2.length - this.f2014h; i7++) {
                fileArrListFiles2[i7].delete();
            }
        }
        if (fileArrListFiles != null) {
            for (File file3 : fileArrListFiles) {
                file3.delete();
            }
        }
    }

    private int d() {
        int iIncrementAndGet = this.f2017k.incrementAndGet();
        if (iIncrementAndGet >= 999) {
            this.f2017k.set(0);
        }
        return iIncrementAndGet;
    }

    public boolean a(String str, String str2) throws Throwable {
        Exception exc;
        Throwable th;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rws");
                try {
                    long j6 = 0;
                    if (randomAccessFile2.length() > 0) {
                        MappedByteBuffer map = randomAccessFile2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile2.length());
                        long length = randomAccessFile2.length();
                        while (length > 0 && map.get(((int) length) - 1) == 0) {
                            length--;
                        }
                        j6 = length;
                    }
                    randomAccessFile2.seek(j6);
                    randomAccessFile2.write(str2.getBytes("UTF-8"));
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused) {
                    }
                    return true;
                } catch (Exception e) {
                    exc = e;
                    randomAccessFile = randomAccessFile2;
                    XCrash.getLogger().a("NCRASH", "FileManager appendText failed", exc);
                    if (randomAccessFile == null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Exception unused2) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e6) {
            exc = e6;
        }
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (this.d != null && this.f2014h > 0) {
            try {
                File[] fileArrListFiles = new File(this.d).listFiles(new FilenameFilter() { // from class: cn.fly.tools.xcrash.b.3
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file2, String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(b.this.f2011a);
                        sb.append("_");
                        return str.startsWith(sb.toString()) && str.endsWith(b.this.b);
                    }
                });
                if (fileArrListFiles != null && fileArrListFiles.length >= this.f2014h) {
                    try {
                        return file.delete();
                    } catch (Exception unused) {
                        return false;
                    }
                }
                File file2 = new File(String.format(Locale.US, "%s/%s_%020d%s", this.d, this.f2011a, Long.valueOf((new Date().getTime() * 1000) + ((long) d())), this.c));
                if (!file.renameTo(file2)) {
                    try {
                        return file.delete();
                    } catch (Exception unused2) {
                        return false;
                    }
                }
                return d(file2);
            } catch (Exception e) {
                XCrash.getLogger().a("NCRASH", "FileManager recycleLogFile failed", e);
                try {
                    return file.delete();
                } catch (Exception unused3) {
                    return false;
                }
            }
        }
        try {
            return file.delete();
        } catch (Exception unused4) {
            return false;
        }
    }

    private boolean a(File file, final String str, int i5) {
        File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: cn.fly.tools.xcrash.b.4
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.startsWith("tombstone_") && str2.endsWith(str);
            }
        });
        boolean z6 = true;
        if (fileArrListFiles != null && fileArrListFiles.length > i5) {
            if (i5 > 0) {
                Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: cn.fly.tools.xcrash.b.5
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        return file2.getName().compareTo(file3.getName());
                    }
                });
            }
            for (int i6 = 0; i6 < fileArrListFiles.length - i5; i6++) {
                if (!a(fileArrListFiles[i6])) {
                    z6 = false;
                }
            }
        }
        return z6;
    }
}
