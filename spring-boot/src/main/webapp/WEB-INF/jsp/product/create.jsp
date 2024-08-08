<jsp:include page="../include/header.jsp"/>

<h1 class="page-title">This is a create product page</h1>


<div class="container">
    <form action="/product/createSubmit">

        <div class="row pt-5">
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="exampleInputName">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputDescription" class="form-label">Description</label>
                    <input type="text" name="description" class="form-control" id="exampleInputDescription">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputPrice" class="form-label">Price</label>
                    <input type="text" name="price" class="form-control" id="exampleInputPrice">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <div class="mb-3">
                    <label for="exampleInputImageURL" class="form-label">Image URL</label>
                    <input type="text" name="imageUrl" class="form-control" id="exampleInputImageUrl">
                </div>
            </div>
        </div>

        <div class="row pt-3">
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Save Product</button>
            </div>
        </div>

    </form>
</div>

<jsp:include page="../include/footer.jsp"/>