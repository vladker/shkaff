package com.zlylib.fileselectorlib;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FileSelector {
    public static final int BY_EXTENSION_ASC = 6;
    public static final int BY_NAME_ASC = 0;
    public static final int BY_NAME_DESC = 1;
    public static final int BY_SIZE_ASC = 4;
    public static final int BY_SIZE_DESC = 5;
    public static final int BY_TIME_ASC = 2;
    public static final int BY_TIME_DESC = 3;
    private final WeakReference<Context> mContext;
    private final WeakReference<Fragment> mFragment;

    private FileSelector(Activity activity) {
        this(activity, null);
    }

    public static SelectCreator from(Activity activity) {
        return new FileSelector(activity).initFile();
    }

    private SelectCreator initFile() {
        return new SelectCreator(this);
    }

    public Context getActivity() {
        return this.mContext.get();
    }

    public Fragment getFragment() {
        WeakReference<Fragment> weakReference = this.mFragment;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private FileSelector(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public static SelectCreator from(Fragment fragment) {
        return new FileSelector(fragment).initFile();
    }

    private FileSelector(Context context, Fragment fragment) {
        this.mContext = new WeakReference<>(context);
        this.mFragment = new WeakReference<>(fragment);
    }
}
