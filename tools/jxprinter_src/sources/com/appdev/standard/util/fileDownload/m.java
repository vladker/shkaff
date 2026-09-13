package com.appdev.standard.util.fileDownload;

import android.util.Log;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import okhttp3.W;
import retrofit2.r0;
import retrofit2.t0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    /* JADX WARN: Code duplicated, block: B:34:0x00b2 A[Catch: IOException -> 0x00c5, TRY_ENTER, TryCatch #1 {IOException -> 0x00c5, blocks: (B:8:0x004d, B:17:0x0074, B:34:0x00b2, B:36:0x00b7, B:37:0x00ba, B:39:0x00bd, B:41:0x00c2), top: B:48:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b7 A[Catch: IOException -> 0x00c5, TryCatch #1 {IOException -> 0x00c5, blocks: (B:8:0x004d, B:17:0x0074, B:34:0x00b2, B:36:0x00b7, B:37:0x00ba, B:39:0x00bd, B:41:0x00c2), top: B:48:0x004d }] */
    public void downloadFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        if (p002a.d.f905a == null) {
            t0 t0Var = new t0();
            t0Var.a("https://example.com/");
            t0Var.c(Executors.newSingleThreadExecutor());
            t0Var.f8161a.add(new z5.a(new Gson()));
            p002a.d.f905a = t0Var.b();
        }
        r0<W> r0VarExecute = ((l) p002a.d.f905a.a(l.class)).downloadFile(str).execute();
        if (!r0VarExecute.f8159a.a()) {
            Log.d("FileDownloader", "Server contact failed");
            return;
        }
        W wBody = r0VarExecute.body();
        boolean z6 = false;
        try {
            File file = new File(str2);
            InputStream inputStream = null;
            try {
                try {
                    byte[] bArr = new byte[4096];
                    long jC = wBody.c();
                    try {
                        InputStream inputStream2 = wBody.d().inputStream();
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            long j6 = 0;
                            while (true) {
                                try {
                                    int i5 = inputStream2.read(bArr);
                                    if (i5 == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i5);
                                    j6 += (long) i5;
                                    Log.d("FileDownloader", "file download: " + j6 + " of " + jC);
                                } catch (IOException unused) {
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream = inputStream2;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream.flush();
                            inputStream2.close();
                            fileOutputStream.close();
                            z6 = true;
                        } catch (IOException unused2) {
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException unused3) {
                fileOutputStream = null;
            }
        } catch (IOException unused4) {
        }
        Log.d("FileDownloader", "File download was a success? " + z6);
    }
}
