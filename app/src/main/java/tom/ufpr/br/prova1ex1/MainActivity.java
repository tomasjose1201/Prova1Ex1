package tom.ufpr.br.prova1ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent it = new Intent(this, Main2Activity.class);
        Bundle params = new Bundle();
        EditText nome = (EditText)findViewById(R.id.editTextNome);
        params.putString("nome", nome.getText().toString());
        EditText nota1 = (EditText)findViewById(R.id.editTextNota1);
        params.putDouble("nota1", Double.parseDouble(nota1.getText().toString()));
        EditText nota2 = (EditText)findViewById(R.id.editTextNota2);
        params.putDouble("nota2", Double.parseDouble(nota2.getText().toString()));
        EditText frequencia = (EditText)findViewById(R.id.editTextFrequencia);
        params.putInt("frequencia", Integer.parseInt(frequencia.getText().toString()));
        it.putExtras(params);
        startActivity(it);
        finish();
    }
}
