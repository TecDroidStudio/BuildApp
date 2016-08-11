package com.aplication.buildapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aplication.buildapp.R;
import com.aplication.buildapp.ViewBuild;
import com.aplication.buildapp.classes.Build;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    ListView lvBuild;
    List<Build> buildList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_fragment_home, container, false);

        buildList = new ArrayList<>();

        Build buildJax = new Build();

        buildJax.setBuildName("Jax top Build");
        buildJax.setImgBuild(R.drawable.jax);
        buildJax.setAuthor("Author' build 1");
        buildJax.setDate("08/07/2016");
        buildJax.setImgSeason(R.drawable.imac_icon);

        Build buildAzir = new Build();

        buildAzir.setBuildName("Azir mid Build");
        buildAzir.setImgBuild(R.drawable.azir);
        buildAzir.setAuthor("Author' build 2");
        buildAzir.setDate("08/07/2016");
        buildAzir.setImgSeason(R.drawable.imac_icon);

        Build buildShaco = new Build();

        buildShaco.setBuildName("Shaco jungle Build");
        buildShaco.setImgBuild(R.drawable.shaco);
        buildShaco.setAuthor("Author' build 3");
        buildShaco.setDate("08/07/2016");
        buildShaco.setImgSeason(R.drawable.imac_icon);

        Build buildEkko = new Build();

        buildEkko.setBuildName("Ekko mid Build");
        buildEkko.setImgBuild(R.drawable.ekko);
        buildEkko.setAuthor("Author' build 4");
        buildEkko.setDate("08/07/2016");
        buildEkko.setImgSeason(R.drawable.imac_icon);

        buildList.add(buildJax);
        buildList.add(buildAzir);
        buildList.add(buildShaco);
        buildList.add(buildEkko);

        lvBuild = (ListView) view.findViewById(R.id.lvBuildTop);

        CustomListViewBuild customListViewBuild = new CustomListViewBuild(getContext(), buildList);

        lvBuild.setAdapter(customListViewBuild);

        lvBuild.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getContext(), ViewBuild.class);

                Bundle parameters = new Bundle();

                parameters.putString("buildName", buildList.get(position).getBuildName());
                parameters.putString("buildAuthor", buildList.get(position).getAuthor());
                parameters.putString("buildDate", buildList.get(position).getDate());
                parameters.putInt("buildImg", buildList.get(position).getImgBuild());

                it.putExtras(parameters);

                startActivity(it);
            }
        });

        return view;
}

    //Define como a listView será exibida
    public class CustomListViewBuild extends ArrayAdapter {

        Context context;

        private List<Build> buildList;

        Bitmap bitmap;

        public CustomListViewBuild(Context context, List<Build> objects) {
            super(context, R.layout.item_builds, R.id.tvBuild_name, objects);

            this.context = context;
            buildList = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;

            if (row == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.item_builds, parent, false);
            }

            TextView buildName = (TextView) row.findViewById(R.id.tvBuild_name);
            ImageView imgBuild = (ImageView) row.findViewById(R.id.imgv_champ);
            TextView author = (TextView) row.findViewById(R.id.tv_author);
            TextView date = (TextView) row.findViewById(R.id.tv_date);
            ImageView imgSeason = (ImageView) row.findViewById(R.id.imgv_season);

            bitmap = BitmapFactory.decodeResource(row.getResources(), buildList.get(position).getImgSeason());

            Bitmap bitmapResized = bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 4, bitmap.getHeight() / 4, false);

            buildName.setText(buildList.get(position).getBuildName().toString());
            author.setText(buildList.get(position).getAuthor().toString());
            date.setText(buildList.get(position).getDate().toString());
            imgBuild.setImageBitmap(BitmapFactory.decodeResource(row.getResources(), buildList.get(position).getImgBuild()));
            imgSeason.setImageBitmap(bitmapResized);

            return row;
        }
    }
}
