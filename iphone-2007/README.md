```mermaid
classDiagram
    Main --> Iphone2007
    Iphone2007 ..|> ReprodutorMusical
    Iphone2007 ..|> AparelhoTelefonico
    Iphone2007 ..|> NavegadorInternet

    class ReprodutorMusical {
      + void tocar()
      + void pausar()
      + void selecionarMusica(String musica)
    }

    class AparelhoTelefonico {
      + void ligar(String numero)
      + void atender()
      + void iniciarCorreioDeVoz()
    }

    class NavegadorInternet {
      + void exibirPagina(String url)
      + void adicionarNovaAba()
      + void atualizarPagina()
    }

    class Iphone2007 {
    }

    class Main
