package com.esprit.je_suis_enceinte.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/user/register")
    Call<ResponseBody> createUser(@Field("email") String email, @Field("password") String password, @Field("name") String name);

    @FormUrlEncoded
    @POST("/user/login")
    Call<ResponseBody> loginUser(@Field("password") String password, @Field("username") String name);

}
