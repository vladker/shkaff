package cn.fly.commons;

import com.mob.commons.MOBLINK;
import com.mob.commons.MOBPUSH;
import com.mob.commons.SECVERIFY;
import com.mob.commons.SHARESDK;
import com.mob.commons.SMSSDK;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Object> f1470a;

    static {
        LinkedList linkedList = new LinkedList();
        f1470a = linkedList;
        try {
            linkedList.add(SHARESDK.class);
        } catch (Throwable unused) {
        }
        try {
            f1470a.add(SMSSDK.class);
        } catch (Throwable unused2) {
        }
        try {
            f1470a.add(MOBLINK.class);
        } catch (Throwable unused3) {
        }
        try {
            f1470a.add(MOBPUSH.class);
        } catch (Throwable unused4) {
        }
        try {
            f1470a.add(SECVERIFY.class);
        } catch (Throwable unused5) {
        }
        try {
            f1470a.add(FLYVERIFY.class);
        } catch (Throwable unused6) {
        }
    }
}
