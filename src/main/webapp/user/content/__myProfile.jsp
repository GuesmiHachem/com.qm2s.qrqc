
<%@page import="java.util.Date"%>
<%@page import="entity.*"%>
<%@page import="service.*"%>

<%@page import="domaine.Design"%>
<%@page import="java.util.List"%>

<%
    String idUser = request.getParameter("id");
    User user = (User) session.getAttribute("user");
    String permission = (String) session.getAttribute("permission");
%>

<div class="card mb-3">
    <div class="card-header">Mon profile</div>
    <div class="card-body w3-dark-gray w3-text-black" >
        <div class="card-group">

            <div class="card" style="max-width: 15rem;">
                <div class="card-header">
                    <i class="fa fa-id-badge"></i>
                    Carte Identité
                </div>

                <%
                    String src1 = "";
                    if (user == null) {
                        src1 = application.getContextPath() + "/img/profile/user.png";
                    } else if (user.getPicture().equals("")) {
                        src1 = application.getContextPath() + "/img/profile/user.png";
                    } else {
                        src1 = application.getContextPath() + "/img/profile/" + user.getPicture();
                    }
                %> 

                <img class="card-img-tops ui medium image rounded" src="<%=src1%>" alt="...">

                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <!-- Button trigger modal -->
                        <form action="<%=application.getContextPath()%>/removePicture?id=<%=user.getId()%>" method="post">
                            <button type="button" class="btn btn-primary w3-block mb-3" data-toggle="modal" data-target="#updatepicture">
                                <i class="fa fa-edit"></i>
                                modifier
                            </button>

                            <button onclick="if (window.confirm('Voulez-vous vraiment supprimer ?')) {
                                        return true;
                                    } else {
                                        return false;
                                    }"  name="removePhoto" type="submit" class="btn btn-danger w3-block"> 
                                <i class="fa fa-trash">
                                </i>
                                Supprimer
                            </button>
                        </form>

                    </li>
                </ul>   
            </div>
            <div class="card" style="max-width: 15rem;">
                <div class="card-header">
                    <i class="fa fa-id-badge"></i>
                    Carte Identité
                </div>

                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <i class="fa fa-user"></i>
                        <span class="w3-text-grey date card-text"><%=user.getName() + " " + user.getFirstName()%></span>
                    </li>
                    <li class="list-group-item">
                        <i class="fa fa-id-card"></i>
                        <span class="w3-text-grey date card-text"><%=user.getCin()%></span>
                    </li>
                    <li class="list-group-item">
                        <i class="fa fa-barcode"></i>
                        <span class="w3-text-grey date card-text"><%=user.getMatricule()%></span>
                    </li>
                    <li class="list-group-item">
                        <i class="fa fa-birthday-cake"></i>
                        <span class="w3-text-grey date card-text"><%=user.getBirthday()%></span>
                    </li>
                    <li class="list-group-item text-truncate">
                        <i class="fa fa-envelope"></i>
                        <span class=" card-text"><%=user.getEmail()%></span>
                    </li>
                    <li class="list-group-item">
                        <i class="fa fa-phone-square"></i>
                        <span class=" card-text"><%=user.getTel()%></span>
                    </li>
                    <li class="list-group-item">
                        <i class="fa fa-user"></i>
                        <span class=" card-text"><%=user.getLogin()%></span>
                    </li>
                    <li class="list-group-item">
                        <i class="fa fa-key"></i>
                        <span class=" card-text"><%=user.getPassword()%></span>
                    </li>
                    <li class="list-group-item">
                        <a href="#">
                            <i class="w3-text-red fa fa-warning"></i>
                            <span class="w3-text-grey card-text"><%=user.getProblemList().size()%> Probleme</span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateprofile">
                            <i class="fa fa-edit"></i>
                            modifier profile
                        </button>
                    </li>
                    <li class="list-group-item">

                    </li>
                </ul>   
            </div>  
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-warning w3-text-red"></i>
                    Problem créer par <b><%=user.getName() + " " + user.getFirstName()%></b> ---
                    <span class="w3-text-grey card-text "><%=user.getProblemList().size()%> Probléme</span>
                </div>
                <ul class="card-body">
                    <table id=""  class="w3-table display responsive no-wrap w3-round w3-border w3-border-blue-gray" style="width:100%">
                        <thead class="w3-blue-gray">
                            <tr>
                                <th style=" white-space: nowrap;"> Code&nbsp;</th>
                                <th style=" white-space: nowrap;"> Status&nbsp;</th>
                                <th style=" white-space: nowrap;"> Référence&nbsp;</th>
                                <th style=" white-space: nowrap;"> Piece mauvaise&nbsp;</th>
                                <th style=" white-space: nowrap;"> Piece Bonne&nbsp;</th>
                                <th style=" white-space: nowrap;"> Type_de_problem&nbsp;</th>
                                <th style=" white-space: nowrap;"> Date_creation&nbsp;</th>
                                <th class="disabled-sorting"> </th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<Problem> listProblemUser = user.getProblemList();
                                for (Problem p : listProblemUser) {
                                    if (p == null) {
                                        continue;
                                    }
                                    TypeProblem typeProblem = p.getIdTypeProblem();
                                    Step1 step1 = p.getIdStep1();

                                    if (typeProblem == null) {
                                        continue;
                                    }
                                    if (step1 == null) {
                                        continue;
                                    }
                                    TypeUser typeuser = user.getIdTypeUser();
                                    if (typeuser == null) {
                                        continue;
                                    }

                            %>
                            <tr style="background-colodr: <%=typeProblem.getColor()%>">
                                <td ><span class="w3-tag w3-padding-small w3-round"  style="background-color: <%=typeProblem.getColor()%>"><%=p.getCode()%></span></td>
                                <td><%=p.getStatus()%> </td>
                                <td><%=p.getReference()%></td>
                                <td>
                                    <img class="w3-border w3-border-dark-gray w3-round" width="40px" height="40px" src="<%=application.getContextPath()%>/upload/<%=step1.getBadPiece()%>" alt="...">
                                </td>
                                <td>
                                    <img class="w3-border w3-border-dark-gray w3-round" width="40px" height="40px" src="<%=application.getContextPath()%>/upload/<%=step1.getGoodPiece()%>" alt="...">
                                </td>
                                <td class=""><%=typeProblem.getName()%></td>
                                <td><%=p.getDateCreation().toLocaleString()%></td>
                                <td>
                                    <form action="<%=application.getContextPath()%>/ListProblem" method="post">
                                        <a href="Problem?id=<%=p.getId()%>" class="<%=Design.btn%> w3-text-green ti-eye " ></a>
                                        <%if (permission.equals("yes")) {%>    
                                        <input hidden name="id" type="text" value="<%= p.getId()%>"/>
                                        <button name="removeProblem" type="submit" class="<%=Design.btn%> w3-text-pink fa fa-trash"></button>
                                        <button  onclick="document.location.href = 'ProblemPdf?id=<%=p.getId()%>'"  type="button" class="<%=Design.btn%> w3-text-red fa fa-file-pdf-o "> 
                                        </button>
                                        <%} else {%>    
                                        <input hidden name="id" type="text" value="<%= p.getId()%>"/>
                                        <button disabled name="removeProblem" type="submit" class="<%=Design.btn%> w3-text-pink fa fa-trash"></button>
                                        <button  disabled onclick="document.location.href = 'ProblemPdf?id=<%=p.getId()%>'"  type="button" class="<%=Design.btn%> w3-text-red fa fa-file-pdf-o "> 
                                        </button>
                                        <%}%>    
                                    </form>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table> 
                </ul>
            </div>
            <div class="card"  style="max-width: 15rem;">
                <div class="card-header">
                    Fonction
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <i class="fa fa-briefcase"></i>
                        Team Leader
                    </li>


                    <!--    equipe -->
                    <%if (user.getIdLevel0() != null) {%>
                    <li class="list-group-item ">
                        <div class="d-flex bd-highlight">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Equipe
                            </div>
                            <div class="p-2 flex-fill bd-highlight w3-text-blue">
                                <%=user.getIdLevel0().getName()%>
                            </div>
                        </div>
                    </li>
                    <%} else {%>
                    <li class="list-group-item w3-opacity-max">
                        <div class="d-flex bd-highlight">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Equipe
                            </div>
                            <div class="p-2 flex-fill bd-highlight">
                                <i class="fa fa-ban"></i>
                            </div>
                        </div>
                    </li>
                    <%}%>


                    <!--    Niveau 1 -->
                    <%if (user.getIdLevel1() != null) {%>
                    <li class="list-group-item ">
                        <div class="d-flex bd-highlight">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Niveau 1
                            </div>
                            <div class="p-2 flex-fill bd-highlight w3-text-blue">
                                <%=user.getIdLevel1().getName()%>
                            </div>
                        </div>
                    </li>
                    <%} else {%>
                    <li class="list-group-item w3-opacity-max">
                        <div class="d-flex bd-highlight ">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Niveau 1
                            </div>
                            <div class="p-2 flex-fill bd-highlight">
                                <i class="fa fa-ban"></i>
                            </div>
                        </div>
                    </li>
                    <%}%>

                    <!--    Niveau 2 -->
                    <%if (user.getIdLevel2() != null) {%>
                    <li class="list-group-item ">
                        <div class="d-flex bd-highlight">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Niveau 2
                            </div>
                            <div class="p-2 flex-fill bd-highlight w3-text-blue">
                                <%=user.getIdLevel2().getName()%>
                            </div>
                        </div>
                    </li>
                    <%} else {%>
                    <li class="list-group-item w3-opacity-max">
                        <div class="d-flex bd-highlight ">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Niveau 2
                            </div>
                            <div class="p-2 flex-fill bd-highlight">
                                <i class="fa fa-ban"></i>
                            </div>
                        </div>
                    </li>
                    <%}%>

                    <!--    Niveau 3 -->
                    <%if (user.getIdLevel3() != null) {%>
                    <li class="list-group-item ">
                        <div class="d-flex bd-highlight">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Niveau 3
                            </div>
                            <div class="p-2 flex-fill bd-highlight w3-text-blue">
                                <%=user.getIdLevel3().getName()%>
                            </div>
                        </div>
                    </li>
                    <%} else {%>
                    <li class="list-group-item w3-opacity-max">
                        <div class="d-flex bd-highlight ">
                            <div class="p-2 flex-fill bd-highlight w3-light-gray ">
                                Niveau 3
                            </div>
                            <div class="p-2 flex-fill bd-highlight">
                                <i class="fa fa-ban"></i>
                            </div>
                        </div>
                    </li>
                    <%}%>
                    <li class="list-group-item">

                    </li>
                </ul>
            </div> 
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="updatepicture" tabindex="-9" role="dialog" aria-labelledby="updatePicture" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Photo de profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">


                        <form action="<%=application.getContextPath()%>/UpdatePicture?id=<%=user.getId()%>"  method="post" enctype="multipart/form-data" class="">
                            <div class="form-group">
                                <label class="newbtn w3-center" style="cursor: pointer;" >
                                    <%
                                        String src = "";
                                        if (user == null) {
                                            src = application.getContextPath() + "/img/profile/user.png";
                                        } else if (user.getPicture().equals("")) {
                                            src = application.getContextPath() + "/img/profile/user.png";
                                        } else {
                                            src = application.getContextPath() + "/img/profile/" + user.getPicture();
                                        }
                                    %> 
                                    <img id="img1" class="w3-round img-fluid "  src="<%=src%>" alt="...">

                                    <input required style="display: none;"  onchange="readURL(this, img1);" name="photo" type="file" accept="image/*" >
                                </label> 
                            </div>
                            <hr>
                            <div class="">
                                <button class="btn btn-light " type="reset" value="" onclick="getElementById('img1').src = '<%=src%>'">
                                    Annuler
                                </button>
                                <button class="btn btn-primary " type="submit" name="updatePhoto" value="updatePhoto" >
                                    Modifier la photo
                                </button>
                            </div>

                            <script>
                                function readURL(input, img) {
                                    if (input.files && input.files[0]) {
                                        var reader = new FileReader();
                                        reader.onload = function (e) {
                                            $(img).attr('src', e.target.result);
                                        };
                                        reader.readAsDataURL(input.files[0]);
                                    }
                                }
                            </script>


                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="updateprofile" tabindex="-9" role="dialog" aria-labelledby="updateprofile" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Modifier profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-lg-12">
                        <form action="<%=application.getContextPath()%>/UpdateProfile?id=<%=user.getId()%>" method="post">
                            <div class="form-group">
                                <label for="firstName">Prénom</label>
                                <input name="firstName"  id="firstName" type="text" class="form-control" value="<%=user.getFirstName()%>">
                            </div>
                            <div class="form-group">
                                <label for="name">Nom</label>
                                <input name="name"  id="name" type="text" class="form-control" value="<%=user.getName()%>">
                            </div>
                            <div class="form-group">
                                <label for="cin">C.I.N</label>
                                <input name="cin"  id="cin" type="number" class="form-control" value="<%=user.getCin()%>">
                            </div>
                            <div class="form-group">
                                <label for="matricule">Matricule</label>
                                <input name="matricule"  id="matricule"  class="form-control" type="text" class="form-control" value="<%=user.getMatricule()%>">
                            </div>
                            <div class="form-group">
                                <label for="email">E-mail</label>
                                <input name="email"  id="email" class="form-control" type="email" class="form-control" value="<%=user.getEmail()%>">
                            </div>
                            <div class="form-group">
                                <label for="tel">Tel</label>
                                <input name="tel" id="tel" class="form-control" type="number" class="form-control" value="<%=user.getTel()%>">
                            </div>
                            <div class="form-group">
                                <label for="birthday">Date de Naissance </label>
                                <input name="birthday" id="birthday" class="form-control" type="date" value="<%=user.getBirthday()%>" >
                            </div>

                            <div class="form-group">
                                <label for="login">Login</label>
                                <input name="login" id="login" class="form-control" type="text" class="form-control" value="<%=user.getLogin()%>">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input name="password" id="password" class="form-control" type="password" class="form-control" value="<%=user.getPassword()%>">
                            </div>

                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>

                    </div>  
                </div>
            </div>
        </div>
    </div>
</div>