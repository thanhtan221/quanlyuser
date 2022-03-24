<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/18/2022
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Quản Lý Quán Cafe Đêm Mai</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        table {
            border-spacing: 1;
            border-collapse: collapse;
            background: white;
            border-radius: 6px;
            overflow: hidden;
            width: 100%;
            margin: 0 auto;
            position: relative;
        }
        table * {
            position: relative;
        }
        table td,
        table th {
            padding-left: 8px;
        }
        table thead tr {
            height: 60px;
            background: #ffed86;
            font-size: 16px;
        }
        table tbody tr {
            height: 48px;
            border-bottom: 1px solid #e3f1d5;
        }
        table tbody tr:last-child {
            border: 0;
        }
        table td,
        table th {
            text-align: left;
        }
        table td.l,
        table th.l {
            text-align: right;
        }
        table td.c,
        table th.c {
            text-align: center;
        }
        table td.r,
        table th.r {
            text-align: center;
        }

        @media screen and (max-width: 35.5em) {
            table {
                display: block;
            }
            table > *,
            table tr,
            table td,
            table th {
                display: block;
            }
            table thead {
                display: none;
            }
            table tbody tr {
                height: auto;
                padding: 8px 0;
            }
            table tbody tr td {
                padding-left: 45%;
                margin-bottom: 12px;
            }
            table tbody tr td:last-child {
                margin-bottom: 0;
            }
            table tbody tr td:before {
                position: absolute;
                font-weight: 700;
                width: 40%;
                left: 10px;
                top: 0;
            }
            table tbody tr td:nth-child(1):before {
                content: "Code";
            }
            table tbody tr td:nth-child(2):before {
                content: "Stock";
            }
            table tbody tr td:nth-child(3):before {
                content: "Cap";
            }
            table tbody tr td:nth-child(4):before {
                content: "Inch";
            }
            table tbody tr td:nth-child(5):before {
                content: "Box Type";
            }
        }
        body {
            background: #9bc86a;
            font: 400 14px "Calibri", "Arial";
            padding: 20px;
        }

        blockquote {
            color: white;
            text-align: center;
        }
        a{
            color: red;
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
</head>
<body>
<script>
    $(window).on("load resize ", function () {
        var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
        $('.tbl-header').css({'padding-right': scrollWidth});
    }).resize();</script>
<div id="menu">

    <ul>

        <li><a href="/">Log out</a></li>

        <li><a href="product">Home</a></li>

        <li><a href="/product?action=addcaffe">ODER</a></li>



    </ul>

</div>
<div class="box">
    <form class="sbox" action="/product?action=search" method="post" style="text-align: right">
        <input class="stext" type="text" name="key" placeholder="Tìm kiếm drinks...">
        <button class="sbutton" type="submit" href="javascript:void(0);">
            <i class="fa fa-search"></i>
        </button>
    </form>
</div>
<h3>${message}</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Drinks</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>ToTol</th>
        <th></th>
        <th></th>
    </tr>
    <thead>
    <tbody>
<c:forEach   var="CafeShop" items="${listcafeshop}">
    <tr>
        <td><c:out value="${CafeShop.id}"/></td>
        <td><c:out value="${CafeShop.drinks}"/></td>
        <td><c:out value="${CafeShop.price}"/> VNĐ</td>
        <td><c:out value="${CafeShop.quantity}"/></td>
        <td><c:out value="${CafeShop.total}"/> VNĐ</td>
        <td>
            <a href="/product?action=edit&id=${CafeShop.id}">Edit</a>
        </td>
    </tr>
</c:forEach>
    </tbody>
</table >
</body>
</html>