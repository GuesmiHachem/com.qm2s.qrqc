<%-- 
    Document   : x
    Created on : 29 août 2018, 16:31:55
    Author     : Hachem
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.File"%>
<%@page import="java.awt.Image"%>
<%@page import="dao.DaoProblem"%>
<%@page import="domaine.Design"%>
<%@page import="dao.DaoTypeUser"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.TypeUser"%>
<%@page import="model.User"%>
<%@page import="dao.DaoUser"%>
<%@page import="model.Step1"%>
<%@page import="model.Problem"%>
<%@page import="java.util.List"%>
<%@page import="dao.DaoTypeProblem"%>
<%

    String gc = request.getParameter("gc");
    if (gc != null) {
        Runtime.getRuntime().gc();

    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <body>
        <button onclick="beep();">Beep!</button>


        <br><br>
        freeMemory : <%=(Runtime.getRuntime().freeMemory()) / (1024 * 1024)%> MB <br>
        maxMemory : <%=(Runtime.getRuntime().maxMemory()) / (1024 * 1024)%> MB  <br>
        totalMemory : <%=(Runtime.getRuntime().totalMemory()) / (1024 * 1024)%> MB <br>
        <form action="" method="post">
            <button type="submit" name="gc">GC</button>
        </form>



        <script>
            function beep() {
                var snd = new Audio("file.mp3"); // buffers automatically when created
                snd.play();
            }
        </script>


        <table id="datatables"  class="<%=Design.table%>" cellspacing="0" width="100%" >
            <thead>
                <tr>
                    <th> ID</th>
                    <th> Code</th>
                    <th> Num</th>
                    <th> Utilisateur</th>
                    <th> Type_Utilisateur</th>

                    <th> Référence</th>
                    <th> Type_de_problem</th>
                    <th> Quand?&nbsp;</th>
                    <th> Quoi?</th>
                    <th> Respect_du_standard?</th>
                    <th> Lancer_un_tri</th>
                    <th> </th>
                </tr>
            </thead>
            <tbody>
                <%
                    Iterator<Problem> it = DaoProblem.getInstance().findAll().iterator();
                    //for (Problem problem : listProblem) {
                    while (it.hasNext()) {
                        Problem problem = it.next();
                        Step1 step1 = problem.getStep1();
                        if (step1 != null) {

                            User user = DaoUser.getInstance().find(step1.getId_user());
                            TypeUser typeuser = null;
                            if (user != null) {
                                typeuser = DaoTypeUser.getInstance().find(user.getId_type_user());
                            }

                %>
                <tr>
                    <td><%= step1.getId()%></td>

                    <td><%= problem.getCode() == null ? "" : problem.getCode()%></td>
                    <td><%= problem.getNum() == 0 ? "" : problem.getNum()%> </td>

                    <td><%=user == null ? "" : user.getName() + " " + user.getFirst_name()%></td>


                    <td><%=typeuser == null ? "" : typeuser.getName()%></td>


                    <td><%=problem.getReference() == null ? "" : problem.getReference()%></td>
                    <td class=""><%=DaoTypeProblem.getInstance().find(step1.getId_type_problem()).getName()%></td>
                    <td><%=step1.getWhen_() == null ? "" : step1.getWhen_()%></td>
                    <td><%=step1.getWhat_() == null ? "" : step1.getWhat_()%></td>
                    <%if (step1.getRespect_standard()) {%>
                    <td class="text-success ti-check"> oui</td>
                    <%} else {%>
                    <td class="text-danger ti-close "> non</td>
                    <%}%>

                    <%if (step1.getSort()) {%>
                    <td class="text-success ti-check"> oui</td>
                    <%} else {%>
                    <td class=" text-danger ti-close "> non</td>
                    <%}%>
                    <td>
                        <form action="<%=application.getContextPath()%>/Problems" method="post">
                            <a href="Problem?id=<%=problem.getId()%>" class="w3-btn w3-border w3-round w3-light-gray text-success ti ti-eye " ></a>

                            <input hidden name="id" type="text" value="<%= problem.getId()%>">
                            <button name="removeProblem" type="submit" class="w3-btn w3-border w3-round w3-light-gray text-danger fa fa-trash"/>

                        </form>

                    </td>


                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>




        <%
            ArrayList album = new ArrayList();
            Image img, img2, img3;
            try {
                img = ImageIO.read(new File("images.jpg"));
                img2 = ImageIO.read(new File("images.jpg"));
                img3 = ImageIO.read(new File("images.jpg"));
                album.add(img);
                album.add(img2);
                album.add(img3);

            } catch (IOException e) {
                e.printStackTrace();
            }

        %>    

        <img src="../../img/profile/12.jpg" width="340" height="148" alt="12"/>

        <div id="capture" style="padding: 10px; background: #f5da55">
            <h4 style="color: #000; ">Hello world!</h4>
        </div>

    </body>
</html>

<script>
    html2canvas(document.querySelector("#capture")).then(canvas => {
        document.body.appendChild(canvas)
    });
</script>

<%

%>