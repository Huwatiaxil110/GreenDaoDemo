package com.gdd.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gdd.R;
import com.gdd.app.GDApplication;
import com.gdd.greendao.InfoBean;
import com.gdd.greendao.InfoBeanDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    InfoBeanDao mInfoBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

//    public void initPermission(View view){
//        int hasPermisson = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        if(hasPermisson != PackageManager.PERMISSION_GRANTED){
//            if(Build.VERSION.SDK_INT > 23){
//                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 110);
//            }
//        }
//    }

    public void initGreenDao(View view){
        initDao();
    }

    private void initDao(){
        mInfoBeanDao = GDApplication.getApplication().getDaoSession().getInfoBeanDao();
    }

    public void add(View view){
        InfoBean mInfoBean = new InfoBean();
        mInfoBean.setClassTypeName("英语");
        Log.e("MainActivity", mInfoBean.toString());

        mInfoBeanDao.insert(mInfoBean);
    }

    public void delete(View view){
        InfoBean mInfoBean = new InfoBean();
//        mInfoBean.setClassTypeName("英语");
        mInfoBean.setTabid(1L);
        Log.e("MainActivity", mInfoBean.toString());

        mInfoBeanDao.delete(mInfoBean);
    }

    public void update(View view){
//        InfoBean mInfoBean = new InfoBean();
//        mInfoBean.setTabid(1L);
//        mInfoBean.setClassTypeName("数学");
//        Log.e("MainActivity", mInfoBean.toString());


        if(isFirst){
            isFirst = !isFirst;
            List<InfoBean> infoBeanList = mInfoBeanDao.queryBuilder().where(InfoBeanDao.Properties.ClassTypeName.eq("英语")).list();
            for(int i=0;i<infoBeanList.size();i++){
                InfoBean mInfoBean = infoBeanList.get(i);
                Log.e("MainActivity", mInfoBean.toString());

                mInfoBean.setClassTypeName("数学");
                Log.e("MainActivity", mInfoBean.toString());
            }

            mInfoBeanDao.updateInTx(infoBeanList);
        }else{
            isFirst = !isFirst;
            List<InfoBean> infoBeanList = mInfoBeanDao.queryBuilder().where(InfoBeanDao.Properties.ClassTypeName.eq("数学")).list();
            for(int i=0;i<infoBeanList.size();i++){
                InfoBean mInfoBean = infoBeanList.get(i);
                Log.e("MainActivity", mInfoBean.toString());
            }
        }
    }

    boolean isFirst = true;
    public void query(View view){
        if(isFirst){
            isFirst = !isFirst;
            List<InfoBean> infoBeanList = mInfoBeanDao.queryBuilder().where(InfoBeanDao.Properties.ClassTypeName.eq("英语")).list();
            for(int i=0;i<infoBeanList.size();i++){
                InfoBean mInfoBean = infoBeanList.get(i);
                Log.e("MainActivity", mInfoBean.toString());
            }
        }else{
            isFirst = !isFirst;
            List<InfoBean> infoBeanList = mInfoBeanDao.queryBuilder().where(InfoBeanDao.Properties.ClassTypeName.eq("数学")).list();
            for(int i=0;i<infoBeanList.size();i++){
                InfoBean mInfoBean = infoBeanList.get(i);
                Log.e("MainActivity", mInfoBean.toString());
            }
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
}
