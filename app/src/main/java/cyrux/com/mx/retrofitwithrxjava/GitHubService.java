package cyrux.com.mx.retrofitwithrxjava;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{user}/repos")
    Observable<List<Repository>> reposForUser(@Path("user") String user);
}
