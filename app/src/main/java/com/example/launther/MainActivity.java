package com.example.launther;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.service.media.MediaBrowserService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_MAIL = 1;
    static final int REQUEST_MAP = 2;
    static final int REQUEST_CAMERA = 3;
    static final int REQUEST_GARRARY = 4;


    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView2);
        editText = (EditText)findViewById(R.id.editText);
        editText.setText("初期状態");
    }
    public void map(View v){
        String location = "geo:0,0?q=" + editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
        startActivityForResult(intent,REQUEST_MAP);
    }
    public void mail(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:life.is.text@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"題名");
        intent.putExtra(Intent.EXTRA_TEXT,"本文");
        startActivityForResult(intent,REQUEST_MAIL);
    }

    public void  camera(View v){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CAMERA);
    }

    public  void app(View v){
        PackageManager pm = getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage("com.android.vending");
        startActivity(intent);
    }

    public void pict(View v){
        Intent intent = new Intent(Intent.ACTION_PICK,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,REQUEST_GARRARY);
    }

    public void onActivityResult(int requestCode, int resultcode, Intent intent)

}

