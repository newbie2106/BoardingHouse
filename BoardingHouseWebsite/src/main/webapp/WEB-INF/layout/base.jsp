<%-- 
    Document   : base
    Created on : Apr 25, 2024, 7:38:38 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link rel="apple-touch-icon" sizes="180x180" href="vendors/images/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="vendors/images/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="vendors/images/favicon-16x16.png">

        <!-- Mobile Specific Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">


        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());

            gtag('config', 'UA-119386393-1');
        </script>


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <link rel="stylesheet" type="text/css" href="<c:url value="/vendors/styles/core.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/vendors/styles/icon-font.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/src/plugins/slick/slick.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.css"/>">
        
        <link rel="stylesheet" type="text/css" href="<c:url value="/src/plugins/jvectormap/jquery-jvectormap-2.0.3.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/vendors/styles/style.css"/>">

        <script src="<c:url value="/vendors/scripts/core.js"/>"></script>
        <script src="<c:url value="/vendors/scripts/script.min.js"/>"></script>
        <script src="<c:url value="/vendors/scripts/process.js"/>"></script>
        <script src="<c:url value="/vendors/scripts/layout-settings.js"/>"></script>
        <script src="<c:url value="/js/main.js"/>"></script> 
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    </head>
    <body>
        <tiles:insertAttribute name="header" />

        <section class="container">
            <tiles:insertAttribute name="content" />
        </section>
        <tiles:insertAttribute name="footer" />
    </body>
</html>