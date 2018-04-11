package tom.ufpr.br.prova1ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent it = getIntent();
        if(it != null) {
            Bundle params = it.getExtras();
            if(params != null) {
                String nome = params.getString("nome");
                double n1 = params.getDouble("nota1");
                double n2 = params.getDouble("nota2");
                int freq = params.getInt("frequencia");
                double media = calculaMedia(n1, n2);
                String situacao = buscaSituacao(media, freq);
                TextView tvMedia = (TextView)findViewById(R.id.textViewMedia);
                TextView tvSituacao = (TextView)findViewById(R.id.textViewSituacao);
                tvMedia.setText("Olá, " + nome + "\nSua média é: " + String.valueOf(media));
                tvSituacao.setText("Situação:\n" + situacao);
            }
        }
    }

    private double calculaMedia(double n1, double n2) {
        return (n1+n2)/2;
    }

    private String buscaSituacao(double media, int frequencia) {
        if (frequencia >= 75) {
            if (media >= 4) {
                if (media <= 6.9) {
                    return "Final";
                } else {
                    return "Aprovado";
                }
            } else {
                return "Reprovado por nota";
            }
        } else {
            return "Reprovado por falta";
        }
    }

    public void onClick(View view) {
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }
}
