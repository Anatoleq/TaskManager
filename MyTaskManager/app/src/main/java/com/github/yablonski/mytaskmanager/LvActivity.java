package com.github.yablonski.mytaskmanager;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class LvActivity extends Activity {

    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);

        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new Product("Product " + i, i * 1000,
                    R.drawable.ic_launcher, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String result = "Товары в корзине:";
        for (Product p : boxAdapter.getBox()) {
            if (p.box)
                result += "\n" + p.name;
        }
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
