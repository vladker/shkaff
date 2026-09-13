package org.apache.logging.log4j.status;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.ParameterizedNoReferenceMessageFactory;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.util.Constants;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.Strings;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StatusLogger extends AbstractLogger {
    private static final String DEFAULT_STATUS_LEVEL;
    public static final String DEFAULT_STATUS_LISTENER_LEVEL = "log4j2.StatusLogger.level";
    private static final int MAX_ENTRIES;
    public static final String MAX_STATUS_ENTRIES = "log4j2.status.entries";
    private static final String NOT_AVAIL = "?";
    private static final PropertiesUtil PROPS;
    public static final String STATUS_DATE_FORMAT = "log4j2.StatusLogger.DateFormat";
    private static final StatusLogger STATUS_LOGGER;
    private static final long serialVersionUID = 2;
    private final Collection<StatusListener> listeners;
    private int listenersLevel;
    private final ReadWriteLock listenersLock;
    private final SimpleLogger logger;
    private final Queue<StatusData> messages;
    private final Lock msgLock;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BoundedQueue<E> extends ConcurrentLinkedQueue<E> {
        private static final long serialVersionUID = -3945953719763255337L;
        private final int size;

        public BoundedQueue(int i5) {
            this.size = i5;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(E e) {
            int i5;
            super.add(e);
            while (true) {
                int size = StatusLogger.this.messages.size();
                i5 = this.size;
                if (size <= i5) {
                    break;
                }
                StatusLogger.this.messages.poll();
            }
            return i5 > 0;
        }
    }

    static {
        PropertiesUtil propertiesUtil = new PropertiesUtil("log4j2.StatusLogger.properties");
        PROPS = propertiesUtil;
        MAX_ENTRIES = propertiesUtil.getIntegerProperty(MAX_STATUS_ENTRIES, 200);
        DEFAULT_STATUS_LEVEL = propertiesUtil.getStringProperty(DEFAULT_STATUS_LISTENER_LEVEL);
        STATUS_LOGGER = new StatusLogger(StatusLogger.class.getName(), ParameterizedNoReferenceMessageFactory.INSTANCE);
    }

    private StatusLogger(String str, MessageFactory messageFactory) {
        super(str, messageFactory);
        this.listeners = new CopyOnWriteArrayList();
        this.listenersLock = new ReentrantReadWriteLock();
        this.messages = new BoundedQueue(MAX_ENTRIES);
        this.msgLock = new ReentrantLock();
        PropertiesUtil propertiesUtil = PROPS;
        String stringProperty = propertiesUtil.getStringProperty(STATUS_DATE_FORMAT, "");
        this.logger = new SimpleLogger("StatusLogger", isDebugPropertyEnabled() ? Level.TRACE : Level.ERROR, false, true, !Strings.isEmpty(stringProperty), false, stringProperty, messageFactory, propertiesUtil, System.err);
        this.listenersLevel = Level.toLevel(DEFAULT_STATUS_LEVEL, Level.WARN).intLevel();
    }

    private static void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static StatusLogger getLogger() {
        return STATUS_LOGGER;
    }

    private StackTraceElement getStackTraceElement(String str, StackTraceElement[] stackTraceElementArr) {
        if (str == null) {
            return null;
        }
        boolean z6 = false;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (z6 && !str.equals(className)) {
                return stackTraceElement;
            }
            if (!str.equals(className)) {
                if (NOT_AVAIL.equals(className)) {
                    break;
                }
            } else {
                z6 = true;
            }
        }
        return null;
    }

    private boolean isDebugPropertyEnabled() {
        return PropertiesUtil.getProperties().getBooleanProperty(Constants.LOG4J2_DEBUG, false, true);
    }

    public void clear() {
        this.msgLock.lock();
        try {
            this.messages.clear();
        } finally {
            this.msgLock.unlock();
        }
    }

    @Override // org.apache.logging.log4j.Logger
    public Level getLevel() {
        return this.logger.getLevel();
    }

    public Iterable<StatusListener> getListeners() {
        return this.listeners;
    }

    public List<StatusData> getStatusData() {
        this.msgLock.lock();
        try {
            return new ArrayList(this.messages);
        } finally {
            this.msgLock.unlock();
        }
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public void logMessage(String str, Level level, Marker marker, Message message, Throwable th) {
        StatusData statusData = new StatusData(str != null ? getStackTraceElement(str, Thread.currentThread().getStackTrace()) : null, level, message, th, null);
        this.msgLock.lock();
        try {
            this.messages.add(statusData);
            this.msgLock.unlock();
            if (isDebugPropertyEnabled() || this.listeners.size() <= 0) {
                this.logger.logMessage(str, level, marker, message, th);
                return;
            }
            for (StatusListener statusListener : this.listeners) {
                if (statusData.getLevel().isMoreSpecificThan(statusListener.getStatusLevel())) {
                    statusListener.log(statusData);
                }
            }
        } catch (Throwable th2) {
            this.msgLock.unlock();
            throw th2;
        }
    }

    public void registerListener(StatusListener statusListener) {
        this.listenersLock.writeLock().lock();
        try {
            this.listeners.add(statusListener);
            Level statusLevel = statusListener.getStatusLevel();
            if (this.listenersLevel < statusLevel.intLevel()) {
                this.listenersLevel = statusLevel.intLevel();
            }
        } finally {
            this.listenersLock.writeLock().unlock();
        }
    }

    public void removeListener(StatusListener statusListener) {
        closeSilently(statusListener);
        this.listenersLock.writeLock().lock();
        try {
            this.listeners.remove(statusListener);
            int iIntLevel = Level.toLevel(DEFAULT_STATUS_LEVEL, Level.WARN).intLevel();
            Iterator<StatusListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                int iIntLevel2 = it.next().getStatusLevel().intLevel();
                if (iIntLevel < iIntLevel2) {
                    iIntLevel = iIntLevel2;
                }
            }
            this.listenersLevel = iIntLevel;
        } finally {
            this.listenersLock.writeLock().unlock();
        }
    }

    public void reset() {
        this.listenersLock.writeLock().lock();
        try {
            Iterator<StatusListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                closeSilently(it.next());
            }
            this.listeners.clear();
            this.listenersLock.writeLock().unlock();
            clear();
        } catch (Throwable th) {
            this.listeners.clear();
            this.listenersLock.writeLock().unlock();
            clear();
            throw th;
        }
    }

    public void setLevel(Level level) {
        this.logger.setLevel(level);
    }

    public void updateListenerLevel(Level level) {
        if (level.intLevel() > this.listenersLevel) {
            this.listenersLevel = level.intLevel();
        }
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object... objArr) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, CharSequence charSequence, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Object obj, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.ExtendedLogger
    public boolean isEnabled(Level level, Marker marker, Message message, Throwable th) {
        return isEnabled(level, marker);
    }

    @Override // org.apache.logging.log4j.spi.AbstractLogger, org.apache.logging.log4j.Logger
    public boolean isEnabled(Level level, Marker marker) {
        if (isDebugPropertyEnabled()) {
            return true;
        }
        if (this.listeners.size() > 0) {
            return this.listenersLevel >= level.intLevel();
        }
        return this.logger.isEnabled(level, marker);
    }
}
