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
  <title>商品情報更新画面</title>
</head>

<body>
  <div class="side">
    <ul>
      <li><a href="#"><img class="side-img" src="../../shinor/img/Header.PNG" alt=""></a></li>
       <li><a href="Orderadmin">注文データ一覧</a></li>
      <li><a href="Itemadmin">商品管理</a></li>
      <li><a href="Useradmin">ユーザ管理</a></li>
    </ul>
  </div>
  <div id="product-details">
    <h2>商品情報更新</h2>
    <form action="ItemUpdate" id="product-form" method="post">
      <label for="productName">商品名:</label>
      <input type="text" id="productName" name="productName" required>

    <%--<label for="productCode">商品コード:</label>
      <input type="text" id="productCode" name="productCode" required>
 --%>  
      <label for="price">価格:</label>
      <input type="number" id="price" name="price" value="1000" required>

      <label for="stockQuantity">在庫数:</label>
      <input type="number" id="stockQuantity" name="stockQuantity" min="0" value="0" required>
      
      <label for="stockQuantity">:</label>
      <input type="number" id="stockQuantity" name="FEATURED_PRODUCTS" min="0" max="1" value="0" required>

      <label for="description">説明:</label>
      <textarea id="description" name="description" rows="4" required></textarea>

      <label for="size">サイズ:</label>
      <input type="text" id="size" name="size">

      <label for="color">色:</label>
      <input type="text" id="item_color" name="color" required>

      <label for="productName">画像URL:</label>
      <input type="text" id="productName" name="image_url" required>
      
      <label for="stockQuantity">:</label>
      <input type="number" id="stockQuantity" name="PRODUCT_TYPE" min="0" max="1" value="0" required>
      
      
      <label for="stockQuantity">:</label>
      <input type="number" id="stockQuantity" name="new_item" min="0" max="1" value="0" required>
      

      <button type="submit" onclick="updateProductDetails()">更新</button>
    </form>
  </div>
  <script>
    // 商品画像のプレビュー表示
    document.getElementById('productImage').addEventListener('input', function() {
        document.getElementById('previewImage').src = this.value;
    });

    // 商品情報の更新
    function updateProductDetails() {
        // ここで商品情報を保存・更新する処理を追加
        alert('商品情報が更新されました。');
    }
  </script>
</body>

</html>
