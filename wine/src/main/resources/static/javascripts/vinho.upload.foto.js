/*namespace*/
var Wine = Wine || {};
					/*function anonima*/
Wine.UploadFoto = (function() {
	
	/*construtor de objeto*/
	function UploadFoto(){
		/*inicializa as variaveis*/
		/*var uploadDrop = $('#upload-drop'); deve ser chamado de this(orientado a objetos) quando ficar dentro do objeto UploadFoto*/
		this.uploadDrop = $('#upload-drop');
		this.containerFoto = $('.js-container-foto');
		
	}
	
	/*iniciando o objeto*/
	UploadFoto.prototype.iniciar = function(){

		var settings = {
				type: 'json',
				filelimit: 1,
				allow: '*.(jpg|jpeg|png)',
				action:'/fotos/' + this.uploadDrop.data('codigo'),
				complete: onUploadCompleto.bind(this),/*passa o contexto de this como parametro somente quando o upload estiver completo*/
				beforeSend: adicionarCsrfToken
		};
		
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);
	}

	/**/
	function adicionarCsrfToken(xhr){
		var header= $('input[name=_csrf_header]').val();
		var token=  $('input[name=_csrf]').val();
		xhr.setRequestHeader(header, token);
	}
	
	function onUploadCompleto(foto){
		 /*funcao para callback-retorno*/
		console.log('... resposta', foto.url);
		this.uploadDrop.addClass('hidden');
		this.containerFoto.prepend('<img src="' + foto.url + '" class="img-responsive" style="margin:auto;" />');
	}
	
	
	return UploadFoto;
	
})();/*para executar a funcao em javascript e so abrir e fechar parenteses*/


$(function(){
	console.log("Página carregada!"); 
	var uploadFoto = new Wine.UploadFoto();
	uploadFoto.iniciar();
});



