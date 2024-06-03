//1012178-Adrian Maulana Rizqy-PemAndro3-3 Juni 2024
package com.example.utsandroid_pemandro3_10121078_adrianmaulanarizqy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var etNama: EditText
    private lateinit var etDate: EditText
    private lateinit var etBirth: EditText
    private lateinit var etNIK: EditText
    private lateinit var rbKelamin1: RadioButton
    private lateinit var rbKelamin2: RadioButton
    private lateinit var rbTes1: RadioButton
    private lateinit var rbTes2: RadioButton
    private lateinit var rbHubungan1: RadioButton
    private lateinit var rbHubungan2: RadioButton
    private lateinit var rbHubungan3: RadioButton
    private lateinit var rbHubungan4: RadioButton
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi EditText
        etDate = findViewById(R.id.et_date)
        etNama = findViewById(R.id.et_nama)
        etBirth = findViewById(R.id.et_birth)
        etNIK = findViewById(R.id.et_nik)

        // Inisialisasi RadioButton
        rbKelamin1 = findViewById(R.id.rb_kelamin1)
        rbKelamin2 = findViewById(R.id.rb_kelamin2)
        rbTes1 = findViewById(R.id.rb_tes1)
        rbTes2 = findViewById(R.id.rb_tes2)
        rbHubungan1 = findViewById(R.id.rb_hub1)
        rbHubungan2 = findViewById(R.id.rb_hub2)
        rbHubungan3 = findViewById(R.id.rb_hub3)
        rbHubungan4 = findViewById(R.id.rb_4)

        // Inisialisasi Button
        btnNext = findViewById(R.id.button)

        // Set onClickListener pada Button
        btnNext.setOnClickListener {
            // Buat Intent untuk berpindah ke Activity kedua
            val intent = Intent(this, MainActivity2::class.java)

            // Sisipkan data yang akan dilempar ke Activity kedua
            intent.putExtra("nama", etNama.text.toString())
            intent.putExtra("tanggal_dikonfirmasi",etDate.text.toString())
            intent.putExtra("tanggal_lahir", etBirth.text.toString())
            intent.putExtra("nik", etNIK.text.toString())

            // Cek RadioButton yang dipilih dan sisipkan nilainya ke Intent
            if (rbKelamin1.isChecked) {
                intent.putExtra("jenis_kelamin", "Laki-Laki")
            } else if (rbKelamin2.isChecked) {
                intent.putExtra("jenis_kelamin", "Perempuan")
            }

            if (rbTes1.isChecked) {
                intent.putExtra("jenis_tes", "Rapid Antigen")
            } else if (rbTes2.isChecked) {
                intent.putExtra("jenis_tes", "PCR")
            }
            // Cek RadioButton untuk hubungan keluarga dan sisipkan nilainya ke Intent
            if (rbHubungan1.isChecked) {
                intent.putExtra("hubungan_keluarga", "Orang tua")
            } else if (rbHubungan2.isChecked) {
                intent.putExtra("hubungan_keluarga", "Suami/Istri")
            } else if (rbHubungan3.isChecked) {
                intent.putExtra("hubungan_keluarga", "Anak")
            } else if (rbHubungan4.isChecked) {
                intent.putExtra("hubungan_keluarga", "Kerabat Lainnya")
            }

            // Mulai Activity kedua
            startActivity(intent)
        }
    }
}


