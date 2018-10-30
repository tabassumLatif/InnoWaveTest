package com.innowave.assessment.views.activities.search;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.innowave.assessment.R;
import com.innowave.assessment.models.User;
import com.innowave.assessment.networking.NetworkManager;
import com.innowave.assessment.callback.UserCallBack;
import com.innowave.assessment.views.activities.userDetail.DetailUserActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.innowave.assessment.utils.Constents.KEY_USER;

public class SearchActivity extends AppCompatActivity implements UserCallBack {

    @BindView(R.id.etSearch)
    EditText edtSearch;
    private NetworkManager networkManager;
    ProgressDialog loadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initializeNetworkRequest();
    }

    private void initializeNetworkRequest() {
        networkManager = new NetworkManager(this);
    }

    public void getUserDetail(View view) {
        String search = edtSearch.getText().toString();
        if (search.isEmpty())
            return;
        networkManager.getUser(this, search);
        showLoader();
    }

    private void showLoader(){
        if(loadingDialog == null) {
            loadingDialog = new ProgressDialog(this);
        }
        loadingDialog.setMessage("Searching, please wait.");
        loadingDialog.show();
    }

    private void hideLoader(){
        if(loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void onNetworkSuccess(String tag, User user) {
        hideLoader();
        Intent intent = new Intent(this, DetailUserActivity.class);
        intent.putExtra(KEY_USER, user);
        startActivity(intent);
    }

    @Override
    public void error() {
        hideLoader();
    }

}
