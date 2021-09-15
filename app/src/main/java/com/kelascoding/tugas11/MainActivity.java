package com.kelascoding.tugas11;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //Deklarasi Variable
    private Button Play1, Pause1, Stop1, Play2, Pause2, Stop2, Play3, Pause3, Stop3, playVideo1, playVideo2, playVideo3;
    private MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;
    private VideoView videoView1, videoView2, videoView3;
    private MediaController mediaController1, mediaController2, mediaController3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Button
        Play1 = findViewById(R.id.play1);
        Pause1 = findViewById(R.id.pause1);
        Stop1 = findViewById(R.id.stop1);

        Play2 = findViewById(R.id.play2);
        Pause2 = findViewById(R.id.pause2);
        Stop2 = findViewById(R.id.stop2);

        Play3 = findViewById(R.id.play3);
        Pause3 = findViewById(R.id.pause3);
        Stop3 = findViewById(R.id.stop3);

        //Menambahkan Listener pada Button
        Play1.setOnClickListener(this::onClick);
        Pause1.setOnClickListener(this::onClick);
        Stop1.setOnClickListener(this::onClick);

        Play2.setOnClickListener(this::onClick);
        Pause2.setOnClickListener(this::onClick);
        Stop2.setOnClickListener(this::onClick);

        Play3.setOnClickListener(this::onClick);
        Pause3.setOnClickListener(this::onClick);
        Stop3.setOnClickListener(this::onClick);

        stateAwal();

        //Inisialisasi VideoView, MediaController dan Button
        videoView1 = findViewById(R.id.video1);
        playVideo1 = findViewById(R.id.plays1);
        mediaController1 = new MediaController(this);

        videoView2 = findViewById(R.id.video2);
        playVideo2 = findViewById(R.id.plays2);
        mediaController2 = new MediaController(this);

        videoView3 = findViewById(R.id.video3);
        playVideo3 = findViewById(R.id.plays3);
        mediaController3 = new MediaController(this);

        //Menjalankan Video saat tombol Play di Klik
        playVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.titipane_gusti_denny_caknan);

                videoView1.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView1.setMediaController(mediaController1);
                mediaController1.setAnchorView(videoView1);

                //Menjalankan Video
                videoView1.start();
            }
        });

        //Menjalankan Video saat tombol Play di Klik
        playVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.satru);

                videoView2.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView2.setMediaController(mediaController2);
                mediaController2.setAnchorView(videoView2);

                //Menjalankan Video
                videoView2.start();
            }
        });

        //Menjalankan Video saat tombol Play di Klik
        playVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.widodari);

                videoView3.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView3.setMediaController(mediaController3);
                mediaController3.setAnchorView(videoView3);

                //Menjalankan Video
                videoView3.start();
            }
        });


    }

    private void stateAwal() {
        Play1.setEnabled(true);
        Pause1.setEnabled(false);
        Stop1.setEnabled(false);

        Play2.setEnabled(true);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play3.setEnabled(true);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

    }

    //Method untuk memainkan musik
    private void playAudio1() {
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer1 = MediaPlayer.create(this, R.raw.denny_caknan_widodari);

        //Kondisi Button setelah tombol play di klik
        Play1.setEnabled(false);
        Pause1.setEnabled(true);
        Stop1.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer1.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer1.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk memainkan musik
    private void playAudio2() {
        mediaPlayer2 = MediaPlayer.create(this, R.raw.denny_caknan_happy_asmara_satru);

        Play2.setEnabled(false);
        Pause2.setEnabled(true);
        Stop2.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer2.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer2.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk memainkan musik
    private void playAudio3() {
        mediaPlayer3 = MediaPlayer.create(this, R.raw.denny_caknan_titipane_gusti);

        Play3.setEnabled(false);
        Pause3.setEnabled(true);
        Stop3.setEnabled(true);

        //Menjalankan Audio / Musik
        try {
            mediaPlayer3.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer3.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });

    }

    //Method untuk mengentikan musik
    private void pauseAudio1() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer1.isPlaying()) {
            if (mediaPlayer1 != null) {
                mediaPlayer1.pause();
                Pause1.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer1 != null) {
                mediaPlayer1.start();
                Pause1.setText("Pause");
            }
        }

    }

    //Method untuk mengentikan musik
    private void pauseAudio2() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer2.isPlaying()) {
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
                Pause2.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                Pause2.setText("Pause");
            }
        }
    }

    //Method untuk mengentikan musik
    private void pauseAudio3() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer3.isPlaying()) {
            if (mediaPlayer3 != null) {
                mediaPlayer3.pause();
                Pause2.setText("Lanjutkan");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer3 != null) {
                mediaPlayer3.start();
                Pause3.setText("Pause");
            }
        }

    }

    //Method untuk mengakhiri musik
    private void stopAudio1() {
        mediaPlayer1.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer1.prepare();
            mediaPlayer1.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();

    }

    //Method untuk mengakhiri musik
    private void stopAudio2() {
        mediaPlayer2.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer2.prepare();
            mediaPlayer2.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    //Method untuk mengakhiri musik
    private void stopAudio3() {
        mediaPlayer3.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer3.prepare();
            mediaPlayer3.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play1:
                playAudio1();
                break;

            case R.id.pause1:
                pauseAudio1();
                break;

            case R.id.stop1:
                stopAudio1();
                break;

            case R.id.play2:
                playAudio2();
                break;

            case R.id.pause2:
                pauseAudio2();
                break;

            case R.id.stop2:
                stopAudio2();
                break;

            case R.id.play3:
                playAudio3();
                break;

            case R.id.pause3:
                pauseAudio3();
                break;

            case R.id.stop3:
                stopAudio3();
                break;
        }
    }
}
