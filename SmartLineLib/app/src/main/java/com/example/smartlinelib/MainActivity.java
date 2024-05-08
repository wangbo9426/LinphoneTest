package com.example.smartlinelib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartlineaar.SLManager;

import org.linphone.core.*;



public class MainActivity extends AppCompatActivity {

    private SLManager sl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sl=new SLManager();
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sl.init(getApplicationContext());
                Toast.makeText(getApplicationContext(),"初始化完毕",Toast.LENGTH_SHORT).show();
            }
        });


    }

//    public void login(String username,String password,String domain)
//    {
//
//        TransportType transportType =TransportType.Udp;;
//        AuthInfo authInfo = Factory.instance().createAuthInfo(username, null, password, null, null, domain, null);
//
//        AccountParams params = core.createAccountParams();
//        Address identity = (Address) Factory.instance().createAddress("sip:" + username + "@" + domain);
//        params.setIdentityAddress(identity);
//
//        Address serverAddress = Factory.instance().createAddress("sip:" + domain);
//        if (serverAddress != null) {
//            serverAddress.setTransport(transportType);
//            params.setServerAddress(serverAddress);
//        }
//        params.setRegisterEnabled(true);
//        Account account = core.createAccount(params);
//
//        core.addAuthInfo(authInfo);
//        core.addAccount(account);
//
//        core.setDefaultAccount(account);
//        core.addListener(coreListener);
//        core.start();
//        Toast.makeText(getApplicationContext(),"登录完毕",Toast.LENGTH_SHORT).show();
////        // We will need the RECORD_AUDIO permission for video call
////        if (ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
////            requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
////            return;
////        }
//    }

//    private CoreListener coreListener = new CoreListenerStub() {
//        @Override
//        public void onAccountRegistrationStateChanged(Core core, Account account, RegistrationState state, String message)
//        {
//            //findViewById(R.id.registration_status).setText(message);
//
//            if (state == RegistrationState.Failed) {
//                // findViewById(R.id.connect).setEnabled(true);
//            } else if (state == RegistrationState.Ok) {
//                //  findViewById(R.id.register_layout).setVisibility(View.GONE);
//                //  findViewById(R.id.call_layout).setVisibility(View.VISIBLE);
//            }
//        }
//
//        @Override
//        public void onAudioDeviceChanged(Core core, AudioDevice audioDevice) {
//            // This callback will be triggered when a successful audio device has been changed
//        }
//
//        @Override
//        public void onAudioDevicesListUpdated(Core core) {
//            // This callback will be triggered when the available devices list has changed,
//            // for example after a bluetooth headset has been connected/disconnected.
//        }
//
//        @Override
//        public void onCallStateChanged(Core core, Call call, Call.State state, String message) {
//            //findViewById(R.id.call_status).setText(message);
//
//            // When a call is received
//            switch (state) {
//                case IncomingReceived:
//                    //findViewById(R.id.hang_up).setEnabled(true);
//                    //findViewById(R.id.answer).setEnabled(true);
//                    //findViewById(R.id.remote_address).setText(call.getRemoteAddress().asStringUriOnly());
//                    break;
//                case Connected:
//                    //findViewById(R.id.mute_mic).setEnabled(true);
//                    // findViewById(R.id.toggle_speaker).setEnabled(true);
//                    break;
//                case Released:
//                    //  findViewById(R.id.hang_up).setEnabled(false);
//                    //  findViewById(R.id.answer).setEnabled(false);
//                    //  findViewById(R.id.mute_mic).setEnabled(false);
//                    //  findViewById(R.id.toggle_speaker).setEnabled(false);
//                    //  findViewById(R.id.remote_address).setText("");
//                    break;
//            }
//        }
//    };


}