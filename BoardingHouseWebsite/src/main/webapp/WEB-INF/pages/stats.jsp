<%-- 
    Document   : stats
    Created on : May 1, 2024, 8:11:12 PM
    Author     : tongh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-info mt-1">THỐNG KÊ DOANH THU</h1>

<!--STATS 1-->
<h2 class="text-danger mt-5">Thống kê doanh thu theo tháng/quý</h2>
<div class="row">
    <div class="col-md-5 col-12">
        <div>

            <form>
                <div class="alert alert-info">
                    <h4>Năm: ${param.year}</h4>
                    <h4>Khoảng thời gian: ${param.period}</h4>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="number" class="form-control" id="year" placeholder="Năm" name="year" value="2024">
                    <label for="year">Năm</label>
                </div>

                <div class="form-floating  mb-3 mt-3">
                    <select class="form-select" id="period" name="period">
                        <option value="MONTH">Tháng</option>
                        <option value="QUARTER">Qúy</option>
                    </select>
                    <label for="sel1" class="form-label">Khoảng thời gian:</label>
                </div>
                <div class="form-floating  mb-3 mt-3">
                    <button class="btn btn-info">Lọc</button>
                </div>
            </form>
        </div>
        <table class="table">
            <tr>
                <th>Thời gian (${param.period})</th>
                <th>Số lượng người dùng</th>
            </tr>

            <c:forEach items="${statsUserByPeriod}" var="s">
                <tr>
                    <td>${s[0]}</td>                   
                    <td>${s[1]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChartByPeriod"></canvas>
    </div>
</div>

<!--STATS 2-->         
<h2 class="text-danger mt-5">Thống kê doanh thu theo ngày của tháng</h2>

<div class="row">
    <div class="col-md-5 col-12">
        <div>

            <form>
                <div class="alert alert-info">
                    <h4>Năm: ${param.year}</h4>
                    <h4>Tháng:${param.month} </h4>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="number" class="form-control" id="year" placeholder="Năm" name="year" value="2024">
                    <label for="year">Năm</label>
                </div>

                <div class="form-floating  mb-3 mt-3">

                    <select class="form-select" id="month" name="month">
                        <option value="1">Tháng 1</option>
                        <option value="2">Tháng 2</option>
                        <option value="3">Tháng 3</option>  
                        <option value="4">Tháng 4</option>
                        <option value="5">Tháng 5</option>
                        <option value="6">Tháng 6</option>
                        <option value="7">Tháng 7</option>
                        <option value="8">Tháng 8</option>
                        <option value="9">Tháng 9</option>
                        <option value="10">Tháng 10</option>
                        <option value="11">Tháng 11</option>
                        <option value="12">Tháng 12</option>
                    </select>
                    <label for="sel1" class="form-label">Khoảng thời gian:</label>
                </div>
                <div class="form-floating  mb-3 mt-3">
                    <button class="btn btn-info">Lọc</button>
                </div>
            </form>
        </div>
        <table class="table">
            <tr>
                <th>Ngày</th>
                <th>Số lượng người dùng</th>
            </tr>
            <c:forEach items="${statsUserByDay}" var="s">
                <tr>
                    <td>${s[0]}</td>                   
                    <td>${s[1]}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChartByDay"></canvas>
    </div>
</div>

<script>
    let labels = [];
    let data = [];
    <c:forEach items="${statsUserByPeriod}" var="s">
    labels.push(${s[0]});
    data.push(${s[1]});
    </c:forEach>

    let labels2 = [];
    let data2 = [];
    <c:forEach items="${statsUserByDay}" var="s">
    labels2.push(${s[0]});
    data2.push(${s[1]});
    </c:forEach>

    function drawChart(ctx, labels, data) {
        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                        label: 'Số lượng người dùng',
                        data: data,
                        borderWidth: 1,
                        backgroundColor: ['red', 'green', 'blue', 'gold', 'brown']
                    }],
            },
            options: {
                scales: {
                    x: {
                        title: {
                            display: true,
                            text: '${param.period}'
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: 'Số lượng'
                        },
                        beginAtZero: true,
                        ticks: {
                            min: 0,
                            max: 10,
                            stepSize: 1
                        }
                    }
                }
            }
        });
    }
    function drawChart2(ctx2, labels2, data2) {
        new Chart(ctx2, {
            type: 'bar',
            data: {
                labels: labels2,
                datasets: [{
                        label: 'Số lượng người dùng',
                        data: data2,
                        borderWidth: 1,
                        backgroundColor: ['red', 'green', 'blue', 'gold', 'brown']
                    }],
            },
            options: {
                scales: {
                    x: {
                        title: {
                            display: true,
                            text: 'Day'
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: 'Số lượng'
                        },
                        beginAtZero: true,
                        ticks: {
                            min: 0,
                            max: 10,
                            stepSize: 1
                        }
                    }
                }
            }
        });
    }
    window.onload = function () {
        let ctx1 = document.getElementById("myChartByPeriod");
        let ctx2 = document.getElementById("myChartByDay");
        drawChart(ctx1, labels, data);
        drawChart2(ctx2, labels2, data2);

    };

</script>

