package com.ahmeddonkl.retrofittutorial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ahmeddonkl.retrofittutorial.Service.API.API;
import com.ahmeddonkl.retrofittutorial.Service.API.ServiceBuilder;
import com.ahmeddonkl.retrofittutorial.Service.Model.RouteObject;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PerformMoviesCall();

    }

    public void PerformMoviesCall(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.show();
        ServiceBuilder Builder = new ServiceBuilder();
        API.Routes service =Builder.BuildMovies();
        service.getRoutes("30.02747,31.21057","30.04427,31.23560","30.03814,31.21134|30.03976,31.21928|30.04303,31.22681",Constants.API_KRY, new retrofit.Callback<RouteObject>() {
            @Override
            public void success(RouteObject routeObject, Response response) {
               // routeObject.routes.get(0).legs.get(0).distance
                System.out.print(routeObject);
               progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                progressDialog.dismiss();
               Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
