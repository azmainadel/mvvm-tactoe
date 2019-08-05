package com.example.tictactoe.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.tictactoe.R;
import com.example.tictactoe.databinding.ActivityMainBinding;
import com.example.tictactoe.viewmodel.TicTacToeViewModel;

public class MainActivity extends AppCompatActivity {

    private TicTacToeViewModel ticTacToeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        bindViewModel();

        ticTacToeViewModel.onCreate();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
    }

    private void bindViewModel() {
        ticTacToeViewModel = new TicTacToeViewModel();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(ticTacToeViewModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tictactoe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_reset) {
            ticTacToeViewModel.onResetSelected();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ticTacToeViewModel.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ticTacToeViewModel.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ticTacToeViewModel.onDestroy();
    }
}
