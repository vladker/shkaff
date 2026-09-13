package com.mob.tools.network;

import A3.AbstractC0157z;
import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.ResHelper;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.HttpHeaders;
import com.mob.commons.a;
import com.mob.tools.MobLog;
import com.mob.tools.network.wrapper.b;
import com.mob.tools.network.wrapper.c;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.HashonHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkHelper implements EverythingKeeper {
    public static int connectionTimeout = 0;
    private static boolean followRedirects = true;
    public static int readTimout;
    private cn.fly.tools.network.NetworkHelper flyImpl;
    protected boolean instanceFollowRedirects = followRedirects;

    public static class NetworkTimeOut implements PublicMemberKeeper {
        public int connectionTimeout;
        public int readTimout;
    }

    public NetworkHelper() {
        cn.fly.tools.network.NetworkHelper networkHelper = new cn.fly.tools.network.NetworkHelper();
        this.flyImpl = networkHelper;
        networkHelper.instanceFollowRedirects = this.instanceFollowRedirects;
    }

    @Deprecated
    public static String checkHttpRequestUrl(String str) {
        return NetCommunicator.checkHttpRequestUrl(str);
    }

    @Deprecated
    private ByteArrayPart getDataPostHttpPart(HttpURLConnection httpURLConnection, String str, byte[] bArr) throws IOException {
        ByteArrayPart byteArrayPart = new ByteArrayPart();
        byteArrayPart.append(bArr);
        return byteArrayPart;
    }

    @Deprecated
    private HTTPPart getFilePostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2) throws Throwable {
        String string = UUID.randomUUID().toString();
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + string);
        MultiPart multiPart = new MultiPart();
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                KVPair<String> kVPair = arrayList.get(i5);
                i5++;
                KVPair<String> kVPair2 = kVPair;
                stringPart.append("--").append(string).append("\r\n");
                stringPart.append("Content-Disposition: form-data; name=\"").append(kVPair2.name).append("\"\r\n\r\n");
                stringPart.append(kVPair2.value).append("\r\n");
            }
        }
        multiPart.append(stringPart);
        int size2 = arrayList2.size();
        int i6 = 0;
        while (i6 < size2) {
            KVPair<String> kVPair3 = arrayList2.get(i6);
            i6++;
            KVPair<String> kVPair4 = kVPair3;
            StringPart stringPart2 = new StringPart();
            File file = new File(kVPair4.value);
            stringPart2.append("--").append(string).append("\r\n");
            stringPart2.append("Content-Disposition: form-data; name=\"").append(kVPair4.name).append("\"; filename=\"").append(file.getName()).append("\"\r\n");
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(kVPair4.value);
            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                if (kVPair4.value.toLowerCase().endsWith(ContentTypes.EXTENSION_JPG_1) || kVPair4.value.toLowerCase().endsWith(ContentTypes.EXTENSION_JPG_2)) {
                    contentTypeFor = ContentTypes.IMAGE_JPEG;
                } else if (kVPair4.value.toLowerCase().endsWith(ContentTypes.EXTENSION_PNG)) {
                    contentTypeFor = ContentTypes.IMAGE_PNG;
                } else if (kVPair4.value.toLowerCase().endsWith(ContentTypes.EXTENSION_GIF)) {
                    contentTypeFor = ContentTypes.IMAGE_GIF;
                } else {
                    FileInputStream fileInputStream = null;
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(kVPair4.value);
                        try {
                            String strGuessContentTypeFromStream = URLConnection.guessContentTypeFromStream(fileInputStream2);
                            a.a(fileInputStream2);
                            contentTypeFor = (strGuessContentTypeFromStream == null || strGuessContentTypeFromStream.length() <= 0) ? "application/octet-stream" : strGuessContentTypeFromStream;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            a.a(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            stringPart2.append("Content-Type: ").append(contentTypeFor).append("\r\n\r\n");
            multiPart.append(stringPart2);
            FilePart filePart = new FilePart();
            filePart.setFile(kVPair4.value);
            multiPart.append(filePart);
            StringPart stringPart3 = new StringPart();
            stringPart3.append("\r\n");
            multiPart.append(stringPart3);
        }
        StringPart stringPart4 = new StringPart();
        stringPart4.append("--").append(string).append("--\r\n");
        multiPart.append(stringPart4);
        return multiPart;
    }

    @Deprecated
    private HTTPPart getTextPostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList) {
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            stringPart.append(this.flyImpl.requestParamsToUrl(kvPairsToObjHashMap(arrayList)));
        }
        return stringPart;
    }

    public static cn.fly.tools.network.NetworkHelper.NetworkTimeOut getTimeoutWrapper(NetworkTimeOut networkTimeOut) {
        if (networkTimeOut == null) {
            return null;
        }
        cn.fly.tools.network.NetworkHelper.NetworkTimeOut networkTimeOut2 = new cn.fly.tools.network.NetworkHelper.NetworkTimeOut();
        networkTimeOut2.connectionTimeout = networkTimeOut.connectionTimeout;
        networkTimeOut2.readTimout = networkTimeOut.readTimout;
        return networkTimeOut2;
    }

    @Deprecated
    private HashMap<String, Object> kvPairsToObjHashMap(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        HashMap<String, Object> map = new HashMap<>();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            KVPair<String> kVPair = arrayList.get(i5);
            i5++;
            KVPair<String> kVPair2 = kVPair;
            map.put(kVPair2.name, kVPair2.value);
        }
        return map;
    }

    @Deprecated
    private HashMap<String, String> kvPairsToStrHashMap(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            KVPair<String> kVPair = arrayList.get(i5);
            i5++;
            KVPair<String> kVPair2 = kVPair;
            map.put(kVPair2.name, kVPair2.value);
        }
        return map;
    }

    public void download(String str, OutputStream outputStream, NetworkTimeOut networkTimeOut) throws IOException {
        this.flyImpl.download(str, outputStream, getTimeoutWrapper(networkTimeOut));
    }

    public String downloadCache(Context context, String str, String str2, boolean z6, NetworkTimeOut networkTimeOut) {
        return downloadCache(context, str, str2, z6, networkTimeOut, null);
    }

    @Deprecated
    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return this.flyImpl.httpGetNew(str, kvPairsToObjHashMap(arrayList), kvPairsToStrHashMap(arrayList2), getTimeoutWrapper(networkTimeOut));
    }

    public String httpGetNew(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut) {
        return this.flyImpl.httpGetNew(str, map, map2, getTimeoutWrapper(networkTimeOut));
    }

    @Deprecated
    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return httpPostNew(str, kvPairsToObjHashMap(arrayList), kvPairsToStrHashMap(arrayList2), networkTimeOut);
    }

    @Deprecated
    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i5, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        httpPost(str, arrayList, arrayList2, arrayList3, i5, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.1
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                a.a(bufferedReader2, inputStreamReader);
                                map.put("resp", sb.toString());
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                a.a(bufferedReader, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String line2 = bufferedReader3.readLine(); line2 != null; line2 = bufferedReader3.readLine()) {
                                    if (sb2.length() > 0) {
                                        sb2.append('\n');
                                    }
                                    sb2.append(line2);
                                }
                                a.a(bufferedReader3, inputStreamReader2);
                                HashMap map2 = new HashMap();
                                map2.put("error", sb2.toString());
                                map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(map2));
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader = bufferedReader3;
                                a.a(bufferedReader, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader2 = null;
                    }
                }
            }
        }, networkTimeOut);
        return (String) map.get("resp");
    }

    @Deprecated
    public String httpPostFilesChecked(String str, ArrayList<KVPair<String>> arrayList, byte[] bArr, ArrayList<KVPair<String>> arrayList2, int i5, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        httpPost(str, arrayList, bArr, arrayList2, i5, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.2
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                a.a(bufferedReader2, inputStreamReader);
                                map.put("resp", sb.toString());
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                a.a(bufferedReader, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String line2 = bufferedReader3.readLine(); line2 != null; line2 = bufferedReader3.readLine()) {
                                    if (sb2.length() > 0) {
                                        sb2.append('\n');
                                    }
                                    sb2.append(line2);
                                }
                                a.a(bufferedReader3, inputStreamReader2);
                                HashMap map2 = new HashMap();
                                map2.put("error", sb2.toString());
                                map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(map2));
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader = bufferedReader3;
                                a.a(bufferedReader, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader2 = null;
                    }
                }
            }
        }, networkTimeOut);
        return (String) map.get("resp");
    }

    public String httpPostNew(String str, HashMap<String, Object> map, HashMap<String, String> map2, NetworkTimeOut networkTimeOut) {
        return this.flyImpl.httpPostNew(str, map, map2, getTimeoutWrapper(networkTimeOut));
    }

    public void httpPostWithBytes(String str, byte[] bArr, HashMap<String, String> map, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        this.flyImpl.httpPostWithBytes(str, bArr, map, i5, b.a(httpResponseCallback), getTimeoutWrapper(networkTimeOut));
    }

    @Deprecated
    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return httpPut(str, kvPairsToObjHashMap(arrayList), kVPair, arrayList2, networkTimeOut, null);
    }

    @Deprecated
    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return this.flyImpl.jsonPost(str, kvPairsToObjHashMap(arrayList), kvPairsToStrHashMap(arrayList2), getTimeoutWrapper(networkTimeOut));
    }

    @Deprecated
    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        this.flyImpl.rawGet(str, kvPairsToStrHashMap(arrayList), c.a(rawNetworkCallback), getTimeoutWrapper(networkTimeOut));
    }

    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        rawPost(str, arrayList, hTTPPart, 0, httpResponseCallback, networkTimeOut);
    }

    @Deprecated
    private void jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        HashMap<String, Object> map = new HashMap<>();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            KVPair<String> kVPair = arrayList.get(i5);
            i5++;
            KVPair<String> kVPair2 = kVPair;
            map.put(kVPair2.name, kVPair2.value);
        }
        jsonPost(str, map, arrayList2, networkTimeOut, httpResponseCallback);
    }

    public String downloadCache(Context context, String str, String str2, boolean z6, NetworkTimeOut networkTimeOut, FileDownloadListener fileDownloadListener) throws Throwable {
        InputStreamReader inputStreamReader;
        String strJ;
        String strMD5;
        char c;
        char c6;
        FileOutputStream fileOutputStream;
        int i5;
        List<String> list;
        int iLastIndexOf;
        List<String> list2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        FlyLog.getInstance().i("downloading: " + str);
        if (z6) {
            File file = new File(ResHelper.getCachePath(context, str2), Data.MD5(str));
            if (z6 && file.exists()) {
                FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (fileDownloadListener != null) {
                    fileDownloadListener.onProgress(100, file.length(), file.length());
                }
                return file.getAbsolutePath();
            }
        }
        HttpURLConnection connection = this.flyImpl.getConnection(str, getTimeoutWrapper(networkTimeOut));
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        int responseCode = connection.getResponseCode();
        char c7 = 1;
        Closeable closeable = null;
        if (responseCode == 200) {
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            if (headerFields == null || (list2 = headerFields.get(HttpHeaders.CONTENT_DISPOSITION)) == null || list2.size() <= 0) {
                strJ = null;
            } else {
                strJ = null;
                for (String str3 : list2.get(0).split(";")) {
                    if (str3.trim().startsWith("filename")) {
                        String str4 = str3.split("=")[1];
                        strJ = (str4.startsWith("\"") && str4.endsWith("\"")) ? androidx.collection.a.g(1, 1, str4) : str4;
                    }
                }
            }
            if (strJ == null) {
                strMD5 = Data.MD5(str);
                if (headerFields != null && (list = headerFields.get(HttpHeaders.CONTENT_TYPE)) != null && list.size() > 0) {
                    String str5 = list.get(0);
                    String strTrim = str5 == null ? "" : str5.trim();
                    if (strTrim.startsWith("image/")) {
                        String strSubstring = strTrim.substring(6);
                        StringBuilder sbX = AbstractC0157z.x(strMD5, Consts.DOT);
                        if (ContentTypes.EXTENSION_JPG_2.equals(strSubstring)) {
                            strSubstring = ContentTypes.EXTENSION_JPG_1;
                        }
                        sbX.append(strSubstring);
                        strJ = sbX.toString();
                    } else {
                        int iLastIndexOf2 = str.lastIndexOf(47);
                        String strSubstring2 = iLastIndexOf2 > 0 ? str.substring(iLastIndexOf2 + 1) : null;
                        if (strSubstring2 != null && strSubstring2.length() > 0 && (iLastIndexOf = strSubstring2.lastIndexOf(46)) > 0 && strSubstring2.length() - iLastIndexOf < 10) {
                            strJ = androidx.exifinterface.media.a.j(strSubstring2, iLastIndexOf, androidx.collection.a.r(strMD5));
                        }
                    }
                    strMD5 = strJ;
                }
            } else {
                strMD5 = strJ;
            }
            File file2 = new File(ResHelper.getCachePath(context, str2), strMD5);
            if (z6 && file2.exists()) {
                connection.disconnect();
                FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (fileDownloadListener != null) {
                    fileDownloadListener.onProgress(100, file2.length(), file2.length());
                }
                return file2.getAbsolutePath();
            }
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists()) {
                file2.delete();
            }
            if (fileDownloadListener != null) {
                try {
                    if (fileDownloadListener.isCanceled()) {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    throw th;
                }
            }
            try {
                InputStream inputStream = connection.getInputStream();
                try {
                    int contentLength = connection.getContentLength();
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[1024];
                        int i6 = inputStream.read(bArr);
                        int i7 = 0;
                        while (true) {
                            if (i6 <= 0) {
                                c = c7;
                                c6 = 0;
                                break;
                            }
                            try {
                                fileOutputStream.write(bArr, 0, i6);
                                int i8 = i6 + i7;
                                if (fileDownloadListener != null) {
                                    c6 = 0;
                                    c = c7;
                                    try {
                                        fileDownloadListener.onProgress(contentLength <= 0 ? 100 : (i8 * 100) / contentLength, i8, contentLength);
                                        if (fileDownloadListener.isCanceled()) {
                                            break;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        closeable = inputStream;
                                        i5 = 2;
                                        Closeable[] closeableArr = new Closeable[i5];
                                        closeableArr[c6] = closeable;
                                        closeableArr[c] = fileOutputStream;
                                        a.a(closeableArr);
                                        throw th;
                                    }
                                } else {
                                    c = c7;
                                }
                                i6 = inputStream.read(bArr);
                                bArr = bArr;
                                i7 = i8;
                                c7 = c;
                            } catch (Throwable th3) {
                                th = th3;
                                c6 = 0;
                                c = c7;
                            }
                        }
                        if (fileDownloadListener != null) {
                            if (fileDownloadListener.isCanceled()) {
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                fileOutputStream.flush();
                                Closeable[] closeableArr2 = new Closeable[2];
                                closeableArr2[c6] = inputStream;
                                closeableArr2[c] = fileOutputStream;
                                a.a(closeableArr2);
                                return null;
                            }
                            fileDownloadListener.onProgress(100, file2.length(), file2.length());
                        }
                        fileOutputStream.flush();
                        Closeable[] closeableArr3 = new Closeable[2];
                        closeableArr3[c6] = inputStream;
                        closeableArr3[c] = fileOutputStream;
                        a.a(closeableArr3);
                        connection.disconnect();
                        FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return file2.getAbsolutePath();
                    } catch (Throwable th4) {
                        th = th4;
                        c = 1;
                        c6 = 0;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    c = 1;
                    c6 = 0;
                    fileOutputStream = null;
                    i5 = 2;
                    closeable = inputStream;
                    Closeable[] closeableArr4 = new Closeable[i5];
                    closeableArr4[c6] = closeable;
                    closeableArr4[c] = fileOutputStream;
                    a.a(closeableArr4);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                c = 1;
                c6 = 0;
                fileOutputStream = null;
            }
        } else {
            if (cn.fly.tools.network.NetworkHelper.isRedirects(connection)) {
                return downloadCache(context, connection.getHeaderField(HttpHeaders.LOCATION), str2, z6, networkTimeOut, fileDownloadListener);
            }
            StringBuilder sb = new StringBuilder();
            try {
                inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                            if (sb.length() > 0) {
                                sb.append('\n');
                            }
                            sb.append(line);
                        }
                        a.a(bufferedReader, inputStreamReader);
                        connection.disconnect();
                        HashMap map = new HashMap();
                        map.put("error", sb.toString());
                        map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                        new cn.fly.tools.utils.HashonHelper();
                        throw new Throwable(cn.fly.tools.utils.HashonHelper.fromHashMap(map));
                    } catch (Throwable th7) {
                        th = th7;
                        closeable = bufferedReader;
                        a.a(closeable, inputStreamReader);
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Throwable th9) {
                th = th9;
                inputStreamReader = null;
            }
        }
    }

    public String httpGet(String str, HashMap<String, Object> map, HashMap<String, String> map2) {
        cn.fly.tools.network.NetworkHelper.NetworkTimeOut networkTimeOut = new cn.fly.tools.network.NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
        networkTimeOut.connectionTimeout = 10000;
        return this.flyImpl.httpGetNew(str, map, map2, networkTimeOut);
    }

    @Deprecated
    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        cn.fly.tools.network.NetworkHelper.NetworkTimeOut timeoutWrapper = getTimeoutWrapper(networkTimeOut);
        FlyLog.getInstance().i("httpPost: " + str);
        HttpURLConnection connection = this.flyImpl.getConnection(str, timeoutWrapper);
        connection.setDoOutput(true);
        connection.setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        if (arrayList2 == null || arrayList2.size() <= 0) {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.length());
        } else {
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList2);
            if (i5 >= 0) {
                connection.setChunkedStreamingMode(i5);
            }
        }
        if (arrayList3 != null) {
            int size = arrayList3.size();
            int i6 = 0;
            while (i6 < size) {
                KVPair<String> kVPair = arrayList3.get(i6);
                i6++;
                KVPair<String> kVPair2 = kVPair;
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream = null;
        try {
            outputStream = connection.getOutputStream();
            try {
                inputStream = textPostHTTPPart.toInputStream();
                byte[] bArr = new byte[65536];
                for (int i7 = inputStream.read(bArr); i7 > 0; i7 = inputStream.read(bArr)) {
                    outputStream.write(bArr, 0, i7);
                }
                outputStream.flush();
                a.a(inputStream, outputStream);
                if (httpResponseCallback != null) {
                    try {
                        httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                        connection.disconnect();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            connection.disconnect();
                            throw th2;
                        }
                    }
                } else {
                    connection.disconnect();
                }
                FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th3) {
                th = th3;
                a.a(inputStream, outputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
        }
    }

    @Deprecated
    public String httpPut(String str, HashMap<String, Object> map, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList, NetworkTimeOut networkTimeOut, OnReadListener onReadListener) throws Throwable {
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPut: " + str);
        if (map != null) {
            String strRequestParamsToUrl = this.flyImpl.requestParamsToUrl(map);
            if (strRequestParamsToUrl.length() > 0) {
                str = androidx.collection.a.o(str, "?", strRequestParamsToUrl);
            }
        }
        HttpURLConnection connection = this.flyImpl.getConnection(str, getTimeoutWrapper(networkTimeOut));
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
        this.flyImpl.setHeader(connection, kvPairsToStrHashMap(arrayList));
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        Closeable closeable = null;
        try {
            outputStream = connection.getOutputStream();
            try {
                FilePart filePart = new FilePart();
                if (onReadListener != null) {
                    filePart.setOnReadListener(onReadListener);
                }
                filePart.setFile(kVPair.value);
                InputStream inputStream = filePart.toInputStream();
                try {
                    byte[] bArr = new byte[65536];
                    for (int i5 = inputStream.read(bArr); i5 > 0; i5 = inputStream.read(bArr)) {
                        outputStream.write(bArr, 0, i5);
                    }
                    outputStream.flush();
                    a.a(inputStream, outputStream);
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200 || responseCode == 201) {
                        StringBuilder sb = new StringBuilder();
                        try {
                            inputStreamReader = new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8"));
                            try {
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                try {
                                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                        if (sb.length() > 0) {
                                            sb.append('\n');
                                        }
                                        sb.append(line);
                                    }
                                    a.a(bufferedReader, inputStreamReader);
                                    connection.disconnect();
                                    String string = sb.toString();
                                    MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                                    return string;
                                } catch (Throwable th) {
                                    th = th;
                                    closeable = bufferedReader;
                                    a.a(closeable, inputStreamReader);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStreamReader = null;
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            inputStreamReader2 = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                            try {
                                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);
                                try {
                                    for (String line2 = bufferedReader2.readLine(); line2 != null; line2 = bufferedReader2.readLine()) {
                                        if (sb2.length() > 0) {
                                            sb2.append('\n');
                                        }
                                        sb2.append(line2);
                                    }
                                    a.a(bufferedReader2, inputStreamReader2);
                                    HashMap map2 = new HashMap();
                                    map2.put("error", sb2.toString());
                                    map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                                    new HashonHelper();
                                    throw new Throwable(HashonHelper.fromHashMap(map2));
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable = bufferedReader2;
                                    a.a(closeable, inputStreamReader2);
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            inputStreamReader2 = null;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    closeable = inputStream;
                    a.a(closeable, outputStream);
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            outputStream = null;
        }
    }

    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        this.flyImpl.rawPost(str, kvPairsToStrHashMap(arrayList), com.mob.tools.network.wrapper.a.a(hTTPPart), 0, b.a(httpResponseCallback), getTimeoutWrapper(networkTimeOut));
    }

    @Deprecated
    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        this.flyImpl.rawGet(str, kvPairsToStrHashMap(arrayList), b.a(httpResponseCallback), getTimeoutWrapper(networkTimeOut));
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        rawGet(str, new HashMap<>(), rawNetworkCallback, networkTimeOut);
    }

    public void rawPost(String str, HashMap<String, String> map, HTTPPart hTTPPart, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        this.flyImpl.rawPost(str, map, com.mob.tools.network.wrapper.a.a(hTTPPart), i5, b.a(httpResponseCallback), getTimeoutWrapper(networkTimeOut));
    }

    @Deprecated
    public void jsonPost(String str, HashMap<String, Object> map, ArrayList<KVPair<String>> arrayList, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        this.flyImpl.jsonPost(str, map, kvPairsToStrHashMap(arrayList), getTimeoutWrapper(networkTimeOut), b.a(httpResponseCallback));
    }

    public void rawGet(String str, HashMap<String, String> map, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) {
        this.flyImpl.rawGet(str, map, c.a(rawNetworkCallback), getTimeoutWrapper(networkTimeOut));
    }

    public void rawGet(String str, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        rawGet(str, new HashMap<>(), httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, HashMap<String, String> map, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) {
        this.flyImpl.rawGet(str, map, b.a(httpResponseCallback), getTimeoutWrapper(networkTimeOut));
    }

    @Deprecated
    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        long jCurrentTimeMillis = System.currentTimeMillis();
        cn.fly.tools.network.NetworkHelper.NetworkTimeOut timeoutWrapper = getTimeoutWrapper(networkTimeOut);
        FlyLog.getInstance().i("rawpost: " + str);
        HttpURLConnection connection = this.flyImpl.getConnection(str, timeoutWrapper);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                KVPair<String> kVPair = arrayList.get(i5);
                i5++;
                KVPair<String> kVPair2 = kVPair;
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        Closeable closeable = null;
        try {
            outputStream = connection.getOutputStream();
            try {
                InputStream inputStream = hTTPPart.toInputStream();
                try {
                    byte[] bArr = new byte[65536];
                    for (int i6 = inputStream.read(bArr); i6 > 0; i6 = inputStream.read(bArr)) {
                        outputStream.write(bArr, 0, i6);
                    }
                    outputStream.flush();
                    a.a(inputStream, outputStream);
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200) {
                        if (rawNetworkCallback != null) {
                            InputStream inputStream2 = connection.getInputStream();
                            try {
                                rawNetworkCallback.onResponse(inputStream2);
                                a.a(inputStream2);
                                connection.disconnect();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    a.a(inputStream2);
                                    connection.disconnect();
                                    throw th2;
                                }
                            }
                        } else {
                            connection.disconnect();
                        }
                        FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                a.a(bufferedReader, inputStreamReader);
                                connection.disconnect();
                                HashMap map = new HashMap();
                                map.put("error", sb.toString());
                                map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(map));
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = bufferedReader;
                                a.a(closeable, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStreamReader = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    closeable = inputStream;
                    a.a(closeable, outputStream);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            th = th8;
            outputStream = null;
        }
    }

    @Deprecated
    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, byte[] bArr, ArrayList<KVPair<String>> arrayList2, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        FlyLog.getInstance().i("httpPost: " + str);
        HttpURLConnection connection = this.flyImpl.getConnection(str, getTimeoutWrapper(networkTimeOut));
        connection.setDoOutput(true);
        connection.setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        if (bArr != null && bArr.length > 0) {
            textPostHTTPPart = getDataPostHttpPart(connection, str, bArr);
            if (i5 >= 0) {
                connection.setChunkedStreamingMode(i5);
            }
        } else {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.length());
        }
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i6 = 0;
            while (i6 < size) {
                KVPair<String> kVPair = arrayList2.get(i6);
                i6++;
                KVPair<String> kVPair2 = kVPair;
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        InputStream inputStream = null;
        try {
            outputStream = connection.getOutputStream();
            try {
                inputStream = textPostHTTPPart.toInputStream();
                byte[] bArr2 = new byte[65536];
                for (int i7 = inputStream.read(bArr2); i7 > 0; i7 = inputStream.read(bArr2)) {
                    outputStream.write(bArr2, 0, i7);
                }
                outputStream.flush();
                a.a(inputStream, outputStream);
                if (httpResponseCallback != null) {
                    try {
                        httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                        connection.disconnect();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            connection.disconnect();
                            throw th2;
                        }
                    }
                } else {
                    connection.disconnect();
                }
                FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th3) {
                th = th3;
                a.a(inputStream, outputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
        }
    }

    @Deprecated
    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, int i5, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        httpPost(str, arrayList, i5, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.3
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                InputStreamReader inputStreamReader;
                InputStreamReader inputStreamReader2;
                int responseCode = httpConnection.getResponseCode();
                BufferedReader bufferedReader = null;
                if (responseCode == 200 || responseCode < 300) {
                    StringBuilder sb = new StringBuilder();
                    try {
                        inputStreamReader = new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                            try {
                                for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                    if (sb.length() > 0) {
                                        sb.append('\n');
                                    }
                                    sb.append(line);
                                }
                                a.a(bufferedReader2, inputStreamReader);
                                map.put("resp", sb.toString());
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                a.a(bufferedReader, inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = null;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        inputStreamReader2 = new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8"));
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                            try {
                                for (String line2 = bufferedReader3.readLine(); line2 != null; line2 = bufferedReader3.readLine()) {
                                    if (sb2.length() > 0) {
                                        sb2.append('\n');
                                    }
                                    sb2.append(line2);
                                }
                                a.a(bufferedReader3, inputStreamReader2);
                                HashMap map2 = new HashMap();
                                map2.put("error", sb2.toString());
                                map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                                new HashonHelper();
                                throw new Throwable(HashonHelper.fromHashMap(map2));
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader = bufferedReader3;
                                a.a(bufferedReader, inputStreamReader2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStreamReader2 = null;
                    }
                }
            }
        }, networkTimeOut);
        return (String) map.get("resp");
    }

    @Deprecated
    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, int i5, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        OutputStream outputStream;
        long jCurrentTimeMillis = System.currentTimeMillis();
        FlyLog.getInstance().i("httpPost: " + str);
        HttpURLConnection connection = this.flyImpl.getConnection(str, getTimeoutWrapper(networkTimeOut));
        connection.setDoOutput(true);
        connection.setRequestProperty(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        if (arrayList != null) {
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                KVPair<String> kVPair = arrayList.get(i6);
                i6++;
                KVPair<String> kVPair2 = kVPair;
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        StringPart stringPart = new StringPart();
        InputStream inputStream = null;
        stringPart.append(null);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        try {
            outputStream = connection.getOutputStream();
            try {
                inputStream = stringPart.toInputStream();
                byte[] bArr = new byte[65536];
                for (int i7 = inputStream.read(bArr); i7 > 0; i7 = inputStream.read(bArr)) {
                    outputStream.write(bArr, 0, i7);
                }
                outputStream.flush();
                a.a(inputStream, outputStream);
                if (httpResponseCallback != null) {
                    try {
                        httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                        connection.disconnect();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            connection.disconnect();
                            throw th2;
                        }
                    }
                } else {
                    connection.disconnect();
                }
                FlyLog.getInstance().i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th3) {
                th = th3;
                a.a(inputStream, outputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
        }
    }
}
