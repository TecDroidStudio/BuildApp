package com.aplication.buildapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class ViewBuild extends AppCompatActivity {

    private TextView tvBuildName;
    private TextView tvBuildAuthor;
    private TextView tvBuildDate;
    private ImageView imgvBuild;
    private ImageView imgvBuildSeason;
    private Bitmap bitmap;
    private Bitmap bitmapSeason;

    String buildName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_build);

        tvBuildName = (TextView) findViewById(R.id.tv_view_build_name);
        tvBuildAuthor = (TextView) findViewById(R.id.tv_view_author);
        tvBuildDate = (TextView) findViewById(R.id.tv_view_date);
        imgvBuild = (ImageView) findViewById(R.id.imgv_build_top_image);
        imgvBuildSeason = (ImageView) findViewById(R.id.imgv_view_build_season);

        Intent it = getIntent();

        Bundle parameters = it.getExtras();

        bitmap = BitmapFactory.decodeResource(getResources(), parameters.getInt("buildImg"));
        bitmapSeason = BitmapFactory.decodeResource(getResources(), R.drawable.sign_check_icon);

        tvBuildName.setText(parameters.getString("buildName"));
        tvBuildAuthor.setText(parameters.getString("buildAuthor"));
        tvBuildDate.setText(parameters.getString("buildDate"));
        imgvBuild.setImageBitmap(bitmap);
        imgvBuildSeason.setImageBitmap(bitmapSeason);
    }
}
