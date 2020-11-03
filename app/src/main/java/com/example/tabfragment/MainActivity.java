package com.example.tabfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.util.Log;

import com.example.tabfragment.Fragmnet.AddFragment;
import com.example.tabfragment.Fragmnet.ResultFragment;

public class MainActivity extends AppCompatActivity {
    private boolean isTwoPane;
    private static String Tag = "TAG";
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.resultFrag) != null){
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }


        if (savedInstanceState == null){
            fragmentManager.beginTransaction()
                    .add(R.id.listFrag, new AddFragment())
                    .commit();
            Log.d(Tag, "List fragment Added");
        }
        if (isTwoPane){
            fragmentManager.beginTransaction()
                    .replace(R.id.resultFrag, new ResultFragment())
                    .commit();
            Log.d(Tag, "Result fragment Added");

        }
    }
}