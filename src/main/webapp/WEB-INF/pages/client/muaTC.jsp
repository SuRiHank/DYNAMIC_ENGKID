<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký Thành Công</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/paging.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <style type="text/css">
        .success-message {
            margin-top: 100px;
            text-align: center;
            font-family: Arial, sans-serif;
            color: #28a745;
        }
        .success-message h1 {
            font-size: 36px;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
        }
        .success-message p {
            font-size: 18px;
            color: #555;
        }
        .success-icon {
            color: #28a745;
            font-size: 48px;
        }
        .back-home {
            margin-top: 20px;
            font-size: 18px;
            color: #007bff; /* Màu cho liên kết */
        }
        .back-home a {
            text-decoration: none; /* Bỏ gạch chân */
            color: #007bff; /* Màu cho liên kết */
        }
        .back-home a:hover {
            text-decoration: underline; /* Gạch chân khi hover */
        }
    </style>
</head>
<body>

<jsp:include page="template/header.jsp"></jsp:include>

<div class="container success-message">
    <h1>
        <i class="fas fa-check-circle success-icon"></i> Thanh toán thành công!
    </h1>
    <p>Cảm ơn bạn đã đăng ký. Chúng tôi đã nhận được thanh toán của bạn.</p>

    <div class="back-home">
        <a href="${pageContext.request.contextPath}">Trở về trang chủ</a>
    </div>
</div>



</body>
</html>
