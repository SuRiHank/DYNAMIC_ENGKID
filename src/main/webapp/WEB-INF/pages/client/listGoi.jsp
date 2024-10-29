<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Danh sách Gói Đăng Ký</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/paging.css">

    <style type="text/css">
        .subscription-container {
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
            gap: 20px;
        }

        .subscription-box {
            border: 1px solid #ddd;
            border-radius: 8px;
            width: 30%;
            padding: 30px;
            text-align: center;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.1);
            background-color: #ffffff; /* Nền trắng */
            transition: transform 0.3s;
        }

        .subscription-box:hover {
            transform: scale(1.05);
        }

        .subscription-box h3 {
            font-weight: bold;
            margin-bottom: 15px;
        }

        .subscription-box .price {
            font-size: 28px;
            color: #007bff;
            margin-bottom: 20px;
        }

        .subscription-box p {
            font-size: 16px;
            margin-bottom: 25px;
            color: #666;
        }

        .subscription-box button {
            font-size: 16px;
            padding: 10px 20px;
            border-radius: 5px;
        }
    </style>

    <script type="text/javascript">
        $(document).ready(function() {
            $('.buy-subscription').click(function() {
                var baseUrl = $('#baseUrl').val();
                var subscriptionType = $(this).data('subscription');
                window.location.href = baseUrl + "/api/payment/create_payment";
            });
        });
    </script>
</head>
<body>

<jsp:include page="template/header.jsp"></jsp:include>
<input style="display:none;" id="baseUrl" value="${pageContext.request.contextPath}"/>

<div class="container">
    <!--PAGE TITLE-->
    <div class="row">
        <div class="span9 text-center">
            <div class="page-header">
                <h4 style="font-weight: bold;">DANH SÁCH GÓI ĐĂNG KÝ</h4>
            </div>
        </div>
    </div>
    <!-- /. PAGE TITLE-->

    <div class="subscription-container">
        <!-- Gói Theo Ngày -->
        <div class="subscription-box">
            <h3>Gói Theo Ngày</h3>
            <div class="price">39,000 VNĐ/ngày</div>
            <p>Truy cập toàn bộ nội dung trong vòng 1 ngày.</p>
            <button class="btn btn-primary buy-subscription" data-subscription="day">Mua Gói Ngày</button>
        </div>

        <!-- Gói Theo Tuần -->
        <div class="subscription-box">
            <h3>Gói Theo Tuần</h3>
            <div class="price">199,000 VNĐ/tuần</div>
            <p>Truy cập toàn bộ nội dung trong vòng 1 tháng.</p>
            <button class="btn btn-primary buy-subscription" data-subscription="week">Mua Gói Tháng</button>
        </div>

        <!-- Gói Theo Tháng -->
        <div class="subscription-box">
            <h3>Gói Theo Tháng</h3>
            <div class="price">150,000 VNĐ/tháng</div>
            <p>Truy cập toàn bộ nội dung trong vòng 1 năm.</p>
            <button class="btn btn-primary buy-subscription" data-subscription="month">Mua Gói Năm</button>
        </div>
    </div>
</div>

<jsp:include page="include/footerHome.jsp"></jsp:include>

</body>
</html>
