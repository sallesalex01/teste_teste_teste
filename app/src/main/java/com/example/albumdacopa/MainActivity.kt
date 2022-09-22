package com.example.albumdacopa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.albumdacopa.databinding.ActivityMainBinding
import com.example.albumdacopa.models.Figurinha
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    val viewModel: CopaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // variavel do navHost
        val navHostFragment = supportFragmentManager.findFragmentById (R.id.nav_host_fragment) as NavHostFragment
        // variável de fluxo de navegação
        val navController = navHostFragment.navController
        //Creating top level destinations
        //and adding them to bottom navigation
        // inicializado com os ícones das telas
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_repetidas, R.id.nav_faltantes, R.id.nav_compartilhar)
        )
        // vinculando o appBar com o navHost
        setupActionBarWithNavController(navController, appBarConfiguration)
        findViewById<BottomNavigationView>(R.id.nav_view)?.setupWithNavController(navController)


        initializeFigurinhas()

    }

    fun initializeFigurinhas(){

        val lista = listOf(
            Figurinha("BR 01", 0),
            Figurinha("BR 02", 0),
            Figurinha("BR 03", 1),
            Figurinha("BR 04", 0),
            Figurinha("BR 05", 0),
            Figurinha("BR 06", 2),
            Figurinha("BR 07", 0),
            Figurinha("BR 08", 3),
            Figurinha("BR 09", 0),
            Figurinha("BR 10", 0),
        )

        viewModel.setListaFigurinha(lista)
    }


}