import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String BASE_URL = "https://api.i3rb.com/";
    private static ApiService instance;
    private Retrofit retrofit;

    private ApiService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    public <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }
}