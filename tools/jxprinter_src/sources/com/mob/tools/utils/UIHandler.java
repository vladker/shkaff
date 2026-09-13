package com.mob.tools.utils;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
public class UIHandler implements PublicMemberKeeper {
    public static boolean sendEmptyMessage(int i5, Handler.Callback callback) {
        return cn.fly.tools.utils.UIHandler.sendEmptyMessage(i5, callback);
    }

    public static boolean sendEmptyMessageDelayed(int i5, long j6, Handler.Callback callback) {
        return cn.fly.tools.utils.UIHandler.sendEmptyMessageDelayed(i5, j6, callback);
    }

    public static boolean sendMessage(Message message, Handler.Callback callback) {
        return cn.fly.tools.utils.UIHandler.sendMessage(message, callback);
    }

    public static boolean sendMessageDelayed(Message message, long j6, Handler.Callback callback) {
        return cn.fly.tools.utils.UIHandler.sendMessageDelayed(message, j6, callback);
    }
}
