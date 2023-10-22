// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val usuario1 = Usuario()
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 90, Nivel.AVANCADO)
    val conteudo3 = ConteudoEducacional("Fundamentos de Matemática", 60, Nivel.INTERMEDIARIO)
    
    val formacao1 = Formacao("Desenvolvimento em Kotlin", listOf(conteudo1, conteudo2))
    formacao1.matricular(usuario1)
    
    println("Formação: ${formacao1.nome}")
    println("Inscritos na formação:")
    
    if (formacao1.inscritos.isNotEmpty()) {
        formacao1.inscritos.forEachIndexed { index, usuario ->
            println("${index + 1}. Nome: ${usuario::class.simpleName}, HashCode: ${usuario.hashCode()}")
        }
    } else {
        println("Nenhum inscrito na formação ainda.")
    }
}

