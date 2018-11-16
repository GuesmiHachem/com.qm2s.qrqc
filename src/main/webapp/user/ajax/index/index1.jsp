
<%@page import="domaine.Design"%>

<form  name="f" class="w3-white" novalidate="" id="loginFormValidation" method="post" action="<%=application.getContextPath()%>/Connexion">

    <div class="<%=Design.card%>">
        <div class="card-content ">
            <div class="card-header">
                <h3 class="card-title">Connexion</h3>
            </div>
            <div class="card-content">



                <div class="form-group">
                    <h3 class="<%=Design.textTitle%>">Login <star> *</star></h3>
                    <input name="login" type="text" placeholder="Login" class="form-control " required>
                </div>
                <div class="form-group">
                    <h3 class="<%=Design.textTitle%>">Password <star> *</star></h3>
                    <input  name="password" type="password" placeholder="Password" class="form-control " required>
                </div>
                <br>
                <div class="category"><star>*</star> Required fields</div>

            </div>
            <div class="card-footer text-center">
                <button type="submit" class="w3-btn w3-round w3-light-blue">Connecter</button>
            </div>
        </div>
    </div>
</form>

