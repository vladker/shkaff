package cn.fly.tools;

import cn.fly.commons.ac;
import cn.fly.tools.proguard.PublicMemberKeeper;
import cn.fly.tools.utils.i;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.apache.poi.xddf.usermodel.Angles;

/* JADX INFO: loaded from: classes.dex */
public class MDP implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f1594a = new Object();

    public static Object get(String str, ArrayList<Object> arrayList) {
        return get(str, arrayList, false, 0);
    }

    private static Object a(String str, BlockingQueue blockingQueue) {
        int i5;
        if ("gia".equals(str) || "gal".equals(str) || "gsl".equals(str) || "giafce".equals(str)) {
            i5 = CMAESOptimizer.DEFAULT_MAXITERATIONS;
        } else {
            i5 = "glctn".equals(str) ? Angles.OOXML_DEGREE : 3000;
        }
        return blockingQueue.poll(i5, TimeUnit.MILLISECONDS);
    }

    public static Object get(String str, ArrayList<Object> arrayList, int i5) {
        return get(str, arrayList, false, i5);
    }

    public static Object get(String str, ArrayList<Object> arrayList, boolean z6) {
        return get(str, arrayList, z6, 0);
    }

    public static Object get(final String str, final ArrayList<Object> arrayList, boolean z6, int i5) {
        Object objPoll;
        if (z6) {
            return cn.fly.tools.c.a.a(str, arrayList);
        }
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ac.c.execute(new i() { // from class: cn.fly.tools.MDP.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                Object objA = cn.fly.tools.c.a.a(str, arrayList);
                if (objA == null) {
                    objA = MDP.f1594a;
                }
                linkedBlockingQueue.offer(objA);
            }
        });
        try {
            if (i5 <= 0) {
                objPoll = a(str, linkedBlockingQueue);
            } else {
                objPoll = linkedBlockingQueue.poll(i5, TimeUnit.MILLISECONDS);
            }
            if (objPoll == f1594a) {
                return null;
            }
            return objPoll;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }
}
