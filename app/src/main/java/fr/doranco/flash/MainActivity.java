package fr.doranco.flash;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import fr.doranco.flash.database.SpecialiteDatabaseTest;
import fr.doranco.flash.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    private ActivityMainBinding binding;

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // ajouter toolbar
        setSupportActionBar(binding.topAppBar);
        // ajouter le toggler sur le toolbar
        toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.topAppBar, R.string.openDrawer, R.string.closeDrawer);
        binding.drawerLayout.addDrawerListener(toggle);
        //binding.topAppBar.setNavigationIcon(R.drawable.baseline_home_24);
        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.white)); // mettre a jour la couleur
        toggle.syncState();

        // parametrage des id de menu de navigation, chaque menu correspond a une destination dans l'app
        appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.accueilFragment, R.id.specialiteFragment, R.id.etudiantFragment, R.id.coursFragment)
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavHostFragment navHostFragment =(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_container_view);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
}