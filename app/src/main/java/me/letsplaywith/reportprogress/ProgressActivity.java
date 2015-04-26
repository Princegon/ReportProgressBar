package me.letsplaywith.reportprogress;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class ProgressActivity extends Activity {

    private static final String TAG = "ProgressActivity";
    private Button mButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mButton = (Button) findViewById(R.id.btn_start_counter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setMax(100);
                progressBar.setProgress(0);
                new ProgressStarter(progressBar).execute();
            }
        });
    }

    private class ProgressStarter extends AsyncTask {

        private ProgressBar mProgressBar;

        public ProgressStarter(View v) {
            super();
            mProgressBar = (ProgressBar) v;
        }

        @Override
        protected Object doInBackground(Object[] params) {

            if (mProgressBar == null) {
                Log.d(TAG, "mProgressBar is not found!");
                return null;
            }

            try {
                for (int i = 0; i < 100; i++) {
                    mProgressBar.incrementProgressBy(1);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
