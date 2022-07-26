package jp.suntech.s21030.bmicalculators030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.btM);
        HelloListener listener = new HelloListener();
        btClick.setOnClickListener(listener);
        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);

    }
    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.etAge);
            EditText input1 = findViewById(R.id.etH);
            EditText input2 = findViewById(R.id.etW);
            String inputA = input.getText().toString();
            String inputH = input1.getText().toString();
            String inputW = input2.getText().toString();
            TextView output1=findViewById(R.id.tvt1);
            TextView output2=findViewById(R.id.tvBMI);
            TextView output3=findViewById(R.id.tvt2);
            TextView output4=findViewById(R.id.tvBw);
            TextView output5=findViewById(R.id.tvKg2);
            float a=Float.parseFloat(inputA);
            float h=Float.parseFloat(inputH);
            float w=Float.parseFloat(inputW);
            int id = view.getId();
            switch (id){
                case R.id.btM:
                    if (a<16){
                        ConfirmDialogWarning warning=new ConfirmDialogWarning();
                        warning.show(getSupportFragmentManager(),"ConfirmDialogWarning");
                    }
                    float b=w/((h/100)*(h/100));
                    output1.setText(R.string.tx_tvt1);
                    if(b<18.5){
                        output2.setText("低体重(瘦せ型)");
                    }else if(b<25){
                        output2.setText("普通体重");
                    }else if (b<30){
                        output2.setText("肥満(1度)");
                    }else if (b<35){
                        output2.setText("肥満(2度)");
                    }else if (b<40){
                        output2.setText("肥満(3度)");
                    }else {
                        output2.setText("肥満(4度)");
                    }
                    output3.setText(R.string.tx_tvt2);
                    float bw=22*((h/100)*(h/100));
                    String Bw=String.format("%.1f",bw);
                    output4.setText(Bw);
                    output5.setText(R.string.tv_kg);
                    break;
                case R.id.btClear:
                    input.setText("");
                    input1.setText("");
                    input2.setText("");
                    output1.setText("");
                    output2.setText("");
                    output3.setText("");
                    output4.setText("");
                    output5.setText("");
                    break;
            }

        }
    }
}