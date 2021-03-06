package screen.addmember;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cometchat.pro.uikit.R;

import constant.StringContract;
import com.cometchat.pro.uikit.Settings.UISettings;

public class CometChatAddMemberScreenActivity extends AppCompatActivity {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_screen);
        handleIntent();
        if (UISettings.getColor()!=null)
            getWindow().setStatusBarColor(Color.parseColor(UISettings.getColor()));
    }

    private void handleIntent() {
        if (getIntent()!=null) {
            Bundle bundle = new Bundle();
            fragment=new CometChatAddMemberScreen();
            if (getIntent().hasExtra(StringContract.IntentStrings.GUID))
                bundle.putString(StringContract.IntentStrings.GUID, getIntent()
                        .getStringExtra(StringContract.IntentStrings.GUID));
            if (getIntent().hasExtra(StringContract.IntentStrings.GROUP_NAME))
                bundle.putString(StringContract.IntentStrings.GROUP_NAME, getIntent()
                        .getStringExtra(StringContract.IntentStrings.GROUP_NAME));
            if (getIntent().hasExtra(StringContract.IntentStrings.GROUP_MEMBER))
                bundle.putStringArrayList(StringContract.IntentStrings.GROUP_MEMBER,getIntent()
                        .getStringArrayListExtra(StringContract.IntentStrings.GROUP_MEMBER));

            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment,fragment).commit();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

           if(item.getItemId()==android.R.id.home){
               onBackPressed();
           }

        return super.onOptionsItemSelected(item);
    }


}
