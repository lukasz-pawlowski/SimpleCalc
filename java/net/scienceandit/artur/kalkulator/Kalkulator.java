package net.scienceandit.artur.kalkulator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Kalkulator extends ActionBarActivity {
    String dzialanie_globalne="";
    float numberone;
    float numbertwo;
    boolean finish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        // wczytanie obiektów
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        // ustawienie tekstu na obiektach
        poprzednie.setText("");
        dzialanie.setText("");
    }

    public void buttonNumeric(View view) {
        String value = "0";
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);

        switch (view.getId()) {
            case R.id.button0:
                value = "0";
                break;
            case R.id.button1:
                value = "1";
                break;
            case R.id.button2:
                value = "2";
                break;
            case R.id.button3:
                value = "3";
                break;
            case R.id.button4:
                value = "4";
                break;
            case R.id.button5:
                value = "5";
                break;
            case R.id.button6:
                value = "6";
                break;
            case R.id.button7:
                value = "7";
                break;
            case R.id.button8:
                value = "8";
                break;
            case R.id.button9:
                value = "9";
                break;
            case R.id.przecinek:
                value = ".";
                break;
        }
        dzialanie.setText(dzialanie.getText() + "" + value);
    }
    public void Click(View view) {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        //dodawanie liczby do dzialania
        numberone = Float.valueOf(dzialanie.getText().toString());
        //dodawanie znaku
        String value="";
        switch (view.getId()) {
            case R.id.dodaj:
                value = "+";
                dzialanie_globalne = "dod";
                break;
            case R.id.odejmij:
                value = "-";
                dzialanie_globalne = "ode";
                break;
            case R.id.pomnoz:
                value = "*";
                dzialanie_globalne = "mno";
                break;
            case R.id.podziel:
                value = "/";
                dzialanie_globalne = "dzi";
                break;
        }
        if(dzialanie != null) {
            poprzednie.setText(dzialanie.getText() + value);
            dzialanie.setText("");
        } else {
            dzialanie.setText("Wprowadź liczbę");
        }
    }
    public void getnumbertwo(View view) {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        if(dzialanie == null || poprzednie == null) {
            dzialanie.setText("Najpierw stwórz działanie");
        } else {
            numbertwo = Float.valueOf(dzialanie.getText().toString());

            poprzednie.setText(poprzednie.getText() + "" + dzialanie.getText());
            dzialanie.setText("");

            wynik();
            finish = true;
        }
    }
    public void wynik() {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);
        String value="";
        switch (dzialanie_globalne) {
            case "dod":
                value = String.valueOf(numberone + numbertwo);
                break;
            case "ode":
                value = String.valueOf(numberone - numbertwo);
                break;
            case "mno":
                value = String.valueOf(numberone * numbertwo);
                break;
            case "dzi":
                value = String.valueOf(numberone / numbertwo);
                break;
        }
        poprzednie.setText("");
        dzialanie.setText(value);
    }
    public void Czyszczenie(View view) {
        TextView poprzednie=(TextView)findViewById(R.id.poprzednie);
        TextView dzialanie=(TextView)findViewById(R.id.dzialanie);

        numberone = 0;
        numbertwo = 0;
        dzialanie_globalne = "";
        dzialanie.setText("");
        poprzednie.setText("");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kalkulator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
