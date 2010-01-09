class ZkLightTagLib {

	static namespace="z"

	def head = { attrs, body ->
		// TODO remove after dev		
		def path = servletContext.contextPath + "/plugins/zk-light-0.1"
		out << """
	<link rel=\"stylesheet\" type=\"text/css\" href=\"${path}/css/zk.css\"/>
	<script type=\"text/javascript\" src=\"${path}/js/zk-all.js\" charset="UTF-8">
	</script>
	<script type=\"text/javascript\" src=\"${path}/js/zuml.js\" charset="UTF-8">
	</script>
	<script type=\"text/javascript\" src=\"${path}/js/lang.js\" charset="UTF-8">
	</script>
"""
	}

	def page = { attrs, body ->
		out << """
		<div id=\"zk\">
			<!--
				${body()}
			-->
		</div>
		<script>
			var main = zk.zuml.Parser.createAt('#zk');
		</script>
"""
	}
	
	def window = { attrs, body ->
		def apply = attrs.remove("apply")
		if(apply) {
			// generate event handlers
		}
		// attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")
		out << """
		<window ${attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")}>
			${body()}
		</window>
"""
	}
	
	def combobox = { attrs, body ->
		out << """
		<combobox ${attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")}>
			${body()}
		</combobox>
"""		
	}
	
	def comboitem = { attrs, body ->
		out << "<comboitem ${attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")}/>"
	}
	
	def separator = { attrs, body ->
		out << "<separator ${attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")}/>"
	}
}
