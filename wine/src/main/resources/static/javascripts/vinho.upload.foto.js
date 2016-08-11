$(function() {
	/* console.log("Página carregada!"); */
	
	var uploadDrop = $('#upload-drop');
	var settings = {
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)',
			action:'/fotos/' + uploadDrop.data('codigo'),
			complete: function(foto){ /*funcao para callback-retorno*/
				console.log('... resposta', foto.nome);
			}
	};
	
	UIkit.uploadSelect($('#upload-select'), settings);
	UIkit.uploadDrop($('#upload-drop'), settings);
});