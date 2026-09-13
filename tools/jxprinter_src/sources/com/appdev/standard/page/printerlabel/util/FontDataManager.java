package com.appdev.standard.page.printerlabel.util;

import android.content.Context;
import com.appdev.standard.model.TextFontModel;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FontDataManager implements J.a {
    private static FontDataManager instance;
    private static Context mContext;
    private Map<String, com.appdev.standard.util.fileDownload.h> downloadCenterListenerHashMap = new HashMap();
    private String fontFilePath = mContext.getCacheDir().getAbsolutePath() + "/fontData/%s.ttf";
    private List<TextFontModel> textFontModels;
    private J.b textFontWorker;

    private FontDataManager() {
        J.b bVar = new J.b(mContext);
        this.textFontWorker = bVar;
        bVar.b = this;
        List<TextFontModel> list = (List) Hawk.get("FONT_LIB_DATA", null);
        this.textFontModels = list;
        if (list == null) {
            this.textFontWorker.a();
        }
    }

    public static FontDataManager getInstance() {
        if (instance == null) {
            synchronized (FontDataManager.class) {
                try {
                    if (instance == null) {
                        instance = new FontDataManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static void init(Context context) {
        mContext = context;
    }

    @Override // J.a
    public void getAppFontLibSuccess(List<TextFontModel> list) {
        this.textFontModels = list;
    }

    public void getFontLocalFile(String str, String str2, com.appdev.standard.util.fileDownload.h hVar) {
        final TextFontModel next;
        File file = new File(String.format(this.fontFilePath, str));
        if (file.exists()) {
            if (hVar != null) {
                hVar.onExists();
                return;
            }
            return;
        }
        List<TextFontModel> list = this.textFontModels;
        if (list == null) {
            if (hVar != null) {
                hVar.onError("", new Exception("字体库数据不存在"));
                return;
            }
            return;
        }
        Iterator<TextFontModel> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!next.getFontlibId().equals(String.valueOf(str)));
        if (next == null) {
            if (hVar != null) {
                hVar.onError("", new Exception("找不到字体数据"));
                return;
            }
            return;
        }
        this.downloadCenterListenerHashMap.put(str + "_" + str2 + "_" + next.getFileUrl(), hVar);
        com.appdev.standard.util.fileDownload.g.b().b.add(new com.appdev.standard.util.fileDownload.h() { // from class: com.appdev.standard.page.printerlabel.util.FontDataManager.1
            @Override // com.appdev.standard.util.fileDownload.h
            public void onError(String str3, Throwable th) {
                for (String str4 : FontDataManager.this.downloadCenterListenerHashMap.keySet()) {
                    if (str4.contains(next.getFileUrl())) {
                        ((com.appdev.standard.util.fileDownload.h) FontDataManager.this.downloadCenterListenerHashMap.get(str4)).onError(str3, th);
                    }
                }
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onSuccess(String str3) {
                for (String str4 : FontDataManager.this.downloadCenterListenerHashMap.keySet()) {
                    if (str4.contains(next.getFileUrl())) {
                        ((com.appdev.standard.util.fileDownload.h) FontDataManager.this.downloadCenterListenerHashMap.get(str4)).onSuccess(str3);
                    }
                }
            }
        });
        hVar.onStartShowLoading();
        com.appdev.standard.util.fileDownload.g.b().a(file, next.getFileUrl());
    }

    public File getFontLocalFile(String str) {
        return new File(String.format(this.fontFilePath, str));
    }

    @Override // J.a
    public void getAppFontLibFailed(int i5, String str) {
    }
}
