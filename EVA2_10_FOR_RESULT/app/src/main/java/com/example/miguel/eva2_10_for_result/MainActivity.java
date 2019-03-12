package com.example.miguel.eva2_10_for_result;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;
    EditText txtProvider;
    EditText txtExample;
    Button btnCallActivity2;
    Uri[] uriProvider = {
            Uri.parse("content://media/external/audio/media"),
            Uri.parse("content://media/external/images/media"),
            android.provider.ContactsContract.Contacts.CONTENT_URI,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
// use requestCode to find out who is talking to us
            switch (requestCode) {
                case (222): {
// 222 is our friendly contact-picker activity
                    if (resultCode == Activity.RESULT_OK) {
                        String returnedData = data.getDataString();
                        Toast.makeText(getApplication(), "id " + returnedData, Toast.LENGTH_SHORT).show();
// it will return an URI that looks like:
// content://contacts/people/n
// where n is the selected contact's ID
                        txtMsg.setText(returnedData.toString());
// show a 'nice' screen with the selected contact
                        Toast.makeText(getApplication(), "Nice UI for\n "
                                + returnedData, Toast.LENGTH_LONG).show();
                        Intent myAct3 = new Intent(Intent.ACTION_VIEW,

                                Uri.parse(returnedData));

                        startActivity(myAct3);
                    } else {
// user pressed the BACK button to end called activity
                        txtMsg.setText("Selection CANCELLED " + requestCode + " " + resultCode);
                    }
                    break;
                }
            }// switch
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            txtMsg = (TextView) findViewById(R.id.txtMsg);
            txtProvider = (EditText) findViewById(R.id.txtProviderOption);
// show some examples of built-in content providers
            txtExample = (EditText) findViewById(R.id.txtExample);
            for (int i = 0; i < uriProvider.length; i++)
                txtExample.append("\n" + i + " "
                        + uriProvider[i].toString());
            btnCallActivity2 = (Button) findViewById(R.id.btnOption);
            btnCallActivity2.setOnClickListener(new ClickHandler());
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }

    }

    public class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            try {
// start myActivity2. Tell it that my nickname is 222
                int option = Integer.parseInt(txtProvider.getText().toString());
                Intent myActivity2 = new Intent(Intent.ACTION_PICK,
                        uriProvider[option]);

                startActivityForResult(myActivity2, 222);
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        }// onClick
    }//
}


