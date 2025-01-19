
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doge</title>
        <link rel="icon" href="./assets/icons/doge.png">
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="LoadControl" method="post" >
                        <div class="modal-header">
                            <h4 class="modal-title">Update Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>ID</label>
                                <input value="DetailControl.productOptionID" type="number" name="id" class="form-control" required>
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
    </body>
</html>
