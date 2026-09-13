package com.mob.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.fly.tools.utils.UIHandler;
import com.mob.tools.proguard.EverythingKeeper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class RxMob implements EverythingKeeper {

    public interface OnSubscribe<T> extends EverythingKeeper {
        void call(Subscriber<T> subscriber);
    }

    public static abstract class QuickSubscribe<T> implements OnSubscribe<T> {
        @Override // com.mob.tools.RxMob.OnSubscribe
        public final void call(Subscriber<T> subscriber) {
            subscriber.onStart();
            try {
                doNext(subscriber);
                subscriber.onCompleted();
            } catch (Throwable th) {
                subscriber.onError(th);
            }
        }

        public abstract void doNext(Subscriber<T> subscriber);
    }

    public static final class Subscribable<T> implements EverythingKeeper {
        private Thread observeThread;
        private OnSubscribe<T> onSubscribe;
        private Thread subscribeThread;

        public Subscribable<T> observeOn(Thread thread) {
            this.observeThread = thread;
            return this;
        }

        public void subscribe(final Subscriber<T> subscriber) {
            OnSubscribe<T> onSubscribe = this.onSubscribe;
            if (onSubscribe != null) {
                Thread thread = this.subscribeThread;
                if (thread == Thread.UI_THREAD) {
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.RxMob.Subscribable.1
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            Subscribable.this.onSubscribe.call(new SubscriberWarpper(Subscribable.this, subscriber));
                            return false;
                        }
                    });
                } else if (thread == Thread.NEW_THREAD) {
                    new java.lang.Thread() { // from class: com.mob.tools.RxMob.Subscribable.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            Subscribable.this.onSubscribe.call(new SubscriberWarpper(Subscribable.this, subscriber));
                        }
                    }.start();
                } else {
                    onSubscribe.call(new SubscriberWarpper(this, subscriber));
                }
            }
        }

        public Subscribable<T> subscribeOn(Thread thread) {
            this.subscribeThread = thread;
            return this;
        }

        public void subscribeOnNewThreadAndObserveOnUIThread(Subscriber<T> subscriber) {
            subscribeOn(Thread.NEW_THREAD);
            observeOn(Thread.UI_THREAD);
            subscribe(subscriber);
        }

        private Subscribable() {
        }
    }

    public static final class SubscriberWarpper<T> extends Subscriber<T> {
        private Subscribable<T> subscribable;
        private Subscriber<T> subscriber;

        public SubscriberWarpper(Subscribable<T> subscribable, Subscriber<T> subscriber) {
            this.subscribable = subscribable;
            this.subscriber = subscriber;
            subscriber.setWarpper(this);
        }

        @Override // com.mob.tools.RxMob.Subscriber
        public void onCompleted() {
            if (this.subscriber != null) {
                if (((Subscribable) this.subscribable).observeThread != Thread.UI_THREAD) {
                    if (((Subscribable) this.subscribable).observeThread == Thread.NEW_THREAD) {
                        new java.lang.Thread() { // from class: com.mob.tools.RxMob.SubscriberWarpper.6
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                if (SubscriberWarpper.this.subscriber == null) {
                                    MobLog.getInstance().crash(new Throwable("[NewThread/onComplete] Network request interrupted as Subscriber is null"));
                                } else {
                                    SubscriberWarpper.this.subscriber.onCompleted();
                                    SubscriberWarpper.this.removeSubscriber();
                                }
                            }
                        }.start();
                        return;
                    } else {
                        this.subscriber.onCompleted();
                        removeSubscriber();
                        return;
                    }
                }
                if (java.lang.Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onCompleted();
                    removeSubscriber();
                } else {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 0;
                    messageObtain.obj = this.subscriber;
                    UIHandler.sendMessage(messageObtain, new Handler.Callback() { // from class: com.mob.tools.RxMob.SubscriberWarpper.5
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            if (message == null) {
                                return false;
                            }
                            try {
                                Subscriber subscriber = (Subscriber) message.obj;
                                if (subscriber != null) {
                                    subscriber.onCompleted();
                                    SubscriberWarpper.this.removeSubscriber();
                                } else {
                                    MobLog.getInstance().crash(new Throwable("[UIThread/onComplete] Network request interrupted as Subscriber is null"));
                                }
                                return false;
                            } catch (Throwable th) {
                                MobLog.getInstance().crash(th);
                                return false;
                            }
                        }
                    });
                }
            }
        }

        @Override // com.mob.tools.RxMob.Subscriber
        public void onError(final Throwable th) {
            if (this.subscriber != null) {
                if (((Subscribable) this.subscribable).observeThread != Thread.UI_THREAD) {
                    if (((Subscribable) this.subscribable).observeThread == Thread.NEW_THREAD) {
                        new java.lang.Thread() { // from class: com.mob.tools.RxMob.SubscriberWarpper.8
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                if (SubscriberWarpper.this.subscriber == null) {
                                    MobLog.getInstance().crash(new Throwable("[NewThread/onError] Network request interrupted as Subscriber is null"));
                                } else {
                                    SubscriberWarpper.this.subscriber.onError(th);
                                    SubscriberWarpper.this.removeSubscriber();
                                }
                            }
                        }.start();
                        return;
                    } else {
                        this.subscriber.onError(th);
                        removeSubscriber();
                        return;
                    }
                }
                if (java.lang.Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onError(th);
                    removeSubscriber();
                } else {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 0;
                    messageObtain.obj = this.subscriber;
                    UIHandler.sendMessage(messageObtain, new Handler.Callback() { // from class: com.mob.tools.RxMob.SubscriberWarpper.7
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            if (message == null) {
                                return false;
                            }
                            try {
                                Subscriber subscriber = (Subscriber) message.obj;
                                if (subscriber != null) {
                                    subscriber.onError(th);
                                    SubscriberWarpper.this.removeSubscriber();
                                } else {
                                    MobLog.getInstance().crash(new Throwable("[UIThread/onError] Network request interrupted as Subscriber is null"));
                                }
                                return false;
                            } catch (Throwable th2) {
                                MobLog.getInstance().crash(th2);
                                return false;
                            }
                        }
                    });
                }
            }
        }

        @Override // com.mob.tools.RxMob.Subscriber
        public void onNext(final T t6) {
            if (this.subscriber != null) {
                if (((Subscribable) this.subscribable).observeThread != Thread.UI_THREAD) {
                    if (((Subscribable) this.subscribable).observeThread == Thread.NEW_THREAD) {
                        new java.lang.Thread() { // from class: com.mob.tools.RxMob.SubscriberWarpper.4
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                if (SubscriberWarpper.this.subscriber != null) {
                                    SubscriberWarpper.this.subscriber.onNext(t6);
                                } else {
                                    MobLog.getInstance().crash(new Throwable("[NewThread/onNext] Network request interrupted as Subscriber is null"));
                                }
                            }
                        }.start();
                        return;
                    } else {
                        this.subscriber.onNext(t6);
                        return;
                    }
                }
                if (java.lang.Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onNext(t6);
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 0;
                messageObtain.obj = this.subscriber;
                UIHandler.sendMessage(messageObtain, new Handler.Callback() { // from class: com.mob.tools.RxMob.SubscriberWarpper.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        if (message == null) {
                            return false;
                        }
                        try {
                            Subscriber subscriber = (Subscriber) message.obj;
                            if (subscriber != 0) {
                                subscriber.onNext(t6);
                            } else {
                                MobLog.getInstance().crash(new Throwable("[UIThread/onNext] Network request interrupted as Subscriber is null"));
                            }
                            return false;
                        } catch (Throwable th) {
                            MobLog.getInstance().crash(th);
                            return false;
                        }
                    }
                });
            }
        }

        @Override // com.mob.tools.RxMob.Subscriber
        public void onStart() {
            if (this.subscriber != null) {
                if (((Subscribable) this.subscribable).observeThread != Thread.UI_THREAD) {
                    if (((Subscribable) this.subscribable).observeThread == Thread.NEW_THREAD) {
                        new java.lang.Thread() { // from class: com.mob.tools.RxMob.SubscriberWarpper.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                if (SubscriberWarpper.this.subscriber != null) {
                                    SubscriberWarpper.this.subscriber.onStart();
                                } else {
                                    MobLog.getInstance().crash(new Throwable("[NewThread/onStart] Network request interrupted as Subscriber is null"));
                                }
                            }
                        }.start();
                        return;
                    } else {
                        this.subscriber.onStart();
                        return;
                    }
                }
                if (java.lang.Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
                    this.subscriber.onStart();
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 0;
                messageObtain.obj = this.subscriber;
                UIHandler.sendMessage(messageObtain, new Handler.Callback() { // from class: com.mob.tools.RxMob.SubscriberWarpper.1
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        if (message == null) {
                            return false;
                        }
                        try {
                            Subscriber subscriber = (Subscriber) message.obj;
                            if (subscriber != null) {
                                subscriber.onStart();
                            } else {
                                MobLog.getInstance().crash(new Throwable("[UIThread/onStart] Network request interrupted as Subscriber is null"));
                            }
                            return false;
                        } catch (Throwable th) {
                            MobLog.getInstance().crash(th);
                            return false;
                        }
                    }
                });
            }
        }

        public void removeSubscriber() {
            this.subscriber = null;
        }
    }

    public enum Thread implements EverythingKeeper {
        IMMEDIATE,
        UI_THREAD,
        NEW_THREAD
    }

    public static <T> Subscribable<T> create(OnSubscribe<T> onSubscribe) {
        Subscribable<T> subscribable = new Subscribable<>();
        ((Subscribable) subscribable).onSubscribe = onSubscribe;
        return subscribable;
    }

    public static <T> Subscribable<T> from(final Iterator<T> it) {
        return create(new QuickSubscribe<T>() { // from class: com.mob.tools.RxMob.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.mob.tools.RxMob.QuickSubscribe
            public void doNext(Subscriber<T> subscriber) {
                while (it.hasNext()) {
                    subscriber.onNext(it.next());
                }
            }
        });
    }

    public static <T> Subscribable<T> just(final T... tArr) {
        return create(new QuickSubscribe<T>() { // from class: com.mob.tools.RxMob.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.mob.tools.RxMob.QuickSubscribe
            public void doNext(Subscriber<T> subscriber) {
                for (Object obj : tArr) {
                    subscriber.onNext(obj);
                }
            }
        });
    }

    public static class Subscriber<T> implements EverythingKeeper {
        private SubscriberWarpper<T> warpper;

        /* JADX INFO: Access modifiers changed from: private */
        public void setWarpper(SubscriberWarpper<T> subscriberWarpper) {
            this.warpper = subscriberWarpper;
        }

        public final void unsubscribe() {
            SubscriberWarpper<T> subscriberWarpper = this.warpper;
            if (subscriberWarpper != null) {
                subscriberWarpper.removeSubscriber();
                this.warpper = null;
            }
        }

        public void onCompleted() {
        }

        public void onStart() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(T t6) {
        }
    }
}
