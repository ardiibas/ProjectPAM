package id.gifood.projectpam.network;

import android.database.Observable;

import id.gifood.projectpam.util.AuthToken;
import id.gifood.projectpam.util.Users;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ibas on 11/09/2017.
 */

public interface JalurAPI {

    @GET ("users")
    Call<Users> getUser();

    @POST("users")
    Call<AuthToken> login(
            @Field("name") String name,
            @Field("phone") String phone
    );

}
