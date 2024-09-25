<%-- 
    Document   : approvepost
    Created on : Apr 25, 2024, 8:10:00 PM
    Author     : tongh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card-box mb-30">
    <div class="pd-20">
        <h4 class="text-blue h4">Bài viết của chủ nhà trọ</h4>
    </div>
    <div class="pb-20">
        <table class="table hover multiple-select-row data-table-export nowrap">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Ảnh trọ</th>
                    <th>Tiêu đề</th>
                    <th>Giá phòng</th>
                    <th>Địa chỉ</th>
                    <th>Tên chủ bài viết</th>
                    <th>Ngày tạo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${lposts}" var="lp">
                    <tr>
                        <td>${lp[0]}</td>
                        <td style="width:260px"><img class="card-img-top" 
                                                     src="${lp[7]}"
                                                     alt="Card image"></td>
                        <td>${lp[1]}</td>
                        <td>${lp[3]}VNĐ/Tháng</td>
                        <td>${lp[4]},${lp[5]},${lp[6]}</td>
                        <td>${lp[9]} ${lp[10]}</td>
                        <td>${lp[11]}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
       
    </div>
</div>

<div class="card-box mb-30">
    <div class="pd-20">
        <h4 class="text-blue h4">Bài viết của khách hàng</h4>
    </div>
    <div class="pb-20">
        <table class="table hover multiple-select-row data-table-export nowrap">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Tiêu đề</th>
                    <th>Mô tả</th>
                    <th>Địa chỉ</th>
                    <th>Tên chủ bài viết</th>
                    <th>Ngày tạo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cposts}" var="cp">
                    <tr>
                        <td>${cp[0]}</td>
                        <td>${cp[1]}</td>
                        <td>${cp[2]}</td>
                        <td>${cp[3]}</td>
                        <td>${cp[4]} ${cp[5]}</td>
                        <td>${cp[7]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </div>
</div>


