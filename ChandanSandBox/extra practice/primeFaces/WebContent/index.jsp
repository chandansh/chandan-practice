
<%@page import="com.test.DocumentsController"%>
<%@page isELIgnored="false" %>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui">

<h:head>

<%
	DocumentsController documentsController = new DocumentsController();
	request.setAttribute("documentsController", documentsController);
%>
</h:head>

<h:body>

	<h:form>

		<p:treeTable value="#{documentsController.root}" var="document">
			<f:facet name="header">  
            Document Viewer  
        </f:facet>

			<p:column style="width:150px">
				<f:facet name="header">  
                Name  
            </f:facet>
				<h:outputText value="#{document.name}" />
			</p:column>

			<p:column style="width:100px">
				<f:facet name="header">  
                Size  
            </f:facet>
				<h:outputText value="#{document.size}" />
			</p:column>

			<p:column style="width:100px">
				<f:facet name="header">  
                Type  
            </f:facet>
				<h:outputText value="#{document.type}" />
			</p:column>

			<p:column style="width:20px">
				<p:commandLink update="documentPanel"
					oncomplete="documentDialog.show()" title="View Detail"
					styleClass="ui-icon ui-icon-search">
					<f:setPropertyActionListener value="#{document}"
						target="#{documentsController.selectedDocument}" />
				</p:commandLink>
			</p:column>
		</p:treeTable>

		<p:dialog header="Document Detail" showEffect="fade"
			widgetVar="documentDialog" modal="true">
			<p:outputPanel id="documentPanel">
				<h:panelGrid columns="2" cellpadding="5"
					rendered="#{not empty documentsController.selectedDocument}">
					<h:outputLabel for="name" value="Name: " />
					<h:outputText id="name"
						value="#{documentsController.selectedDocument.name}"
						style="font-weight:bold" />

					<h:outputLabel for="size" value="Size: " />
					<h:outputText id="size"
						value="#{documentsController.selectedDocument.size}"
						style="font-weight:bold" />

					<h:outputLabel for="type" value="Type " />
					<h:outputText id="type"
						value="#{documentsController.selectedDocument.type}"
						style="font-weight:bold" />
				</h:panelGrid>
			</p:outputPanel>
		</p:dialog>

	</h:form>

</h:body>
</html>
