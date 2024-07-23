<jsp:include page="include/header.jsp" />

    <h1 class="page-title text-center pt-5 pb-5">File Upload</h1>

    <form method="post" action="/file-upload" enctype="multipart/form-data">

        <div class="row align-items-center justify-content-center">
            <div class="col-2">
                <label for="file" class="col-form-label">File</label>
            </div>
            <div class="col-4">
                <input type="file" id="file" name="file" class="form-control">
            </div>
        </div>

        <div class="row align-items-center justify-content-center pt-3">
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Upload</button>
            </div>
        </div>
    </form>

<jsp:include page="include/footer.jsp" />