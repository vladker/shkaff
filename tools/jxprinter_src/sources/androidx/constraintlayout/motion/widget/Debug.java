package androidx.constraintlayout.motion.widget;

import A3.AbstractC0157z;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.a;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"LogConditional"})
public class Debug {
    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = a.z()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ") " + str + "  ";
        PrintStream printStream = System.out;
        StringBuilder sbY = AbstractC0157z.y(" >>>>>>>>>>>>>>>>>>. dump ", str2, "  ");
        sbY.append(layoutParams.getClass().getName());
        printStream.println(sbY.toString());
        for (Field field : layoutParams.getClass().getFields()) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals(StructuredDataId.RESERVED)) {
                    System.out.println(str2 + "       " + name + " " + obj);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = a.z()[1];
        String str = ".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ")";
        Class<?> cls = obj.getClass();
        PrintStream printStream = System.out;
        StringBuilder sbX = AbstractC0157z.x(str, "------------- ");
        sbX.append(cls.getName());
        sbX.append(" --------------------");
        printStream.println(sbX.toString());
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals(StructuredDataId.RESERVED)) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(str + "    " + field.getName() + " " + obj2);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder sbX2 = AbstractC0157z.x(str, "------------- ");
        sbX2.append(cls.getSimpleName());
        sbX2.append(" --------------------");
        printStream2.println(sbX2.toString());
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i5) {
        StackTraceElement stackTraceElement = a.z()[i5 + 2];
        return ".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = a.z()[1];
        return ".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = a.z()[1];
        return ".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = a.z()[2];
        return ".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i5) {
        return getState(motionLayout, i5, -1);
    }

    public static void logStack(String str, String str2, int i5) {
        StackTraceElement[] stackTraceElementArrZ = a.z();
        int iMin = Math.min(i5, stackTraceElementArrZ.length - 1);
        String strN = " ";
        for (int i6 = 1; i6 <= iMin; i6++) {
            StackTraceElement stackTraceElement = stackTraceElementArrZ[i6];
            String str3 = ".(" + stackTraceElementArrZ[i6].getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElementArrZ[i6].getLineNumber() + ") " + stackTraceElementArrZ[i6].getMethodName();
            strN = a.n(strN, " ");
            Log.v(str, str2 + strN + str3 + strN);
        }
    }

    public static void printStack(String str, int i5) {
        StackTraceElement[] stackTraceElementArrZ = a.z();
        int iMin = Math.min(i5, stackTraceElementArrZ.length - 1);
        String strN = " ";
        for (int i6 = 1; i6 <= iMin; i6++) {
            StackTraceElement stackTraceElement = stackTraceElementArrZ[i6];
            String str2 = ".(" + stackTraceElementArrZ[i6].getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElementArrZ[i6].getLineNumber() + ") ";
            strN = a.n(strN, " ");
            System.out.println(str + strN + str2 + strN);
        }
    }

    public static String getState(MotionLayout motionLayout, int i5, int i6) {
        int length;
        if (i5 == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i5);
        if (i6 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i6) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= i6 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        return resourceEntryName.replaceAll(CharBuffer.allocate((resourceEntryName.length() - i6) / length).toString().replace((char) 0, '.') + "_", "_");
    }

    public static String getName(Context context, int i5) {
        if (i5 != -1) {
            try {
                return context.getResources().getResourceEntryName(i5);
            } catch (Exception unused) {
                return AbstractC0157z.k(i5, "?");
            }
        }
        return "UNKNOWN";
    }

    public static String getName(Context context, int[] iArr) {
        String resourceEntryName;
        try {
            String str = iArr.length + "[";
            int i5 = 0;
            while (i5 < iArr.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i5 == 0 ? "" : " ");
                String string = sb.toString();
                try {
                    resourceEntryName = context.getResources().getResourceEntryName(iArr[i5]);
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = "? " + iArr[i5] + " ";
                }
                str = string + resourceEntryName;
                i5++;
            }
            return str + "]";
        } catch (Exception e) {
            Log.v("DEBUG", e.toString());
            return "UNKNOWN";
        }
    }

    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = a.z()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ParameterizedMessage.ERROR_MSG_SEPARATOR + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            PrintStream printStream = System.out;
            StringBuilder sbX = AbstractC0157z.x(str2, "     ");
            sbX.append(getName(childAt));
            printStream.println(sbX.toString());
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals(StructuredDataId.RESERVED)) {
                        System.out.println(str2 + "       " + field.getName() + " " + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }
}
