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

	// Normal tags
	private normal(tag, attrs, body) {
		// attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")
		return """
		<${tag} ${attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")}>
			${body()}
		</${tag}>"""
	}	
	def window = { attrs, body ->
		def apply = attrs.remove("apply")
		if(apply) {
			// generate event handlers
		}
		out << normal("combobox", attrs, body)
	}
	def combobox = { attrs, body ->
		out << normal("combobox", attrs, body)
	}
	
	// border layout
	def borderlayout = { attrs, body ->
		out << normal("borderlayout", attrs, body)
	}
	def north = { attrs, body ->
		out << normal("north", attrs, body)
	}
	def west = { attrs, body ->
		out << normal("west", attrs, body)
	}
	def east = { attrs, body ->
		out << normal("east", attrs, body)
	}
	def south = { attrs, body ->
		out << normal("south", attrs, body)
	}
	def center = { attrs, body ->
		out << normal("center", attrs, body)
	}
	
	// tree	
	def tree = { attrs, body ->
		out << normal("tree", attrs, body)
	}
	def treechildren = { attrs, body ->
		out << normal("treechildren", attrs, body)
	}
	def treeitem = { attrs, body ->
		out << normal("treeitem", attrs, body)
	}

	def div = { attrs, body ->
		out << normal("div", attrs, body)
	}
	def include = { attrs, body ->
		out << normal("include", attrs, body)
	}
	def iframe = { attrs, body ->
		out << normal("iframe", attrs, body)
	}
	def hbox = { attrs, body ->
		out << normal("hbox", attrs, body)
	}
	def vbox = { attrs, body ->
		out << normal("vbox", attrs, body)
	}

	// Leaf tags	
	private leaf(tag, attrs) {
		return "<${tag} ${attrs.collect { k, v -> "${k}=\"${v}\""}.join(" ")}/>"
	}
	
	def comboitem = { attrs, body ->
		out << leaf("comboitem", attrs)
	}	
	def separator = { attrs, body ->
		out << leaf("separator", attrs)
	}
	def toolbarbutton = { attrs, body ->
		out << leaf("toolbarbutton", attrs)
	}
	def label = { attrs, body ->
		out << leaf("label", attrs)		
	}
}
