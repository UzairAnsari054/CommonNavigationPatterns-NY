package com.example.menus_drawer_bottomnavigation_ny

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class HelpFragment : Fragment(), MenuProvider {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.home_menu, menu)

        val helpMenuItem = menu.findItem(R.id.action_help)
        if (helpMenuItem != null) {
            helpMenuItem.isVisible = false
        }
        val cartMenuItem = menu.findItem(R.id.action_cart)
        if (cartMenuItem != null) {
            cartMenuItem.isVisible = false
        }
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_settings -> {
                findNavController().navigate(R.id.settingsFragment)
                true
            }
            else -> false
        }
    }
}