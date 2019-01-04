package flo.muslim.info;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import flo.muslim.info.adapter.ViewPagerAdapter;
import flo.muslim.info.fragment.DoaFragment;
import flo.muslim.info.fragment.SholatFragment;
import flo.muslim.info.fragment.ZakatFragment;

public class TabWOIconActivity extends AppCompatActivity {

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    //Fragments

    SholatFragment chatFragment;
    DoaFragment callsFragment;
    ZakatFragment contactsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_without_icon);
        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position,false);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        // Associate searchable configuration with the SearchView
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent custom_tab=new Intent(this,AboutActivity.class);
                startActivity(custom_tab);
                return true;

            case R.id.action_faq:
                // FAQ activity
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        callsFragment=new DoaFragment();
        chatFragment=new SholatFragment();
        contactsFragment=new ZakatFragment();
        adapter.addFragment(callsFragment,getString(R.string.tab1));
        adapter.addFragment(chatFragment,getString(R.string.tab2));
        adapter.addFragment(contactsFragment,getString(R.string.tab3));
        viewPager.setAdapter(adapter);
    }

}
