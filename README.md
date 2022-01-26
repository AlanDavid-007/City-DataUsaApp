# Cities | População dos estados americanos
* Linguagem de programação utilizada ```Kotlin```
* Ferramenta de desenvolvimento utilizada ```Android Studio```
* Arquitetura do projeto ```MVP```
* Android ```6.0 | Marshmallow```
* API ```23```

Desafio proposto pela [WS WORK SISTEMAS](https://www.wswork.com.br/) para a criação de um aplicativo android com os seguintes critérios:
* Criar um app android em java ou kotlin que carregue dados da seguinte [API](https://datausa.io/api/data?drilldowns=State&measures=Population&year=latest).
* O App deve seguir a estrutura da imagem abaixo.

![wirefreme](https://user-images.githubusercontent.com/59364674/148001859-6be7a344-468c-4fbe-af2b-c71013c3dc7f.png)

* Ao salvar um item, salvar apenas em memória.
* O dado alterado deve refletir na lista.
* Disponibilizar o código fonte no github.

Atividade extra:
* se o candidato quiser, pode salvar os dados no armazenamento local do dispositivo mobile (pode usar algum banco de dados, como o SQLite) 

Permissões do Android Manisfest
 ```
 <uses-permission android:name="android.permission.INTERNET" />
 ```
Rotas e links da API disponíveis
```
https://datausa.io/api/data?drilldowns=State&measures=Population&year=latest
```

Bibliotecas de terceiros
```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'
```

 Links úteis:
 * [DATA USA](https://datausa.io/)
 * [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)
 * [OkHttp](https://github.com/square/okhttp)
 * [Retrofit](https://github.com/square/retrofit)
 * [WS WORK SISTEMAS](https://www.wswork.com.br/)
