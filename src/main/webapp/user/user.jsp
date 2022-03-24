<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/10/2022
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Quản Lý Quán Cafe Đêm Mai</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/Search.css">
</head>
<style>
    h1 {
        font-size: 30px;
        color: #fff;
        text-transform: uppercase;
        font-weight: 300;
        text-align: center;
        margin-bottom: 15px;
    }

    table {
        width: 100%;
        table-layout: fixed;
    }

    .tbl-header {
        background-color: rgba(255, 255, 255, 0.3);
    }

    .tbl-content {
        height: 300px;
        overflow-x: auto;
        margin-top: 0px;
        border: 1px solid rgba(255, 255, 255, 0.3);
    }

    th {
        padding: 20px 15px;
        text-align: left;
        font-weight: 500;
        font-size: 12px;
        color: #fff;
        text-transform: uppercase;
    }

    td {
        padding: 15px;
        text-align: left;
        vertical-align: middle;
        font-weight: 300;
        font-size: 12px;
        color: #fff;
        border-bottom: solid 1px rgba(255, 255, 255, 0.1);
    }

    /* demo styles */

    @import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
    body {
        background: -webkit-linear-gradient(left, #25c481, #25b7c4);
        background: linear-gradient(to right, #25c481, #25b7c4);
        font-family: "Roboto", sans-serif;
    }

    section {
        margin: 50px;
    }

    /* follow me template */
    .made-with-love {
        margin-top: 40px;
        padding: 10px;
        clear: left;
        text-align: center;
        font-size: 10px;
        font-family: arial;
        color: #fff;
    }

    .made-with-love i {
        font-style: normal;
        color: #f50057;
        font-size: 14px;
        position: relative;
        top: 2px;
    }

    .made-with-love a {
        color: #fff;
        text-decoration: none;
    }

    .made-with-love a:hover {
        text-decoration: underline;
    }

    ::-webkit-scrollbar {
        width: 6px;
    }

    ::-webkit-scrollbar-track {
        -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
    }

    ::-webkit-scrollbar-thumb {
        -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
    }

    #menu ul {
        list-style: none;
    }

    #menu a {
        float: left;
        border: 3px solid #FF0000;
        display: block;
        background-color: #99CCFF;
        width: 100px;
        text-align: center;
        text-decoration: none;
        margin-right: 1px;
    }

    #menu a:hover {
        background-color: #CC3399;
        color: #FFFFFF;
        text-decoration: underline;
    }
</style>
<script>
    $(window).on("load resize ", function () {
        var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
        $('.tbl-header').css({'padding-right': scrollWidth});
    }).resize();</script>
<body>
<div id="menu">

    <ul>

        <li><a href="/">Log out</a></li>

        <li><a href="user">Home</a></li>

        <li><a href="/user?action=add">ADD USER</a></li>

        <li><a href="/product?action=product">Product</a></li>


    </ul>

</div>
<h1>USER Management</h1>
<div class="box">
    <form class="sbox" action="/user?action=search" method="post" style="text-align: right">
        <input class="stext" type="text" name="key" placeholder="Tìm kiếm USER...">
        <a class="sbutton" type="submit" href="javascript:void(0);">
            <i class="fa fa-search"></i>
        </a>
    </form>
</div>
<h3>${message}</h3>
<div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
        <thead>
        <tr>
            <td>Id</td>
            <th>Name</th>
            <th hidden>password</th>
            <th>Phone</th>
            <th>Address</th>
            <th>City</th>
            <th>Status</th>
            <th>Role</th>
            <td>Update</td>
        </tr>
        </thead>
    </table>
</div>
<div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
        <tbody>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td hidden><c:out value="${user.password}"/></td>
                <td><c:out value="${user.phone}"/></td>
                <td><c:out value="${user.address}"/></td>
                <td><c:out value="${user.city}"/></td>
                <td style="color: red">Hoạt Động</td>
                <td><c:out value="${user.role}"/></td>
                <td>
                    <a href="/user?action=edit&id=${user.id}" style="color: red">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</section>
</body>
</html>