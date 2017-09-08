package id.gifood.projectpam;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import id.gifood.projectpam.fragment.FragmentHistory;
import id.gifood.projectpam.fragment.FragmentHome;
import id.gifood.projectpam.fragment.FragmentProfil;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        FragmentHome.OnFragmentInteractionListener,
        FragmentHistory.OnFragmentInteractionListener,
        FragmentProfil.OnFragmentInteractionListener {

    private BottomNavigationView bottomNavigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, FragmentHome.newInstance());
        fragmentTransaction.commit();

        bottomNavigationMenu = (BottomNavigationView) findViewById(R.id.bottom_nav);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.menu_home:
                fragment = FragmentHome.newInstance();
                break;
            case R.id.menu_history:
                fragment = FragmentHistory.newInstance();
                break;
            case R.id.menu_profil:
                fragment = FragmentProfil.newInstance();
                break;
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Mau keluar?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();
    }
}
