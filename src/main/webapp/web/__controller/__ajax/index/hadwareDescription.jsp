
<%@page import="entity.Hardware"%>
<%@page import="service.ServiceHardware"%>
<%@page import="entity.Level1"%>
<%@page import="service.ServiceLevel1"%>
<%@page import="domaine.Design"%>

<%

    String idHardware = request.getParameter("idHardware");
    Hardware hardware = ServiceHardware.find(Integer.parseInt(idHardware));


%>
<div class="w3-row">
    <div class="w3-col l12">
        <div class="w3-white w3-round w3-padding ">
            <div class="w3-padding">
                <div class="w3-panel">
                    <span class="w3-padding-small w3-round w3-dark-gray w3-text-light-gray ">Nom de l'appareil</span>
                    <span class="w3-padding-small w3-round w3-white w3-border "><%=hardware.getName()%></span>
                </div>
                <div class="w3-panel">
                    <span class="w3-padding-small w3-round w3-dark-gray w3-text-light-gray ">Date de Création</span>
                    <span class="w3-padding-small w3-round w3-white w3-border "><%=hardware.getDateCreation().toLocaleString()%></span>

                </div>
                <div class="w3-panel">
                    <%if (hardware.getActive()) {%>

                    <span class="w3-padding-small w3-round w3-dark-gray w3-text-light-gray ">Status</span>
                    <span class="w3-padding-small w3-round w3-white w3-border w3-text-green">Activé</span>


                    <%} else {%>

                    <span class="w3-padding-small w3-round w3-dark-gray w3-text-light-gray ">Status</span>
                    <span class="w3-padding-small  w3-round w3-white w3-border w3-text-pink">Non Activé</span>


                    <%}%>
                </div>
                
            </div>
        </div>       

    </div>
</div>

