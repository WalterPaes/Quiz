package com.example.walterjunior.quiz;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    public TextView pergunta;
    public RadioButton rb1, rb2, rb3, rb4, rb5;
    public Button btnEnviar;
    public RadioGroup rg;
    private int c = 1;
    private int result = 0;
    private Pergunta perguntaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        pergunta = (TextView) findViewById(R.id.tvPergunta);
        rg = (RadioGroup) findViewById(R.id.rbAlternativas);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        if (c == 1) {
            insertPerguntas();
            setDisplay(pergunta, rb1, rb2, rb3, rb4, rb5);
        }

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectId = rg.getCheckedRadioButtonId();
                RadioButton selected = (RadioButton) rg.findViewById(selectId);

                String selecionado = (String) selected.getText();

                if (selecionado.equals(perguntaAtual.getrCerta())) {
                    result += 1;
                }

                c++;

                if (c <= 10) {
                    setDisplay(pergunta, rb1, rb2, rb3, rb4, rb5);
                } else {
                    double pct = (result / 10 * 100);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Quiz.this);
                    dlg.setTitle("Resultado");
                    dlg.setMessage("Você acertou " + pct + "% das questões!");
                    dlg.show();
                }
            }
        });

    }

    private void setDisplay(TextView pergunta, RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4, RadioButton rb5){
        buscaPergunta(c);
        String enunciado = Integer.toString(c) + ". " + perguntaAtual.getPergunta();
        pergunta.setText(enunciado);
        rb1.setText(perguntaAtual.getR1());
        rb2.setText(perguntaAtual.getR2());
        rb3.setText(perguntaAtual.getR3());
        rb4.setText(perguntaAtual.getR4());
        rb5.setText(perguntaAtual.getR5());
    }

    private void buscaPergunta(int id) {
        BancoController bd = new BancoController(getBaseContext());

        ArrayList<Pergunta> pergunta = bd.carregaPergunta(id);
        perguntaAtual = pergunta.get(0);
    }

    private void insertPerguntas() {
        BancoController bd = new BancoController(getBaseContext());

        Pergunta pergunta1 = new Pergunta(
                "Quem é o maior artilheiro do Manchester United?",
                "Ryan Giggs",
                "Van Persie",
                "Wayne Rooney",
                "Andy Cole",
                "Bobby Charlton",
                "Wayne Rooney"
        );
        bd.inserePergunta(pergunta1);

        Pergunta pergunta2 = new Pergunta(
                "Quem fez o gol do Manchester United na final do mundial de 99?",
                "Ryan Giggs",
                "Andy Cole",
                "Dwight Yorke",
                "Paul Scholes",
                "Roy Keane",
                "Roy Keane"
        );
        bd.inserePergunta(pergunta2);

        Pergunta pergunta3 = new Pergunta(
                "Quantos títulos ingleses possui o Manchester United?",
                "20",
                "19",
                "12",
                "6",
                "18",
                "20"
        );
        bd.inserePergunta(pergunta3);

        Pergunta pergunta4 = new Pergunta(
                "Quais os nomes dos integrantes da famosa United Trinity?",
                "Ryan Giggs, Paul Scholes e Gary Neville",
                "Bobby Charlton, Ryan Giggs e Eric Cantona",
                "Eric Cantona, Denis Law e Paul Scholes",
                "George Best, Alex Ferguson e Ryan Giggs",
                "George Best, Denis Law e Bobby Charton",
                "George Best, Denis Law e Bobby Charton"
        );
        bd.inserePergunta(pergunta4);

        Pergunta pergunta5 = new Pergunta(
                "Qual nome do jogador que mais vestiu a camisa do Manchester United?",
                "Wayne Rooney",
                "Paul Scholes",
                "Ryan Giggs",
                "David Beckham",
                "Eric Cantona",
                "Ryan Giggs"
        );
        bd.inserePergunta(pergunta5);

        Pergunta pergunta6 = new Pergunta(
                "Qual desses jogadores não vestiu a camisa 7 do Manchester United?",
                "Di Maria",
                "Ruud Van Nistelrooy",
                "Eric Cantona",
                "George Best",
                "David Beckham",
                "Ruud Van Nistelrooy"
        );
        bd.inserePergunta(pergunta6);

        Pergunta pergunta7 = new Pergunta(
                "Qual o nome do estádio do Manchester United?",
                "Theater of Dreams",
                "City of Manchester",
                "Old Trafford",
                "Sir Alex Ferguson Stand",
                "Wembley",
                "Old Trafford"
        );
        bd.inserePergunta(pergunta7);

        Pergunta pergunta8 = new Pergunta(
                "Qual o nome do treinador mais vencedor da história do Manchester United?",
                "Bobby Charlton",
                "Matt Busby",
                "David Moyes",
                "Alex Ferguson",
                "José Mourinho",
                "Alex Ferguson"
        );
        bd.inserePergunta(pergunta8);

        Pergunta pergunta9 = new Pergunta(
                "Em 1999, o Manchester United foi campeão da UEFA Champions League vencendo o Bayern de Munique por 2 a 1 com os dois gols marcados nos acréscimos do segundo tempo. Quais os jogadores que marcaram os gols?",
                "Teddy Sheringham e Old Gunnar Solskjaer",
                "Teddy Sheringham e Peter Schmeichel",
                "Peter Schmeichel e Andy Cole",
                "Peter Schmeichel e Ole Gunnar Solskjaer",
                "Ole Gunnar Solskjaer e Andy Cole",
                "Teddy Sheringham e Old Gunnar Solskjaer"
        );
        bd.inserePergunta(pergunta9);

        Pergunta pergunta10 = new Pergunta(
                "Contra qual adversário Robin Van Persie marcou seu primeiro gol com a camisa do Manchester United?",
                "Everton",
                "Arsenal",
                "Fulham",
                "Manchester City",
                "Southampton",
                "Fulham"
        );
        bd.inserePergunta(pergunta10);
    }
}
