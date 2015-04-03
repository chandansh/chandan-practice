AUI().ready(
	function() {
	}
);

Liferay.Portlet.ready(
	function(portletId, node) {
		/*
		if(window && window.console && window.console.log) {
			window.console.log("[Portlet-ready] id:" + portletId + ", node=" + node);
		}
		//*/
	}
);

Liferay.on(
	'allPortletsReady',
	function() {
	}
);