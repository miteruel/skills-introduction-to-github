package com.google.mlkit.showcase.vidastraduki.java;

//import android.app.IntentService;
import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.util.LruCache;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

/*
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProviders;

import com.google.mlkit.nl.translate.TranslateLanguage;



/**
 * An {@link Service} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class VidasTradukiService extends Service {

    // TODO: Rename actions, choose action names that describe tasks that this
    // Service can perform, e.g. ACTION_FETCH_NEW_ITEMS
    //private static final String ACTION_FOO = "com.google.mlkit.showcase.vidastraduki.action.FOO";
    //private static final String ACTION_BAZ = "com.google.mlkit.showcase.vidastraduki.action.BAZ";

    // TODO: Rename parameters
    //private static final String EXTRA_PARAM1 = "com.google.mlkit.showcase.vidastraduki.extra.PARAM1";
    //private static final String EXTRA_PARAM2 = "com.google.mlkit.showcase.vidastraduki.extra.PARAM2";

    //private final static String TAG_ = "MyForegroundService";


    public String finalresulta="";
    //public static final int MSG_SAY_HELLO_ = 1;
    public static final int MSG_SAY_HELLO_DELPHI = 123;
    static final int MSG_RESPONSE_HELLO_DELPHI = 321;

    //static final int MSG_SET_INT_VALUE_ = 3;
    //static final int MSG_SET_STRING_VALUE_ = 4;



    public VidasTradukiService() {
     //   super("VidasTradukiService");
    }
    private final static String TAG = "MyForegroundService";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService

    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, VidasTradukiService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }
 */

    private Looper mServiceLooper;
    private VidasTradukiService.ServiceHandler mServiceHandler;
    // private final static String TAG = "MyForegroundService";

    //Random r_;

    private static final int NUM_TRANSLATORS_ = 3;

    private final LruCache<TranslatorOptions, Translator> translators =
            new LruCache<TranslatorOptions, Translator>(NUM_TRANSLATORS_) {
                @Override
                public Translator create(TranslatorOptions options) {
                    return Translation.getClient(options);
                }

                @Override
                public void entryRemoved(
                        boolean evicted, TranslatorOptions key, Translator oldValue, Translator newValue) {
                    oldValue.close();
                }
            };

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService

    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, VidasTradukiService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }
 */


    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.

    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }
 */
    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.

    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
