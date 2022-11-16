package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.service.autofill.OnClickAction
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentQuestionBinding
import com.example.myapplication.fragments.MenuFragment
import com.example.myapplication.fragments.NewQuestionFragment

class MainActivity : AppCompatActivity() {
    val TAG= "MainActivity"

//    val choosephonenum=1
//    lateinit var personName : TextView
//    lateinit var startButton : Button
//    lateinit var choosebtn : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = MenuFragment()
        val fragment : Fragment? =
            supportFragmentManager.findFragmentByTag(MenuFragment::class.java.simpleName)

        if (fragment !is MenuFragment){
            supportFragmentManager.beginTransaction().add(R.id.container_fragment, homeFragment,MenuFragment::class.java.simpleName).commit()
        }
    val bind= FragmentQuestionBinding.inflate(layoutInflater)
//
//    val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
//    val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
//    val navigationView = findViewById<NavigationView>(R.id.navigationView)
//
//    topAppBar.setNavigationOnClickListener {
//        drawerLayout.open()
//    }
//
//    navigationView.setNavigationItemSelectedListener { menuItem ->
//        // Handle menu item selected
//        when (menuItem.itemId) {
//            R.id.home -> {
//                // navigate to home screen
//                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.home)
//            }
//            R.id.quiz -> {
//                //Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.startFragment)
//            }
//            R.id.profile -> {
//                //Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.profileFragment)
//            }
//
//            R.id.list -> {
//                //Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.questionListFragment)
//            }
//            R.id.add -> {
//                //Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.questionAddFragment)
//            }
//            else -> super.onOptionsItemSelected(menuItem)
//
//        }
//        menuItem.isChecked = true
//        drawerLayout.close()
//        true
//    }


//        Log.i(TAG,"onCreate() called.")
//        startButton=findViewById(R.id.startbutton)
//        startButton.setOnClickListener { callActivity() }
//
//        personName=findViewById(R.id.PersonName)
//        choosebtn=findViewById(R.id.choose)
//        choosebtn.setOnClickListener {
//        val intent= Intent(Intent.ACTION_PICK,ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
//        startActivity(intent) }





    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"onStart() called.")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"onResume() called.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG,"onRestart() called.")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"onStop() called.")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"onPause() called.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy() called.")
    }
    private fun callActivity(){
        val editText=findViewById<EditText>(R.id.PersonName)
        val message=editText.text.toString()

        val intent = Intent(this,MainActivity2::class.java).also {
            it.putExtra("Name",message)
            startActivity(it)
        }
    }


}