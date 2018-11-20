
<%@page import="entity.Level1"%>
<%@page import="service.ServiceLevel1"%>
<%@page import="domaine.Design"%>
<form name="f_index2" method="get" >
    <div class="w3-row">
        <div class="w3-col l12">
            <div class="w3-white w3-round w3-padding">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Nom de l'appareil </label>
                    <input name="name" type="text" class="form-control w3-white w3-hover-border-blue" id="exampleFormControlInput1" placeholder="Tablette Azus">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Ligne</label>
                    <select  name="idLigne" class="form-control w3-white w3-hover-border-blue"  id="exampleFormControlSelect1">
                        <%
                            for (Level1 level1 : ServiceLevel1.findAll()) {
                        %>
                        <option value="<%=level1.getId()%>" class="w3-input w3-text-light-gray">
                            <%=level1.getName()%>
                        </option>
                        <option value="<%=level1.getId()%>" class="w3-text-light-gray w3-padding">
                            <%=level1.getName()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <br>
                <br>
                <button type="button" class="form-control w3-blue w3-btn w3-round w3-block " onclick="addHardware();">Ajouter mon appareil  </button>

            </div>


        </div>
    </div>


</form>

<script>

</script>
