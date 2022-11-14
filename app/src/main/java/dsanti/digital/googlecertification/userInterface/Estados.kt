package dsanti.digital.googlecertification.userInterface



data class Estado(
    val nome:String = "",
    val capital: String = "",
    val descricao:String = "",
    val image_url: String = ""
)

data class Regiao(
    val name: String = "",
    val estados: List<Estado> = listOf()
)

data class Brasil(
    val regioes: List<Regiao> = regioesList
)

val Nordeste = listOf(
    Estado("Alagoas", "Maceio", "Alagoas é um pequeno estado do nordeste brasileiro cujo litoral tropical é marcado por praias de areia branca repletas de palmeiras, lagoas cristalinas e recifes de corais. Em Maceió, sua capital, estão localizadas as famosas praias Pajuçara e Ponta Verde, com hotéis, bares e restaurantes. Os recifes de corais decoram o litoral ao norte de Maceió que, por isso, tem o apelido de Costa dos Corais.", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Bandeira_de_Alagoas.svg/500px-Bandeira_de_Alagoas.svg.png"),
    Estado("Bahia", "Salvador", "A Bahia é um estado do nordeste brasileiro com paisagens que variam da costa tropical até a aridez do Sertão.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/Bandeira_da_Bahia.svg/500px-Bandeira_da_Bahia.svg.png"),
    Estado("Ceará", "Fortaleza", "O Ceará é uma das 27 unidades federativas do Brasil. Está situado no norte da Região Nordeste e tem por limites o Oceano Atlântico a norte e nordeste, Rio Grande do Norte e Paraíba a leste, Pernambuco ao sul e Piauí a oeste.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Bandeira_do_Cear%C3%A1.svg/500px-Bandeira_do_Cear%C3%A1.svg.png"),
    Estado("Maranhão", "São Luís", "Maranhão, estado no nordeste brasileiro, é formado em parte pela Floresta Amazônica e pelas praias ao longo do Oceano Atlântico. Próximo à cidade de Barreirinhas, grandes dunas de areia branca criam paisagens que lembram um deserto no Parque Nacional Lençóis Maranhenses, onde lagoas de água fresca nas quais se pode nadar se formam durante a temporada de chuvas.", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/45/Bandeira_do_Maranh%C3%A3o.svg/500px-Bandeira_do_Maranh%C3%A3o.svg.png"),
    Estado("Paraíba", "João Pessoa", "Paraíba, um estado no nordeste do Brasil, é conhecido pela linha da costa tropical e pela arquitetura colonial portuguesa. A capital, João Pessoa, possui praias como a Manaíra e Tambaú, além de locais de mergulho repletos de corais ao largo da costa. Junto ao rio Paraíba, o centro histórico da cidade possui casas coloridas e a igreja de São Francisco, com uma arquitetura barroca.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Bandeira_da_Para%C3%ADba.svg/500px-Bandeira_da_Para%C3%ADba.svg.png"),
    Estado("Pernambuco", "Recife", "Pernambuco é um estado no nordeste do Brasil, no Oceano Atlântico. A sua capital moderna, o Recife, inclui um porto, a cidade velha e a popular área balnear de Boa Viagem. ", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Bandeira_de_Pernambuco.svg/500px-Bandeira_de_Pernambuco.svg.png"),
    Estado("Piauí", "Teresina", "Piauí é um estado no nordeste do Brasil conhecido pelos parques nacionais. O Parque Nacional Serra da Capivara, no sudeste, possui sítios arqueológicos com pinturas rupestres pré-históricas.", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/33/Bandeira_do_Piau%C3%AD.svg/500px-Bandeira_do_Piau%C3%AD.svg.png"),
    Estado("Rio Grande do Norte", "Natal", "Rio Grande do Norte é um estado na extremidade nordeste do Brasil. A capital, Natal, fica numa costa repleta de praias onde se encontra o Forte dos Reis Magos, em forma de estrela, um forte português do século XVI. ", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Bandeira_do_Rio_Grande_do_Norte.svg/500px-Bandeira_do_Rio_Grande_do_Norte.svg.png"),
    Estado("Sergipe", "Aracaju", "Sergipe, o estado mais pequeno do Brasil, situa-se na costa atlântica da região do nordeste.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Bandeira_de_Sergipe.svg/500px-Bandeira_de_Sergipe.svg.png"),
)

val regioesList = listOf(
    Regiao("Norte", Nordeste),
    Regiao("Nordeste", Nordeste),
    Regiao("Centro-Oeste", Nordeste),
    Regiao("Sudeste", Nordeste),
    Regiao("Sul", Nordeste),
)


