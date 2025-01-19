<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/store.css"/>
        <link rel="stylesheet" href="css/cmt2.css"/>
        <title>Review Page</title>
    </head>
    <body>
        <!-- Reviews -->
	<div class="reviews">
		<div class="container-reviews">
			<form name="myform" action="ReviewControl" method="post">
				<input type="hidden" name="accountID" value="${sessionScope.account.accountID}">
				<input class="bobo" type="text" name="comment" placeholder="Please comment">
				<br>
				<input class="product-buttons01" type="submit" value="Send">
			</form>
			<div id="mycomment"></div>
		</div>
		<div class="comment-list">
			<h3>Reviews:</h3>
			<c:forEach items="${listR}" var="review">
				<div class="comment-item">
					<div class="comment-item-header">
						<h4>${review.accountID}</h4>
						<span>20-20-20</span>
					</div>
					<span>${review.comment}</span>
				</div>
			</c:forEach>
		</div>
	</div>
    </body>
</html>
