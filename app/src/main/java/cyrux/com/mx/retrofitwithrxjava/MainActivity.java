package cyrux.com.mx.retrofitwithrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRepositories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRepositories = findViewById(R.id.rvRepositories);
        rvRepositories.setLayoutManager(new LinearLayoutManager(this));
        rvRepositories.setAdapter(new RepositoriesAdapter(Repository.getRepositories()));
    }
}
