package com.wiser.wheelview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.wiser.wheel.WheelView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WheelView.OnItemSelectedListener<String> {

	WheelView<String> wheelView;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wheelView = findViewById(R.id.wv_view);

		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("车轮" + i);
		}
		wheelView.setItemData(list);
		wheelView.setOnItemSelectedListener(this);
	}

	@Override public void onItemSelected(WheelView<String> wheelView, String data, int position) {
		Toast.makeText(this, data, Toast.LENGTH_LONG).show();
		System.out.println("--------da--->>"+data);
	}
}
