// Desafio: Evoluir as classes modeladas para um domínio educacional

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String) {
    // Adicione propriedades e métodos relevantes para um usuário
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    // Adicione propriedades e métodos relevantes para um conteúdo educacional
}

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome.")
    }

    fun exibirDetalhes() {
        println("Formação: $nome")
        println("Conteúdos:")
        conteudos.forEach { println("- ${it.nome}, Duração: ${it.duracao} minutos") }
        println("Inscritos:")
        inscritos.forEach { println("- ${it.nome}, Email: ${it.email}") }
    }
}

fun main() {
    // Simulação de cenários de teste
    val usuario1 = Usuario("João", "joao@email.com")
    val usuario2 = Usuario("Maria", "maria@email.com")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacao = Formacao("Desenvolvimento Kotlin")
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.adicionarConteudo(conteudo1)
    formacao.adicionarConteudo(conteudo2)

    formacao.exibirDetalhes()
}
