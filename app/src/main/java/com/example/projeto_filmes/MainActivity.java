package com.example.projeto_filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView nome, genero, descricao;
    Button btnCarregaDados;

    String url_json = "http://192.168.15.10/Projeto-Movies/informacoes.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.txtNome);
        genero = findViewById(R.id.txtGenero);
        descricao = findViewById(R.id.txtDescricao);

        btnCarregaDados = findViewById(R.id.btnCarregaInformacoes);

        btnCarregaDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_json, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    nome.setText(response.getString("Nome"));
                                    genero.setText(response.getString("Genero"));
                                    descricao.setText(response.getString("Descricao"));
                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(),
                                            "Nenhum nome encontrado...",
                                            Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao carregar as informações",
                                Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestque(jsonObjectRequest);
            }
        });
    }
}
