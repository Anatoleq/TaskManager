package com.github.yablonski.mytaskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.yablonski.mytaskmanager.utils.AuthUtils;


public class LoginActivity extends ActionBarActivity {

    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button cancelBtn = (Button) findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        edit_text = (EditText) findViewById(R.id.edit_text);
    }

    public void onLoginClick(View view) {
        com.github.yablonski.mytaskmanager.utils.AuthUtils.setLogged(true);
        setResult(RESULT_OK);
        Intent intent = new Intent();
        intent.putExtra("name",edit_text.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }


}
