/**
 * modal 레이어 팝업
 */
modal = {
	
	show : function(modalId, title, body, oklink, oktext) {
		$("#ModalLabel").text(title);
		$("#ModalBody").text(body);
		$("#btnModal")
		.attr("href", oklink)
		.text(oktext);
		
		$("#" + modalId).modal();
	}
}
