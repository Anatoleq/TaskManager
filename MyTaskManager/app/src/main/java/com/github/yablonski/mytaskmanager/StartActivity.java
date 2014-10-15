package com.github.yablonski.mytaskmanager;

/**
 * Created by Acer on 06.10.2014.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.github.yablonski.mytaskmanager.utils.AuthUtils;

public class StartActivity extends ActionBarActivity{

    public static final int REQUEST_LOGIN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AuthUtils.isLogged()) {
            startMainActivity();
        } else {
            startActivityForResult(new Intent(this, LoginActivity.class), REQUEST_LOGIN);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOGIN && resultCode == RESULT_OK) {
            startMainActivity();
        } else {
            finish();
        }
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("extra_key", "asdd");
        startActivity(intent);
        finish();
    }
}
