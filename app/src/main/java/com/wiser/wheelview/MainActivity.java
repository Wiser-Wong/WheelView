package com.wiser.wheelview;

import java.util.ArrayList;
import java.util.List;

import com.wiser.linkageview.OptionsPickerView;
import com.wiser.pickerview.DatePickerView;
import com.wiser.wheel.WheelView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements WheelView.OnItemSelectedListener<String>, DatePickerView.OnDateSelectedListener {

	WheelView<String>			wheelView;

	DatePickerView				pickerView;

	OptionsPickerView<String>	opvView;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		wheelView = findViewById(R.id.wv_view);
		pickerView = findViewById(R.id.date_picker_view);
		opvView = findViewById(R.id.opv_view);

		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("车轮" + i);
		}
		wheelView.setItemData(list);
		wheelView.setOnItemSelectedListener(this);

		pickerView.initDatePickerView(false);
		pickerView.setOnDateSelectedListener(this);

		List<List<String>> lists = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {

			List<String> list1 = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				list1.add(list.get(i) + "火烈" + j);
			}
			lists.add(list1);
		}

		List<List<List<String>>> lists1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			List<List<String>> lists2 = new ArrayList<>();
			for (int j = 0; j < lists.size(); j++) {
				List<String> list1 = new ArrayList<>();
				for (int k = 0; k < 10; k++) {
					list1.add(list.get(i) + "代理商" + k);
				}
				lists2.add(list1);
			}
			lists1.add(lists2);
		}

		opvView.setLinkageData(list, lists, lists1);
	}

	@Override public void onItemSelected(WheelView<String> wheelView, String data, int position) {}

	@Override public void onDateSelected(DatePickerView datePickerView, int year, int month, int day, @Nullable String date) {}
}
