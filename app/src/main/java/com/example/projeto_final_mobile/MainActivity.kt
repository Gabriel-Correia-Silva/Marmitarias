package com.example.projeto_final_mobile

import Cadastro
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            // Inicie a nova atividade
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)

            // Destrua esta atividade
            finish()
        } else {
        // Mostre a tela de login
            val botaoEntrar = findViewById<Button>(R.id.botao_login)
            val botaoEsqueceuSenha = findViewById<Button>(R.id.botao_esqueceu_senha)
            val botaoCadastro = this.findViewById<Button>(R.id.botao_cadastro)
            val botaoLoginGoogle = findViewById<Button>(R.id.Login_google)

            // Configurar onClickListeners para os botões existentes

            botaoEntrar.setOnClickListener {

    
                val emailUser = findViewById<EditText>(R.id.email_login).text.toString()
                val passwordUser = findViewById<EditText>(R.id.senha_login).text.toString()

                // Crie a chave única para este usuário
                val userKey = "$emailUser-$passwordUser"

                val sharedPreferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE)

                // Recupera a senha
                val savedPassword = sharedPreferences.getString("$userKey-password", "")

                if (passwordUser == savedPassword) {
                
                // Salve o estado de login
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                // Inicie a nova atividade
                val intent = Intent(this, MainScreen::class.java)
                startActivity(intent)

                // Destrua esta atividade
                finish()
                    } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
                }
        }
         botaoEsqueceuSenha.setOnClickListener {
            // lógica para recuperação de senha
        }


            // Redirecione para a tela de cadastro
        botaoCadastro.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

        botaoLoginGoogle.setOnClickListener {
            // lógica de login com o Google
        }
        }

        

       



    }
}