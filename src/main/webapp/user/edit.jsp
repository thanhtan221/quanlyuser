<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/16/2022
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</head>

<body>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="user?action=user">Users</a>
    </li>
</ul>
<h2 style=" display: block; margin: auto;">Edit User</h2>
<form method="post" style="width: 50%; display: block; margin: auto;" class="row g-3 needs-validation" novalidate>
<c:if test="${user != null}">
    <div class="row-md-4">
        <label for="validationCustom01" class="form-label">Id</label>
        <input type="text" class="form-control" name="id" disabled id="validationCustom01" value="<c:out value='${user.id}'/>" required >
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
</c:if>
    <div class="row-md-4">
        <label for="validationCustom01" class="form-label">Name</label>
        <input type="text" name="name" class="form-control"
               value="<c:out value='${user.name}' />"   required >
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>
    <div class="row-md-4">
        <label for="validationCustom02" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="validationCustom02"
               value="<c:out value='${user.password}' />"  required >
        <div class="valid-feedback">
            Looks good!
        </div>
        <div class="invalid-feedback">
            Please choose a email.
        </div>
    </div>
    <div class="row-md-4">
        <label for="validationCustomUsername" class="form-label">phone</label>
        <div class="input-group has-validation">
            <span class="input-group-text" id="inputGroupPrepend">+84</span>
            <input type="text"   name="phone" class="form-control" id="validationCustomUsername"
                   aria-describedby="inputGroupPrepend"
                   value="<c:out value='${user.phone}' />"  required >
            <div class="invalid-feedback">
                Please choose a username.
            </div>
        </div>
    </div>
    <div class="row-md-6">
        <label for="validationCustom03" class="form-label">Address</label>
        <input type="text" name="address" class="form-control"
               value="<c:out value='${user.address}' />"   required  >
        <div class="invalid-feedback">
            Please provide a Address city.
        </div>
    </div>
    <div class="row-md-6">
        <label for="validationCustom03" class="form-label">city</label>
        <input type="text" name="city" class="form-control"  id="validationCustom03"
               value="<c:out value='${user.city}' /> " required  >
        <div class="invalid-feedback">
            Please provide a Address city.
        </div>
    </div>
    <div class="row-12">
        <input class="btn btn-primary" type="submit" value="Update">
    </div>
</form>
<script>
    (function () {
        'use strict'
        var forms = document.querySelectorAll('.needs-validation')
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</body>

</html>
