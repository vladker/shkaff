package com.zlylib.fileselectorlib;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class SelectOptions {
    public static final String defaultTargetPath = Environment.getExternalStorageDirectory() + PackagingURIHelper.FORWARD_SLASH_STRING;
    public String[] mFileTypes;
    public String mSortType;
    public int request_code;
    public boolean isSingle = false;
    public int maxCount = 10;
    private boolean onlyShowFolder = false;
    private boolean onlySelectFolder = false;
    public String targetPath = defaultTargetPath;
    private int titleBg = 0;
    private int titleColor = 0;
    private int titleLiftColor = 0;
    private int titleRightColor = 0;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class InstanceHolder {
        private static final SelectOptions INSTANCE = new SelectOptions();

        private InstanceHolder() {
        }
    }

    public static SelectOptions getCleanInstance() {
        SelectOptions selectOptions = getInstance();
        selectOptions.reset();
        return selectOptions;
    }

    public static SelectOptions getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void reset() {
        this.mFileTypes = new String[0];
        this.mSortType = String.valueOf(0);
        this.isSingle = false;
        this.maxCount = 10;
        this.onlyShowFolder = false;
        this.onlySelectFolder = false;
        this.targetPath = defaultTargetPath;
        this.titleBg = 0;
        this.titleColor = 0;
        this.titleLiftColor = 0;
        this.titleRightColor = 0;
    }

    public String[] getFileTypes() {
        String[] strArr = this.mFileTypes;
        return (strArr == null || strArr.length == 0) ? new String[0] : strArr;
    }

    public int getSortType() {
        if (TextUtils.isEmpty(this.mSortType)) {
            return 0;
        }
        return Integer.valueOf(this.mSortType).intValue();
    }

    public String getTargetPath() {
        if (new File(this.targetPath).exists()) {
            return this.targetPath;
        }
        String str = defaultTargetPath;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public int getTitleBg() {
        return this.titleBg;
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public int getTitleLiftColor() {
        return this.titleLiftColor;
    }

    public int getTitleRightColor() {
        return this.titleRightColor;
    }

    public boolean isOnlySelectFolder() {
        return this.onlySelectFolder;
    }

    public boolean isOnlyShowFolder() {
        return this.onlyShowFolder;
    }

    public void setOnlySelectFolder(boolean z6) {
        this.onlySelectFolder = z6;
    }

    public void setOnlyShowFolder(boolean z6) {
        this.onlyShowFolder = z6;
    }

    public void setSortType(int i5) {
        this.mSortType = String.valueOf(i5);
    }

    public void setTitleBg(int i5) {
        this.titleBg = i5;
    }

    public void setTitleColor(int i5) {
        this.titleColor = i5;
    }

    public void setTitleLiftColor(int i5) {
        this.titleLiftColor = i5;
    }

    public void setTitleRightColor(int i5) {
        this.titleRightColor = i5;
    }
}
