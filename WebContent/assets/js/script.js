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



function filterOrders1() {
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


function filterOrders2() {
    var input, filter, orderItems, i, txtValue;
    input = document.getElementById("orderSearchInput");
    filter = input.value.toUpperCase();
    orderItems = document.querySelectorAll('.order-item');

    orderItems.forEach(function (item) {
        txtValue = item.textContent || item.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            item.style.display = "";
        } else {
            item.style.display = "none";
        }
    });
}

document.addEventListener("DOMContentLoaded", function () {
    // ページロード時にすべての選択を復元
    document.querySelectorAll('select[name="delivery"]').forEach(
        function (selectElement, index) {
            var savedSelection = localStorage
                .getItem("selectedDelivery" + index);
            if (savedSelection) {
                selectElement.value = savedSelection;
            }
            // 選択の変更をローカルストレージに保存
            selectElement.addEventListener("change", function () {
                localStorage.setItem("selectedDelivery" + index,
                    this.value);
            });
        });
});

function filterOrders3() {
    var input, filter, userItems, i, txtValue;
    input = document.getElementById("orderSearchInput");
    filter = input.value.toUpperCase();
    userItems = document.querySelectorAll('.user');

    userItems.forEach(function (item) {
        txtValue = item.textContent || item.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            item.style.display = "";
        } else {
            item.style.display = "none";
        }
    });
}