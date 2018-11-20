<%@page import="service.ServiceLevel3"%>
<%@page import="entity.Level3"%>
<%@page import="service.ServiceLevel2"%>
<%@page import="entity.Level2"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="service.ServiceHardware"%>
<%@page import="domaine.Design"%>
<%@page import="entity.Level1"%>
<%@page import="service.ServiceLevel1"%>
<%@page import="entity.Hardware"%>








<div class="card-group">

    <%                try {
            String idHardware = request.getParameter("idHardware");
            boolean afficher = false;

            if (isInteger(idHardware)) {
                Hardware hardware = ServiceHardware.find(Integer.parseInt(idHardware));
                if (hardware == null) {
                    afficher = true;
                }
            } else {
                afficher = true;
            }

    %>

    <%        if (afficher == true) {
    %>

    <div class="card">
        <div class="card-header">
            Ajouter mon Appareil
        </div>
        <div class="card-body">
            <form name="f_index2" method="get" >
                <div class="form-group">
                    <label for="exampleInputEmail1">Nom de l'appareil</label>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">
                                <i class="fa fa-television"></i>
                            </span>
                        </div>
                        <input name="name" type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Poste</label>
                    <select  name="idLigne" class="form-control w3-white w3-hover-border-blue"  id="exampleFormControlSelect1">
                        <%
                            for (Level1 level1 : ServiceLevel1.findAll()) {
                        %>
                        <option value="<%=level1.getId()%>" class="w3-input">
                            <%=level1.getName()%>
                        </option>
                        <%
                            }
                        %>
                        <%
                            for (Level2 level2 : ServiceLevel2.findAll()) {
                        %>
                        <option value="<%=level2.getId()%>" class="w3-input">
                            <%=level2.getName()%>
                        </option>
                        <%
                            }
                        %>
                        <%
                            for (Level3 level3 : ServiceLevel3.findAll()) {
                        %>
                        <option value="<%=level3.getId()%>" class="w3-input">
                            <%=level3.getName()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <button type="button" class="btn btn-primary"  onclick="addHardware();">Ajouter</button>
            </form>  

        </div>
        <div class="card-footer">

        </div>
    </div>
    <%
            }
        } catch (Exception ex) {

        }
    %>   

    <%                try {
            String idHardware = request.getParameter("idHardware");
            Hardware hardware = null;
            if (idHardware != null) {
                if (!idHardware.equals("null")) {
                    if (!idHardware.equals("")) {
                        hardware = ServiceHardware.find(Integer.parseInt(idHardware));
                        if (hardware != null) {
                            if (hardware.getActive() == true) {
    %>
    <div class="card">
        <div class="card-header">
            <i class="fa fa-sign-in"></i>
            Connexion
        </div>
        <div class="card-body">
            <form name="f_connexion" action="<%=application.getContextPath()%>/Connexion" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">Nom d'utilisateur</label>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">
                                <i class="fa fa-user"></i>
                            </span>
                        </div>
                        <input name="login" type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Mot de passe</label>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">
                                <i class="fa fa-lock"></i>  
                            </span>
                        </div>
                        <input name="password" type="password" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>  

        </div>
        <div class="card-footer">

        </div>
    </div>
    <%      // 
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {

        }

    %>   


    <%                try {
            String idHardware = request.getParameter("idHardware");
            Hardware hardware = null;
            if (idHardware != null) {
                if (!idHardware.equals("null")) {
                    if (!idHardware.equals("")) {
                        hardware = ServiceHardware.find(Integer.parseInt(idHardware));
                        if (hardware != null) {

    %>
    <div class="card">
        <div class="card-header">
            <i class="fa fa-television"></i>
            Mon Appareil
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-lg-6 col-md-12">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <i class="fa fa-television"></i>
                            <%=hardware.getName()%>
                        </li>
                        <li class="list-group-item">
                            <i class="fa fa-calendar"></i>
                            <%= new SimpleDateFormat("dd/MM/yyyy").format(hardware.getDateCreation())%>
                        </li>
                        <li class="list-group-item">
                            <i class="ti-time"></i>
                            <%= new SimpleDateFormat("HH:mm").format(hardware.getDateCreation())%>
                        </li>

                        <%if (hardware.getActive() == true) {%>
                        <li class="list-group-item w3-text-green">
                            Status
                            <i class="fa fa-check-circle"></i>
                        </li>
                        <%} else {%>
                        <li class="list-group-item w3-text-pink">
                            Status
                            <i class="fa fa-times-circle"></i>
                        </li>
                        <%}%>
                    </ul>
                    <br>
                </div>

                <div class="col-lg-6 col-md-12">
                    <ul class="list-group">
                        <li class="list-group-item w3-light-gray">
                            <i class="fa fa-map-marker w3-meduim"></i>
                            Ma position actuelle
                        </li>
                        <li class="list-group-item">
                            <i class="fa fa-caret-right w3-text-blue"></i>
                            <%=hardware.getIdLevel1().getName()%>
                        </li>
                        <li class="list-group-item">
                            <i class="fa fa-caret-right w3-text-blue"></i>
                            <%=hardware.getIdLevel1().getIdLevel2().getName()%>
                        </li>
                        <li class="list-group-item">
                            <i class="fa fa-caret-right w3-text-blue"></i>
                            <%=hardware.getIdLevel1().getIdLevel2().getIdLevel3().getName()%>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="card-footer">
        </div>
    </div>

    <%      // 
                        }
                    }
                }
            }
        } catch (Exception ex) {

        }

    %>       

</div>    
<br>



<%!public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
%>