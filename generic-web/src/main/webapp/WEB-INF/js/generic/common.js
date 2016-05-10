(function() {
	window.generic = window.generic || {
		resolveResponse : function(response, callBack) {
			if (!response.data.success) {
				console.error("ERROR->", response);
			}else{
				if (callBack == undefined){
					if (!response.data.message){
						alert("Success!");
					}else{
						alert(response.data.message)
					}
				}else{
					callBack();
				}
			}
		}
	};
})();