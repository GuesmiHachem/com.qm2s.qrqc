<%-- 
    Document   : top
    Created on : 23 oct. 2018, 10:42:21
    Author     : Hachem
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<div class="w3-bar w3-black w3-small ">
    <div class="w3-bar-item">
        <span class="w3-large w3-text-light-gray ">e-QRQC 1.0</span>
    </div>
    <div class="w3-bar-item">
        <i class="fa fa-calendar"></i>
        <%= new SimpleDateFormat("dd/MM/yyyy").format(new Date())%>
    </div>
    <div class="w3-bar-item">
        <i class="ti-time"></i>
        <span id="time"></span> 
    </div>
    <div class="w3-bar-item">
        <i class="fa fa-phone-square"></i>
        <a class="w3-text-white" href="tel:01234567890">01234 567 890</a>
    </div>
    <div class="w3-bar-item">
        <i class="fa fa-envelope"></i>
        <a class="w3-text-white" href="mailto:guesmi.hachem@gmail.com">guesmi.hachem@gmail.com</a>   
    </div>
</div>

