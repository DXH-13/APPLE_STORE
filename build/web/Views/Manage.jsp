<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Doge</title>
        <link rel="icon" href="./assets/icons/doge.png">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="./css/manage.css"/>
    </head>
    <body>
        <div class="container">
            <h1 class="h1">Manage Products</h1>
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <a href="ManageOrder">Orders</a></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal" class="btn btn-success hoho" data-toggle="modal">
                                <span>Add New Product</span></a>
                            <a href="#deleteEmployeeModal" class="btn btn-danger hoho" data-toggle="modal">
                                <span>Delete</span></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>ID</th>
                            <th>Product Name</th>
                            <th>Image</th>
                            <th>Color</th>
                            <th>Storage</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listPO}" var="po" begin="130" end="140">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>${po.productOptionID}</td>
                                <td>${po.p.productName}</td>
                                <td><img class="img-manage" src="${po.photo1}" alt="macbook"></td>
                                <td>${po.cl.colorName}</td>
                                <td>${po.s.storage}</td>
                                <td>$${po.price}</td>
                                <td>
                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons"
                                                                                                     data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="DeleteControl?pid=${po.productOptionID}" class="delete" data-toggle="modal"><i class="material-icons"
                                                                                                                            data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="AddControl" method="post" >
                        <div class="modal-header">
                            <h4 class="modal-title">Insert Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="number" name="id" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Product</label>
                                <select name = "product">
                                    <c:forEach items="${listP}" var="p">
                                        <option value = '${p.productID}'>${p.productName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Color</label>
                                <select name = "color">
                                    <c:forEach items="${listCl}" var="cl">
                                        <option value = '${cl.colorID}'>${cl.colorName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Storage</label>
                                <select name = "storage">
                                    <c:forEach items="${listS}" var="s">
                                        <option value = '${s.storageID}'>${s.storage}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="number" name="price" value="${pO.price}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Promotion</label>
                                <input type="text" name="promotion" value="${pO.price}" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Image 1</label>
                                <input type="text" name="photo1" value="${pO.photo1}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image 2</label>
                                <input type="text" name="photo2" value="${pO.photo1}" class="form-control" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" name='btnInsert' value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="UpdateControl" method="post" >
                        <div class="modal-header">
                            <h4 class="modal-title">Update Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="number" name="id" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Product</label>
                                <select name = "product">
                                    <c:forEach items="${listP}" var="p">
                                        <option value = '${p.productID}'>${p.productName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Color</label>
                                <select name = "color">
                                    <c:forEach items="${listCl}" var="cl">
                                        <option value = '${cl.colorID}'>${cl.colorName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Storage</label>
                                <select name = "storage">
                                    <c:forEach items="${listS}" var="s">
                                        <option value = '${s.storageID}'>${s.storage}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="number" name="price" value="${pO.price}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Promotion</label>
                                <input type="text" name="promotion" value="${pO.price}" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Image 1</label>
                                <input type="text" name="photo1" value="${pO.photo1}" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image 2</label>
                                <input type="text" name="photo2" value="${pO.photo1}" class="form-control" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" name='btnUpdate' value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Delete Employee</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete these Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                // Activate tooltip
                $('[data-toggle="tooltip"]').tooltip();

                // Select/Deselect checkboxes
                var checkbox = $('table tbody input[type="checkbox"]');
                $("#selectAll").click(function () {
                    if (this.checked) {
                        checkbox.each(function () {
                            this.checked = true;
                        });
                    } else {
                        checkbox.each(function () {
                            this.checked = false;
                        });
                    }
                });
                checkbox.click(function () {
                    if (!this.checked) {
                        $("#selectAll").prop("checked", false);
                    }
                });
            });
        </script>
    </body>
</html>
