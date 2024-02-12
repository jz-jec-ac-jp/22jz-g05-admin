<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ page import="java.util.List" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>新規商品登録</title>
				<link rel="stylesheet" href="assets/css/style.css">
			</head>

			<body>
				<div id="newProductForm" class="new-product-form">
					<h3>新規商品登録</h3>
					<form id="product-form" action="ItemInfo" method="post" enctype="multipart/form-data">
						<label for="productName">商品名:</label>
						<input type="text" id="productName" name="productName" required>

						<label for="productCode">商品コード:</label>
						<input type="text" id="productCode" name="productCode" required>

						<label for="price">価格:</label>
						<input type="number" id="price" name="price" value="1000" required>
						<label for="stockQuantity">在庫数:</label>
						<input type="number" id="stockQuantity" name="stockQuantity" min="0" value="0" required>
						<label for="description">説明:</label>
						<textarea id="description" name="description" rows="4" required></textarea>

						<label for="size">サイズ:</label>
						<input type="text" id="size" name="size">
						<label for="color">色:</label>
						<select name="color">
							<option value="gold">ゴールド</option>
							<option value="silver">シルバー</option>
						</select>
						<label for="productImage">商品画像:</label>
						<input type="file" id="productImage" name="productImage" accept="image/*" onchange="previewImage(this)">
						<button type="submit" onclick="updateProductDetails()">登録</button>
					</form>
				</div>
				</div>

			</body>

			</html>