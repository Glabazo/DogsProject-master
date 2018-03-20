package com.example.hp1.dog;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.ByteArrayInputStream;

public class ShowPics extends AppCompatActivity {

    Bitmap bitmap;
    DbHandiling dbHandiling;

    //need to fix exception
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pics);
        dbHandiling=new DbHandiling(this);
        Cursor res=dbHandiling.getAllData();

        //ERROR

      if(res!=null&&res.getCount()>0)
        {
            for (int i=0;res.moveToNext();i++){
                byte[] bytes=res.getBlob(i);
                bitmap= BitmapFactory.decodeByteArray(bytes , 0, bytes .length);
            }
        }

    }

    public Bitmap ByteArrayToBitmap(byte[] byteArray)
    {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArray);
         bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }
}
