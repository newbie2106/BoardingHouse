function eDelete(url, id) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(url, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!");

        });
    }
}
function approvePost(url, id) {
    if (confirm("Bạn chắc chắn duyệt không?") === true) {
        fetch(url, {
            method: "post"
        }).then(res => {
            if (res.status === 204) {
                // Chuyển hướng đến trang users
                window.location.href = "/users"; // Thay thế "/users" bằng URL chính xác của trang users
            } else {
                alert("Something wrong!");
            }
        });
    }
}


