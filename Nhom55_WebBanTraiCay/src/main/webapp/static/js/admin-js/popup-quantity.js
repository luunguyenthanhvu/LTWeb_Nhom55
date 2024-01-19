function addQuantity(productId) {
  // hiển thị popup
  $(".overlay").show();

  // Lấy vị trí cuộn trang hiện tại
  var scrollPosition = window.scrollY || document.documentElement.scrollTop;

  // Đặt vị trí top cố định cho popup
  var popupTop = 100;

  // Đặt vị trí top cho popup
  $("#popup-add-quantity").css("top", popupTop + "px");

  // Hiển thị popup
  $("#popup-add-quantity").removeClass("hide").addClass("show").show();


  // Tạo một overlay và thêm vào body
  var overlay = document.createElement('div');
  overlay.classList.add('overlay');
  document.body.appendChild(overlay);


}


function closePopup() {
  $(".overlay").hide();
  $("#popup-add-quantity").removeClass("show").addClass("hide");
  setTimeout(function () {
    $("#popup-add-quantity").hide();
  }, 500);
}

function hidePopup() {
  $(".overlay").hide();
  $("#popup-add-quantity").removeClass("show hide");
}
