<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="assets/css/style.css">
  <title>注文データ詳細画面</title>
</head>

<body class="order-admin">
  <main class="order-main">
    <div class="side">
      <ul>
        <li><a href="#"><img class="side-img" src="../../shinor/img/Header.PNG" alt=""></a></li>
         <li><a href="Orderadmin">注文データ一覧</a></li>
      <li><a href="Itemadmin">商品管理</a></li>
      <li><a href="Useradmin">ユーザ管理</a></li>
        <li><a href="Logout">logout</a></li>
      </ul>
    </div>
    <div class="order-info-container">
      <h2 class="order-info-title">注文データ詳細</h2>
      <div class="order-imfo-form">
        <div class="order-info-details">
          <div class="order-info2">
            <h3 class="info-title">顧客情報</h3>
            <p><strong>注文ID:</strong> 001</p>
            <p><strong>顧客名:</strong> 顧客A</p>
            <p><strong>注文日時:</strong> 2024-01-27 10:30</p>
            <p><strong>配送情報:</strong> 住所など</p>
            <!-- 他の注文情報も同様に追加 -->
          </div>
          <div class="product-info2">
            <h3 class="info-title">商品情報</h3>
            <p><strong>商品名:</strong> 商品A</p>
            <p><strong>商品ID:</strong> 12345</p>
            <p><strong>単価:</strong> ￥1,000</p>
            <p><strong>数量:</strong> 5</p>
            <p><strong>合計金額:</strong> ￥5,000</p>
          </div>
          <div class="payment-info">
            <h3 class="info-title">支払い情報</h3>
            <p><strong>支払い方法:</strong> クレジットカード</p>
            <p><strong>支払情報:</strong> XXXX-XXXX-XXXX-1234</p>
          </div>
          <div class="shipping-info">
            <h3 class="info-title">配送情報</h3>
            <p><strong>配送状態:</strong> 
              <select id="shipping-status">
                <option value="before">配送前</option>
                <option value="during">配送中</option>
                <option value="completed">配送完了</option>
              </select>
            </p>
          </div>
          <button class="order-info-button">更新</button>
        </div>
      </div>
    </div>
  </main>
</body>

</html>
