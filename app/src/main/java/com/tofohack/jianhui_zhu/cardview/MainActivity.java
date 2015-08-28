package com.tofohack.jianhui_zhu.cardview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @Bind(R.id.list)
    RecyclerView list;
    private List<Tree> trees=initTree();
    private List<Tree> initTree(){
        List<Tree> trees=new ArrayList<>();
        trees.add(new Tree.TreeBuilder().setName("Tree 1").setImagePath(R.drawable.tree1).build());
        trees.add(new Tree.TreeBuilder().setName("Tree 2").setImagePath(R.drawable.tree2).build());
        trees.add(new Tree.TreeBuilder().setName("Tree 3").setImagePath(R.drawable.tree3).build());
        trees.add(new Tree.TreeBuilder().setName("Tree 4").setImagePath(R.drawable.tree4).build());
        trees.add(new Tree.TreeBuilder().setName("Tree 5").setImagePath(R.drawable.tree5).build());
        trees.add(new Tree.TreeBuilder().setName("Tree 6").setImagePath(R.drawable.tree6).build());
        trees.add(new Tree.TreeBuilder().setName("Tree 7").setImagePath(R.drawable.tree7).build());
        return trees;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setItemAnimator(new DefaultItemAnimator());
        list.setHasFixedSize(true);
        list.setAdapter(new CardViewAdapter.CardViewAdapterBuilder().setContext(MainActivity.this).setTrees(trees).build());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}
