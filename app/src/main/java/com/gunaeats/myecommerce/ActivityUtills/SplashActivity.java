package com.gunaeats.myecommerce.ActivityUtills;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.gunaeats.myecommerce.LoginActivity;
import com.gunaeats.myecommerce.MainActivity;
import com.gunaeats.myecommerce.R;
import com.gunaeats.myecommerce.UAtils.UserSession;
import com.gunaeats.myecommerce.utils.PermissionChecker;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2500;

    String[] RequiredPermissions = {Manifest.permission.CAMERA, READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE,READ_PHONE_STATE};
    Handler handler;
    PermissionChecker permissionChecker = new PermissionChecker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        checkPermissions();
    }


  void  launchApp(){

      new Handler().postDelayed(new Runnable(){
          @Override
          public void run() {
              if (UserSession.getInstance(SplashActivity.this).readPrefs(UserSession.PREFS_USER_MOBILE).equals("")){
                  Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                  SplashActivity.this.startActivity(mainIntent);
                  SplashActivity.this.finish();
              }else {
                  Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                  SplashActivity.this.startActivity(mainIntent);
                  SplashActivity.this.finish();
              }

          }
      }, SPLASH_DISPLAY_LENGTH);


  }

    private void checkPermissions() {
        permissionChecker.verifyPermissions(this, RequiredPermissions, new PermissionChecker.VerifyPermissionsCallback() {
            @Override
            public void onPermissionAllGranted() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                launchApp();
                            }
                        }, 3000);

                    }
//
                }, 1 * 1000);
            }

            @Override
            public void onPermissionDeny(String[] permissions) {
                Toast.makeText(SplashActivity.this, "Please grant required permissions.", Toast.LENGTH_LONG).show();
                launchApp();
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionChecker.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}