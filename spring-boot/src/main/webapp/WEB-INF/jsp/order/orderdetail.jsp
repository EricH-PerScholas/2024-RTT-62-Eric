<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<h1>TThsi is your cart page</h1>


<section>
    <div class="container">
        <div class="row pt-5">
            <div class="col-12">
                <h2 class="text-center">Items In Cart (${orderDetails.size()})</h2>
            </div>
        </div>
        <div class="row pt-3">
            <div class="col-12">
                <table class="table">
                    <tr>
                        <th>Order Id</th>
                        <th>Order Date</th>
                        <th>Product Name</th>
                        <th>Quantity Ordered</th>
                        <th>Price</th>
                        <th>Total Price</th>
                    </tr>
                    <c:forEach items="${orderDetails}" var="detail">
                        <tr>
                            <td>${detail.order_id}</td>
                            <td>${detail.order_date}</td>
                            <td>${detail.product_name}</td>
                            <td>${detail.quantity}</td>
                            <td>${detail.price}</td>
                            <td>${detail.total}</Td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" class="text-right">Total</td>
                        <td>${orderTotal}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>




<jsp:include page="../include/footer.jsp" />