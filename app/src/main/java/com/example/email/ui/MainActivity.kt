package com.example.email.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.email.databinding.ActivityMainBinding
import com.example.email.models.Email

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var emailAdapter: EmailAdapter
    private var emailList = mutableListOf<Email>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setupRecyclerView()

        binding.newEmailButton.setOnClickListener {
            startActivity(Intent(this, ComposeEmailActivity::class.java))
        }

        binding.filterButton.setOnClickListener {
            // Lógica para aplicar filtros
            showFilterOptions()
        }

        binding.logoutButton.setOnClickListener {
            // Lógica para logout
            logout()
        }

        // Carregar emails iniciais
        loadEmails()
    }

    private fun setupRecyclerView() {
        emailAdapter = EmailAdapter(emailList) { email ->
            // Lógica ao clicar no email
            val intent = Intent(this, EmailDetailActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = emailAdapter
        }
    }

    private fun loadEmails() {
        emailList = getEmails().toMutableList()
        emailAdapter.notifyDataSetChanged()
    }

    private fun getEmails(): List<Email> {
        // Aqui você pode buscar emails de uma API ou banco de dados
        return listOf(
            Email(1, "Pessoa 1", "pessoa1@example.com", "Assunto 1", "Mensagem do email 1", System.currentTimeMillis()),
            Email(2, "Pessoa 2", "pessoa2@example.com", "Assunto 2", "Mensagem do email 2", System.currentTimeMillis()),
            Email(3, "Pessoa 3", "pessoa3@example.com", "Assunto 3", "Mensagem do email 3", System.currentTimeMillis())
        )
    }

    private fun showFilterOptions() {
        val options = arrayOf("Todos", "Contatos", "Prioritários", "Não lidos")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Filtrar por remetente")
        builder.setItems(options) { dialog, which ->
            when (options[which]) {
                "Todos" -> loadEmails()
                else -> applyFilters(options[which])
            }
        }
        builder.show()
    }

    private fun applyFilters(filter: String) {
        // Filtrar emails pelo remetente selecionado
        val filteredEmails = emailList.filter { it.sender == filter }
        emailAdapter = EmailAdapter(filteredEmails) { email ->
            val intent = Intent(this, EmailDetailActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
        binding.recyclerView.adapter = emailAdapter
    }

    private fun logout() {
        // Lógica para logout, por exemplo, limpar dados do usuário e redirecionar para a tela de login
        // Aqui você pode adicionar a lógica para limpar as preferências compartilhadas ou o banco de dados do usuário
        finish()
    }
}
