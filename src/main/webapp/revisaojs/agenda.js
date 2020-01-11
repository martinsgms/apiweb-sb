	function mostrarNome() {
		var campoNome = document.getElementById("txtNome");
		var nome = campoNome.value;

		var painel = document.getElementById("painel");
		painel.innerText = nome;
	}

	function addCampo() {
		var listaContatos = document.getElementById("listaContatos");

		var labelContato = document.createElement("label");
		var inputContato = document.createElement("input");
		var btnDeletar = document.createElement("input");
		var br = document.createElement("br");
		var linha = document.createElement("div");

		inputContato.setAttribute("name","txtContato");
		btnDeletar.setAttribute("type", "button");
		btnDeletar.setAttribute("value", "x");
		labelContato.innerText = "Contato: ";

		linha.appendChild(labelContato);
		linha.appendChild(inputContato);
		linha.appendChild(btnDeletar);
		linha.appendChild(br);

		btnDeletar.onclick = function(){
			listaContatos.removeChild(linha);
		};

		listaContatos.appendChild(linha);
	}

	function salvar() {
		var arrayInputContatos = document.formContatos.txtContato;
		var painelContatos = document.getElementById("painelContatos");
		var nome = document.getElementById("txtNome");
		var pContato = "Contatos - " + nome.value + "<br>";

		for (var i = 0; i < arrayInputContatos.length; i++) {
			pContato += i + ": "+ arrayInputContatos[i].value + "<br>";
			pContato.innerText = arrayInputContatos[i].value;
			painelContatos.innerHTML = pContato;
		}
		painelContatos.innerHTML += "<hr><br>";
	}