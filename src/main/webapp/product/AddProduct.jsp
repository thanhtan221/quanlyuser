<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 3/18/2022
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a class="nav-link active" aria-current="page" href="/product?action=product">Product</a>
    </li>
</ul>
<h2 style="width: 20%; display: block; margin: auto;">Add New User</h2>
<form style="width: 50%; display: block; margin: auto;" class="row g-3 needs-validation" novalidate method="post">

    <div class="row-md-4">
        <label for="validationCustom01" class="form-label">drinks</label>
        <input type="text" class="form-control" name="drinks" id="validationCustom01"  required>
        <div class="valid-feedback">
        </div>
        <div class="invalid-feedback">
        </div>
    </div>
    <div class="row-md-4">
        <label for="validationCustom02" class="form-label">price</label>
        <input type="text" class="form-control" name="price" id="validationCustom02" value="" required>
        <div class="valid-feedback">
        </div>
        <div class="invalid-feedback">
        </div>
    </div>
    <div class="row-md-4">
        <label for="validationCustomUsername" class="form-label">quantity</label>
        <div class="input-group has-validation">
            <input type="text" class="form-control"  name="quantity" id="validationCustomUsername"
                   aria-describedby="inputGroupPrepend" required>
            <div class="invalid-feedback">
            </div>
        </div>
    </div>
    <div class="row-12">
        <button class="btn btn-primary" type="submit">Add</button>
    </div>
</form>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
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
