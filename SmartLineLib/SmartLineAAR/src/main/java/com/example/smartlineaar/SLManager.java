package com.example.smartlineaar;



import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import org.linphone.core.*;


public class SLManager
{
//    private Activity _unityActivity;
//    /**
//     * 获取unity项目的上下文
//     * @return
//     */
//    Activity getActivity(){
//        if(null == _unityActivity) {
//            try {
//                Class<?> classtype = Class.forName("com.unity3d.player.UnityPlayer");
//                Activity activity = (Activity) classtype.getDeclaredField("currentActivity").get(classtype);
//                _unityActivity = activity;
//            } catch (ClassNotFoundException e) {
//
//            } catch (IllegalAccessException e) {
//
//            } catch (NoSuchFieldException e) {
//
//            }
//        }
//        return _unityActivity;
//    }
    private Core core;

//    public boolean showToast(String content){
//        Toast.makeText(getActivity(),content,Toast.LENGTH_SHORT).show();
//        //这里是主动调用Unity中的方法，该方法之后unity部分会讲到
//       // callUnity("obj","OnCallTest", "hello unity i'm android");
//        return true;
//    }
    public void hangup()
    {
        if (core.getCurrentCall() != null) {
            core.getCurrentCall().terminate();
        }
    }

    public void answer()
    {
        if (core.getCurrentCall() != null) {
            core.getCurrentCall().accept();
        }
    }

    public void mutemic()
    {
      //  core.setMicEnabled(true);
    }

    public void init(Context context)
    {
        Factory factory = Factory.instance();
        //factory.setDebugMode(true, "Hello Linphone");
        core = factory.createCore(null, null, context);
       // Toast.makeText(getActivity(),"初始化完毕",Toast.LENGTH_SHORT).show();

    }

    private void toggleSpeaker() {
        // Get the currently used audio device
        AudioDevice currentAudioDevice = core.getCurrentCall().getOutputAudioDevice();
        boolean speakerEnabled = currentAudioDevice.getType() == AudioDevice.Type.Speaker;

        // We can get a list of all available audio devices
        // Note that on tablets for example, there may be no Earpiece device
        AudioDevice[] audioDevices = core.getAudioDevices();
        for (AudioDevice audioDevice : audioDevices) {
            if (speakerEnabled && audioDevice.getType() == AudioDevice.Type.Earpiece) {
                core.getCurrentCall().setOutputAudioDevice(audioDevice);
                return;
            } else if (!speakerEnabled && audioDevice.getType() == AudioDevice.Type.Speaker) {
                core.getCurrentCall().setOutputAudioDevice(audioDevice);
                return;
            }/* If we wanted to route the audio to a bluetooth headset
        else if (audioDevice.type() == AudioDevice.Type.Bluetooth) {
            core.getCurrentCall().outputAudioDevice(audioDevice);
        }*/
        }
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
//        Toast.makeText(getActivity(),"登录完毕",Toast.LENGTH_SHORT).show();
////        // We will need the RECORD_AUDIO permission for video call
////        if (ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
////            requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 0);
////            return;
////        }
//   }

   private CoreListener coreListener = new CoreListenerStub() {
    @Override
    public void onAccountRegistrationStateChanged(Core core, Account account, RegistrationState state, String message)
    {
        //findViewById(R.id.registration_status).setText(message);

        if (state == RegistrationState.Failed) {
           // findViewById(R.id.connect).setEnabled(true);
        } else if (state == RegistrationState.Ok) {
          //  findViewById(R.id.register_layout).setVisibility(View.GONE);
          //  findViewById(R.id.call_layout).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAudioDeviceChanged(Core core, AudioDevice audioDevice) {
        // This callback will be triggered when a successful audio device has been changed
    }

    @Override
    public void onAudioDevicesListUpdated(Core core) {
        // This callback will be triggered when the available devices list has changed,
        // for example after a bluetooth headset has been connected/disconnected.
    }

    @Override
    public void onCallStateChanged(Core core, Call call, Call.State state, String message) {
        //findViewById(R.id.call_status).setText(message);

        // When a call is received
        switch (state) {
            case IncomingReceived:
                //findViewById(R.id.hang_up).setEnabled(true);
                //findViewById(R.id.answer).setEnabled(true);
                //findViewById(R.id.remote_address).setText(call.getRemoteAddress().asStringUriOnly());
                break;
            case Connected:
                //findViewById(R.id.mute_mic).setEnabled(true);
               // findViewById(R.id.toggle_speaker).setEnabled(true);
                break;
            case Released:
              //  findViewById(R.id.hang_up).setEnabled(false);
              //  findViewById(R.id.answer).setEnabled(false);
              //  findViewById(R.id.mute_mic).setEnabled(false);
              //  findViewById(R.id.toggle_speaker).setEnabled(false);
              //  findViewById(R.id.remote_address).setText("");
                break;
        }
    }
};


}
