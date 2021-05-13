package com.example.magicball;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.magicball.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton Ball;
    private TextView respuesta;
    private EditText pregunta;
    private String [] respuestaArray={"Es cierto", "Definitivamente es así",
            "Sin duda", "Sí definitivamente", "Puede confiar en él", "Como yo lo veo, sí", "Lo más probable",
            "Perspectiva buena", "Sí", "Las señales apuntan a sí", "Respuesta confusa intente de nuevo",
            "Pregunte de nuevo más tarde", "Mejor no decirte ahora", "No puedo predecir ahora", "Concéntrate y pregunta de nuevo",
            "No cuentes con eso", "Mi respuesta es no", "Mis fuentes dicen que no", "Outlook no es tan bueno", "Muy dudoso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencia la imagen
        Ball=findViewById(R.id.btn);

        //referencia texto
        respuesta=findViewById(R.id.respuestavista);

        //referencia input pregunta
        pregunta = findViewById(R.id.question);

        //proceso
        Ball.setOnClickListener(this);
        Toast.makeText(MainActivity.this, "Consulta tu Suerte", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v){
        //creacion metodo switch
        switch (v.getId()){
            case R.id.btn:

                int rand = new Random().nextInt(respuestaArray.length);
                //se valida que pregunta no este vacia
                if ( pregunta.getText().length() == 0 ){
                    respuesta.setText("...");
                    AlertDialog.Builder mybuilder = new AlertDialog.Builder(this);
                    mybuilder.setMessage("Debe escribir su pregunta");
                    mybuilder.setTitle("Error");
                    mybuilder.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog dialog = mybuilder.create();
                    dialog.show();

                }else {
                    //luego de presionar el boton, se limpia el input
                    pregunta.setText("");
                    respuesta.setText(respuestaArray[rand]);
                }
                break;
        }
    }
}