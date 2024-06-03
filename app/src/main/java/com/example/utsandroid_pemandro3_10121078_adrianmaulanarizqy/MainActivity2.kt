//1012178-Adrian Maulana Rizqy-PemAndro3-3 Juni 2024
package com.example.utsandroid_pemandro3_10121078_adrianmaulanarizqy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Mengambil data dari Intent yang dikirimkan oleh MainActivity
        val tanggalDikonfirmasi = intent.getStringExtra("tanggal_dikonfirmasi")
        val nama = intent.getStringExtra("nama")
        val tanggalLahir = intent.getStringExtra("tanggal_lahir")
        val nik = intent.getStringExtra("nik")
        val jenisKelamin = intent.getStringExtra("jenis_kelamin")
        val jenisTes = intent.getStringExtra("jenis_tes")
        val hubunganKeluarga = intent.getStringExtra("hubungan_keluarga")

        // Menampilkan data yang diterima ke dalam TextView pada layout activity_main2.xml
        findViewById<TextView>(R.id.textView12).text = nama
        findViewById<TextView>(R.id.textView10).text = tanggalDikonfirmasi
        findViewById<TextView>(R.id.textView13).text = tanggalLahir
        findViewById<TextView>(R.id.textView11).text = nik
        findViewById<TextView>(R.id.textView14).text = jenisKelamin
        findViewById<TextView>(R.id.textView9).text = jenisTes
        findViewById<TextView>(R.id.textView16).text = hubunganKeluarga

        // Inisialisasi Button
        val btnBack = findViewById<Button>(R.id.button2)

        // Set onClickListener pada Button
        btnBack.setOnClickListener {
            // Buat Intent untuk kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup Activity saat ini agar tidak bisa kembali menggunakan tombol back
        }
        //Tambahkan fungsi untuk menampilkan popup saat tombol cek hasil diklik
        val btnCekHasil: Button = findViewById(R.id.button4)
        btnCekHasil.setOnClickListener {
            // Menampilkan popup
            showSuccessPopup()
        }
    }

    private fun showSuccessPopup() {
        // Inflate layout popup_success.xml
        val inflater: LayoutInflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.popup, null)

        // Membuat AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        // Membuat AlertDialog dari builder
        val dialog: AlertDialog = builder.create()

        // Mendapatkan tombol OK dari layout popup
        val btnOk: Button = view.findViewById(R.id.button_ok)
        btnOk.setOnClickListener {
            // Menutup popup ketika tombol OK diklik
            dialog.dismiss()
        }

        // Menampilkan popup
        dialog.show()
    }
}

