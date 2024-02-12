<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style.css">
<title>商品画面</title>
</head>

<body class="product-admin">

	<main>
		<ul class="sidenav">
			<li><img class="admin-header" src="../../shinor/img/Header.PNG"
				alt=""></li>
			<li><a class="active" href="Useradmin">ユーザ管理</a></li>
			<li><a href="Itemadmin">商品一覧管理</a></li>
			<li><a href="Orderadmin">注文データ一覧</a></li>
			<li><a href="Logout">ログアウト</a></li>
		</ul>

		<h2 class="product-title">商品管理</h2>
		<div class="product-form">
			<div class="product-list">
				<h3>商品一覧</h3>
				<form action="ItemInfo" method="get">
    <input type="submit" value="新規登録">
</form>

				<input type="text" id="orderSearchInput" oninput="filterOrders()"
					placeholder="商品を検索...">
<c:forEach var="item" items="${item_list}">
    <div class="product-item">
        <span>${item.id}</span>
        <span>${item.productName}</span>
        <span>${item.price}</span>
       <form action="ItemUpdate" method="post">
       <input type="submit" name="update" value="編集">
       </form>
    </div>
</c:forEach>
			</div>

		
		<%-- 成功メッセージを表示 --%>
        <c:if test="${not empty successMessage}">
            <div class="success-message">${successMessage}</div>
        </c:if>
	</main>
	
	<script>
	 // 商品情報の更新機能
function updateItem(itemId) {
    var updatedStock = prompt("更新後の在庫数を入力してください:", "");

    // Ajaxリクエストを送信
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "Itemadmin", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            alert("商品の在庫が更新されました。");
            location.reload(); // ページをリロードして更新を反映
        }
    };

    // 在庫数の更新情報を送信
    xhr.send("action=update&itemId=" + itemId + "&updatedStock=" + encodeURIComponent(updatedStock));
}


</script>
<script>
    function filterOrders() {
      var input, filter, userItems, i, txtValue;
      input = document.getElementById("orderSearchInput");
      filter = input.value.toUpperCase();
      userItems = document.querySelectorAll('.product-item');

      userItems.forEach(function (item) {
        txtValue = item.textContent || item.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          item.style.display = "";
        } else {
          item.style.display = "none";
        }
      });
    }
  </script>
</body>

</html>
