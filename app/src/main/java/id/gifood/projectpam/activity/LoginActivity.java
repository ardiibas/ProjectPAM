package id.gifood.projectpam.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.gifood.projectpam.R;
import id.gifood.projectpam.network.JalurAPI;
import id.gifood.projectpam.network.ServieGenerator;
import id.gifood.projectpam.util.AuthToken;
import id.gifood.projectpam.util.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText etName, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button)findViewById(R.id.button_login);

        etName = (EditText)findViewById(R.id.email_login);
        etPhone = (EditText)findViewById(R.id.password_login);

        loginButton.setOnClickListener(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Toast.makeText(this, "Ada token: "+preferences.getString("token", "kosong bos"), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login :
                JalurAPI api = ServieGenerator.createService(JalurAPI.class);

                Call<Users> call = api.getUser();

                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        if (response.isSuccessful()){
                            String token = response.body().getToken();

                            Log.v("Token", token);
//                            Users token = response.body();
//
//                            SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                            SharedPreferences.Editor editor = mSettings.edit();
//                            editor.putString("token", token.getToken());
//                            editor.apply();
//
//                            Toast.makeText(LoginActivity.this, (CharSequence) token, Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            finish();
                        }
                        else {
                            int statusCode = response.code();
                            Log.e("Error", String.valueOf(statusCode));
                        }
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                        Log.v("Error", t.getMessage());
                    }
                });
        }
    }
}