*/


    public Task<String> translate(String que,String so, String tar) {
        final String text = que;//sourceText.getValue();
        //final TranslateViewModel.Language source ="es";// sourceLang.getValue();
        //final TranslateViewModel.Language target = "eo"; //targetLang.getValue();

        if (text == null || text.isEmpty()) {
            return Tasks.forResult("");
        }
        if (so=="") so="es";
        if (tar=="") tar="eo";

        String sourceLangCode =so; //"es";// TranslateLanguage.fromLanguageTag(source.getCode());
        String targetLangCode =tar; // "eo"; //TranslateLanguage.fromLanguageTag(target.getCode());
        TranslatorOptions options =
                new TranslatorOptions.Builder()
                        .setSourceLanguage(sourceLangCode)
                        .setTargetLanguage(targetLangCode)
                        .build();
        Translator tra= translators.get(options);
        return tra
                .downloadModelIfNeeded()
                .continueWithTask(
                        new Continuation<Void, Task<String>>() {
                            @Override
                            public Task<String> then(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    Task<String> te= translators.get(options).translate(text);
                                    return te;
                                } else {
                                    Exception e = task.getException();

                                    return Tasks.forException(e);

                                }

                            }
                        });
    }



    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            //promote to foreground and create persistent notification.
            //in Oreo we only have a few seconds to do this or the service is killed.
            //Notification notification_ = getNotification("MyService is running");
            //???  startForeground(msg.arg1, notification);  //the ID as same as the notification id.  can't be zero.

            Log.d(TAG, "should be foreground now. id number is " + msg.arg1);
            // Normally we would do some work here, like download a file.
            // For our example, we just sleep for 5 seconds then display toasts.

            int times = 1, i;

            Bundle extras = msg.getData();
            if (extras != null) {
                times = extras.getInt("times", 1);  //default is one
            }
            //loop that many times, sleeping for 2 seconds.
            for (i = 0; i < times; i++) {
                synchronized (this) {
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        Log.e(TAG, e.toString());
                    }
                }
                //String info = i + " saluton " ;


                //Toast.makeText(VidasTradukiService.this, info, Toast.LENGTH_SHORT).show();
                //toast(info);
            }
            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            //¿   stopSelf(msg.arg1);  //notification will go away as well.
        }
    }

    final Handler mHandler = new Handler();

    // Helper for showing tests
    void toast(final CharSequence text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(VidasTradukiService.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreate() {
        //r_ = new Random();
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.  We also make it
        // background priority so CPU-intensive work will not disrupt our UI.

        HandlerThread thread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);


    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "servo komencas", Toast.LENGTH_SHORT).show();

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;//needed for stop.

        if (intent != null) {
            msg.setData(intent.getExtras());
            mServiceHandler.sendMessage(msg);
        } else {
            Toast.makeText(VidasTradukiService.this, "The Intent to start is null?!", Toast.LENGTH_SHORT).show();
        }

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }




    private void responseMessageToUI(Messenger msgs, int msgid, String res) {
        try {

            //   msgs.send(Message.obtain(null, MSG_SET_INT_VALUE, invaluetosend, 0));

            //Send data as a String
            Bundle b = new Bundle();
            b.putString("str1", res);
            Message msg = Message.obtain(null, msgid);
            msg.setData(b);
            ///  Toast.makeText(getApplicationContext(), "-!"+res, Toast.LENGTH_SHORT).show();

            msgs.send(msg);

        }
        catch (RemoteException e) {
            // The client is dead. Remove it from the list; we are going through the list
            // from back to front so this is safe to do inside the loop.
            //   mClients.remove(i);
        }

    }




    final OnCompleteListener<String> processTranslation =
            new OnCompleteListener<String>() {
                @Override
                public void onComplete(@NonNull Task<String> task) {
                    if (task.isSuccessful()) {
                        finalresulta=task.getResult();
                    } else {
                        finalresulta="";
                    }

                }
            };




    Handler incomingHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Log.v("MsgService", "Message received");
            if (msg.what == MSG_SAY_HELLO_DELPHI){
                Bundle extras = msg.getData();
                String t="";
                String lang="";
                String tolang="";

                if (extras != null) {
                    t = extras.getString("texto", "");  //default is one
                    lang = extras.getString("lang", "");  //default is one
                    tolang = extras.getString("tolang", "");  //default is one
                }
                responseMessageToUI(msg.replyTo,MSG_RESPONSE_HELLO_DELPHI,"ok");

                Task<String>  tt=translate(t,lang,tolang);
                tt.addOnCompleteListener(processTranslation);
                // Toast.makeText(getApplicationContext(), lang+"-"+t+"-"+tolang, Toast.LENGTH_SHORT).show();


            }
            if (msg.what == MSG_RESPONSE_HELLO_DELPHI){
                Bundle extras = msg.getData();
                String t="";
                if (extras != null) {
                    t = extras.getString("texto", "");  //default is one
                }
                responseMessageToUI(msg.replyTo,MSG_SAY_HELLO_DELPHI,finalresulta);

            }


           // if (msg.what == MSG_SAY_HELLO)
           //     Toast.makeText(getApplicationContext(), "hello!", Toast.LENGTH_SHORT).show();
            return true;
        }
    });



    final Messenger mMessenger = new Messenger(incomingHandler);


    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();

    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
    }



    // build a persistent notification and return it.
    public Notification getNotification(String message) {
        return null;
                /*
        return new NotificationCompat.Builder(getApplicationContext(), MainActivity.id1)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)  //persistent notification!
                .setChannelId(MainActivity.id1)
                .setContentTitle("Service")   //Title message top row.
                .setContentText(message)  //message when looking at the notification, second row
                .build();  //finally build and return a Notification.*/
    }
}