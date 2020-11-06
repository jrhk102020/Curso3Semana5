package com.yaritzapech.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ContactoActivity extends AppCompatActivity {

    private Button buttonEnviar;
    private EditText TextMail;
    private EditText TextAsunto;
    private EditText TextMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);



        TextMail = (EditText) findViewById(R.id.etCorreo);
        TextAsunto = (EditText) findViewById(R.id.etNombre);
        TextMensaje = (EditText) findViewById(R.id.etMensaje);

        buttonEnviar = (Button) findViewById(R.id.btnContacto);

   //     assert btnSiguiente != null;
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        //Adding click listener
        //buttonEnviar.setOnClickListener(this);


        //agrega la toolbar
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //agrega la flecha hacia atras.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.huella);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }


    private void sendEmail() {

        Toast.makeText(this, "Email!", Toast.LENGTH_SHORT).show();

        //Getting content for email
        String email = TextMail.getText().toString().trim();
        String subject = TextAsunto.getText().toString().trim();
        String message = TextMensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    /*
    public void onClick(View v) {
        sendEmail();
    }
    */

}
