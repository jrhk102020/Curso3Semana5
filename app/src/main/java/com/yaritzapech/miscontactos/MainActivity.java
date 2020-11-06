package com.yaritzapech.miscontactos;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

/*
import android.support.v7.widget.Toolbar;


import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;
*/

import com.yaritzapech.miscontactos.adapter.PageAdapter;
import com.yaritzapech.miscontactos.fragment.DetalleFragment;
import com.yaritzapech.miscontactos.fragment.MascotasFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();


        /*
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.huella);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        */






        if ( toolBar != null ){
            setSupportActionBar(toolBar);
        }


    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        //ArrayList fragments = new ArrayList<>();

        //Toast.makeText(this,"Aqui",Toast.LENGTH_SHORT).show();

        fragments.add(new MascotasFragment());
        fragments.add(new DetalleFragment());

        return fragments;
    }


    private void setUpViewPager(){
        //Toast.makeText(this,"Alla",Toast.LENGTH_SHORT).show();
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog_48);

    }









    public void fabClicked(View v){
        Toast.makeText(this, "Subir", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_favorite:
                Intent intent=new Intent(this, FavoritosActivity.class);
                this.startActivity(intent);
                return true;

            case R.id.action_about:
                //Toast.makeText(this,"Acerca de ",Toast.LENGTH_SHORT).show();
                Intent intentAbout =new Intent(this, AboutActivity.class);
                this.startActivity(intentAbout);
                return true;

            case R.id.action_contacto:
                //Toast.makeText(this,"Contacto",Toast.LENGTH_SHORT).show();
                Intent intentContacto =new Intent(this, ContactoActivity.class);
                this.startActivity(intentContacto);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
