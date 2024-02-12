<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style.css">
<script src="assets/js/script.js" defer></script>
<title>注文データ一覧画面</title>
</head>

<body class="order-admin">
	<main class="order-main">
		<ul class="sidenav">
			<li><img class="admin-header" src="../../shinor/img/Header.PNG"
				alt=""></li>
			<li><a class="active" href="Useradmin">ユーザ管理</a></li>
			<li><a href="Itemadmin">商品一覧管理</a></li>
			<li><a href="Orderadmin">注文データ一覧</a></li>
			<li><a href="Logout">Logout</a></li>
		</ul>
		<div class="container">
			<h2 class="order-title">注文データ管理</h2>
			<div class="order-form">
				<div class="order-list">
					<h3>注文データ一覧</h3>
					<input type="text" id="orderSearchInput" oninput="filterOrders2()"
						placeholder="注文を検索...">
					<c:forEach var="ph" items="${ph}">
						<div class="order-item">
							<p>
								<strong>注文ID:</strong>${ph.id}</p>
							<p>
								<strong>顧客名:</strong>${ph.user.getName()}</p>
							<p>
								<strong>注文日時:</strong>${ph.purchase_date}
							</p>
							<select id="delivery${status.index}" name="delivery">
								<option value="apple">準備中</option>
								<option value="banana">配送中</option>
								<option value="orange">配送完了</option>
							</select>
							<button type="submit" class="order-button">更新</button>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</main>
	
</body>

</html>
