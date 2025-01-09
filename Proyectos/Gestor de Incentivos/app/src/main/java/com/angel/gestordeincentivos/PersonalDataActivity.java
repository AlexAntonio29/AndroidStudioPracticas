package com.angel.gestordeincentivos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonalDataActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SELECT_IMAGE = 1;

    Context context;
    Button bGuardar, bRegresar;
    ImageButton bCamera;
    LinearLayout mparent;
    ImageView ivFoto;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        this.context=this;

        ivFoto=findViewById(R.id.imageCuenta);
        mparent=findViewById(R.id.llContenedorDatosPersonales);
        bGuardar= findViewById(R.id.bGuardarPersonalData);
        bRegresar=findViewById(R.id.bRegresarDatosPersonales);
        bCamera=findViewById(R.id.ibEditCamera);



        LayoutInflater inflater= LayoutInflater.from(context);



        loadSavedImage();



        String[] listaDatosPersonales={"Nombre","Apellidos","Numero Telefonico","Email"};
        String[] listaEtx={"Ingrese el Nombre", "Ingrese el apellido","Ingrese su numero telefonico", "Ingrese su correo"};


        for (int i=0;i<listaDatosPersonales.length;i++){

            View myview =inflater.inflate(R.layout.item_datos_personales,null,false);

            TextView titulo= myview.findViewById(R.id.tvTitleDatosPersonales);
            EditText getText=myview.findViewById(R.id.etText);

            titulo.setText(listaDatosPersonales[i]);
            getText.setHint(listaEtx[i]);


            mparent.addView(myview);




        }

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        bRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


bCamera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*"); // Selecciona solo imágenes
        startActivityForResult(intent, 1); // 1 es el código de solicitud
    }
});

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData(); // Obtener URI de la imagen seleccionada

            if (selectedImageUri != null) {
                try {
                    // Mostrar la imagen en el ImageView
                    ivFoto.setImageURI(selectedImageUri);

                    // Guardar la imagen en el almacenamiento interno
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);

                    File directory = getDir("images", Context.MODE_PRIVATE); // Directorio interno
                    File imageFile = new File(directory, "default_image.jpg");
                    FileOutputStream fos = new FileOutputStream(imageFile);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.close();

                    Toast.makeText(this, "Imagen guardada y mostrada correctamente", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Error al guardar la imagen", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    private void loadSavedImage() {
        try {
            // Directorio interno donde se guardó la imagen
            File directory = getDir("images", Context.MODE_PRIVATE);
            File imageFile = new File(directory, "default_image.jpg");

            if (imageFile.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                ivFoto.setImageBitmap(bitmap); // Cargar la imagen en el ImageView
            } else {
                Toast.makeText(this, "No se encontró una imagen guardada", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al cargar la imagen guardada", Toast.LENGTH_SHORT).show();
        }
    }


}


