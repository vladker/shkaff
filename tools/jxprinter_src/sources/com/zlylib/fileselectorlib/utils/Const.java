package com.zlylib.fileselectorlib.utils;

import androidx.core.app.NotificationCompat;
import androidx.webkit.internal.AssetHelper;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.openxml4j.opc.ContentTypes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Const {
    public static final String EXTRA_KEY_FILE_TYPE = "EXTRA_KEY_FILE_TYPE";
    public static final String EXTRA_KEY_IS_SINGLE = "EXTRA_KEY_IS_SINGLE";
    public static final String EXTRA_KEY_MAX_COUNT = "EXTRA_KEY_MAX_COUNT";
    public static final String EXTRA_KEY_OnSelectFileListener = "EXTRA_KEY_OnSelectFileListener";
    public static final String EXTRA_KEY_SORT_TYPE = "EXTRA_KEY_SORT_TYPE";
    public static final String EXTRA_RESULT_SELECTION = "extra_result_selection";
    public static Map<String, String> mimeTypeMap;

    static {
        HashMap map = new HashMap();
        mimeTypeMap = map;
        map.put("apk", "application/vnd.android.package-archive");
        mimeTypeMap.put("asf", "video/x-ms-asf");
        mimeTypeMap.put("avi", "video/x-msvideo");
        mimeTypeMap.put("bin", "application/octet-stream");
        mimeTypeMap.put("bmp", "image/bmp");
        mimeTypeMap.put("c", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put(Constants.CLASS, "application/octet-stream");
        mimeTypeMap.put("conf", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put("cpp", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put("doc", "application/msword");
        mimeTypeMap.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        mimeTypeMap.put("xls", "application/vnd.ms-excel");
        mimeTypeMap.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        mimeTypeMap.put("exe", "application/octet-stream");
        mimeTypeMap.put(ContentTypes.EXTENSION_GIF, ContentTypes.IMAGE_GIF);
        mimeTypeMap.put("gtar", "application/x-gtar");
        mimeTypeMap.put(CompressorStreamFactory.GZIP, "application/x-gzip");
        mimeTypeMap.put("h", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put("htm", "text/html");
        mimeTypeMap.put("html", "text/html");
        mimeTypeMap.put(ArchiveStreamFactory.JAR, "application/java-archive");
        mimeTypeMap.put("java", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put(ContentTypes.EXTENSION_JPG_2, ContentTypes.IMAGE_JPEG);
        mimeTypeMap.put(ContentTypes.EXTENSION_JPG_1, ContentTypes.IMAGE_JPEG);
        mimeTypeMap.put("js", "application/x-javascript");
        mimeTypeMap.put("log", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put("m3u", "audio/x-mpegurl");
        mimeTypeMap.put("m4a", "audio/mp4a-latm");
        mimeTypeMap.put("m4b", "audio/mp4a-latm");
        mimeTypeMap.put("m4p", "audio/mp4a-latm");
        mimeTypeMap.put("m4u", "video/vnd.mpegurl");
        mimeTypeMap.put("m4v", "video/x-m4v");
        mimeTypeMap.put("mov", "video/quicktime");
        mimeTypeMap.put("mp2", "audio/x-mpeg");
        mimeTypeMap.put("mp3", "audio/mpeg");
        mimeTypeMap.put("mp4", "video/mp4");
        mimeTypeMap.put("mpc", "application/vnd.mpohun.certificate");
        mimeTypeMap.put("mpe", "video/mpeg");
        mimeTypeMap.put("mpeg", "video/mpeg");
        mimeTypeMap.put("mpg", "video/mpeg");
        mimeTypeMap.put("mpg4", "video/mp4");
        mimeTypeMap.put("mpga", "audio/mpeg");
        mimeTypeMap.put(NotificationCompat.CATEGORY_MESSAGE, "application/vnd.ms-outlook");
        mimeTypeMap.put("ogg", "audio/ogg");
        mimeTypeMap.put("pdf", "application/pdf");
        mimeTypeMap.put(ContentTypes.EXTENSION_PNG, ContentTypes.IMAGE_PNG);
        mimeTypeMap.put("pps", "application/vnd.ms-powerpoint");
        mimeTypeMap.put("ppt", "application/vnd.ms-powerpoint");
        mimeTypeMap.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        mimeTypeMap.put("prop", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put("rc", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put("rmvb", "audio/x-pn-realaudio");
        mimeTypeMap.put("rtf", "application/rtf");
        mimeTypeMap.put("sh", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put(ArchiveStreamFactory.TAR, "application/x-tar");
        mimeTypeMap.put("tgz", "application/x-compressed");
        mimeTypeMap.put("txt", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put("wav", "audio/x-wav");
        mimeTypeMap.put("wma", "audio/x-ms-wma");
        mimeTypeMap.put("wmv", "audio/x-ms-wmv");
        mimeTypeMap.put("wps", "application/vnd.ms-works");
        mimeTypeMap.put("xml", AssetHelper.DEFAULT_MIME_TYPE);
        mimeTypeMap.put(CompressorStreamFactory.f6702Z, "application/x-compress");
        mimeTypeMap.put(ArchiveStreamFactory.ZIP, "application/x-zip-compressed");
        mimeTypeMap.put("", "*/*");
    }
}
