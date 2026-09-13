package com.zlylib.fileselectorlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.zlylib.fileselectorlib.ui.FileSelectorActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class SelectCreator {
    private FileSelector filePicker;
    private SelectOptions selectOptions = SelectOptions.getCleanInstance();

    public SelectCreator(FileSelector fileSelector) {
        this.filePicker = fileSelector;
    }

    public SelectCreator isSingle() {
        SelectOptions selectOptions = this.selectOptions;
        selectOptions.isSingle = true;
        selectOptions.maxCount = 1;
        return this;
    }

    public SelectCreator onlySelectFolder() {
        this.selectOptions.setOnlySelectFolder(true);
        return this;
    }

    public SelectCreator onlyShowFolder() {
        this.selectOptions.setOnlyShowFolder(true);
        this.selectOptions.setOnlySelectFolder(true);
        return this;
    }

    public SelectCreator requestCode(int i5) {
        this.selectOptions.request_code = i5;
        return this;
    }

    public SelectCreator setFileTypes(String... strArr) {
        this.selectOptions.mFileTypes = strArr;
        return this;
    }

    public SelectCreator setMaxCount(int i5) {
        SelectOptions selectOptions = this.selectOptions;
        selectOptions.maxCount = i5;
        if (i5 > 1) {
            selectOptions.isSingle = false;
            return this;
        }
        selectOptions.maxCount = 1;
        selectOptions.isSingle = true;
        return this;
    }

    public SelectCreator setSortType(int i5) {
        this.selectOptions.setSortType(i5);
        return this;
    }

    public SelectCreator setTargetPath(String str) {
        this.selectOptions.targetPath = str;
        return this;
    }

    public SelectCreator setTilteBg(int i5) {
        this.selectOptions.setTitleBg(i5);
        return this;
    }

    public SelectCreator setTitleColor(int i5) {
        this.selectOptions.setTitleColor(i5);
        return this;
    }

    public SelectCreator setTitleLiftColor(int i5) {
        this.selectOptions.setTitleLiftColor(i5);
        return this;
    }

    public SelectCreator setTitleRightColor(int i5) {
        this.selectOptions.setTitleRightColor(i5);
        return this;
    }

    public void start() {
        Context activity = this.filePicker.getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, FileSelectorActivity.class);
        Fragment fragment = this.filePicker.getFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, this.selectOptions.request_code);
        } else {
            ((Activity) activity).startActivityForResult(intent, this.selectOptions.request_code);
        }
    }
}
