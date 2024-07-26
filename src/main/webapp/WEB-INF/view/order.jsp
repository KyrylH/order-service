<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Order</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
            .form-padding-10px {
                padding: 10px;
            }
        </style>
    </head>
    <body>
    <div style="margin-inline: auto; max-width: fit-content;margin-top: 15%">
        <form action="/" class="order__form" method="post">
            <div class="col-10 form-padding-10px">
                <label for="surname" class="form-label">surname:</label>
                <input name="surname" id="surname" class="form-control" placeholder="Surname" type="text">
            </div>
            <div class="col-10 form-padding-10px">
                <label for="productName">product name:</label>
                <input name="productName" id="productName" class="form-control" placeholder="Product name" type="text">
            </div>
            <div class="col-10 form-padding-10px">
                <label for="productCount">product count:</label>
                <input name="productCount" id="productCount" class="form-control" placeholder="0" type="number" min="1">
            </div>
            <input class="btn btn-danger form-padding-10px" type="submit">
        </form>
    </div>
        <c:if test="${containsMessage}">
            <script>
                alert("${message}")
            </script>
        </c:if>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>