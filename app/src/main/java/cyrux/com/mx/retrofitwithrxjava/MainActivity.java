package cyrux.com.mx.retrofitwithrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRepositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRepositories = findViewById(R.id.rvRepositories);
        rvRepositories.setLayoutManager(new LinearLayoutManager(this));
        GitHubService service = ServiceGenerator.createService(GitHubService.class);
        Observable<List<Repository>> observable = service.reposForUser("cyl2ux");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repository>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Repository> repositoryList) {
                        rvRepositories.setAdapter(new RepositoriesAdapter(repositoryList));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Request failed", "Cannot Request GitHub repositories");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
