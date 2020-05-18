package pe.edu.tecsup.almacenapp.service;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pe.edu.tecsup.almacenapp.ResponseMessage;
import pe.edu.tecsup.almacenapp.models.Producto;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String API_BASE_URL = "http://192.168.1.4:8080";

    @GET("/productos")
    Call<List<Producto>> getProductos();
    @FormUrlEncoded
    @POST("/productos")
    Call<ResponseMessage> createProducto(@Field("nombre") String nombre,
                                         @Field("precio") String precio,
                                         @Field("detalles") String detalles);
    @Multipart
    @POST("/productos")
    Call<ResponseMessage> createProductoWithImage(
            @Part("nombre") RequestBody nombre,
            @Part("precio") RequestBody precio,
            @Part("detalles") RequestBody detalles,
            @Part MultipartBody.Part imagen
    );


}
