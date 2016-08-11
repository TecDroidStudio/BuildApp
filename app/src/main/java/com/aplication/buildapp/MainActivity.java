package com.aplication.buildapp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.aplication.buildapp.adapter.FragmentSlideAdapter;
import com.aplication.buildapp.classes.Build;
import com.aplication.buildapp.fragment.FragmentBuilds;
import com.aplication.buildapp.fragment.FragmentHome;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    ListView lvBuild;
    List<Build> buildList;

    TabHost tabHost;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        buildList = new ArrayList<>();
//        Build buildJax = new Build();
//
//        buildJax.setBuildName("Jax top Build");
//        buildJax.setImgBuild(R.drawable.jax);
//        buildJax.setAuthor("Author' build 1");
//        buildJax.setDate("08/07/2016");
//        buildJax.setImgSeason(R.drawable.imac_icon);
//
//        Build buildAzir = new Build();
//
//        buildAzir.setBuildName("Azir mid Build");
//        buildAzir.setImgBuild(R.drawable.azir);
//        buildAzir.setAuthor("Author' build 2");
//        buildAzir.setDate("08/07/2016");
//        buildAzir.setImgSeason(R.drawable.imac_icon);
//
//        Build buildShaco = new Build();
//
//        buildShaco.setBuildName("Shaco jungle Build");
//        buildShaco.setImgBuild(R.drawable.shaco);
//        buildShaco.setAuthor("Author' build 3");
//        buildShaco.setDate("08/07/2016");
//        buildShaco.setImgSeason(R.drawable.imac_icon);
//
//        Build buildEkko = new Build();
//
//        buildEkko.setBuildName("Ekko mid Build");
//        buildEkko.setImgBuild(R.drawable.ekko);
//        buildEkko.setAuthor("Author' build 4");
//        buildEkko.setDate("08/07/2016");
//        buildEkko.setImgSeason(R.drawable.imac_icon);
//
//        buildList.add(buildJax);
//        buildList.add(buildAzir);
//        buildList.add(buildShaco);
//        buildList.add(buildEkko);
//
//        lvBuild = (ListView) findViewById(R.id.lvBuildTop);
        tabHost = (TabHost) findViewById(R.id.tabHost);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        initFragments();

        setTabHost();

//        CustomListViewBuild customListViewBuild = new CustomListViewBuild(getBaseContext(), buildList);
//
//        lvBuild.setAdapter(customListViewBuild);
//
//        lvBuild.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent it = new Intent(getBaseContext(), ViewBuild.class);
//
//                Bundle parameters = new Bundle();
//
//                parameters.putString("buildName", buildList.get(position).getBuildName());
//                parameters.putString("buildAuthor", buildList.get(position).getAuthor());
//                parameters.putString("buildDate", buildList.get(position).getDate());
//                parameters.putInt("buildImg", buildList.get(position).getImgBuild());
//
//                it.putExtras(parameters);
//
//                startActivity(it);
//            }
//        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //+++++++++++++++++++ Implementation +++++++++++++++++++++

    //Define como a listView será exibida
    public class CustomListViewBuild extends ArrayAdapter{

        Context context;

        private List<Build> buildList;

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

            buildName.setText(buildList.get(position).getBuildName().toString());
            author.setText(buildList.get(position).getAuthor().toString());
            date.setText(buildList.get(position).getDate().toString());
            imgBuild.setImageBitmap(BitmapFactory.decodeResource(row.getResources(), buildList.get(position).getImgBuild()));
            imgSeason.setImageBitmap(BitmapFactory.decodeResource(row.getResources(), buildList.get(position).getImgSeason()));

            return row;
        }
    }

    //Cria uma list de fragments
    public void initFragments(){
        List<Fragment> fragmentList = new ArrayList<Fragment>();

        fragmentList.add(new FragmentHome());
        fragmentList.add(new FragmentBuilds());

        FragmentSlideAdapter fragmentSlideAdapter = new FragmentSlideAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(fragmentSlideAdapter);

        viewPager.addOnPageChangeListener(this);
    }

    //Context para as páginas
    public class ContentPage implements TabHost.TabContentFactory{

        Context context;

        public ContentPage(Context context){
            this.context = context;
        }

        @Override
        public View createTabContent(String tag) {
            View contextPage = new View(context);
            contextPage.setMinimumWidth(0);
            contextPage.setMinimumHeight(0);

            return contextPage;
        }
    }

//    //Função para configurar o tabHost
    public void setTabHost(){

        tabHost.setup();

        TabHost.TabSpec tab_main = tabHost.newTabSpec("main_page");
        tab_main.setContent(new ContentPage(getApplicationContext()));
        tab_main.setIndicator("Home");

        TabHost.TabSpec tab_build = tabHost.newTabSpec("main_build");
        tab_build.setContent(new ContentPage(getApplicationContext()));
        tab_build.setIndicator("Builds");

//        TabHost.TabSpec tab_main = tabHost.newTabSpec("main_page");
//        tab_main.setContent(R.id.tabMain);
//        tab_main.setIndicator("Main page");
//
//        TabHost.TabSpec tab_build = tabHost.newTabSpec("main_build");
//        tab_build.setContent(R.id.tabBuildHost);
//        tab_build.setIndicator("Build page");

        tabHost.addTab(tab_main);
        tabHost.addTab(tab_build);

        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onTabChanged(String tabId) {
        int currentPage = tabHost.getCurrentTab();
        viewPager.setCurrentItem(currentPage);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
