package com.derekudacityclassprojects.jokeappproject;

/**
 * Created by pittsd on 12/6/2017.
 */

public class MainActivityFragmentContract {
    interface FragmentView {
    }
    interface Presenter {
        void loadAllJokes(GetJokesFromFirebaseAsyncTask.GetAllJokesCallback callback);
        void closeAllAsyncTasks();
    }
}
