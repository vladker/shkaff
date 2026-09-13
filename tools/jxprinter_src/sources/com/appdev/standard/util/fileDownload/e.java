package com.appdev.standard.util.fileDownload;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import okhttp3.W;
import p050j.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements p027e3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f2844a;

    public e(a aVar) {
        this.f2844a = aVar;
    }

    @Override // p027e3.g
    public void accept(W w6) throws Throwable {
        a aVar = this.f2844a;
        File file = aVar.b;
        String str = aVar.c;
        aVar.d = 2;
        byte[] bArr = new byte[2048];
        FileOutputStream fileOutputStream = null;
        try {
            try {
                Log.d("rustAppProgressCb", "saveFile: body content length: " + w6.c());
                aVar.e = w6.d().inputStream();
                File parentFile = file.getParentFile();
                if (parentFile == null) {
                    throw new FileNotFoundException("target file has no dir.");
                }
                if (!parentFile.exists()) {
                    Log.d("rustAppProgressCb", "Create dir " + parentFile.mkdirs() + ", " + parentFile);
                }
                if (!file.exists()) {
                    Log.d("rustAppProgressCb", "Create new file " + file.createNewFile());
                }
                Log.d("rustAppProgressCb", "saveFile: localFileStartByteIndex: 0");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        while (true) {
                            int i5 = aVar.e.read(bArr);
                            if (i5 == -1 || aVar.a() || n.a(aVar.d, 3)) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, i5);
                            int iCurrentTimeMillis = i5 - (1000 * ((int) (System.currentTimeMillis() - jCurrentTimeMillis)));
                            if (iCurrentTimeMillis > 0) {
                                try {
                                    Thread.sleep(iCurrentTimeMillis / 1000);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (aVar.a()) {
                                aVar.d = 7;
                                aVar.e.close();
                                break;
                            }
                        }
                        if (n.a(aVar.d, 3)) {
                            aVar.d = 4;
                            aVar.c(str);
                        } else if (!aVar.a()) {
                            fileOutputStream2.flush();
                            if (file.renameTo(aVar.f2840a)) {
                                aVar.d = 5;
                                aVar.d(str);
                            } else {
                                aVar.d = 6;
                                Exception exc = new Exception("Rename file fail. " + file);
                                Iterator it = ((b) aVar).f2841f.b.iterator();
                                while (it.hasNext()) {
                                    ((h) it.next()).onError(str, exc);
                                }
                            }
                        }
                        try {
                            InputStream inputStream = aVar.e;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            fileOutputStream2.close();
                        } catch (Exception e6) {
                            Log.e("rustAppProgressCb", "saveFile", e6);
                        }
                        if (!aVar.a()) {
                            return;
                        }
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        try {
                            InputStream inputStream2 = aVar.e;
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Exception e7) {
                            Log.e("rustAppProgressCb", "saveFile", e7);
                        }
                        if (!aVar.a()) {
                            throw th;
                        }
                        aVar.b(str);
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    fileOutputStream = fileOutputStream2;
                    e = e8;
                    Log.e("rustAppProgressCb", "saveFile: FileNotFoundException ", e);
                    aVar.d = 6;
                    Iterator it2 = ((b) aVar).f2841f.b.iterator();
                    while (it2.hasNext()) {
                        ((h) it2.next()).onError(str, e);
                    }
                    try {
                        InputStream inputStream3 = aVar.e;
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e9) {
                        Log.e("rustAppProgressCb", "saveFile", e9);
                    }
                    if (!aVar.a()) {
                        return;
                    }
                } catch (Exception e10) {
                    fileOutputStream = fileOutputStream2;
                    e = e10;
                    Log.e("rustAppProgressCb", "saveFile: IOException ", e);
                    aVar.d = 6;
                    Iterator it3 = ((b) aVar).f2841f.b.iterator();
                    while (it3.hasNext()) {
                        ((h) it3.next()).onError(str, e);
                    }
                    try {
                        InputStream inputStream4 = aVar.e;
                        if (inputStream4 != null) {
                            inputStream4.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e11) {
                        Log.e("rustAppProgressCb", "saveFile", e11);
                    }
                    if (!aVar.a()) {
                        return;
                    }
                }
                aVar.b(str);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e12) {
            e = e12;
        } catch (Exception e13) {
            e = e13;
        }
    }
}
