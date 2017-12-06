package com.derekudacityclassprojects.jokeappproject;

/**
 * Created by pittsd on 12/6/2017.
 */

public class MainActivityFragmentPresenter implements MainActivityFragmentContract.Presenter {
    private GetJokesFromFirebaseAsyncTask getJokesFromFirebaseAsyncTask;
    @Override
    public void loadAllJokes(GetJokesFromFirebaseAsyncTask.GetAllJokesCallback callback) {
        getJokesFromFirebaseAsyncTask = new GetJokesFromFirebaseAsyncTask(callback);
    }

    @Override
    public void closeAllAsyncTasks() {
        if(getJokesFromFirebaseAsyncTask != null){
            getJokesFromFirebaseAsyncTask.cancel(true);
        }
    }
}
